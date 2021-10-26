package com.company.chats.IoTCommandsReq.jutsuRequests;

import org.openqa.selenium.By;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.awt.*;
import java.io.IOException;

/**
 * Открывает следующий эпизод
 * @author kirimatt
 */
public class JutsuOpenNextEpisodeReq extends JutsuMain {

    @Override
    public String buildCommand(Update update) throws IOException, AWTException {

        try {
            driver.findElement(By.className("there_is_link_to_next_episode")).click();
        } catch (Exception e) {
            driver.findElement(By.className("vjs-overlay-bottom-right")).click();
        }

        //TODO при vjs-overlay-bottom-right слетает фокусировка. И фулл сайз не работает.
        try {
            driver.findElement(By.className("vjs-big-play-button")).click();
        } catch (Exception e) {
            Robot robot = new Robot();
            robot.delay(2000);
            driver.findElement(By.className("vjs-big-play-button")).click();
        }

        return "Кликаю на следующую серию.";
    }
}
