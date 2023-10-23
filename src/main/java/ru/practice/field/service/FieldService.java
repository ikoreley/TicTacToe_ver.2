package ru.practice.field.service;

import ru.practice.field.model.Cell;
import ru.practice.field.model.Field;
import ru.practice.game.service.SettingFileInput;

import java.util.*;

public class FieldService implements FieldServiceable {
    private static final int sizeField = SettingFileInput.getSettingsGame().get("sizeField");


    @Override
    public Field generateField() {
        final Field field = createField();
        fillField(field);
        return field;
    }

    private Field createField(){
        return new Field(new Cell[getSizeField()][getSizeField()]);
    }

    private void fillField(Field field) {
        for(Cell[] cell: field.getField()){
            Arrays.fill(cell, Cell.EMPTY_CELL);
        }
        createMapEmptyCellField(field);
    }

    private int getSizeField() {
        return sizeField;
    }

    public static void createMapEmptyCellField(Field field){
        final Map<Coordinate, Cell> emptyCells = field.getEmptyCells();
        for (int i = 0; i < field.getField().length; i++){
            for (int j = 0; j < field.getField().length; j++){
                emptyCells.put(new Coordinate(i, j), Cell.EMPTY_CELL);
            }
        }
    }

    public static boolean enteredCoordinate(Field field, int row, int col){
        if(row < 0 || row >= sizeField) return false;
        if(col < 0 || col >= sizeField) return false;

        final Cell cell = field.getCell(row, col);
        return cell == Cell.EMPTY_CELL;

    }
}
