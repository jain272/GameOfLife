import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class GameLogic implements ActionListener{
    public static Cell[][] grid;
    public static Cell[][] gridUpdate;
    public static JPanel[][] panelArray;

    public GameLogic() {
        grid = new Cell[100][100];
        gridUpdate = new Cell[100][100];
        Random r = new Random();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                grid[i][j] = new Cell(false);
                gridUpdate[i][j] = new Cell(false);
                if (r.nextInt(9) < 1) {
                    grid[i][j].setLiving(true);
                } else {
                    grid[i][j].setLiving(false);
                }
            }
        }
    }

    public boolean liveToNext(int m, int n) {
        int adjacentAlive = 0;
        boolean livingForNextGen = false;
        boolean currentState = grid[m][n].getLiving();
        if (m - 1 >= 0) {
            if (grid[m - 1][n].getLiving()) {
                adjacentAlive++;
            }
        }
        if (m + 1 <= 99) {
            if (grid[m + 1][n].getLiving()) {
                adjacentAlive++;
            }
        }
        if (n - 1 >= 0) {
            if (grid[m][n - 1].getLiving()) {
                adjacentAlive++;
            }
        }
        if (n + 1 <= 99) {
            if (grid[m][n + 1].getLiving()) {
                adjacentAlive++;
            }
        }
        if (m - 1 >= 0 && n - 1 >= 0) {
            if (grid[m - 1][n - 1].getLiving()) {
                adjacentAlive++;
            }
        }
        if (m + 1 <= 99 && n + 1 <= 99) {
            if (grid[m + 1][n + 1].getLiving()) {
                adjacentAlive++;
            }
        }
        if (m - 1 >= 0 && n + 1 <= 99) {
            if (grid[m - 1][n + 1].getLiving()) {
                adjacentAlive++;
            }
        }
        if (m + 1 <= 99 && n - 1 >= 0) {
            if (grid[m + 1][n - 1].getLiving()) {
                adjacentAlive++;
            }
        }

        if (currentState && adjacentAlive < 2) {
            livingForNextGen = false; //cell dies
        }
        if (currentState && adjacentAlive > 3) {
            livingForNextGen = false; // cell dies
        }
        if (currentState && (adjacentAlive == 2 || adjacentAlive == 3)) {
            livingForNextGen = true; // cell lives to next generation
        }
        if (!currentState && adjacentAlive == 3) {
            livingForNextGen = true; //dead cell becomes alive
        }

        return livingForNextGen;

    }

    public void update() {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (liveToNext(i, j)) {
                    gridUpdate[i][j].setLiving(true);
                } else {
                    gridUpdate[i][j].setLiving(false);
                }
            }
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                grid[i][j].setLiving(gridUpdate[i][j].getLiving());
            }
        }
    }


    public void initGridGUI() {
        //TODO set up the display
        JFrame jf = new JFrame("Conway's Game of Life");
        jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jf.setSize(1000, 1000);
        jf.setLayout(new GridLayout(101, 100));
        jf.setTitle("Conway's Game of Life");
        panelArray = new JPanel[100][100];
        for (int i = 0; i < panelArray.length; i++) {
            for (int j = 0; j < panelArray[i].length; j++) {
                panelArray[i][j] = new JPanel();
                panelArray[i][j].setBackground(Color.white);
                panelArray[i][j].setSize(50, 50);
                jf.getContentPane().add(panelArray[i][j]);
            }
        }
        JButton exit = new JButton("Exit");
        exit.setSize(200, 200);
        exit.addActionListener(new GameLogic());
        jf.getContentPane().add(exit);
        jf.setVisible(true);
    }

    public void printGridGUI() {
        update();
        //TODO set the colors of the cells based on if they are living or dead
        for (int i = 0; i < panelArray.length; i++) {
            for (int j = 0; j < panelArray[i].length; j++) {
                if (grid[i][j].getLiving()) {
                    panelArray[i][j].setBackground(Color.black);
                } else {
                    panelArray[i][j].setBackground(Color.white);
                }
            }
        }
    }

    public void printGrid() { //this method is only included if you want to visualize how the cells change over time
        // before you implement the GUI

        for (int i = 0; i < grid.length; i++) {
            if (i == 0) {
                for (int k = 0; k < grid[i].length + 1; k++) {
                    System.out.print("-");
                }
                System.out.println("-");
            }
            for (int j = 0; j < grid[i].length; j++) {
                if (j == 0) {
                    System.out.print("|");
                }
                if (j == grid[i].length - 1) {
                    if (grid[i][j].getLiving()) {
                        System.out.print("*");
                    } else {
                        System.out.print(" ");
                    }
                    System.out.println("|");
                } else {
                    if (grid[i][j].getLiving()) {
                        System.out.print("*");
                    } else {
                        System.out.print(" ");
                    }
                }
            }
            if (i == grid.length - 1) {
                for (int k = 0; k < grid[i].length; k++) {
                    System.out.print("-");
                }
                System.out.println("-");
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        JButton b =  (JButton) actionEvent.getSource();
        System.exit(0);
    }
}

