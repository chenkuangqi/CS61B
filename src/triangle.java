public class triangle {
    public static void drawTriangle(int N) {
        int col = 1;
        int row = 1;
        while (N > 0){
            while (col <= row) {
                System.out.print("*");
                col +=1;
            }
            col = 1;
            row +=1;
            System.out.println();
            N -=1;
        }
    }
    public static void main(String[] args){
        drawTriangle(5);
    }
}
