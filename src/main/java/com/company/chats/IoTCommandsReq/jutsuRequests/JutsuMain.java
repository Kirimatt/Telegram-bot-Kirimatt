package com.company.chats.IoTCommandsReq.jutsuRequests;

import com.company.chats.IoTCommandsReq.IoTCommandBuild;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Абстрактный класс для объединения всех JutSu команд
 */
public abstract class JutsuMain extends IoTCommandBuild {
    protected static ChromeDriver driver;
    protected Thread threadAuto = new Thread(new JutsuAutoMode.AutoMode());

}
