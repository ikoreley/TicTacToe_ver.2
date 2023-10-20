package ru.practice.game.service.factory;

import ru.practice.game.service.Game;
import ru.practice.player.model.PlayerComputerRandom;
import ru.practice.player.model.PlayerComputerSequential;
import ru.practice.player.model.PlayerHuman;

public enum TypesOfPlayersTeams {

    ComputerSequential_vs_COMPUTER_RANDOM {
        public Game createGame(){
            return new Game(new PlayerComputerSequential(), new PlayerComputerRandom());
        }
    }, COMPUTER_RANDOM_vs_COMPUTER_RANDOM {
        public Game createGame(){
            return new Game(new PlayerComputerRandom(), new PlayerComputerRandom());
        }
    }, HUMAN_vs_COMPUTER_RANDOM {
        public Game createGame(){
            return new Game(new PlayerHuman(), new PlayerComputerRandom());
        }
    }, HUMAN_vs_HUMAN {
        public Game createGame(){
            return new Game(new PlayerHuman(), new PlayerHuman());
        }
    };

    public abstract Game createGame();
}
