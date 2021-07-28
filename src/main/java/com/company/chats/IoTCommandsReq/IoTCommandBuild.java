package com.company.chats.IoTCommandsReq;

import org.telegram.telegrambots.meta.api.objects.Update;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author azamat
 */
public abstract class IoTCommandBuild {

    Robot rb;

    public abstract String buildCommand(Update update) throws IOException, AWTException;
    protected void cmdExecute(String command) throws IOException {
        ProcessBuilder builder = new ProcessBuilder(
                "cmd.exe", "/c", command);
        builder.redirectErrorStream(true);
        Process p = builder.start();
        BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
        String line;
        while (true) {
            line = r.readLine();
            if (line == null) { break; }
            System.out.println(line);
        }

    }
}
