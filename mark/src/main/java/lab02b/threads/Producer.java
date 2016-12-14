package threads;

import common.RandomStringGenerator;
import datalist.Data;
import datalist.DataBuffer;

/**
 * Created by Mark Lobanov on 22.10.2016.
 */
public class Producer implements Runnable {
    private DataBuffer buffer;
    private RandomStringGenerator generator;
    private int iterationCount;
    private String producerID;

    public Producer(int producerID, DataBuffer buffer, RandomStringGenerator generator, int iterationCount) {
        this.buffer = buffer;
        this.generator = generator;
        this.iterationCount = iterationCount;
        this.producerID = Integer.toString( producerID );
    }

    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    public void run() {
        for (int i=0; i<iterationCount; i++) {
            String str = generator.newRandomString();
            try {
                Data temp = new Data(str, producerID);

                buffer.put( temp );
                System.out.println("<" + temp.toString() + "> was entered");
                Thread.sleep( 500 );
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
