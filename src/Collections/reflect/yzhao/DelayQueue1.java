package Collections.reflect.yzhao;

import static java.time.temporal.ChronoUnit.MILLIS;
import static java.util.concurrent.TimeUnit.MILLISECONDS;


import java.time.Instant;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;


class DelayedJob implements Delayed {
    private Instant scheduledTime;
    String jobName;

    public DelayedJob(String jobName, Instant scheduledTime) {
        this.scheduledTime = scheduledTime;
        this.jobName = jobName;
    }

    @Override
    public long getDelay(TimeUnit unit) {
        long delay = MILLIS.between(Instant.now(), scheduledTime);
        long returnValue = unit.convert(delay, MILLISECONDS);
        return returnValue;
    }

    @Override
    public int compareTo(Delayed job) {
        long currentJobDelay = this.getDelay(MILLISECONDS);
        long jobDelay = job.getDelay(MILLISECONDS);

        int diff = 0;
        if (currentJobDelay > jobDelay) {
            diff = 1;
        } else if (currentJobDelay < jobDelay) {
            diff = -1;
        }
        return diff;
    }

    @Override
    public String toString() {
        String str = this.jobName + ", " + "Scheduled Time:  "
                + this.scheduledTime;
        return str;
    }
}
public class DelayQueue1 {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<DelayedJob> queue = new DelayQueue<>();
        Instant now = Instant.now();

        queue.put(new DelayedJob("A", now.plusSeconds(9)));
        queue.put(new DelayedJob("B", now.plusSeconds(3)));
        queue.put(new DelayedJob("C", now.plusSeconds(6)));
        queue.put(new DelayedJob("D", now.plusSeconds(1)));

        while (queue.size() > 0) {
            System.out.println("started...");
            DelayedJob job = queue.take();
            System.out.println("Job: " + job);
        }
        System.out.println("Finished.");
    }
}