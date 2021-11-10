package com.utils.filesystem.controller;

import com.utils.filesystem.model.LogsDTO;
import com.utils.filesystem.services.LogsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("logsManagement/")
public class LogsController {

    @Autowired
    LogsService logsService;

    @GetMapping("logs")
    public List<LogsDTO> find() {
        return logsService.getAllLogs();
    }
}
