package ru.practice.game.service;

import ru.practice.field.model.Field;
import ru.practice.field.service.FieldService;
import ru.practice.view.ViewFieldAndGame;
import ru.practice.view.ViewGameMenu;

import java.util.Scanner;

public class ProcessGame {
    private ProcessGame(){}
    private static class ProcessGameHolder{
        private final static ProcessGame instance = new ProcessGame();
    }
    public static ProcessGame getInstance(){
        return ProcessGameHolder.instance;
    }
    Scanner scanner = new Scanner(System.in);
    ViewGameMenu viewGameMenu = ViewGameMenu.getInstance();
    MenuChoose menuChoose = MenuChoose.getInstance();

    public void start() {

        viewGameMenu.printMainMenu();

        if (null == menuChoose.firstMenuChoose(scanner, viewGameMenu)) start();

        Game game = menuChoose.secondMenuChoose(scanner);

        FieldService fieldService = new FieldService();
        Field field = fieldService.createField();
        fieldService.fillField(field);
        ViewFieldAndGame.printField(field);
        game.play(field);
    }
}
