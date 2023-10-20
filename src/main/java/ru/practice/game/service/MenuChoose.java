package ru.practice.game.service;


import ru.practice.game.service.factory.TypesOfPlayersTeams;
import ru.practice.view.ViewGameMenu;

import java.util.Scanner;

public class MenuChoose {

    public Integer firstMenuChoose(Scanner scanner, ViewGameMenu viewGameMenu){
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
    public Game SecondMenuChoose(Scanner scanner){
        try {
            switch (scanner.nextLine()){
                case "0" -> {
                    return TypesOfPlayersTeams.ComputerSequential_vs_COMPUTER_RANDOM.createGame();
                }
                case "1" -> {
                    return TypesOfPlayersTeams.COMPUTER_RANDOM_vs_COMPUTER_RANDOM.createGame();
                }
                case "2" -> {
                    return TypesOfPlayersTeams.HUMAN_vs_COMPUTER_RANDOM.createGame();
                }
                case "3" -> {
                    return TypesOfPlayersTeams.HUMAN_vs_HUMAN.createGame();
                }
                default -> throw new IllegalArgumentException();
            }
        }catch (IllegalArgumentException e){
            System.err.println(e);
        }
        return null;
    }
}
