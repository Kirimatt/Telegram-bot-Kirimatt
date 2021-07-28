package com.company.chats;

import com.company.ClassificatoryChats;
import com.company.chats.IoTCommandsReq.*;
import com.company.commons.CommandsEnum;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.IOException;
import java.util.EnumMap;

public class IoTChat extends ClassificatoryChats {

    private static IoTChat ioTChat = new IoTChat();

    private static final EnumMap<CommandsEnum, IoTCommandBuild> ioTCommandEnumMap = new EnumMap<>(CommandsEnum.class);

    protected static String answerBot;

    static {
        ioTCommandEnumMap.put(CommandsEnum.LEFT_ARROW, new LeftArrowReq());
        ioTCommandEnumMap.put(CommandsEnum.RIGHT_ARROW, new RightArrowReq());
        ioTCommandEnumMap.put(CommandsEnum.SHUTDOWN, new ShutdownReq());
        ioTCommandEnumMap.put(CommandsEnum.SPACE, new SpaceReq());
        ioTCommandEnumMap.put(CommandsEnum.YOUTUBE_LINK, new YouTubeReq());
        ioTCommandEnumMap.put(CommandsEnum.SOUND_LOCK_ON, new SoundLockOnReq());
        ioTCommandEnumMap.put(CommandsEnum.SOUND_LOCK_OFF, new SoundLockOffReq());
        ioTCommandEnumMap.put(CommandsEnum.NON_RECOGNIZED, new NonRecognizedReq());
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

        IoTCommandBuild ioTCommandBuild = ioTCommandEnumMap.get(CommandsEnum.getEnumByCommand(update.getMessage().getText()));
        ioTCommandBuild.buildCommand(update);

        message.setText(answerBot);
        execute(message); // Call method to send the message
    }

}
