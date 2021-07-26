package com.company.chats.IoTCommandsReq;

import com.company.chats.IoTChat;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.awt.*;
import java.awt.event.KeyEvent;

public class LeftArrowReq extends IoTChat {

    @Override
    protected void buildCommand(Update update) {
        try {

            Robot rb=new Robot();
            rb.keyPress(KeyEvent.VK_LEFT);
            rb.keyRelease(KeyEvent.VK_LEFT);

            answerBot = "Pressing left arrow...";

        } catch (AWTException e) {
            e.printStackTrace();
        }
    }
}
