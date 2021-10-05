package com.company.chats.IoTCommandsReq;

import org.telegram.telegrambots.meta.api.objects.Update;

import java.io.IOException;

public class ShutdownReq extends IoTCommandBuild {

    @Override
    public String buildCommand(Update update) throws IOException {
        String keys = update.getMessage().getText().
                replace("/shutdown", "").
                replace(" ", "");

        if (keys.isEmpty())
            cmdExecute("shutdown.exe -s -f -t 120");
        else
            cmdExecute("shutdown.exe -s -f -t " + keys);

        System.err.println(keys);
        return "Shutting down...";
    }
}
