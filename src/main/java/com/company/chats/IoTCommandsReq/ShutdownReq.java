package com.company.chats.IoTCommandsReq;

import com.company.chats.IoTChat;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.io.IOException;

public class ShutdownReq extends IoTChat {

    @Override
    protected void buildCommand(Update update) throws IOException {
        String keys = update.getMessage().getText().replace("/shutdown", "").replace(" ", "");
        if(keys.isEmpty())
            cmdExecute("shutdown.exe -s -f -t 120");
        else
            cmdExecute("shutdown.exe -s -f -t " + keys);

        System.err.println(keys);
        answerBot = "Shutting down...";
    }
}
