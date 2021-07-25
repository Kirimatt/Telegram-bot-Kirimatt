package com.company.commons;

public enum CommandsEnum {

    SHUTDOWN(0, "/shutdown", "Выключение компьютера через 2 минуты."),
    SPACE(1, "/space", "Пробел для паузы и воспроизведения."),
    YOUTUBE_LINK(2, "/youtube", "Воспроизвести ссылку на YouTube.");

    private final int num;
    private final String command, description;

    CommandsEnum(int num, String command, String description) {
        this.num = num;
        this.command = command;
        this.description = description;
    }

    public int getNum() {
        return num;
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
                "num=" + num +
                ", command='" + command + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
