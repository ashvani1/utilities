package com.utils.filesystem.services;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.utils.filesystem.model.DetailedLogs;
import com.utils.filesystem.model.Logs;
import com.utils.filesystem.model.LogsDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
public class ProcessFile {

    @Autowired
    public LogsService logsService;


    public static <T> T convertJsonStringToLogObject(String json, TypeToken<T> typeToken) {
        try {
            return new Gson().fromJson(json, typeToken.getType());
        } catch (Exception ex) {
            log.error("There is issue while converting file json entry into Logs Object. exception ",ex);
            return null;
        }
    }

    public void fileProcess(String filePath) throws IOException {
        ArrayList<Logs> logsList = new ArrayList<>();
        HashMap<String, DetailedLogs> logsMap = new HashMap<>();
        log.trace("entering into ProcessFile:fileProcess()");
        log.debug("inside fileProcess() with filePath {}: ",filePath);
        try {
            File file = new File(filePath);
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line;

            while((line=br.readLine())!=null) {
                Logs logObject = convertJsonStringToLogObject(line, new TypeToken<Logs>() {
                });
                logsList.add(logObject);
            }
            
            logsList.forEach(logObject -> {
                if (!logsMap.containsKey(logObject.getId())) {
                    logsMap.put(logObject.getId(), new DetailedLogs(logObject, false, 0L));
                } else {
                    Logs mapLog = logsMap.get(logObject.getId()).getLogs();
                    long duration = Math.abs(logObject.getTimestamp() - mapLog.getTimestamp());
                    if (duration > 4) {
                        log.debug("id {} : is having duration more than 4 ",logObject.getId());
                        logsMap.put(logObject.getId(), new DetailedLogs(logObject, true, duration));
                    } else
                        logsMap.remove(logObject.getId());
                }
            });


            for (Map.Entry<String, DetailedLogs> en : logsMap.entrySet()) {
                if (en.getValue().getDuration() > 0) {
                    LogsDTO e = new LogsDTO(en.getKey(), en.getValue().getDuration(), en.getValue().getLogs().getType(), en.getValue().getLogs().getHost(), true);
                    logsService.setLogs(e);
                }
            }
            log.trace("exiting from ProcessFile:fileProcess()");

        } catch (Exception e) {
            log.error("There is issue in fileHanding and records are not processed properly. exception :",e.getCause());
            throw e;
        }
    }


}
