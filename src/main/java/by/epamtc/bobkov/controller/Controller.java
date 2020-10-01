package main.java.by.epamtc.bobkov.controller;

import main.java.by.epamtc.bobkov.controller.command.Command;
import main.java.by.epamtc.bobkov.controller.command.CommandProvider;
import main.java.by.epamtc.bobkov.dao.UserDao;
import main.java.by.epamtc.bobkov.dao.impl.UserDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Controller extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserDao userDao = new UserDaoImpl();

    private static final String PARAMETER_COMMAND = "command";
    private final CommandProvider commandProvider = new CommandProvider();

    public Controller() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String commandName = request.getParameter(PARAMETER_COMMAND);
        Command command = commandProvider.getCommand(commandName.toUpperCase());
        command.execute(request, response);

    }
}
