package ru.practice.field.model;

public class Field {
    Cell[][] cells;

    public Field(Cell[][] cells) {
        this.cells = cells;
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
