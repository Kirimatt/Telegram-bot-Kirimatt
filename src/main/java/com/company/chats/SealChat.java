package com.company.chats;

import com.company.ClassificatoryChats;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

/**
 * Приватный чат
 * @author kirimatt
 */
public class SealChat extends ClassificatoryChats {


    public final void initialize(Update update) throws TelegramApiException {

        SendMessage message = new SendMessage(); // Create a SendMessage object with mandatory fields
        message.setChatId(update.getMessage().getChatId().toString());
        System.err.println(update.getMessage().getChatId().toString());

        // Call method to send the message
        if (update.getMessage().getText().equals("Доброе утро")) {
            message.setText("Доброе утро, мой любимый тюлененок <3");

        } else {
            message.setText("Мур-мур-мур <3");
        }
        execute(message); // Call method to send the message

        //Передает запрошенную команду или сообщение разработчику
        message.setChatId("433128217");
        message.setText(update.getMessage().getText());
        execute(message);
    }

}
