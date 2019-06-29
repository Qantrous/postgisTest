package com.example.postgistest;


import com.example.postgistest.logs.ReadLogFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping(path = "/log")
public class LogController {

    @Autowired
    private ReadLogFile readLogFile;

    @PostMapping
    public String consoleOutLog(@RequestParam MultipartFile file) throws IOException {
        String result = readLogFile.readLogs(file);
        return  result;
    }
}
