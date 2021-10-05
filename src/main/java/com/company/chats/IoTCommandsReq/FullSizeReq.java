package com.company.chats.IoTCommandsReq;

import org.telegram.telegrambots.meta.api.objects.Update;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.IOException;

public class FullSizeReq extends IoTCommandBuild {

    @Override
    public String buildCommand(Update update) throws IOException, AWTException {

        Robot rb = new Robot();
        rb.keyPress(KeyEvent.VK_F);
        rb.keyRelease(KeyEvent.VK_F);

        return "Pressing f...";
    }

}
