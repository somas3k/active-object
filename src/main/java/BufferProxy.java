public class BufferProxy {
    private Buffer buffer;
    private Scheduler scheduler;
    private Thread schedulerThread;


    public BufferProxy(int m) {
        this.buffer = new Buffer(m);
        this.scheduler = new Scheduler();
        schedulerThread = new Thread(scheduler);
        schedulerThread.start();
    }

    public Future put(int[] elements){
        Future future = new Future(elements.length);
        MethodRequest put = new PutMethodRequest(future, buffer, elements);
        scheduler.addLast(put);
        return future;
    }

    public Future get(int count){
        Future future = new Future(count);
        MethodRequest get = new GetMethodRequest(future, buffer, count);
        scheduler.addLast(get);
        return future;
    }
}
