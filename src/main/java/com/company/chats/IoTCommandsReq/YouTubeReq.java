package com.company.chats.IoTCommandsReq;

import com.company.commons.CommandsEnum;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.IOException;

/**
 * Закрывает предыдущую вкладку, открывает ссылку на ютубе и ставит в полноэкранный режим
 */
public class YouTubeReq extends IoTCommandBuild {

    @Override
    public String buildCommand(Update update) throws IOException, AWTException {

        String answerBot;

        Robot rb = new Robot();
        rb.keyPress(KeyEvent.VK_CONTROL);
        rb.keyPress(KeyEvent.VK_W);
        rb.keyRelease(KeyEvent.VK_CONTROL);
        rb.keyRelease(KeyEvent.VK_W);

        answerBot = "Closing old website link...\n";

        cmdExecute(
                "start "
                        + update.getMessage().getText().replace(CommandsEnum.YOUTUBE_LINK.getCommand(), "")
                        .replace(" ", "")
        );

        answerBot += "Starting YouTube link...\n";

        rb.delay(5000);

        rb.keyPress(KeyEvent.VK_F);
        rb.keyRelease(KeyEvent.VK_F);

        answerBot += "Making full screen...";

        return answerBot;
    }
}
