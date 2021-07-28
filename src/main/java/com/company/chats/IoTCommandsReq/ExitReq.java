package com.company.chats.IoTCommandsReq;

import org.telegram.telegrambots.meta.api.objects.Update;

import java.awt.*;

public class ExitReq extends IoTCommandBuild {

    @Override
    public String buildCommand(Update update) throws AWTException {
        System.exit(0);
        return "Exiting...";
    }
}