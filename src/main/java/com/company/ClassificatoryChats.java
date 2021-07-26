package com.company;

import com.company.chats.IoTChat;
import com.company.chats.NoNameChat;
import com.company.chats.SealChat;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.IOException;

public class ClassificatoryChats extends TelegramLongPollingBot {

    private static final String USERNAME = "KirimattBot";
    private static final String TOKEN = "1922609712:AAGEKMx2dKok9A3GXzQxKybWgBcRjldw8K8";
    private static final String OWNER_CHAT_ID = "433128217";
    private static final String SEAL_CHAT_ID = "767606020";

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {

            try {
                switch (update.getMessage().getChatId().toString()) {
                    case OWNER_CHAT_ID -> IoTChat.getIoTChat().initialize(update);
                    case SEAL_CHAT_ID -> new SealChat().initialize(update);
                    default -> new NoNameChat().initialize(update);
                }
            } catch (TelegramApiException | IOException e) {
                e.printStackTrace();
            }

        }
    }

    @Override
    public String getBotUsername() {
        return USERNAME;
    }

    @Override
    public String getBotToken() {
        return TOKEN;
    }


}
