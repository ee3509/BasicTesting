import java.util.HashMap;
import java.util.Map;

public class CoreMelt {

    static int cores = 0;
    static int seconds =0;
    static int processors = Runtime.getRuntime().availableProcessors();;
    Map<Integer, MyThread> threadMap = new HashMap<Integer, MyThread>();

    class MyThread extends Thread{

        volatile boolean running = true;

        public void requestStop() {
            running = false;
        }

        @Override
        public void run() {
            while (running);
        }
    }

    public static void main(String[] args) {

        if (args.length != 2) {
            System.out.println("Usage : CoreMelt <number of cores> <seconds>");
            System.out.println();
            System.out.println("Cores : (1 - "+processors+")");
            System.out.println();
            System.out.println("e.g. CoreMelt 2 60 - will engage 2 cores for 60 seconds");
            System.out.println("");
            System.exit(1);
        } else


        cores = Integer.parseInt(args[0]);
        seconds = Integer.parseInt(args[1]);

        new CoreMelt().startThreads();

    }

    void startThreads(){

        System.out.println("Generating " + cores + " threads for "+processors+" cores");
        System.out.println("Expected utilisation : "+ ((int) (((double) cores / (double) processors) * 100))+"%") ;
        System.out.println();

        for (int i = 0; i < cores; i++) {
            MyThread thread = new MyThread();
            threadMap.put(i, thread);
        }

        for (Thread thread : threadMap.values()) {
            System.out.println("Starting thread : " + thread.getId());
            thread.start();
        }
        System.out.println();

        try {
            Thread.sleep(seconds*1000);
            for (MyThread thread : threadMap.values()) {
                System.out.print("Waiting for thread " + thread.getId() + " to finish");
                thread.requestStop();
                thread.join();
                System.out.println("... finished");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
