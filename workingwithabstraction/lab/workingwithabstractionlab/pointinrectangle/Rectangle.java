package workingwithabstraction.lab.workingwithabstractionlab.pointinrectangle;

public class Rectangle {
    private int pointXA;
    private int pointYA;
    private int pointXB;
    private int pointYB;

    public Rectangle(int pointXA, int pointYA, int pointXB, int pointYB) {
        this.pointXA = pointXA;
        this.pointYA = pointYA;
        this.pointXB = pointXB;
        this.pointYB = pointYB;
    }

   public boolean contains (Point point){
        boolean isPointIn = true;
        if (point.getPointX() < this.pointXA  || point.getPointX() > this.pointXB){
            isPointIn = false;
        }

        if (point.getGetPointY() < this.pointYA || point.getGetPointY() > this.pointYB){
            isPointIn = false;
        }

        return isPointIn;
   }
}
