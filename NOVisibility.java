package Shibing;

public class NOVisibility {
    private static boolean ready;

    static {
        ready = false;
    }

    private static int number;

    private static class ReaderThread extends Thread {
        @Override
        public void run() {
            while(!ready) {
                Thread.yield();
            }
            System.out.println(number);
        }

        public static void main(String[] args) throws InterruptedException {
            Thread t = new ReaderThread();
            t.start();
            number = 10000000;
            ready = true;
            t.join();
        }

    }
}
