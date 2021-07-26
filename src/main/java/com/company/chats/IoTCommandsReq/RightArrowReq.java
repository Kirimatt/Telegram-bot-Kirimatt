package com.company.chats.IoTCommandsReq;

import com.company.chats.IoTChat;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.awt.*;
import java.awt.event.KeyEvent;

public class RightArrowReq extends IoTChat {

    @Override
    protected void buildCommand(Update update) {
        try {

            Robot rb=new Robot();
            rb.keyPress(KeyEvent.VK_RIGHT);
            rb.keyRelease(KeyEvent.VK_RIGHT);

            answerBot = "Pressing right arrow...";

        } catch (AWTException e) {
            e.printStackTrace();
        }
    }
}
