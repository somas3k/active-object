

public class GetMethodRequest implements MethodRequest{
    private Future future;
    private Buffer buffer;
    private int count;

    public GetMethodRequest(Future future, Buffer buffer, int count) {
        this.future = future;
        this.buffer = buffer;
        this.count = count;
    }

    @Override
    public boolean guard(){
        return buffer.isAvailableToGet(count);
    }

    @Override
    public void execute(){
        buffer.get(count);
        future.setFinished(true);
    }

    @Override
    public String info(){
        return "Got " + count + " from buffer";
    }


}
