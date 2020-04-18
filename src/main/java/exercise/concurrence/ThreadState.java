package exercise.concurrence;

/**
 * @Author: JinYuwei
 * @Since: 2020/4/11
 */
public class ThreadState {
    public void blockedTest() throws InterruptedException {
        Thread a = new Thread(new Runnable() {
            @Override
            public void run() {
                sleep();
            }
        });

        Thread b = new Thread(new Runnable() {
            @Override
            public void run() {
                sleep();
            }
        });


        System.out.println(a.getName() + ":" +a.getState());
        System.out.println(b.getName() + ":" +b.getState());

        a.start();

        System.out.println(a.getName() + ":" +a.getState());
        System.out.println(b.getName() + ":" +b.getState());

        Thread.sleep(1000L);
//        a.join();

        b.start();
        Thread.State state = Thread.State.NEW;
        int i = 0;
        while (!b.getState().equals(Thread.State.TERMINATED)) {
            try {
                if (!state.equals(b.getState())) {
                    System.out.println(a.getName() + ":" + a.getState());
                    System.out.println(b.getName() + ":" + b.getState());
                    state = b.getState();
                }
            } catch (Exception v){
                v.printStackTrace();
            } finally {
                i++;
            }

            if (i > 10000) {
//                break;
            }
        }
    }

    private synchronized void sleep() {
        try{
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadState state = new ThreadState();
        state.blockedTest();
    }
}
