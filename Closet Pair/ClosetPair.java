public class ClosetPair {
    public static void main(String[] args) {
        int[][] pos = {{1,3},{4,7},{8,9},{2,2},{3,0},{3,5},{4,1}};
        Point[] points = new Point[pos.length];
        for(int i = 0 ;i <pos.length;i++){
            Point p = new Point(pos[i][0],pos[i][1]);
            points[i] = p;
        }
        double minDis = Integer.MAX_VALUE;
        Point minp1 = new Point(0,0);
        Point minp2 = new Point(0,0);;
        for(int i = 0 ;i < pos.length -1 ; i++){
            for(int j = i+1;j<pos.length;j++){
                double dis =points[i].distant(points[j]);
                if(dis <minDis){
                    minDis = dis;
                    minp1 = points[i];
                    minp2 = points[j];
                }
            }
        }
        System.out.println("Distance : "+ minDis);
        System.out.println("Point 1 "+minp1.toString());
        System.out.println("Point 2 "+minp2.toString());
    }
}
class Point{
    int x;
    int y;
    public Point(int x,int y){
        this.x = x;
        this.y = y;
    }
    public double distant(Point p2){
        return Math.sqrt(Math.pow((this.x - p2.x),2) + Math.pow((this.y - p2.y),2));
    }
    public String toString(){
        return "("+this.x+","+this.y+")";
    }
}
