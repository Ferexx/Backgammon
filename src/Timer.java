public class Timer {
    private double previousTime = 0;
    private double now;
    private double timer;


    public Timer() {
        //timer
        now = System.currentTimeMillis();
        timer = now - previousTime;
        System.out.println("Time: " + timer);
        previousTime = System.currentTimeMillis();
    }

}
