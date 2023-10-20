package ru.practice.player.model;

import ru.practice.field.model.Cell;
import ru.practice.field.model.Field;
import ru.practice.field.service.Coordinate;
import ru.practice.field.service.FieldService;
import ru.practice.field.service.Move;

import java.util.List;
import java.util.Random;

public class PlayerComputerRandom implements Player {
    private final Random random = new Random();

    @Override
    public Move doMove(Field field, Cell cell) {
        List<Coordinate> listEmptyCell = FieldService.createListEmptyCellField(field);
        return new Move(listEmptyCell.get(random.nextInt(listEmptyCell.size())), cell);
    }
}

