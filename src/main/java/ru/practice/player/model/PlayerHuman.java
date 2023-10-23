package ru.practice.player.model;


import ru.practice.field.model.Cell;
import ru.practice.field.model.Field;
import ru.practice.field.service.Coordinate;
import ru.practice.field.service.FieldService;
import ru.practice.field.service.Move;
import ru.practice.view.ViewFieldAndGame;

import java.util.InputMismatchException;
import java.util.Scanner;

public class PlayerHuman implements Player {

    private final Scanner scanner;

    public PlayerHuman(Scanner scanner) {
        this.scanner = scanner;
    }

    public PlayerHuman() {
        this(new Scanner(System.in));
    }


    @Override
    public Move doMove(Field field, Cell cell) {

        ViewFieldAndGame.printTurn(cell);
        int coutn = 0;
        while (true) {
            try {
                System.out.println("Выберите ряд");
                int row = scanner.nextInt(); // 1 1; 11; 1 enter 1 enter
                System.out.println("Выберите столбец");
                int col = scanner.nextInt(); // 1 1; 11; 1 enter 1 enter

                if (FieldService.enteredCoordinate(field, row, col)) {
                    return new Move(new Coordinate(row, col), cell);
                }
                ViewFieldAndGame.printErrorCoordinate(row, col);
            } catch (InputMismatchException e) {
                System.out.println("Вы ввели неверные координаты");
            }

                if (coutn++ == 3) {
                    ViewFieldAndGame.printManyOfWrongAttempts(cell);
                    return new Move(field.getEmptyCells().entrySet().iterator().next().getKey(), cell);
                }
            }
        }
    }
