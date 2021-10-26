package com.company.chats.IoTCommandsReq;

import org.telegram.telegrambots.meta.api.objects.Update;

import java.awt.*;
import java.io.IOException;

/**
 * Открывает несколько заранее детерменированных ссылок, включая актуальную для просмотра
 */
public class StartLinksReq extends IoTCommandBuild {
    private static final int ANISTAR_VERSION = 100;


    @Override
    public String buildCommand(Update update) throws IOException, AWTException {
        cmdExecute(
                "start chrome.exe" + " " +
                        "https://vk.com/im" + " " +
                        "https://as" + ANISTAR_VERSION + ".online-stars.org/" + " " +
                        "https://www.youtube.com/" + " " +
                        "https://www.twitch.tv/honeymad" + " " +
                        "https://www.instagram.com/" + " " +
                        "https://e.mail.ru/messages/inbox/" + " " +
                        "https://kwork.ru/" + " " +
                        "https://www.dns-shop.ru/" + " " +
                        "https://vk.com/twitch_pirat" + " " +
                        "https://github.com/Kirimatt/" + " " +
                        actualCheckSite

        );

        return "Starting links...\n";
    }
}
