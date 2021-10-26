package com.company.chats.IoTCommandsReq;

import com.company.commons.CommandsEnum;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.awt.*;
import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Высылает ответ со всеми командами
 *
 * @author kirimatt
 */
public class HelpReq extends IoTCommandBuild {
    @Override
    public String buildCommand(Update update) throws IOException, AWTException {

        return Arrays
                .stream(CommandsEnum.values())
                .map(n -> n.getCommand() + " -/- " + n.getDescription() + "\n")
                .sorted()
                .collect(Collectors.toList())
                .toString()
                .replace("[", "")
                .replace("]", "")
                .replace(",", "");

    }
}
