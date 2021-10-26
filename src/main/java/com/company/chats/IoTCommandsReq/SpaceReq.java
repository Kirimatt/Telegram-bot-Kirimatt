package com.company.chats.IoTCommandsReq;

import org.telegram.telegrambots.meta.api.objects.Update;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Нажатие пробела
 */
public class SpaceReq extends IoTCommandBuild {

    @Override
    public String buildCommand(Update update) throws AWTException {
        Robot rb = new Robot();
        rb.keyPress(KeyEvent.VK_SPACE);
        rb.keyRelease(KeyEvent.VK_SPACE);

        return "Pressing space...";
    }
}
