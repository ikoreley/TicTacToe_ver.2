package ru.practice.game.service;

import ru.practice.field.model.Field;
import ru.practice.field.service.FieldService;
import ru.practice.field.service.FieldServiceable;
import ru.practice.view.ViewFieldAndGame;
import ru.practice.view.ViewGameMenu;
import ru.practice.view.ViewGameMenuRU;


public class ProcessGame {

    private static final ProcessGame instance = new ProcessGame();

    private ProcessGame(){}
    public static ProcessGame getInstance(){
        return instance;
    }

    private final MenuChooseable menuChoose = MenuChoose.getInstance();
    private final ViewGameMenu viewGameMenu = ViewGameMenuRU.getInstance();

    public void start() {

        viewGameMenu.printMainMenu();

        if (menuChoose.firstMenuChoose().isEmpty()) start();

        Game game = menuChoose.secondMenuChoose();

        FieldServiceable fieldService = new FieldService();

        Field field = fieldService.generateField();

        ViewFieldAndGame.printField(field);

        game.play(field);
    }
}
