package minesweeper.model.observer;



import java.util.Map;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import minesweeper.model.location.Location;
import minesweeper.model.main.Minesweeper;
import minesweeper.model.state.GameState;
import minesweeper.view.GUI;

public class MinesweeperObserver implements EventHandler<ActionEvent>{

    private Minesweeper game;
    private GUI gui;

    public MinesweeperObserver(Minesweeper game, GUI gui) { 
        this.game = game;
        this.gui = gui;
    }

    @Override
    public void handle(ActionEvent event) {
        if(game.getGameState() == GameState.LOST) {
            for(Location m_loc : game.mines()) {
                Button button = gui.btnboard().get(m_loc);
                Image mineImage = new Image(".\\media\\images\\mine24.png"); 
                ImageView mineView = new ImageView(mineImage);
                button.setGraphic(mineView);
            }
        }
    }
    
}
