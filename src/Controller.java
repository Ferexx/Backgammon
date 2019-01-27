public class Controller {
    public static void main(String args[]) {
        new Display();
        new Dice();
        startingPositions();
    }
    private static Checker[] storeCheckers = new Checker[30];
    private static int[] pointXCoords = new int[]{75, 125, 175, 225, 275, 325, 416, 466, 516, 566, 615, 665, 665, 615, 566, 516, 466, 416, 325, 275, 225, 175, 125, 75};
    private static int[] pointYCoords = new int[]{58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 58, 535, 535, 535, 535, 535, 535, 535, 535, 535, 535, 535, 535};

    public static void startingPositions() {
        for(int i =0; i<15; i++) {
            storeCheckers[i] = new Checker(pointXCoords[i], pointYCoords[i]);
        }
    }
}
