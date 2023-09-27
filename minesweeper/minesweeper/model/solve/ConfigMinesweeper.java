package minesweeper.model.solve;

import java.util.Collection;

import backtracker.Configuration;
import minesweeper.model.main.Minesweeper;
import minesweeper.model.state.GameState;

public class ConfigMinesweeper implements Configuration{

    private Minesweeper game; 

    @Override
    public Collection<Configuration> getSuccessors() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean isValid() {
        return true;
    }

    @Override
    public boolean isGoal() {
        if(game.getGameState() == GameState.WON) { 
            return true; 
        }
        return false;
    }

    @Override
    public String toString() { 
        // TODO prints selections so far and the current configuration
        return null; 
    }
    
    public static ConfigMinesweeper returnConfig(Minesweeper minesweeper) { 
        // TODO this method is called with a minesweeper object and returns a configuration instance
        // this will be used in backtracker
        return null; 
    }
}
