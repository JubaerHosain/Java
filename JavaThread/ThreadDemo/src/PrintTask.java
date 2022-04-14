import java.util.Random;

public class PrintTask implements Runnable {
    private final int sleepTime;
    private final String taskName;
    private final static Random generator = new Random();


    public PrintTask(String taskName) {
        this.sleepTime = generator.nextInt(500);
        this.taskName = taskName;
    }

    @Override
    public void run() {
        try {
            System.out.printf("%s is going to sleep for %d milliseconds\n",
                    taskName, sleepTime);
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            System.out.printf("%s %s\n", taskName,
                    "terminated prematurely due to interruption");
        }
        System.out.printf("%s done sleeping\n", taskName);
    }
}
