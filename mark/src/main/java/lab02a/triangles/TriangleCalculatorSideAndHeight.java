package lab02a.triangles;

/**
 * Custom method for triangle calculation by the side and
 * the height drawn to it
 *
 * @author Mark Lobanov
 * @version 2.0.3
 */
public class TriangleCalculatorSideAndHeight implements ITriangleCalculator {
    private double side;
    private double height;

    // class constructor
    public TriangleCalculatorSideAndHeight() {
        side = 0;
        height = 0;
    }

    /**
     * One sides and and the height drawn to it area calculation method
     * @return triangle area
     */
    @Override
    public double calculateArea() {
        return 0.5 * side * height;
    }

    /**
     * Triangle setup method
     * accepts one side and the height drawn to it values as some string
     *
     * @param data string with triangle parameters
     * @throws IllegalArgumentException if wrong data.data.getTriangleCalculationKind()
     */
    @Override
    public void initFrom(double[] data) {
        side = data[0];
        height = data[1];
    }

    @Override
    public int getParamsCount() {
        return 2;
    }

    @Override
    public String getParamToString() {
        return "Side="+side+" Height="+height+" ";
    }
}
