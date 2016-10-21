package lab02a.triangles;

/**
 * Custom method for triangle calculation by the three sides
 *
 * @author Mark Lobanov
 * @version 2.0.3
 */
public class TriangleCalculatorThreeSides implements ITriangleCalculator {
    // inner fields for triangle sides
    private double sideA;
    private double sideB;
    private double sideC;

    // class constructor
    public TriangleCalculatorThreeSides() {
        sideA = 0;
        sideB = 0;
        sideC = 0;
    }

    /** semiPerimeter calculation method */
    private double getSemiPerimeter() {
        return ( sideA + sideB + sideC )/2;
    }

    /**
     * Three sides area calculation method (Heron's formula)
     * @return triangle area
     */
    @Override
    public double calculateArea() {
        double p = getSemiPerimeter();
        return Math.sqrt(p * (p - sideA) * (p - sideB) * (p - sideC));
    }

    /**
     * Triangle setup method
     * accepts three triangle sides lengths as some string
     * and sets inner sideA..C fields
     *
     * @param data string with triangle parameters
     * @throws IllegalArgumentException if wrong data.data.getTriangleCalculationKind()
     */
    @Override
    public void initFrom(double[] data) {
        sideA = data[0];
        sideB = data[1];
        sideC = data[2];
    }

    @Override
    public int getParamsCount() {
        return 3;
    }

    @Override
    public String getParamToString() {
        return "SideA="+sideA+" SideB="+sideB+" SideC="+sideC+" ";
    }
}
