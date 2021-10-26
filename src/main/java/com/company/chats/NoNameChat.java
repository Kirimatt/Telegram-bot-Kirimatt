package com.company.chats;

import com.company.ClassificatoryChats;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

/**
 * Чат для всех остальных пользователей
 *
 * @author kirimatt
 */
public class NoNameChat extends ClassificatoryChats {

    public final void initialize(Update update) throws TelegramApiException {

        SendMessage message = new SendMessage();
        message.setChatId(update.getMessage().getChatId().toString());
        System.err.println(update.getMessage().getChatId().toString());

        message.setText("Permission denied.");
        execute(message);

        //Передает информацию о запрашиваемой команде разработчику
        message.setChatId("433128217");
        message.setText(update.getMessage().getText());
        execute(message);
    }
}
