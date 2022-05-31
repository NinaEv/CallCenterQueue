package jadv.task_4_1;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class CallCenter {
    private static final int CALLS = 60;
    private static final Queue<String> phoneCalls = new ArrayBlockingQueue<>(CALLS);
    private static final int WAIT = 1000;
    private static final int ANSWER = 3000;

    public void call() {
        phoneCalls.offer(Thread.currentThread().getName());
        try {
            Thread.sleep(WAIT);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(" Поступил звонок " + Thread.currentThread().getName());
    }

    public void takeCall() {
        while (!phoneCalls.isEmpty()) {
            try {
                Thread.sleep(ANSWER);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            String value = phoneCalls.poll();
            if (value == null) break;
            System.out.println("Специалист " + Thread.currentThread().getName() + " ответил на звонок " + value);
        }
    }
}
