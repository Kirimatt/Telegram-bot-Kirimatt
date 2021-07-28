package com.company.chats.IoTCommandsReq;

import org.telegram.telegrambots.meta.api.objects.Update;

import java.io.File;
import java.io.IOException;

public class SoundLockOnReq extends IoTCommandBuild {

    @Override
    public String buildCommand(Update update) {

        RunThread runThread = new RunThread();
        runThread.start();

        //TODO:FiX
        return "Starting sound lock program...\n";
    }

    static class RunThread extends Thread {
        @Override
        public void run() {
            try {
                Runtime.getRuntime().exec("SoundLock.exe", null, new File("."));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
