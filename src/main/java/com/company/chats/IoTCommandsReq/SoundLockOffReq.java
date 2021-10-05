package com.company.chats.IoTCommandsReq;

import org.telegram.telegrambots.meta.api.objects.Update;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.Port;
import java.awt.*;
import java.io.IOException;

public class SoundLockOffReq extends IoTCommandBuild {

    @Override
    public String buildCommand(Update update) throws IOException, AWTException {

        if (soundLockProcess != null)
            soundLockProcess.destroyForcibly();

        cmdExecute(
                "taskkill /F /IM soundlock.exe"
        );
        Robot rb = new Robot();
        rb.delay(5000);
        SoundVolumeDemo.sr();
        //TODO: НЕ РАБОТАЕТ
        return "Killing sound lock program...\n";
    }

    static class SoundVolumeDemo {
        public static void sr() {
            Port.Info source = Port.Info.SPEAKER;
            //        source = Port.Info.LINE_OUT;
            //        source = Port.Info.HEADPHONE;

            if (AudioSystem.isLineSupported(source)) {
                try {
                    Port outline = (Port) AudioSystem.getLine(source);
                    outline.open();
                    FloatControl volumeControl = (FloatControl) outline.getControl(FloatControl.Type.VOLUME);
                    System.out.println("       volume: " + volumeControl.getValue());
                    float v = 1F;
                    volumeControl.setValue(v);

                } catch (LineUnavailableException ex) {
                    System.err.println("source not supported");
                    ex.printStackTrace();
                }
            }
        }

    }
}
