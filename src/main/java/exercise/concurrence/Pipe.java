package exercise.concurrence;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

/**
 * @Author: JinYuwei
 * @Since: 2020/4/11
 */
public class Pipe {
    static class ThreadReader implements Runnable {
        private PipedReader reader;

        ThreadReader(PipedReader reader) {
            this.reader = reader;
        }

        @Override
        public void run() {
            System.out.println("This is Reader");

            int receive = 0;
            while (true)
            {
                try {
                    receive = reader.read();
                    if (receive == -1) {
                        break;
                    }
                    System.out.println((char) receive);
                } catch (IOException e) {
                    e.printStackTrace();
                    break;
                }
            }
        }
    }

    static class ThreadWriter implements Runnable{
        private PipedWriter writer;
        public ThreadWriter(PipedWriter writer) {
            this.writer = writer;
        }

        @Override
        public void run() {
            System.out.println("This is Writer");
            try {
                writer.write("hello java");
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        PipedReader reader = new PipedReader();
        PipedWriter writer = new PipedWriter();
        writer.connect(reader);

        new Thread(new ThreadReader(reader)).start();
        Thread.sleep(100);
        new Thread(new ThreadWriter(writer)).start();
    }
}
