package com.company.chats.IoTCommandsReq;

import com.company.chats.IoTChat;
import org.telegram.telegrambots.meta.api.objects.Update;

public class NonRecognizedReq extends IoTChat {

    @Override
    protected void buildCommand(Update update) {
        answerBot = update.getMessage().getText() + " isn't recognized";
    }
}
