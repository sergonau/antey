/**
 * Java with Sergey Naumovich
 * Homework #2b
 * Multithreading. Threadsafe queue. Producer-consumer pattern.
 *
 * Main runnable class
 *
 * @author Mark Lobanov (22.10.2016)
 * @version 1.0.0
*/
import common.RandomStringGenerator;
import datalist.DataBuffer;
import threads.BufferStatus;
import threads.Consumer;
import threads.Producer;


public class RunMainLab2b {

    public static void main(String[] args) {
        RandomStringGenerator strGenerator = new RandomStringGenerator(5, 7);

        DataBuffer buffer = new DataBuffer( 100 );

        new Thread( new BufferStatus( buffer ) ).start();

        for (int i=1; i<=20; i++) {
            new Thread( new Producer(i, buffer, strGenerator, 10) ).start();
        }

        for (int i=1; i<=5; i++) {
            new Thread( new Consumer( buffer ) ).start();
        }

    }
}
