package ru.practice.game.service;

import ru.practice.field.model.Cell;
import ru.practice.field.model.Field;
import ru.practice.field.service.Move;
import ru.practice.player.model.Player;
import ru.practice.view.ViewFieldAndGame;


public class Game {
    private final Player player1;
    private final Player player2;

    private Cell turn = (int) (Math.random()*2) == 0 ? Cell.X_CELL : Cell.O_CELL;

    public Game(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;

    }

    public void play(final Field field){

        while (true) {
            Player player = (turn==Cell.X_CELL) ? player1: player2;

            ResultGame resultGame =  makeMoveField(player.doMove(field, turn), field);
            if (resultGame != ResultGame.UNKNOWN) {
                ViewFieldAndGame.printResultGame(turn, resultGame, field);
                break;
            }

            System.out.println(turn);
            ViewFieldAndGame.printField(field);
            changeOfTurn(turn);
        }
    }

    private ResultGame makeMoveField(Move move, Field field){
        field.setCell(move.coordinate().firstValue(), move.coordinate().secondValue(), move.cell());
        field.getEmptyCells().remove(move.coordinate());

        int countCellForWin = field.getField().length;
        int diag1 = 0;
        int diag2 = 0;
        for (int u = 0; u < countCellForWin; u++){
            int rowCount = 0;
            int colCount = 0;
            for(int v = 0; v < countCellForWin; v++){
                if (field.getCell(u, v) == move.cell()){
                    rowCount++;
                }
                if(field.getCell(v, u)==move.cell()){
                    colCount++;
                }
            }
            if(rowCount == countCellForWin || colCount == countCellForWin){
                return ResultGame.WIN;
            }
            if(field.getCell(u, u)==move.cell()){
                diag1++;
            }
            if(field.getCell(u, (field.getField().length-1)-u)==move.cell()){
                diag2++;
            }

        }
        if(diag1 == countCellForWin || diag2 == countCellForWin){
            return ResultGame.WIN;
        }

//        if(FieldServiceImpl.createListEmptyCellField(field).isEmpty()) {
        if(field.getEmptyCells().isEmpty()) {
            return ResultGame.DRAW;
        }
        return ResultGame.UNKNOWN;
    }

    private void changeOfTurn(Cell cell){
        turn = (cell == Cell.X_CELL) ? Cell.O_CELL : Cell.X_CELL;
    }
}
