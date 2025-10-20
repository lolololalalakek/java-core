package Lesson11.Pub_Sub;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Scanner;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Pub_Sub {
    public static void main(String[] args) {
        MessageBus bus = new MessageBus();

        Thread publisher = new Thread(new Publisher(bus));
        Thread subscriber = new Thread(new Subscriber(bus));

        publisher.start();
        subscriber.start();

        try {
            publisher.join();
            subscriber.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("Program closed.");
    }
}

@Getter
class MessageBus {
    private final BlockingQueue<String> queue = new LinkedBlockingQueue<>();
}

@RequiredArgsConstructor
class Publisher implements Runnable {
    private final MessageBus bus;

    @Override
    public void run() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Write something (or 'exit' to stop):");
            while (true) {
                String input = scanner.nextLine().trim();
                bus.getQueue().put(input);
                if ("exit".equalsIgnoreCase(input)) break;
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

@RequiredArgsConstructor
class Subscriber implements Runnable {
    private final MessageBus bus;

    @Override
    public void run() {
        try {
            while (true) {
                String msg = bus.getQueue().take();
                if ("exit".equalsIgnoreCase(msg)) break;

                // Simulate message processing
                String processed = msg.toUpperCase(); // другая “фишка”
                System.out.println("Taken: " + processed);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
