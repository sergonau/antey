package datalist;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by Mark Lobanov on 14.12.2016.
 */
public class DataBuffer {
    private BlockingQueue<Data> queue;

    public DataBuffer(int queueCapacity) {
        this.queue = new ArrayBlockingQueue(queueCapacity,true);;
    }

    public void put(Data d) throws InterruptedException {
        queue.put( d );
    }

    public Data take() throws InterruptedException {
        return queue.take();
    }

    public int size() {
        return queue.size();
    }
}
