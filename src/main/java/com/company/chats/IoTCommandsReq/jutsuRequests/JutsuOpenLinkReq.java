package com.company.chats.IoTCommandsReq.jutsuRequests;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.IOException;

/**
 * Открывает ссылку на jutsu с подключением драйвера Selenium и подгрузкой расширения для блокировки рекламы
 *
 * @author kirimatt
 */
public class JutsuOpenLinkReq extends JutsuMain {

    public JutsuOpenLinkReq() {
        super();
    }

    @Override
    public String buildCommand(Update update) throws IOException, AWTException {
        System.setProperty("webdriver.chrome.driver", "C:\\ProgramData\\chocolatey\\lib\\chromedriver\\tools\\chromedriver.exe");

        String site = update.getMessage().getText().
                replace("/jutsu", "").
                replace(" ", "");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("load-extension=C:\\Users\\kirimatt\\AppData\\Local\\" +
                "Google\\Chrome\\User Data\\Default\\Extensions\\cfhdojbkjhnklbpkdaibdccddilifddb\\3.11.2_0");

        driver = new ChromeDriver(options);
        driver.get(site);

        Robot rb = new Robot();
        rb.delay(5000);
        rb.keyPress(KeyEvent.VK_CONTROL);
        rb.keyPress(KeyEvent.VK_W);
        rb.keyRelease(KeyEvent.VK_CONTROL);
        rb.keyRelease(KeyEvent.VK_W);

        driver.findElement(By.className("vjs-big-play-button")).click();
        return "Открывает сайт на Jutsu.";
    }
}
