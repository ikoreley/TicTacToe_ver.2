package ru.practice.view;


import ru.practice.field.model.Cell;
import ru.practice.field.model.Field;
import ru.practice.game.service.ResultGame;

public class ViewFieldAndGame {

    public static void printField(Field field){
        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i < field.getField().length; i++){
            for (int j = 0; j < field.getField()[i].length; j++){
                sb.append('|');
                sb.append(field.getField()[i][j].getSymbol());
            }
            sb.append('|');
            sb.append('\n');
        }
        System.out.println(sb);
    }

    public static void printTurn(Cell cell){
        System.out.println("Enter " + cell + "'s turn");
        System.out.println("RowCol: ");
    }
    public static void printErrorCoordinate(int row, int col){
        System.out.println("Entered " + row + " " + col + "uncorrected coordinate");
    }
    public static void printResultGame(Cell cell, ResultGame resultGame){
        switch (resultGame){
            case WIN -> System.out.println("Win " + cell);
            case DRAW -> System.out.println("DRAW");
            case LOSE -> System.out.println("LOSE " + cell);
        }
    }

}
