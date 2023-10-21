package ru.practice.field.service;

import ru.practice.field.model.Cell;
import ru.practice.field.model.Field;
import ru.practice.game.service.SettingFileInput;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FieldService {
    private int sizeField = SettingFileInput.getSettingsGame().get("sizeField");

    public Field createField(){
        return new Field(new Cell[getSizeField()][getSizeField()]);
    }

    public void fillField(Field field) {
        for(Cell[] cell: field.getField()){
            Arrays.fill(cell, Cell.EMPTY_CELL);
        }
    }

    public int getSizeField() {
        return sizeField;
    }

    public static List<Coordinate> createListEmptyCellField(Field field){
        List<Coordinate> empty = new ArrayList<>();
        for (int i = 0; i < field.getField().length; i++){
            for (int j = 0; j < field.getField().length; j++){
                if(field.getField()[i][j] == Cell.EMPTY_CELL){
                    empty.add(new Coordinate(i, j));
                }
            }
        }
        return empty;
    }

    public static boolean enteredCoordinate(Field field, int row, int col){
        List<Coordinate> empty = createListEmptyCellField(field);
        for (Coordinate coordinate: empty){
            if (coordinate.firstValue() == row && coordinate.secondValue() == col) return true;
        }
        return false;
    }

}
