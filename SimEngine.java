public class SimEngine {

    public static void sleepMethod(int duration) {
        try {
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            e.getMessage();
        }
    }

    public static void main(String[] args) {

        GameLogic gam = new GameLogic();
        gam.initGridGUI();
        gam.printGridGUI();
        //gam.printGrid();
        sleepMethod(500); //sleep longer than normal initially to better show initial condition

        while (true) {                 //main logic loop
            gam.update();
            gam.printGridGUI();
            //gam.printGrid();
            sleepMethod(50);
        }
    }
}
