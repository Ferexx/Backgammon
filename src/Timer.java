import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

public class Timer {

    //AtomicLong so that all threads can see the timer.
    private AtomicLong time = new AtomicLong();

    public long counter = 0;

    public boolean exit = false;


    //Separate function so that we can restart games easier in the future.
    public void threadStart(Window window) {


        Thread timer = new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        while(!exit) {
                            try {
                                counter++;
                                time.set(counter);
                                Thread.sleep(1000);
                                window.drawing.update();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                                exit = true;
                                break;
                            }

                            if(Game.pointList[27].getCount() == 15 || Game.pointList[26].getCount() == 15) {
                                counter = 0;
                                break;
                            }


                        }
                    }
                });

        timer.start();


    }

    //Threading allows for easier management of something that runs independent to the game, like a timer.
    private void timerThread(Window window) {

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
