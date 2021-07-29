package com.company.chats.IoTCommandsReq;

import com.company.commons.CommandsEnum;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.awt.*;

public class RightArrowReq extends IoTCommandBuild {

    @Override
    public String buildCommand(Update update) throws AWTException {
        arrowDelay(update, CommandsEnum.RIGHT_ARROW);

        return "Pressing right arrow...";

    }
}
