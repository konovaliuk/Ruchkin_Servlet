package com.pis.commands;

public enum ECommands {
    home(new Home()),
    login(new Login()),
    CommandLogin(new LoginCommand()),
    logOut(new LogOutCommand()),
    orderList(new CommandOrderList()),
    commandRegister(new CommandRegister()),
    register(new Register()),
    commandProfile(new CommandProfile()),
    commandUpdateUser(new CommandUpdateUser()),
    usersList(new CommandUsersList()),
    deleteUser(new CommandDeleteUser()),
    deleteOrder(new CommandDeleteOrder()),
    addOrder(new CommandAddOrder())
//    login(new CommandLogin()),
//    logout(new CommandLogout()),
//    openOrders(new CommandOpenOrders()),
//    createOrder(new CommandCreateOrder()),
//    viewOrder(new CommandViewOrder()),
//    editOrder(new CommandEditOrder()),
//    deleteOrder(new CommandDeleteOrder()),
//    createUser(new CommandCreateUser()),
    ;
    private final ICommand command;
    ECommands(ICommand command) {
        this.command = command;
    }
    public ICommand getCommand() { return command; }
}
