package com.example.postgistest.Logs.services;

import com.example.postgistest.Logs.entities.Logs;
import com.example.postgistest.Logs.repositories.LogRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.List;
import java.util.Optional;

import static com.example.postgistest.tools.MultipartFileConverter.toFile;

@Service
public class LogService {


    @Autowired
    private LogRepository logRepository;



    public String readLogs(MultipartFile multipartFile) throws IOException {
        File file = toFile(multipartFile);

        FileInputStream fstream = new FileInputStream(file);
        BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

        String result = "";
        String lastInput = "";
        String strLine;

        /* read log line by line */
        while ((strLine = br.readLine()) != null) {
            /* parse strLine to obtain what you want */
            System.out.println (strLine);
            result += strLine + "\n";
            lastInput = strLine;
        }
        fstream.close();

        Logs logs = new Logs();
        logs.setText(result.substring(0, result.length() - lastInput.length()));
        logs.setJobId(Long.parseLong(lastInput));

        logRepository.saveAndFlush(logs);

        return result;
    }



    public Logs getLogByJobId(Long jobId) {
        Optional<Logs> logsOptional = logRepository.findByJobId(jobId);
        return logsOptional.orElse(null);
    }

    public List<Long> getIds() {
        return logRepository.getLogIds();
    }

    public List<Long> getJobIds() {
        return logRepository.getJobIds();
    }
}
