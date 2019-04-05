import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

public class Timer {

    //AtomicLong so that all threads can see the timer.
    public AtomicLong time = new AtomicLong();

    public long counter = 0;

    //Separate function so that we can restart games easier in the future.
    public void threadStart(Window window) {
        new Thread(() -> timerThread(window)).start();
    }

    //Threading allows for easier management of something that runs independent to the game, like a timer.
    public void timerThread(Window window) {
        while(true) {
            try {
                counter++;
                time.set(counter);
                //System.out.println("Time: " + time.get());
                Thread.sleep(1000);
                window.drawing.update();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public Timer() {
        //Default
    }

    //Basic function to return the formatted time
    public String getTime() {
        return (String.format("%02d:%02d:%02d",
                TimeUnit.SECONDS.toHours(time.get()),
                TimeUnit.SECONDS.toMinutes(time.get()) - TimeUnit.HOURS.toMinutes(TimeUnit.SECONDS.toHours(time.get())),
                TimeUnit.SECONDS.toSeconds(time.get()) - TimeUnit.MINUTES.toSeconds(TimeUnit.SECONDS.toMinutes(time.get()))));
    }
}
