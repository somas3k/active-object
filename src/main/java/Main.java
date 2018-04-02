import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Main {
    public static void main(String[] args) {
        int M = 100;
        int producersCount = 5;
        int consumersCount = 5;
        BufferProxy buffer = new BufferProxy(M);
        ExecutorService executorService = Executors.newFixedThreadPool(producersCount+consumersCount);
        ArrayList<Producer> producers = new ArrayList<>();
        ArrayList<Consumer> consumers = new ArrayList<>();

        for(int i = 0 ; i < producersCount; i++){
            Producer producer = new Producer(buffer, M);
            producers.add(producer);
            executorService.submit(producer);

        }
        for(int i = 0 ; i < consumersCount; i++){
            Consumer consumer = new Consumer(buffer, M);
            consumers.add(consumer);
            executorService.submit(consumer);
        }
    }
}
