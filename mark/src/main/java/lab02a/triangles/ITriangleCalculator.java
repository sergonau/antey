package lab02a.triangles;

/**
 * Triangle calculator common interfece
 *
 * @author Mark Lobanov
 * @version 2.0.3
 */
public interface ITriangleCalculator {

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
    void initFrom(double[] data);

    int getParamsCount();

    String getParamToString();
}
