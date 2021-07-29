package com.company.chats.IoTCommandsReq;

import com.company.commons.CommandsEnum;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.awt.*;

/**
 * @author azamat
 */
public class DownArrowReq extends IoTCommandBuild {

    @Override
    public String buildCommand(Update update) throws AWTException {
        arrowDelay(update, CommandsEnum.DOWN_ARROW);

        return "Pressing down arrow...";
    }
}
