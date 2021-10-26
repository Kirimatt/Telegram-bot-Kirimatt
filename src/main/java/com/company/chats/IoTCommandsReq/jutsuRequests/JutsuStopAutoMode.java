package com.company.chats.IoTCommandsReq.jutsuRequests;

import org.telegram.telegrambots.meta.api.objects.Update;

import java.awt.*;
import java.io.IOException;

/**
 * Останавливает поток с автоматическим модом
 * @author azamat
 */
public class JutsuStopAutoMode extends JutsuMain {
    @Override
    public String buildCommand(Update update) throws IOException, AWTException {

        threadAuto.interrupt();

        return "Останавливаю поток автоматизации Jutsu...";
    }
}
