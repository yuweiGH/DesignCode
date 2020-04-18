package exercise.concurrence;

/**
 * @Author: JinYuwei
 * @Since: 2020/4/12
 */
public class VolatileExample {
    int c = 0;
    int a = 0;
    volatile boolean flag = false;
    int b = 0;
    int d = 0;


    public void writer() {
        c = 1; // step 1
        a = 1; // step 1
        flag = true; // step 2
        b = 1;
        d = 1;
    }

    public void reader() {
        if (flag) { // step 3
            System.out.println(a); // step 4
            System.out.println(b); // step 4
            System.out.println(c); // step 4
            System.out.println(d); // step 4
        }
    }

    static class ThreadA implements Runnable{
        private VolatileExample example;
        public ThreadA(VolatileExample example) {
            this.example = example;
        }
        @Override
        public void run() {
            System.out.println("A run");
            example.writer();
        }
    }

    static class ThreadB implements Runnable{
        private VolatileExample example;
        public ThreadB(VolatileExample example) {
            this.example = example;
        }
        @Override
        public void run() {
            System.out.println("B run");

            example.reader();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        VolatileExample example = new VolatileExample();
        new Thread(new ThreadA(example)).start();
        Thread.sleep(10);
        new Thread(new ThreadB(example)).start();

    }
}