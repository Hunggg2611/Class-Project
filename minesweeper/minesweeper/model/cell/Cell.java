package minesweeper.model.cell;
import minesweeper.model.location.Location;
import minesweeper.model.main.Minesweeper;


// CLASS OVERALL TODO: INCOMPLETE
public class Cell {
        private boolean hidden;
        private String val;
        private Location loc;


    /*  CONSTRUCTOR STATUS: TODO: INCOMPLETE
     *      --> JUnit ~ should all data structures are inti (I.E) not null
     *          @Param ~ char Value, Location loc
     *          @Return ~ a cell instance
     */
        public Cell(String value, Location location) {
            this.hidden = true;
            this.val = value;
            this.loc = location;
        }
    

    /*  METHOD STATUS: TODO: INCOMPLETE
     *     --> JUnit ~ should return a boolean value
     *         @Return ~ current value of 'this.hidden'
     */
        public boolean isCovered() {
            return hidden;
        }
    
    /* METHOD STATUS: TODO: INCOMPLETE
     *     --> JUnit ~ should take a String "value" param
     *         @Param ~ String value
     *         @Logic ~ [ 'this.val' set to 'value' ]
     */
        public void val(String value) { 
            this.val = value; 
        }
        public char val() { 
            return val.charAt(0);
        }
    /* METHOD STATUS: TODO: INCOMPLETE
     *     --> JUnit ~ should change 'this.hidden' to false
     *         @Logic ~ [ 'this.hidden' set false ]
     */
        public void reveal() { 
            this.hidden = false; 
        }
    
    /* METHOD STATUS: TODO: INCOMPLETE
     *     --> JUnit ~ should return true if o_loc is nex to 'this.loc'
     *     --> JUnit ~ should take a Location param
     *         @Param ~ Location 'o_loc'
     * 
     *         @Logic ~ [ absoulte val of 'this.row' - 'o.row'  OR  absoulte val of 'this.col' - 'o.col' is less 1 ]
     * 
     *         @Return ~ boolean 'o_loc' is next to 'this.loc'
     */   
        public boolean isNextTo(Location o_loc) {
            int r = Math.abs(this.loc.getRow() - o_loc.getRow());
            int c = Math.abs(this.loc.getCol() - o_loc.getCol());
            if(r<=1 && c<=1) {
                return true;
            } else {
            return false;
            }
        }
    
    /* METHOD STATUS TODO: INCOMPLETE
     *    --> JUnit ~ Should return a String
     *        @Logic ~ [ if hidden return 'COVERED' else return 'this.val' ]
     *        @Return ~ String 'this.val' OR 'COVERED' if 'hidden'
     *    
     */
        @Override
        public String toString() {
            if(hidden) { return "" + Minesweeper.COVERED; }
            else { return "" + this.val; }
        }
    

    /* METHOD STATUS TODO: INCOMPLETE
     *    --> JUnit ~ should return 'this.loc' .hascode + 'this.val'
     *        @Return ~ Integer unique hashcode
     */
        @Override
        public int hashCode() {
            return loc.hashCode()+Integer.parseInt(val);
        }


    public static void main(String[] args) {
        Cell cell = new Cell("",new Location(0,0));
        System.out.println(cell.isNextTo(new Location(2,0)));
    }
}
