package com.company.chats.IoTCommandsReq;

import com.company.commons.CommandsEnum;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.awt.*;
import java.io.IOException;

public class ChangeCheckSite extends IoTCommandBuild {
    @Override
    public String buildCommand(Update update) throws IOException, AWTException {
        actualCheckSite = update.getMessage().getText().
                replace(CommandsEnum.CHANGE_CHECK_SITE.getCommand(), "").
                replace(" ", "");

        return "Changing actual check site to " + actualCheckSite + " ...";
    }
}