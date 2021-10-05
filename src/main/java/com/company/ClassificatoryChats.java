package com.company;

import com.company.chats.IoTChat;
import com.company.chats.NoNameChat;
import com.company.chats.SealChat;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.awt.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ClassificatoryChats extends TelegramLongPollingBot {

    private static final String OWNER_CHAT_ID = "433128217";
    private static final String SEAL_CHAT_ID = "767606020";
    private static String username;
    private static String token;

    static {
        try (InputStream input = new FileInputStream("./config.properties")) {
            Properties properties = new Properties();

            // load a properties file
            properties.load(input);

            username = properties.getProperty("USERNAME");
            token = properties.getProperty("TOKEN");


        } catch (IOException io) {
            io.printStackTrace();
        }
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {

            try {
                switch (update.getMessage().getChatId().toString()) {
                    case OWNER_CHAT_ID -> IoTChat.getIoTChat().initialize(update);
                    case SEAL_CHAT_ID -> new SealChat().initialize(update);
                    default -> new NoNameChat().initialize(update);
                }
            } catch (TelegramApiException | IOException | AWTException e) {
                e.printStackTrace();
            }

        }
    }

    @Override
    public String getBotUsername() {
        return username;
    }

    @Override
    public String getBotToken() {
        return token;
    }


}
