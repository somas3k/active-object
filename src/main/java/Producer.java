import java.util.ArrayList;

public class Producer extends Thread {
    private BufferProxy buffer;
    private int M;
    private ArrayList<Future> futures = new ArrayList<>();

    public Producer(BufferProxy buffer, int M){
        this.buffer = buffer;
        this.M = M;
    }

    @Override
    public void run(){
        int i = 1;
        while(true){
            int count = (int)(Math.random()*M+1);
            int[] elements = new int[count];
            for(int j = 0; j < count; ++j){
                elements[j]=(int)(Math.random() * 10) + 1;
            }
            futures.add(buffer.put(elements));
            System.out.println("Producer " + Thread.currentThread().getId() + " want to get" + count + " elements");
            i++;
        }


    }
}
