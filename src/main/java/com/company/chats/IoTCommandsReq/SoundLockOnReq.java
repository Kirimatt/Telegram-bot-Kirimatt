package com.company.chats.IoTCommandsReq;

import com.company.chats.IoTChat;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.io.File;
import java.io.IOException;

public class SoundLockOnReq extends IoTChat {

    @Override
    protected void buildCommand(Update update) throws IOException {

        Runtime.getRuntime().exec("SoundLock.exe", null, new File("."));

        //TODO:FiX
        answerBot = "Starting sound lock program...\n";

    }
}
