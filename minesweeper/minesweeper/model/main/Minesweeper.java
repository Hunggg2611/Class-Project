package minesweeper.model.main;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import minesweeper.model.exception.MoveLocationException;
import minesweeper.model.cell.Cell;
import minesweeper.model.exception.MineCountException;
import minesweeper.model.location.Location;
import minesweeper.model.state.GameState;


// CLASS OVERALL TODO: INCOMPLETE
public class Minesweeper {
    public static char MINE = 'M';
    public static char COVERED = '-'; 
    public static char FLAG  = '+'; 
        private Map<Location,Cell> board;
        private Set<Location> mines;
        private GameState state; 
        private int moves;
        private final int rows;
        private final int cols;


    /* CONSTRUCTOR STATUS: TODO: INCOMPLETE
     *    --> JUnit ~ throws 'MineCountException'
     *        JUnit ~ 'board' .size() is correct
     *    --> JUnit ~ all data structures are inti (I.E) not null
     * 
     *        @Param ~ int rows, int cols, int mineCount
     * 
     *        @Logic ~ [ add rows*cols Cell to board ] + [ for minCount overwrite random Cell to MINE ]
     *        
     *        @Return ~ Minesweeper game  
     *    --> @Handle ~ mine Location overlapping
     */
        public Minesweeper(int rows, int cols, int mineCount) throws MineCountException {
            Random r = new Random(); this.state = GameState.NOT_STARTED;
            this.board = new HashMap<>(); this.mines = new HashSet<>();
            this.moves = 0; this.rows = rows; this.cols = cols;
            for(int i=0; i<rows; i++) { //cells
                for(int j=0; j<cols; j++) {
                    Location l = new Location(i, j);
                    board.put(l, new Cell(""+COVERED,l));
                }
            }
            for(int i=0; i<mineCount; i++) { //mines
                Location l = new Location(r.nextInt(rows), r.nextInt(cols));
                board.put(l, new Cell(""+MINE, l));
                this.mines.add(l);
            }

        }

        public Minesweeper(Minesweeper minesweeper) { 
            Random r = new Random(); 
            this.state = GameState.IN_PROGRESS; 
            this.board = new HashMap<>(); 
            this.mines = new HashSet<>(); 
            this.moves = minesweeper.getMoveCount(); 
            this.rows = minesweeper.getRows(); 
            this.cols = minesweeper.getCols(); 
            for(int s=0; s<rows; s++) { 
                for(int q=0; q<cols; q++) { 
                    Location l3 = new Location(s, q); 
                    board.put(l3, new Cell(""+COVERED, l3)); 
                }
            }
            for(Location mine : minesweeper.mines) { 
                Location l2 = new Location(mine.getRow(), mine.getCol()); 
                board.put(l2, new Cell("" + MINE, l2)); 
                this.mines.add(l2); 
            }
        }

        public int getRows() { 
            return this.rows; 
        }

        public int getCols() { 
            return this.cols; 
        }

        public int getMineCount() { 
            return this.mines.size(); 
        }

    /* METHOD STATUS: TODO: INCOMPLETE
     *    --> JUnit ~ throws 'MoveLocationException' (I.E) MineSweeperException
     *    --> JUnit ~ 'move' is incremeted
     *        @Param ~ Location loc
     * 
     *    --> @Logic ~ [ 'state' is IN_PROGRESS ] + [ 'board' .contains(loc) ] + [ get Cell at 'loc' ] + [ '.reval()' ] + 
     *                 [ calc val where .isNextTo() forall 'mines' ] + [ 'this.moves' increment ]
     *        
     *        @Handle ~ loc doesn't exist
     *        @Handle ~ loc is already revaled  
     *    --> @Handle ~ state is not expeceted value
     */
        public void makeSelection(Location loc) throws MoveLocationException {
            if((this.state == GameState.IN_PROGRESS || state == GameState.NOT_STARTED ) && this.isVaild()) {
                this.state = GameState.IN_PROGRESS;
                if(this.board.containsKey(loc)) {
                    Cell cell = this.board.get(loc); cell.reveal(); int num = 0;
                    if(mines.contains(loc)) {
                        this.state = GameState.LOST;
                        return;
                    }
                    for(Location m_loc : this.mines) {
                        if(cell.isNextTo(m_loc)) { num++; }
                    }

                    cell.val(""+num);
                    this.moves++;

                } else { throw new MoveLocationException("Invaid Location Parameter"); }
                
            }
        }
    
