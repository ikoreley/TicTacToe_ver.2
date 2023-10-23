package ru.practice.game.service;


import ru.practice.game.service.factory.TypesOfPlayersTeams;
import ru.practice.view.ViewGameMenu;
import ru.practice.view.ViewGameMenuRU;

import java.util.Optional;
import java.util.Scanner;

public class MenuChoose implements MenuChooseable {
    private final static MenuChoose instance = new MenuChoose();
    private MenuChoose() {}
    public static MenuChoose getInstance() {
        return instance;
    }

    Scanner scanner = new Scanner(System.in);

    final ViewGameMenu viewGameMenu = ViewGameMenuRU.getInstance();

    @Override
    public Optional<Integer> firstMenuChoose() {
        try {

            final String choosing = scanner.nextLine();
            switch (choosing) {
                case "Q", "q" -> System.exit(0);
                case "1" -> {
                    viewGameMenu.printRulesOfGame();
                    return Optional.empty();
                }
                case "2" -> {
                    viewGameMenu.printSecondMenu();
                    return Optional.of(2);
                }
                default -> throw new IllegalArgumentException("Неверно выбран пункт меню. Выбран: " + choosing);
            }
        } catch (IllegalArgumentException e) {
            System.err.println();
        }
        return Optional.empty();
    }


    @Override
    public Game secondMenuChoose() {
        try {
            TypesOfPlayersTeams result = switch (scanner.nextLine()) {
                case "0" -> TypesOfPlayersTeams.ComputerSequential_vs_COMPUTER_RANDOM;
                case "1" -> TypesOfPlayersTeams.COMPUTER_RANDOM_vs_COMPUTER_RANDOM;
                case "2" -> TypesOfPlayersTeams.HUMAN_vs_COMPUTER_RANDOM;
                case "3" -> TypesOfPlayersTeams.HUMAN_vs_HUMAN;
                default -> throw new IllegalArgumentException();
            };
            return result.createGame();

        } catch (IllegalArgumentException e) {
            System.err.println();
        }
        return null;
    }
}
