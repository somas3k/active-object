import java.util.ArrayList;
import java.util.List;

public class Buffer {
    private List<Integer> buffer = new ArrayList<>();

    private int M;

    public Buffer() {
    }

    Buffer(int m) {
        M = 2*m;
    }

    public void setM(int m){
        this.M = 2*m;
    }

    public boolean isAvailableToPut(int m){
        if(M - buffer.size() >= m) return true;
        else return false;
    }

    public boolean isAvailableToGet(int m){
        if(buffer.size() >= m) return true;
        else return false;
    }

    public void put(int[] elements){
        for (int e : elements) {
            buffer.add(e);
        }
    }

    public void get(int count){
        for (int i = 0; i < count; ++i) {
            buffer.remove(0);
        }
    }
}
