package com.company.chats.IoTCommandsReq.jutsuRequests;

import org.openqa.selenium.By;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.IOException;

/**
 * Автоматический мод для просмотра серий
 * @author azamat
 */
public class JutsuAutoMode extends JutsuMain {

    public static volatile boolean isAutoMode = true;

    @Override
    public String buildCommand(Update update) throws IOException, AWTException {

        threadAuto.start();

        return "Запущен поток автоматизации Jutsu...";
    }

    static class AutoMode implements Runnable {

        @Override
        public void run() {

            try {
                Robot rb = new Robot();

                while (isAutoMode) {
                    if (driver.findElement(By.className("vjs-overlay-bottom-right")).isDisplayed()) {


                        driver.findElement(By.className("vjs-overlay-bottom-right")).click();

                        try {
                            driver.findElement(By.className("vjs-big-play-button")).click();
                        } catch (Exception e) {

                            rb.delay(2000);
                            driver.findElement(By.className("vjs-big-play-button")).click();
                        }

                        rb.keyPress(KeyEvent.VK_F);
                        rb.keyRelease(KeyEvent.VK_F);
                    }
                }
            } catch (AWTException e) {
                System.err.println("Ошибка треда.");
            }
        }
    }
}
