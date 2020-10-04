import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Point pair1 = new Point(1, 2);
        Point pair2 = new Point(7, 8);
        Point pair3 = new Point(2, 5);
        Point pair4 = new Point(2, 9);
        Point pair5 = new Point(5, 3);
        Point pair6 = new Point(4, 1);
        Point[] list = {pair1, pair2, pair3, pair4, pair5, pair6};

        ArrayList<PairOfPoints> result = convexHull(list);

        printPairOfPointList(result);
    }

    /**
     * 
     * @param pointList - array of Point(x, y) to determine
     * @return Pair of point the will form a boundary
     */
    public static ArrayList<PairOfPoints> convexHull(Point[] pointList) {
        ArrayList<PairOfPoints> boundary = new ArrayList<>();

        for (int i = 0; i < pointList.length - 1; i++) {
            for (int j = i + 1; j < pointList.length; j++) {
                int a = pointList[j].y - pointList[i].y;
                int b = pointList[i].x - pointList[j].x;
                int c = pointList[i].x * pointList[j].y - pointList[j].x * pointList[i].y;

                int left = 0;
                int right = 0;
                for (int k = 0; k < pointList.length; k++) {
                    int currentC = a * pointList[k].x + b * pointList[k].y;

                    if (currentC <= c) {
                        left++;
                    }
                    if (currentC >= c) {
                        right++;
                    }
                }

                if (left == pointList.length || right == pointList.length) {
                    boundary.add(new PairOfPoints(pointList[i], pointList[j]));
                }
            }
        }

        return boundary;
    }

    public static void printPairOfPointList(ArrayList<PairOfPoints> arr) {
        for (PairOfPoints i : arr) {
            System.out.println(i.toString());
        }
    }
}

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

}

class PairOfPoints {
    Point point1;
    Point point2;

    public PairOfPoints(Point point1, Point point2) {
        this.point1 = point1;
        this.point2 = point2;
    }

    public double getDistance() {
        return Math.sqrt(Math.pow(point1.x - point2.x, 2) + Math.pow(point1.y - point2.y, 2));
    }

    @Override
    public String toString() {
        return point1.toString() + " and " + point2.toString();
    }

}