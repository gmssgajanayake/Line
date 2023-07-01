public class Line {
    private Point point1;
    private Point point2;

    public Line() {
        this.setPoint1(new Point());
        this.setPoint2(new Point());
    }

    public Line(Point point1, Point point2) {
        this.point1 = point1;
        this.point2 = point2;
    }

    public Point getPoint1() {
        return point1;
    }

    public void setPoint1(Point point1) {
        this.point1 = point1;
    }

    public Point getPoint2() {
        return point2;
    }

    public void setPoint2(Point point2) {
        this.point2 = point2;
    }

    @Override
    public String toString() {
        return "Line { " +
                "Point 1 = " + point1.toString() +
                " | Point 2 = " + point2.toString() +
                " }";
    }

    double getLength() {
        return Math.sqrt(((point1.getX() - point2.getX()) * (point1.getX() - point2.getX())) +
                ((point1.getY() - point2.getY()) * (point1.getY() - point2.getY())));
    }

    public boolean isGraterThan(Line anotherLine) {
        return this.getLength() > anotherLine.getLength();
    }

    public String getEquation() {
        double m = (double) (point1.getY() - point2.getY()) / (point1.getX() - point2.getX());
        double c = point1.getY() - (m * point1.getX());
        return point1.getX() == point2.getX() ? "x = " + point1.getX() : "y = " + (m == 0 ? "" : m == 1 ? "x" :
                Math.round(m * 100) / 100.0 + "x") + (c < 0 ? " - " + (-c) : m == 0 ? c : " + " + c);
    }

    public boolean isSquare(Line anotherLine1, Line anotherLine2, Line anotherLine3) {
        Point[][] points = {{point1, point2}, {anotherLine1.getPoint1(), anotherLine1.getPoint2()},
                {anotherLine2.getPoint1(), anotherLine2.getPoint2()}, {anotherLine3.getPoint1(), anotherLine3.getPoint2()}};
        L1:
        for (int i = 0; i < points.length; i++) {
            int k = i + 1;
            L2:
            for (; k < points.length; k++) {
                L3:
                for (int j = 0; j < points[k].length; j++) {
                    if (isEqualPoint(points[i][0], points[k][j])) {
                        Point temp = points[i][1];
                        points[i][1] = points[k][j];
                        points[k][j] = temp;
                        continue L1;
                    }
                }
            }
        }
        return isEqualPoint(points[0][0], points[0][1]) && isEqualPoint(points[1][0], points[1][1]) &&
                isEqualPoint(points[2][0], points[2][1]) && isEqualPoint(points[3][0], points[3][1]);
    }

    // This private method for check weather the given two points are equal or not
    private boolean isEqualPoint(Point point1, Point point2) {
        return point1.getX() == point2.getX() && point1.getY() == point2.getY();
    }
}
