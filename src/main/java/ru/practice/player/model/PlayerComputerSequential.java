package ru.practice.player.model;

import ru.practice.field.model.Cell;
import ru.practice.field.model.Field;
import ru.practice.field.service.Move;

public class PlayerComputerSequential implements Player{
    @Override
    public Move doMove(Field field, Cell cell) {
        return new Move(field.getEmptyCells().entrySet().iterator().next().getKey(), cell);
    }
}
