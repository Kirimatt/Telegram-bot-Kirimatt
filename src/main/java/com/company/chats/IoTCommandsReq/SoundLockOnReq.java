package com.company.chats.IoTCommandsReq;

import org.telegram.telegrambots.meta.api.objects.Update;

import java.io.File;
import java.io.IOException;

public class SoundLockOnReq extends IoTCommandBuild {

    @Override
    public String buildCommand(Update update) throws IOException {

        Runtime.getRuntime().exec("SoundLock.exe", null, new File("."));

        //TODO:FiX
        return "Starting sound lock program...\n";
    }
}
