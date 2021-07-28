package com.company.chats.IoTCommandsReq;

import org.telegram.telegrambots.meta.api.objects.Update;

import java.io.IOException;

public class SoundLockOffReq extends IoTCommandBuild {

    @Override
    public String buildCommand(Update update) throws IOException {

        SoundLockOnReq.RunThread.currentThread().interrupt();

        cmdExecute(
                "taskkill /F /IM soundlock.exe"
        );
        //TODO: Проверить
        return "Killing sound lock program...\n";
    }
}
