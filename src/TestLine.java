public class TestLine {
    public static void main(String[] args) {
        Line line1 = new Line(new Point(2, 4), new Point(4, 4));
        Line line2 = new Line(new Point(12, 18), new Point(6, 10));
        System.out.println("Line 01 -:");
        System.out.println("\t" + line1.toString());
        System.out.println("\tThe length of line " + line1.getLength());
        System.out.println("\nLine 02 -:");
        System.out.println("\t" + line2.toString());
        System.out.println("\tThe length of line " + line2.getLength());
        System.out.println("\n*** Check weather the Line 1 > Line 2 or Line 1 < Line 2 ***");
        System.out.println("Line 1 " + (line1.isGraterThan(line2) ? ">" : "<=") + " Line 2");
        System.out.println("\n*** Equations of lines ***");
        System.out.println(line1.getEquation());
        System.out.println(line2.getEquation());
        System.out.println("\nIs it square shape? " +
                (line1.isSquare(
                        new Line(new Point(4, 4), new Point(4, 6)),
                        new Line(new Point(4, 6), new Point(2, 6)),
                        new Line(new Point(2, 6), new Point(2, 4))
                ) ? "Yes" : "No")
        );
    }
}