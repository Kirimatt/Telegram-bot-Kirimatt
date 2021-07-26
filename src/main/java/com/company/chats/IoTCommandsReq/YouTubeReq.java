package com.company.chats.IoTCommandsReq;

import com.company.chats.IoTChat;
import com.company.commons.CommandsEnum;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.IOException;

public class YouTubeReq extends IoTChat {

    @Override
    protected void buildCommand(Update update) throws IOException {
        cmdExecute(
                "start "
                        + update.getMessage().getText().replace(CommandsEnum.YOUTUBE_LINK.getCommand(), "").replace(" ", "")
        );

        answerBot = "Starting YouTube link...\n";

        try {
            Thread.sleep(5000);

            Robot rb=new Robot();
            rb.keyPress(KeyEvent.VK_F);
            rb.keyRelease(KeyEvent.VK_F);

            answerBot += "Making full screen...";

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (AWTException ex) {
            System.err.println("Robot error");
        }
    }
}