    /* METHOD STATUS: TODO: INCOMPLETE
     *    --> JUnit ~ should return a Collection<Location>
     *    --> JUnit ~ should true forall .isCovered Location
     * 
     *        @Logic ~ [ new Set 'vaildMoves' ] + [ forall Cell in 'board' where Cell is covered 'vaildMoves' .add(Cell) ]
     * 
     *        @Return ~ Set 'vaildMoves' where Cell are still covered
     *    --> @Handle ~ Set 'vaildMoves' size is 0
     */
        public Collection<Location> getPossibleSelections() {
            Set<Location> validMoves = new HashSet<>(); 
            for(Location loc : board.keySet()) { 
                if(board.get(loc).isCovered()) { 
                    validMoves.add(loc); 
                }
            }
            return validMoves;
        }
    
    /* METHOD STATUS: TODO: INCOMPLETED
     *    --> JUnit ~ should return board num elements
     *        @Return ~ 'board' size or num cells
     */
        public int size() {
            return this.board.size();
        }
    

    /* METHOD STATUS: TODO: INCOMPLETE
     *    --> JUnit ~ should a integer value
     *        @Return ~ 'this.moves' moves made
     */
        public int getMoveCount() {
            return this.moves;
        }


    /* METHOD STATUS: TODO: INCOMPLETE
     *    --> JUnit ~ should a vaild GameState value
     *        @Return ~ current game state 'this.state'
     */
        public GameState getGameState() {
            return this.state;
        }


        /* METHOD STATUS: TODO: INCOMPLETE
     *    --> JUnit ~ should return if current board is Vaild
     *        @Return ~ Boolean if you hit a mine yet
     */
    public Boolean isVaild() {
        for(Location loc : board.keySet()) { 
            if(!board.get(loc).isCovered()) { 
                Cell cell = board.get(loc);
                if(cell.toString() == "M") {
                    return false;
                }
            }
        }
        return true;
    }

    /* METHOD STATUS: TODO: INCOMPLETE
     *    --> JUnit ~ should change 'state' to IN_PROGRESS if NOT_STARTED
     *        @Logic ~ [ if 'this.state' is 'NOT_STARTED' set 'IN_PROGRESS' ]
     */
        public void start() {
            if(this.state == GameState.NOT_STARTED) { 
                this.state = GameState.IN_PROGRESS; 
            }
        }

    /* METHOD STATUS: TODO: INCOMPLETE
     *        @Param ~ int rows, int cols, int mineCount
     * 
     *        @Logic ~ [ add rows*cols Cell to board ] + [ for minCount overwrite random Cell to MINE ]
     *        
     *        @Return ~ Minesweeper game  
     *    --> @Handle ~ mine Location overlapping
     */
        public void reset() {
            Random r = new Random(); this.state = GameState.NOT_STARTED;
            this.board = new HashMap<>(); int mineCount = mines.size();
            this.moves = 0; this.mines = new HashSet<>();
            for(int i=0; i<rows; i++) { //cells
                for(int j=0; j<cols; j++) {
                    Location l = new Location(i, j);
                    board.put(l, new Cell(""+COVERED,l));
                }
            }
            for(int i=0; i<mineCount; i++) { //mines
                Location l = new Location(r.nextInt(rows), r.nextInt(cols));
                board.put(l, new Cell(""+MINE, l));
                this.mines.add(l);
            }
        }

    /* METHOD STATUS: TODO: INCOMPLETED
     *    --> JUnit ~ should return a String repsentation of 'this.board' + 'this.state' + 'moves made'
     *        @Return ~ visual repsentaion of 'this.board'
     *    --> @Handle ~ different gamestate??
     */
        @Override
        public String toString() {
            String redg = "CURRENT GAME STATE: [ "+this.getGameState()+" ] \n";
            for(int i = 0; i < rows; i++) {
                for(int j = 0; j < cols; j++) {
                    for(Location loc : this.board.keySet()) {
                        if(loc.getRow() == i && loc.getCol() == j) {
                            Cell cell = board.get(loc);
                            redg = redg + " "+cell+" ";
                        }
                    }
                }
                redg = redg +"\n";
            }
            redg = redg+" Moves = "+this.getMoveCount();
            
            return redg;
        }

        public char getSymbol(Cell square) { 
            return square.val(); 
        }

        public int visValue(Cell cell) {
            int num = 0;
            for(Location m_loc : this.mines) {
                if(cell.isNextTo(m_loc)) { num++; }
            }
            return num;
        }

        public Set<Location> mines() {
            return this.mines;
        }

        public Map<Location,Cell> board() {
            return this.board;
        }

        public boolean isCovered(Cell cell) { 
            if(cell.isCovered() == true) { 
                return true; 
            }
            return false; 
        }

    public static void main(String[] args) throws MineCountException, MoveLocationException {
        Minesweeper game = new Minesweeper(2, 2, 1);
        game.start();
        for(Location loc : game.mines) {
            System.out.println(loc);
        }
        game.makeSelection(new Location(1,0));
        System.out.println(game);
    }
}
