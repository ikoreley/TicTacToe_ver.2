package ru.practice.player.model;

import ru.practice.field.model.Cell;
import ru.practice.field.model.Field;
import ru.practice.field.service.Move;

public interface Player {
    Move doMove(Field field, Cell cell);
}
