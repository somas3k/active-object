

public class PutMethodRequest implements MethodRequest {
    private Future future;
    private Buffer buffer;
    private int[] elements;

    public PutMethodRequest(Future future, Buffer buffer, int[] elements) {
        this.future = future;
        this.buffer = buffer;
        this.elements = elements;
    }

    @Override
    public boolean guard(){
        return buffer.isAvailableToPut(elements.length);
    }

    @Override
    public void execute(){
        buffer.put(elements);
        future.setFinished(true);
    }

    @Override
    public String info(){
        return "Put " + elements.length + " to buffer";
    }
}
