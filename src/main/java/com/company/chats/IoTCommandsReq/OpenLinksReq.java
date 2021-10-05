package com.company.chats.IoTCommandsReq;

import com.company.commons.CommandsEnum;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.awt.*;
import java.io.IOException;

public class OpenLinksReq extends IoTCommandBuild {
    @Override
    public String buildCommand(Update update) throws IOException, AWTException {
        cmdExecute(
                "start chrome.exe"
                        + update.getMessage().getText().replace(CommandsEnum.OPEN_LINKS.getCommand(), "")
        );

        return "Starting links...\n";
    }
}
