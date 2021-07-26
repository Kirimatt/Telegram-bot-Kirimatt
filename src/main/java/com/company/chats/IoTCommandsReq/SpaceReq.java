package com.company.chats.IoTCommandsReq;

import com.company.chats.IoTChat;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.awt.*;
import java.awt.event.KeyEvent;

public class SpaceReq extends IoTChat {

    @Override
    protected void buildCommand(Update update) {
        try {

            Robot rb=new Robot();
            rb.keyPress(KeyEvent.VK_SPACE);
            rb.keyRelease(KeyEvent.VK_SPACE);

            answerBot = "Pressing space...";

        } catch (AWTException e) {
            e.printStackTrace();
        }
    }
}
