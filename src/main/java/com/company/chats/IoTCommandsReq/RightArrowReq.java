package com.company.chats.IoTCommandsReq;

import org.telegram.telegrambots.meta.api.objects.Update;

import java.awt.*;
import java.awt.event.KeyEvent;

public class RightArrowReq extends IoTCommandBuild {

    @Override
    public String buildCommand(Update update) throws AWTException {

        Robot rb=new Robot();
        rb.keyPress(KeyEvent.VK_RIGHT);
        rb.keyRelease(KeyEvent.VK_RIGHT);

        return "Pressing right arrow...";

    }
}
