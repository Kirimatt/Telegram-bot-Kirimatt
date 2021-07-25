package com.company.chats;

import com.company.ClassificatoryChats;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class NoNameChat extends ClassificatoryChats {

    public final void initialize(Update update) throws TelegramApiException {

        SendMessage message = new SendMessage(); // Create a SendMessage object with mandatory fields
        message.setChatId(update.getMessage().getChatId().toString());
        System.err.println(update.getMessage().getChatId().toString());

        message.setText("Permission denied.");
        execute(message); // Call method to send the message

    }
}
