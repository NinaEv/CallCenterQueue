package jadv.task_4_1;

public class Main {

    private static final int SPECIALISTS = 15;
    private static final int CALLS = 60;

    public static void main(String[] args) {
        CallCenter center = new CallCenter();
        for (int i = 0; i < CALLS; i++) {
            new Thread(null, center::call, "№ " + (i + 1)).start();
        }

        for (int i = 0; i < SPECIALISTS; i++) {
            new Thread(null, center::takeCall, "№ " + (i + 1)).start();
        }
    }
}
