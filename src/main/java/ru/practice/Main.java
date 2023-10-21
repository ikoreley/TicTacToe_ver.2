package ru.practice;

import ru.practice.game.service.ProcessGame;

public class Main {
    public static void main(String[] args) {

        ProcessGame processGame = ProcessGame.getInstance();
        processGame.start();

    }
}
