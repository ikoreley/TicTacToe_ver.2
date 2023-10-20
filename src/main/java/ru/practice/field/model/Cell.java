package ru.practice.field.model;

public enum Cell {
    X_CELL("X"),
    O_CELL("O"),
    EMPTY_CELL("_");

    private String symbol;

    Cell(String symbol) {
        this.symbol = symbol;
    }
    public String getSymbol(){
        return symbol;
    }
}
