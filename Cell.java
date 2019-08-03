public class Cell {
    private boolean living; //returns true if alive or false if dead

    public Cell(boolean living) {
        this.living = living;
    }

    public void setLiving(boolean living) {
        this.living = living;
    }

    public boolean getLiving() {
        return this.living;
    }
}
