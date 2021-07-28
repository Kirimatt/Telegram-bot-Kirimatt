package com.company.chats.IoTCommandsReq;

import org.telegram.telegrambots.meta.api.objects.Update;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.IOException;

public class LeftArrowReq extends IoTCommandBuild {

    @Override
    public String buildCommand(Update update) throws IOException {
        try {

            Robot rb=new Robot();
            rb.keyPress(KeyEvent.VK_LEFT);
            rb.keyRelease(KeyEvent.VK_LEFT);

            return "Pressing left arrow...";

        } catch (AWTException e) {
            e.printStackTrace();
        }

        throw new IOException();
    }
}
