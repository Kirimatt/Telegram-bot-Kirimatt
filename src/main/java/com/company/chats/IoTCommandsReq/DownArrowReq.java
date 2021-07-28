package com.company.chats.IoTCommandsReq;

import com.company.commons.CommandsEnum;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * @author azamat
 */
public class DownArrowReq extends IoTCommandBuild {

    @Override
    public String buildCommand(Update update) throws AWTException {
        rb = new Robot();
        rb.keyPress(KeyEvent.VK_DOWN);
        arrowDelay(rb, update, CommandsEnum.DOWN_ARROW);
        rb.keyRelease(KeyEvent.VK_DOWN);

        return "Pressing down arrow...";
    }
}
