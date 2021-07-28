package com.company.chats.IoTCommandsReq;

import org.telegram.telegrambots.meta.api.objects.Update;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.IOException;

public class RightArrowReq extends IoTCommandBuild {

    @Override
    public String buildCommand(Update update) throws IOException {
        try {

            Robot rb=new Robot();
            rb.keyPress(KeyEvent.VK_RIGHT);
            rb.keyRelease(KeyEvent.VK_RIGHT);

            return "Pressing right arrow...";

        } catch (AWTException e) {
            e.printStackTrace();
        }

        throw new IOException();
    }
}
