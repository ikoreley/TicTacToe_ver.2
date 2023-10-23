package ru.practice.game.service;

import java.util.Optional;

public interface MenuChooseable {
    Optional<Integer> firstMenuChoose();
    Game secondMenuChoose();
}
