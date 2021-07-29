package com.company.chats;

import com.company.ClassificatoryChats;
import com.company.chats.IoTCommandsReq.*;
import com.company.commons.CommandsEnum;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.awt.*;
import java.io.IOException;
import java.util.EnumMap;

public class IoTChat extends ClassificatoryChats {

    private static final IoTChat ioTChat = new IoTChat();

    private static final EnumMap<CommandsEnum, IoTCommandBuild> ioTCommandEnumMap = new EnumMap<>(CommandsEnum.class);

    static {
        ioTCommandEnumMap.put(CommandsEnum.LEFT_ARROW, new LeftArrowReq());
        ioTCommandEnumMap.put(CommandsEnum.RIGHT_ARROW, new RightArrowReq());
        ioTCommandEnumMap.put(CommandsEnum.UP_ARROW, new UpArrowReq());
        ioTCommandEnumMap.put(CommandsEnum.DOWN_ARROW, new DownArrowReq());
        ioTCommandEnumMap.put(CommandsEnum.SHUTDOWN, new ShutdownReq());
        ioTCommandEnumMap.put(CommandsEnum.SPACE, new SpaceReq());
        ioTCommandEnumMap.put(CommandsEnum.YOUTUBE_LINK, new YouTubeReq());
        ioTCommandEnumMap.put(CommandsEnum.SOUND_LOCK_ON, new SoundLockOnReq());
        ioTCommandEnumMap.put(CommandsEnum.SOUND_LOCK_OFF, new SoundLockOffReq());
        ioTCommandEnumMap.put(CommandsEnum.OPEN_LINKS, new OpenLinksReq());
        ioTCommandEnumMap.put(CommandsEnum.START_LINKS, new StartLinksReq());
        ioTCommandEnumMap.put(CommandsEnum.CHANGE_CHECK_SITE, new ChangeCheckSite());
        ioTCommandEnumMap.put(CommandsEnum.NON_RECOGNIZED, new NonRecognizedReq());
        ioTCommandEnumMap.put(CommandsEnum.EXIT, new ExitReq());
    }

    public static IoTChat getIoTChat() {
        return ioTChat;
    }

    public final void initialize(Update update) throws TelegramApiException, IOException, AWTException {

        SendMessage message = new SendMessage(); // Create a SendMessage object with mandatory fields
        message.setChatId(update.getMessage().getChatId().toString());
        System.err.println(update.getMessage().getChatId().toString());

        IoTCommandBuild ioTCommandBuild = ioTCommandEnumMap.get(CommandsEnum.getEnumByCommand(update.getMessage().getText()));

        message.setText(ioTCommandBuild.buildCommand(update));
        execute(message); // Call method to send the message
    }

}
