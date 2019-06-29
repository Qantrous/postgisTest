package com.example.postgistest.logs;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

import static com.example.postgistest.tools.MultipartFileConverter.toFile;

@Service
public class ReadLogFile {



    public String readLogs(MultipartFile multipartFile) throws IOException {
        File file = toFile(multipartFile);

        FileInputStream fstream = new FileInputStream(file);
        BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

        String result = "";
        String strLine;

        /* read log line by line */

        while ((strLine = br.readLine()) != null) {

            /* parse strLine to obtain what you want */

            System.out.println (strLine);
            result += strLine + "\n";

        }
        fstream.close();




        return result;
    }
}
