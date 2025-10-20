package Lesson11.ThreadPool;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

@Getter
@Setter
@EqualsAndHashCode
public class ThreadPool {
    private final int poolSize;
    private final List<Worker> workers = new ArrayList<>();
    private final BlockingQueue<Runnable> taskQueue = new LinkedBlockingQueue<>();
    private volatile boolean isRunning = true;

    public ThreadPool(int poolSize) {
        this.poolSize = poolSize;
        for (int i = 0; i < poolSize; i++) {
            Worker worker = new Worker("Worker-" + (i + 1));
            workers.add(worker);
            worker.start();
        }
    }

    public void submit(Runnable task) throws InterruptedException {
        if (!isRunning) {
            throw new IllegalStateException("Thread pool has been shut down");
        }
        taskQueue.put(task);
    }

    public void shutdown() {
        isRunning = false;
        for (Worker worker : workers) {
            worker.interrupt();
        }
        System.out.println("Thread pool shut down.");
    }

    @RequiredArgsConstructor
    private class Worker extends Thread {
        private final String workerName;

        @Override
        public void run() {
            while (isRunning || !taskQueue.isEmpty()) {
                try {
                    Runnable task = taskQueue.take();
                    System.out.println(workerName + " started task.");
                    task.run();
                    System.out.println(workerName + " finished task.");
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }


    public static void main(String[] args) throws InterruptedException {
        ThreadPool pool = new ThreadPool(10);

        for (int i = 1; i <= 10; i++) {
            int taskId = i;
            pool.submit(() -> {
                System.out.println("Executing task " + taskId);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ignored) {}
            });
        }

        try {
            Thread.sleep(5000);
        } catch (InterruptedException ignored) {}

        pool.shutdown();
    }
}
