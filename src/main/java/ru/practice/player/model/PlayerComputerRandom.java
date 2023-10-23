package ru.practice.player.model;

import ru.practice.field.model.Cell;
import ru.practice.field.model.Field;
import ru.practice.field.service.Coordinate;
import ru.practice.field.service.Move;

import java.util.Random;

public class PlayerComputerRandom implements Player {
    private final Random random = new Random();

    @Override
    public Move doMove(Field field, Cell cell) {
        Coordinate result = field.getEmptyCells().keySet().stream().toList().get(random.nextInt(field.getEmptyCells().size()));
        return new Move(result , cell);
    }


}

