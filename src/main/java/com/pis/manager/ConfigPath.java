package com.pis.manager;

public enum ConfigPath {
    home("/home.jsp"),
    login("/login.jsp"),
    orders("/orders.jsp"),
    register("/register.jsp"),
    profile("/profile.jsp"),
    users("/users.jsp")
    ;
    private final String commandPath;

    ConfigPath(String commandPath) {
        this.commandPath = commandPath;
    }

    public String getCommandPath() {
        return commandPath;
    }
}
