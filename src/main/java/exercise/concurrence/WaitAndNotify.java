package exercise.concurrence;

/**
 * @Author: JinYuwei
 * @Since: 2020/4/11
 */
public class WaitAndNotify {
    private static Object lock = new Object();
    static class ThreadA implements Runnable{

        @Override
        public void run() {
            synchronized (lock) {
                for (int i=0; i< 5 ;i++) {
                    try {
                        System.out.println("ThreadA: "+i);
                        lock.notify();
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                lock.notify();
            }
        }
    }

    static class ThreadB implements Runnable{

        @Override
        public void run() {
            synchronized (lock) {
                for (int i=0; i< 5 ;i++) {
                    try {
                        System.out.println("ThreadB: "+i);
                        lock.notify();
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                lock.notify();
            }
        }
    }

    static class ThreadC implements Runnable{

        @Override
        public void run() {
            synchronized (lock) {
                for (int i=0; i< 5 ;i++) {
                    try {
                        System.out.println("ThreadC: "+i);
                        lock.notify();
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                lock.notify();
            }
        }
    }

    public static void main(String[] args) {
        Thread A = new Thread(new ThreadA());
        Thread B = new Thread(new ThreadB());
        Thread C = new Thread(new ThreadC());
        A.start();
        B.start();
        C.start();
        int i = 0;
        while (i < 2) {
            System.out.println(A.getName()+" "+A.getState()+"\t"+B.getName()+" "+B.getState()+"\t"+C.getName()+" "+C.getState());
            if (A.getState().equals(Thread.State.TERMINATED) || B.getState().equals(Thread.State.TERMINATED) || C.getState().equals(Thread.State.TERMINATED)) {
                i++;
            }
        }

    }
}
