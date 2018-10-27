package threads;

public class Test {



    public static class Mux2 implements Runnable{

        @Override
        public void run() {
            for (int i = 1; i <= 10; i++) {
                System.out.println(2*i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static class Mux3 implements Runnable{

        @Override
        public void run() {
            for (int i = 1; i <= 10; i++) {
                System.out.println(3*i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static class Mux5 implements Runnable{

        @Override
        public void run() {
            for (int i = 1; i <= 10; i++) {
                System.out.println(5*i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        Thread[] threads = new Thread[3];

        threads[0] = new Thread(new Mux2());
        threads[1] = new Thread(new Mux3());
        threads[2] = new Thread(new Mux5());

        //start all threads
        for (int i = 0; i < threads.length; i++) {
            threads[i].start();
        }

        //wait for all threads to finish
        for (int i = 0; i < threads.length; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }
}
