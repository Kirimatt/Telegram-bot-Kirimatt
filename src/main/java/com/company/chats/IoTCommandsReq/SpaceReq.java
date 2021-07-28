package com.company.chats.IoTCommandsReq;

import org.telegram.telegrambots.meta.api.objects.Update;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.IOException;

public class SpaceReq extends IoTCommandBuild {

    @Override
    public String buildCommand(Update update) throws IOException {
        try {

            Robot rb=new Robot();
            rb.keyPress(KeyEvent.VK_SPACE);
            rb.keyRelease(KeyEvent.VK_SPACE);

            return "Pressing space...";

        } catch (AWTException e) {
            e.printStackTrace();
        }
        throw new IOException();
    }
}
