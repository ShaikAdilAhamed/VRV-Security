package com.adil.Service;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class VrvServiceimpl implements VrvService {

    @Value("${Read.File.path}")
    private String fileData;

    // Regex pattern to match the log line
    private static final String LOG_REGEX = 
            "^([\\d]{1,3}\\.){3}[\\d]{1,3} - - \\[([^\\]]+)\\] \"([A-Z]+) ([^ ]+) HTTP/[0-9.]+\" (\\d{3}) (\\d+)$";
    private static final Pattern pattern = Pattern.compile(LOG_REGEX);

    public String readFile() throws IOException {
        File file = new File(fileData);
        Scanner sc = new Scanner(file);
        StringBuilder result = new StringBuilder();

        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            
            // Match each line with the regex
            Matcher matcher = pattern.matcher(line);
            if (matcher.matches()) {
                result.append("Matched Log: ").append(line).append("\n");
            } else {
                result.append("Non-matched Log: ").append(line).append("\n");
            }
        }

        sc.close();
        return result.toString();
    }
}
