package com.company.chats;

import com.company.ClassificatoryChats;
import com.company.commons.CommandsEnum;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IoTChat extends ClassificatoryChats {

    public IoTChat() {

    }

    public final void initialize(Update update) throws TelegramApiException, IOException {

        SendMessage message = new SendMessage(); // Create a SendMessage object with mandatory fields
        message.setChatId(update.getMessage().getChatId().toString());
        System.err.println(update.getMessage().getChatId().toString());
        //TODO: ENUMMAP for COMMANDS
        // Call method to send the message
        if (update.getMessage().getText().equals(CommandsEnum.SHUTDOWN.getCommand())) {
            message.setText("Shutting down...");
            cmdExecute("shutdown.exe -s -f -t 120");

        } else {
            message.setText(update.getMessage().getText());
        }
        execute(message); // Call method to send the message
    }

    private static void cmdExecute(String command) throws IOException {
        ProcessBuilder builder = new ProcessBuilder(
                "cmd.exe", "/c", command);
        builder.redirectErrorStream(true);
        Process p = builder.start();
        BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
        String line;
        while (true) {
            line = r.readLine();
            if (line == null) { break; }
            System.out.println(line);
        }

    }

}
