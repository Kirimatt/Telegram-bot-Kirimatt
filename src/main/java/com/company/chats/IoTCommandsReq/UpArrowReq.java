package com.company.chats.IoTCommandsReq;

import com.company.commons.CommandsEnum;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.awt.*;

/**
 * Стрекла вверх
 *
 * @author azamat
 */
public class UpArrowReq extends IoTCommandBuild {

    @Override
    public String buildCommand(Update update) throws AWTException {
        arrowDelay(update, CommandsEnum.UP_ARROW);

        return "Pressing up arrow...";
    }
}
