package minesweeper.view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import minesweeper.model.exception.MoveLocationException;
import minesweeper.model.location.Location;
import minesweeper.model.main.Minesweeper;
import minesweeper.model.observer.MinesweeperObserver;
import minesweeper.model.state.GameState;

public class BtN_ACtN implements EventHandler<ActionEvent> {
    private Minesweeper game;
    private GUI gui;
    private Location moveloc;
    private Button button;
    public BtN_ACtN(Minesweeper game, Location loc, Button button, GUI gui) {
        this.game = game;
        this.moveloc = loc;
        this.button = button;
        this.gui = gui;
    }
    @Override
    public void handle(ActionEvent arg0) {
            if(this.game.getGameState() != GameState.LOST) {
                try {
                    game.makeSelection(moveloc);
                } catch (MoveLocationException e) { e.printStackTrace(); }

                if(game.visValue(game.board().get(moveloc)) != 0) {
                    button.setText(""+game.visValue(game.board().get(moveloc)));
                }

                button.setDisable(true);
                button.setBackground(new Background( new BackgroundFill(Color.DARKBLUE, CornerRadii.EMPTY, Insets.EMPTY) ));
                new MinesweeperObserver(game, gui).handle(arg0);
            }
        

    }
    
}
