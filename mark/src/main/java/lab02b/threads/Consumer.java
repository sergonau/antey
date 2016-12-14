package threads;

import datalist.Data;
import datalist.DataBuffer;

/**
 * Created by Mark Lobanov on 22.10.2016.
 */
public class Consumer implements Runnable {
    private DataBuffer buffer;


    public Consumer(DataBuffer buffer) {
        this.buffer = buffer;
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
        while (buffer.size() > 0) {
            try {
                Data tempData = buffer.take( );

                System.out.println( "<" + tempData.toString() + "> was out" );
                Thread.sleep( 500 );
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
