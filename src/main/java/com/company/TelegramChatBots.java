package com.company;


import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class TelegramChatBots {

    public static void registerBots(TelegramLongPollingBot ... telegramLongPollingBots) throws TelegramApiException {

        TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
        for (TelegramLongPollingBot telegramLongPollingBot: telegramLongPollingBots) {
            botsApi.registerBot(telegramLongPollingBot);
        }

    }

    public static void main(String[] args) {
        try {
            registerBots(new ClassificatoryChats());
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
