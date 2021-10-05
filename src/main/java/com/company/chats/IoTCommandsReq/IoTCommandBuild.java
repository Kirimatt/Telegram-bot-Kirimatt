package com.company.chats.IoTCommandsReq;

import com.company.commons.CommandsEnum;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.EnumMap;

/**
 * @author azamat
 */
public abstract class IoTCommandBuild {

    protected Process soundLockProcess;
    protected String actualCheckSite = "https://animego.org/anime/granica-pustoty-2-teoriya-ubiystva-chast-1-o1841";
    private Robot rb;
    private EnumMap<CommandsEnum, Integer> arrowMap = new EnumMap<>(CommandsEnum.class);

    {
        arrowMap.put(CommandsEnum.LEFT_ARROW, KeyEvent.VK_LEFT);
        arrowMap.put(CommandsEnum.RIGHT_ARROW, KeyEvent.VK_RIGHT);
        arrowMap.put(CommandsEnum.UP_ARROW, KeyEvent.VK_UP);
        arrowMap.put(CommandsEnum.DOWN_ARROW, KeyEvent.VK_DOWN);
    }

    public abstract String buildCommand(Update update) throws IOException, AWTException;

    protected synchronized void cmdExecute(String command) throws IOException {
        ProcessBuilder builder = new ProcessBuilder(
                "cmd.exe", "/c", command);
        builder.redirectErrorStream(true);
        Process p = builder.start();
        BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
        String line;
        while (true) {
            line = r.readLine();
            if (line == null) {
                break;
            }
            System.out.println(line);
        }

    }

    protected synchronized void arrowDelay(Update update, CommandsEnum commandsEnum) throws AWTException {
        rb = new Robot();
        String keys = update.getMessage().getText().
                replace(commandsEnum.getCommand(), "").
                replace(" ", "");
        if (!keys.isEmpty())
            for (int i = 0; i < Integer.parseInt(keys); i++) {
                rb.keyPress(arrowMap.get(commandsEnum));
                rb.keyRelease(arrowMap.get(commandsEnum));
            }
    }
}
