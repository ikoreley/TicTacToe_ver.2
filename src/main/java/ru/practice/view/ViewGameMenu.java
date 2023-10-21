package ru.practice.view;

public class ViewGameMenu {

    public void printMainMenu(){
        String MAIN_MENU = """
                Игра Крестики-Нолики
                Выберете пункт меню:
                1 - Ознакомится с правилами игры
                2 - Начать Игру
                Q - Выход из игры
                """;
        System.out.println(MAIN_MENU);
    }

    public void printSecondMenu(){
        String SECOND_MENU = """
                Выберете сложность игры:
                0 - ComputerSequential-ComputerRandom
                1 - ComputerRandom-ComputerRandom
                2 - Human-ComputerRandom
                3 - Human-Human
                """;
        System.out.println(SECOND_MENU);
    }
    public void printRulesOfGame(){
        String RULES_OF_GAME = """
                после выбора сложности игры вам будет случайно назначен Х или О, первый ход делают крестики. 
                Координаты ячейки вводятся в формате 00, 02, 10 и т.д.
                Игра идет до установки подряд трех символов по вертикали или горизонтали или диоганали. Кто первый 
                выставит свои символы тот победит. Ничья когда поле занято и и никто не смог расставить три символа подряд.
                """;
        System.out.println(RULES_OF_GAME);
    }

}
