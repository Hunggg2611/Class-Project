package minesweeper.view;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import minesweeper.model.exception.MineCountException;
import minesweeper.model.main.Minesweeper;

public class BtN_RESET implements EventHandler<ActionEvent> {
    private Minesweeper game;
    private GUI gui;
    private Button button;
    public BtN_RESET(Minesweeper game, GUI gui, Button button) {
        this.game = game;
        this.gui = gui;
        this.button = button;
    }

    @Override
    public void handle(ActionEvent arg0) {
        this.game.reset();
    }
    
}
