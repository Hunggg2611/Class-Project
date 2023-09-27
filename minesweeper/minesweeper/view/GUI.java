package minesweeper.view;

import java.util.HashMap;

import java.util.Map;


import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import minesweeper.model.exception.MineCountException;
import minesweeper.model.location.Location;
import minesweeper.model.main.Minesweeper;

public class GUI extends Application{

    private static Minesweeper game;
    private Map<Location, Button> btnboard;
    private Label minesNum;
    private Label movesLabel;
    private final int rows = 10; 
    private final int cols = 10; 
    
    @Override 
    public void start(Stage stage) throws MineCountException { 
        game = new Minesweeper(rows, cols, 10);
        btnboard = new HashMap<>();
        GridPane visBoard = new GridPane(); 
        for(int r=0; r < this.rows; r ++) { 
            for(int c = 0; c < this.cols; c++) {
                Button cell = guiCell("", new Location(r, c), this);
                btnboard.put(new Location(r, c),cell);
                visBoard.add(cell,r,c);
            }
        }
        VBox vbox = new VBox(); 
        HBox hbox = new HBox(); 

        minesNum = new Label("MINES: " + game.getMineCount()); 
        minesNum.setFont(new Font("Arial", 24));
        minesNum.setTextFill(Color.RED); 
        movesLabel = new Label("MOVES: " + game.getMoveCount()); 
        movesLabel.setFont(new Font("Arial", 24));
        movesLabel.setTextFill(Color.BLUE);
        // minesNum.setAlignment(Pos.TOP_LEFT);
        // movesLabel.setAlignment(Pos.TOP_RIGHT);

        hbox.getChildren().add(minesNum); 
        hbox.getChildren().add(movesLabel); 
        hbox.getChildren().add(guiReset("RESET", this)); 

        vbox.getChildren().add(hbox); 
        vbox.getChildren().add(visBoard); 

        Scene scene = new Scene(vbox, 250, 250); 
        stage.setScene(scene);
        stage.show(); 
    }

    /* METHOD STATUS: TODO: INCOMPLETE
     *        @Return ~ a JavaFX Button (CELL)
     */
    public static Button guiCell(String text, Location loc, GUI gui) {
        Button button = new Button(text);
        button.setPrefSize(100, 100);
        button.setPrefSize(75, 75);
        button.setPadding(new Insets(5));
        button.setOnAction(new BtN_ACtN(game, loc, button, gui));
        return button;
    }
    /* METHOD STATUS: TODO: INCOMPLETE
     *        @Return ~ a JavaFX Button (RESET)
     */
    public static Button guiReset(String text, GUI gui) {
        Button button = new Button("RESET");
        button.setPrefSize(100, 100);
        button.setPrefSize(75, 75);
        button.setPadding(new Insets(5));
        button.setBackground(new Background( new BackgroundFill(Color.LIGHTBLUE, CornerRadii.EMPTY, Insets.EMPTY) ));
        button.setOnAction(new BtN_RESET(game, gui, button));
        return button;
    }

    public void reset() {
        btnboard = new HashMap<>();
        GridPane visBoard = new GridPane(); 
        for(int r=0; r < this.rows; r ++) { 
            for(int c = 0; c < this.cols; c++) {
                Button cell = guiCell("", new Location(r, c), this);
                btnboard.put(new Location(r, c),cell);
                visBoard.add(cell,r,c);
            }
        }

        minesNum = new Label("MINES: " + game.getMineCount()); 
        minesNum.setFont(new Font("Arial", 24));
        minesNum.setTextFill(Color.RED); 
        movesLabel = new Label("MOVES: " + game.getMoveCount()); 
        movesLabel.setFont(new Font("Arial", 24));
        movesLabel.setTextFill(Color.BLUE);
        // minesNum.setAlignment(Pos.TOP_LEFT);
        // movesLabel.setAlignment(Pos.TOP_RIGHT);
    }

    public void hint() {
        for(Location loc : btnboard.keySet()) {
            if(!game.mines().contains(loc)) {
                if(!btnboard.get(loc).isDisabled()) {
                    btnboard.get(loc).setBackground(new Background( new BackgroundFill(Color.GREENYELLOW, CornerRadii.EMPTY, Insets.EMPTY) ));
                }
            }
        }
    }

    public Map<Location, Button> btnboard(){
        return btnboard;
    }

    public static void main(String[] args) { 
        launch(args); 
    }

    public void setGame(Minesweeper gameNew) { 
        this.game = gameNew; 
    }
}