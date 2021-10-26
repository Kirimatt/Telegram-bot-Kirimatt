package com.company.chats.IoTCommandsReq.jutsuRequests;

import org.openqa.selenium.By;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.awt.*;
import java.io.IOException;

/**
 * Пропускает опенинг
 */
public class JutsuSkipOpening extends JutsuMain {
    @Override
    public String buildCommand(Update update) throws IOException, AWTException {
        driver.findElement(By.className("vjs-overlay-skip-intro")).click();
        return null;
    }
}
