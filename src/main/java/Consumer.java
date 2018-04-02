import java.util.ArrayList;

public class Consumer extends Thread {
    private BufferProxy buffer;
    private int M;
    private ArrayList<Future> futures = new ArrayList<>();

    public Consumer(BufferProxy buffer, int M){
        this.buffer = buffer;
        this.M = M;
    }

    @Override
    public void run(){
        int i = 1;
        while(true){
            int count = (int)(Math.random()*M+1);
            futures.add(buffer.get(count));
            System.out.println("Consumer " + Thread.currentThread().getId() + " want to put " + count + " elements");

            i++;
        }

    }
}
