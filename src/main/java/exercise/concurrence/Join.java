package exercise.concurrence;

/**
 * @Author: JinYuwei
 * @Since: 2020/4/11
 */
public class Join {
    static class ThreadA implements Runnable{

        @Override
        public void run() {
            System.out.println("Thread A start");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread A end");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new ThreadA());
        t.start();
        System.out.println("main join");
        t.join();
        System.out.println("main done");
    }
}
