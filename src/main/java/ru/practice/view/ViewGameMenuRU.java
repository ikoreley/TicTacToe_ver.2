package ru.practice.view;

public class ViewGameMenuRU implements ViewGameMenu{
    private final static ViewGameMenuRU instance = new ViewGameMenuRU();
    private ViewGameMenuRU(){}

    public static ViewGameMenuRU getInstance(){
        return instance;
    }

    @Override
    public void printMainMenu(){
        System.out.println("""
                Игра Крестики-Нолики
                Выберете пункт меню:
                1 - Ознакомится с правилами игры
                2 - Начать Игру
                Q - Выход из игры
                """);
    }

    @Override
    public void printSecondMenu(){
        System.out.println("""
                Выберете сложность игры:
                0 - ComputerSequential-ComputerRandom
                1 - ComputerRandom-ComputerRandom
                2 - Human-ComputerRandom
                3 - Human-Human
                """);
    }

    @Override
    public void printRulesOfGame(){
        System.out.println("""
                после выбора сложности игры вам будет случайно назначен Х или О, первый ход делают крестики.
                Координаты ячейки вводятся в формате 00, 02, 10 и т.д.
                Игра идет до установки подряд трех символов по вертикали или горизонтали или диоганали. Кто первый
                выставит свои символы тот победит. Ничья когда поле занято и и никто не смог расставить три символа подряд.
                """);
    }

}
