import java.util.NoSuchElementException;
import java.util.concurrent.ConcurrentLinkedDeque;

public class Scheduler extends ConcurrentLinkedDeque<MethodRequest> implements Runnable {
    //ConcurrentLinkedDeque<MethodRequest> queue;

    public Scheduler() {
        //this.queue = new ConcurrentLinkedDeque<>();
        //this.start();
    }

//    public void enqueue(MethodRequest task){
//        queue.addLast(task);
//    }

    @Override
    public void run(){
        while(true) {
            while(isEmpty()){

            }
            MethodRequest task = this.poll();
            //System.out.println("Scheduler got task");
            if (task.guard()) {
                //System.out.println("Executing task");
                task.execute();

            } else {
                add(task);
            }
        }
    }
}
