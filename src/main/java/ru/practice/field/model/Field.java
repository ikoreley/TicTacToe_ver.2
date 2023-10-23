package ru.practice.field.model;

import ru.practice.field.service.Coordinate;

import java.util.HashMap;
import java.util.Map;

public class Field {
    private Cell[][] cells;
    private final Map<Coordinate, Cell> emptyCells;

    public Field(Cell[][] cells) {
        this.cells = cells;
        emptyCells = new HashMap<>();
    }

    public Map<Coordinate, Cell> getEmptyCells() {
        return emptyCells;
    }

    public Cell[][] getField() {
        return cells;
    }

    public void setField(Cell[][] cells) {
        this.cells = cells;
    }

    public void setCell(int row, int col, Cell cell){
        cells[row][col] = cell;
    }

    public Cell getCell(int row, int col){
        return cells[row][col];
    }

}
