package com.company.chats;

import com.company.ClassificatoryChats;
import com.company.chats.IoTCommandsReq.*;
import com.company.commons.CommandsEnum;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.EnumMap;

public class IoTChat extends ClassificatoryChats {

    private static IoTChat ioTChat = new IoTChat();

    private static EnumMap<CommandsEnum, IoTChat> ioTChatEnumMap;

    protected static String answerBot;

    static {
        ioTChatEnumMap.put(CommandsEnum.LEFT_ARROW, new LeftArrowReq());
        ioTChatEnumMap.put(CommandsEnum.RIGHT_ARROW, new RightArrowReq());
        ioTChatEnumMap.put(CommandsEnum.SHUTDOWN, new ShutdownReq());
        ioTChatEnumMap.put(CommandsEnum.SPACE, new SpaceReq());
        //TODO: Понять почему WARN на возможный дедлок ютуба
        ioTChatEnumMap.put(CommandsEnum.YOUTUBE_LINK, new YouTubeReq());
    }

    public static IoTChat getIoTChat() {
        return ioTChat;
    }

    public IoTChat() {

    }

    public final void initialize(Update update) throws TelegramApiException, IOException {

        SendMessage message = new SendMessage(); // Create a SendMessage object with mandatory fields
        message.setChatId(update.getMessage().getChatId().toString());
        System.err.println(update.getMessage().getChatId().toString());

        ioTChat = ioTChatEnumMap.get(CommandsEnum.getEnumByCommand(update.getMessage().getText()));
        ioTChat.buildCommand(update);

        message.setText(answerBot);
        execute(message); // Call method to send the message
    }

    protected static void cmdExecute(String command) throws IOException {
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

    protected void buildCommand(Update update) throws IOException {
    }

}
