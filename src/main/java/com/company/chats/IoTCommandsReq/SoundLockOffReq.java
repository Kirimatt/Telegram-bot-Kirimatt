package com.company.chats.IoTCommandsReq;

import com.company.chats.IoTChat;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.io.IOException;

public class SoundLockOffReq extends IoTChat {

    @Override
    protected void buildCommand(Update update) throws IOException {
        cmdExecute(
                "taskkill /F /IM soundlock.exe"
        );

        answerBot = "Killing sound lock program...\n";

    }
}
