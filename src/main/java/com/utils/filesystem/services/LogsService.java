package com.utils.filesystem.services;

import com.utils.filesystem.model.LogsDTO;
import com.utils.filesystem.repository.LogsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogsService {

    @Autowired
    public LogsRepository logsRepository;

    public List<LogsDTO> getAllLogs() {
       return logsRepository.findAll();
    }

    void setLogs(LogsDTO logsDTO) {
       logsRepository.save(logsDTO);
    }
}
