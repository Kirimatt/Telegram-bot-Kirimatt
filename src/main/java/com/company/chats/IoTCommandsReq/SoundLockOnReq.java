package com.company.chats.IoTCommandsReq;

import org.telegram.telegrambots.meta.api.objects.Update;

import java.io.IOException;

/**
 * Команда для включения "тихого" режима
 * Запускает программу, которая отслеживает уровень звука и блокирует его на одном уровне.
 * @author kirimatt
 */
public class SoundLockOnReq extends IoTCommandBuild {

    @Override
    public String buildCommand(Update update) throws IOException {
        soundLockProcess = Runtime.getRuntime().exec("SoundLock.exe");
        //TODO:FiX
        return "Starting sound lock program...\n";
    }

}
