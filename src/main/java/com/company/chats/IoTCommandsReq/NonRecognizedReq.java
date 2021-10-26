package com.company.chats.IoTCommandsReq;

import org.telegram.telegrambots.meta.api.objects.Update;

/**
 * Случай когда команда не распознана
 * @author kirimatt
 */
public class NonRecognizedReq extends IoTCommandBuild {

    @Override
    public String buildCommand(Update update) {
        return update.getMessage().getText() + " isn't recognized";
    }
}
