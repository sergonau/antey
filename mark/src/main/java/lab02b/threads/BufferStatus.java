package threads;

import datalist.DataBuffer;

/**
 * Created by Mark Lobanov on 23.10.2016.
 */
public class BufferStatus implements Runnable  {
    private DataBuffer buffer;
    private int nullCnt = 0;
    private int sz = 0;

    public BufferStatus(DataBuffer buffer) {
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

        while ( true ) {
            try {
                sz = buffer.size();
                System.out.println( "Size:" + sz + " is checked" );

                if ((sz == 0) && (nullCnt++ == 3)) {
                    return;
                } else {
                    Thread.sleep( 1000 );
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
