package ru.practice.player.model;


import ru.practice.field.model.Cell;
import ru.practice.field.model.Field;
import ru.practice.field.service.Coordinate;
import ru.practice.field.service.FieldService;
import ru.practice.field.service.Move;
import ru.practice.view.ViewFieldAndGame;

import java.util.Scanner;

public class PlayerHuman implements Player {

    private final Scanner scanner;

    public PlayerHuman(Scanner scanner) {
        this.scanner = scanner;
    }
    public PlayerHuman(){
        this(new Scanner(System.in));
    }


    @Override
    public Move doMove(Field field, Cell cell) {

        ViewFieldAndGame.printTurn(cell);
        int coutn=0;
        while (true) {
            String coord = scanner.nextLine();
            int row = Character.getNumericValue(coord.charAt(0));
            int col = Character.getNumericValue(coord.charAt(1));

            if (FieldService.enteredCoordinate(field, row, col)) {
                return new Move(new Coordinate(row, col), cell);
            }

            ViewFieldAndGame.printErrorCoordinate(row, col);

            coutn++;
            if (coutn == 3) return null;
        }
    }
}
