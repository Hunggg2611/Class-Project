package minesweeper.model.location; 

// CLASS OVERALL: COMPLETED
public class Location { 
    private int row; 
    private int col; 

    public Location(int row, int col) { 
        this.row = row; 
        this.col = col; 
    }

    public int getRow() { 
        return this.row; 
    }

    public int getCol() { 
        return this.col; 
    }

    @Override 
    public boolean equals(Object o) { 
        if(!(o instanceof Location)) { 
            return false; 
        }
        Location other = (Location) o; 
        if(other.getRow() == this.getRow() && other.getCol() == this.getCol()) { 
            return true; 
        }
        return false; 
    }

    @Override 
    public int hashCode() { 
        return (this.row * 4) + (this.col * 7) + 259; 
    }
    
    @Override
    public String toString() {
        // return super.toString();
        return "[" + this.row + ", " + this.col + "]";
    }
}