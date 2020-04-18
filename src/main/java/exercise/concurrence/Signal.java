package exercise.concurrence;

/**
 * @Author: JinYuwei
 * @Since: 2020/4/11
 */
public class Signal {
    private static volatile int signal = 0;

    static class ThreadA implements Runnable {

        @Override
        public void run() {
            synchronized (this) {
                while (signal < 5) {
                    if (signal % 2 == 0) {
                        System.out.println(this.getClass().toString() + " " + signal);
                        signal++;
                    }
                }
            }
        }
    }

    static class ThreadB implements Runnable {

        @Override
        public void run() {
            synchronized (this) {
                while (signal < 5) {
                    if (signal % 2 == 1) {
                        System.out.println(this.getClass().toString() + " " + signal);
                        signal++;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        new Thread(new ThreadA()).start();
        new Thread(new ThreadB()).start();
    }
}
