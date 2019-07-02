package com.example.postgistest;


import com.example.postgistest.Logs.entities.Logs;
import com.example.postgistest.Logs.services.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(path = "/log", produces = "application/json;charset=UTF-8")
public class LogController {

    @Autowired
    private LogService logService;

    @PostMapping
    public String consoleOutLog(@RequestParam MultipartFile file) throws IOException {
        String result = logService.readLogs(file);
        return  result;
    }


    @GetMapping("{jobId}")
    public ResponseEntity<Logs> getLog(@PathVariable Long jobId) {
        return ResponseEntity.ok().body(logService.getLogByJobId(jobId));

    }


    @GetMapping("/ids")
    public ResponseEntity<List<Long>> getIds() {
        return ResponseEntity.ok().body(logService.getIds());
    }

    @GetMapping("/jobIds")
    public ResponseEntity<List<Long>> getJobIds() {
        return ResponseEntity.ok().body(logService.getJobIds());
    }
}
