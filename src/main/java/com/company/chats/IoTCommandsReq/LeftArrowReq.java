package com.company.chats.IoTCommandsReq;

import com.company.commons.CommandsEnum;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.awt.*;

public class LeftArrowReq extends IoTCommandBuild {

    @Override
    public String buildCommand(Update update) throws AWTException {
        arrowDelay(update, CommandsEnum.LEFT_ARROW);

        return "Pressing left arrow...";
    }
}
