package com.company.commons;

import java.util.Locale;

public enum CommandsEnum {

    SHUTDOWN(0, "/shutdown", "Выключение компьютера через 2 минуты."),
    SPACE(1, "/space", "Пробел для паузы и воспроизведения."),
    YOUTUBE_LINK(2, "/youtube", "Воспроизвести ссылку на YouTube."),
    RIGHT_ARROW(3, "/right", "Стрелка вправо для проматывания вперед."),
    LEFT_ARROW(4, "/left", "Стрелка влево для проматывания назад."),
    SOUND_LOCK_ON(5, "/soundlockon", "Включение ограничения громкости."),
    SOUND_LOCK_OFF(6, "/soundlockoff", "Выключение ограничения громкости."),
    UP_ARROW(7, "/up", "Стрелка вверх для увеличения громкости."),
    DOWN_ARROW(8, "/down", "Стрелка вниз для увеличения громкости."),
    NON_RECOGNIZED(-1, "/non_recognized", "Команда не распознана.");

    private final int id;
    private final String command, description;

    CommandsEnum(int id, String command, String description) {
        this.id = id;
        this.command = command;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getCommand() {
        return command;
    }

    public String getDescription() {
        return description;
    }

    public static CommandsEnum getEnumByCommand(String command) {
        for (CommandsEnum commandsEnum: CommandsEnum.values()) {
            if(command.contains(commandsEnum.getCommand().toLowerCase(Locale.ROOT)))
                return commandsEnum;
        }

        return NON_RECOGNIZED;
    }

    @Override
    public String toString() {
        return "CommandsEnum{" +
                "id=" + id +
                ", command='" + command + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
