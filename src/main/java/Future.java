public class Future {
    private boolean isFinished = false;
    private int count;

    public Future(int count) {
        this.count = count;
    }

    public synchronized int getCount(){
        if(!isAvailable()) try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return count;
    }

    public synchronized void setFinished(boolean flag){
        isFinished = flag;
        notifyAll();
    }

    public synchronized boolean isAvailable(){
        return isFinished;
    }

}
