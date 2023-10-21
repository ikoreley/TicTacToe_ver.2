package ru.practice.game.service;


import ru.practice.game.service.factory.TypesOfPlayersTeams;
import ru.practice.view.ViewGameMenu;

import java.util.Scanner;

public class MenuChoose {
    private MenuChoose(){}
    private static class MenuChooseHolder{
        private final static MenuChoose instance = new MenuChoose();
    }
    public static MenuChoose getInstance(){
        return MenuChooseHolder.instance;
    }

    Scanner scanner = new Scanner(System.in);

    public Integer firstMenuChoose(ViewGameMenu viewGameMenu){
        try {
            switch (scanner.nextLine()){
                case "Q","q" -> System.exit(0);
                case "1" -> {
                    viewGameMenu.printRulesOfGame();
                    return null;
                }
                case "2" -> {
                    viewGameMenu.printSecondMenu();
                    return 2;
                }
                default -> throw new IllegalArgumentException();
            }
        }catch (IllegalArgumentException e){
            System.err.println(e);
        }
        return null;
    }


    //TODO: remake method!
    public Game secondMenuChoose(){
        try {
            TypesOfPlayersTeams result = switch (scanner.nextLine()){
                case "0" -> TypesOfPlayersTeams.ComputerSequential_vs_COMPUTER_RANDOM;
                case "1" -> TypesOfPlayersTeams.COMPUTER_RANDOM_vs_COMPUTER_RANDOM;
                case "2" -> TypesOfPlayersTeams.HUMAN_vs_COMPUTER_RANDOM;
                case "3" -> TypesOfPlayersTeams.HUMAN_vs_HUMAN;
                default -> throw new IllegalArgumentException();
            };
            return result.createGame();

        }catch (IllegalArgumentException e){
            System.err.println(e);
        }
        return null;
    }
}
