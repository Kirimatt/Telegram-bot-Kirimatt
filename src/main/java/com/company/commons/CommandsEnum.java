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
    OPEN_LINKS(9, "/openlinks", "Открывает вкладки с заданными ссылками."),
    START_LINKS(10, "/startlinks", "Открывает начальные вкладки."),
    CHANGE_CHECK_SITE(11, "/changecheck", "Меняет последний сайт для просмотра."),
    JUTSU_NEXT_EPISODE(12, "/jutsunext", "Пролистывает эпизод на следующий Jutsu."),
    JUTSU_OPEN(13, "/jutsu", "Открывает ссылку на Jutsu."),
    FULL_SIZE(14, "/full", "Открывает на полное окно."),
    HELP(15, "/help", "Показывает все команды."),
    EXIT(16, "/exit", "Выходит из программы."),
    JUTSU_SKIP_OP(17, "/skip", "Пропускает опенинг."),
    NON_RECOGNIZED(-1, "/non_recognized", "Команда не распознана.");

    private final int id;
    private final String command, description;

    CommandsEnum(int id, String command, String description) {
        this.id = id;
        this.command = command;
        this.description = description;
    }

    public static CommandsEnum getEnumByCommand(String command) {
        for (CommandsEnum commandsEnum : CommandsEnum.values()) {
            if (command.contains(commandsEnum.getCommand().toLowerCase(Locale.ROOT)))
                return commandsEnum;
        }

        return NON_RECOGNIZED;
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

    @Override
    public String toString() {
        return "CommandsEnum{" +
                "id=" + id +
                ", command='" + command + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
