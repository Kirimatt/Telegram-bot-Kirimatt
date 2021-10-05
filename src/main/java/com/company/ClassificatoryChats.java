package com.company;

import com.company.chats.IoTChat;
import com.company.chats.NoNameChat;
import com.company.chats.SealChat;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.awt.*;
import java.io.*;
import java.util.Properties;

public class ClassificatoryChats extends TelegramLongPollingBot {

    private static String username;
    private static String token;
    private static final String ownerChatId = "433128217";
    private static final String sealChatId = "767606020";

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
                    case ownerChatId -> IoTChat.getIoTChat().initialize(update);
                    case sealChatId -> new SealChat().initialize(update);
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
