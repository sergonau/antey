package datalist;

/**
 * Created by Mark Lobanov on 22.10.2016.
 */
public class Data {
    private String data;
    private String producerID;

    public Data(String data, String producerID) {
        this.data = data;
        this.producerID = producerID;
    }

    /**
     * Returns a string representation of the Data object
     *
     * @return a string representation of the Data object.
     */
    public String toString() {
        return producerID+"."+data;
    }


    public String getID() {
        return producerID;
    }
}
