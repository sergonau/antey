package lab02;

/**
 * Triangle calculator common interfece
 *
 * @author Mark Lobanov
 * @version 2.0.3
 */
public interface TriangleCalculator {

    /**
     * Abstract triangle area calculation method
     * @return nothing
     */
    double calculateArea();


    /**
     * Abstract triangle calculation setup method
     * @param data Object with triangle parameters (sides, height, angle)
     * @return Parsed parameters count
     */
    void initFrom(TriangleTransferData data);
}
