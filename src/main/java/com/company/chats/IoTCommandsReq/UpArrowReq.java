package com.company.chats.IoTCommandsReq;

import com.company.commons.CommandsEnum;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * @author azamat
 */
public class UpArrowReq extends IoTCommandBuild {

    @Override
    public String buildCommand(Update update) throws AWTException {
        rb = new Robot();
        rb.keyPress(KeyEvent.VK_UP);
        arrowDelay(rb, update, CommandsEnum.UP_ARROW);
        rb.keyRelease(KeyEvent.VK_UP);

        return "Pressing up arrow...";
    }
}
