package lab02a.triangles;

/**
 * Custom method for triangle calculation by the two sides and
 * angle between them
 *
 * @author Mark Lobanov
 * @version 2.0.3
 */
public class TriangleCalculatorTwoSidesAndAngle implements ITriangleCalculator {
    // inner fields for triangle sides
    private double sideA;
    private double sideB;
    private double angle;

    // class constructor
    public TriangleCalculatorTwoSidesAndAngle() {
        sideA = 0;
        sideB = 0;
        angle = 0;
    }

    /**
     * Method that converts degree angle size into radians
     *
     * @param str Angle size in degrees
     * @return Angle size in radians
     */
    private double convertDegToRad(double deg) {
        return (Math.PI * deg) / 180;
    }

    /**
     * Two sides and angle area calculation method
     *
     * @return triangle area
     */
    @Override
    public double calculateArea() {
        return 0.5 * sideA * sideB * Math.sin(convertDegToRad(angle));
    }

    /**
     * Triangle setup method
     * accepts two triangle sides lengths and angle size in degrees between them
     * as some string
     *
     * @param data string with triangle parameters
     * @throws IllegalArgumentException if wrong data.data.getTriangleCalculationKind()
     */
    @Override
    public void initFrom(double[] data) {
        sideA = data[0];
        sideB = data[1];
        angle = data[2];
    }

    @Override
    public int getParamsCount() {
        return 3;
    }

    @Override
    public String getParamToString() {
        return "SideA="+sideA+" SideB="+sideB+" Angle="+angle+" ";
    }
}
