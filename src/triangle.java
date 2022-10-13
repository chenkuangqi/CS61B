public class drawtriangle {
    public void main(String[] arg){
        int size = 5;
        int col = 1;
        int row = 1;
        while (size <= 5){
            while (col <= row) {
                System.out.print("*");
                col +=1;
            }
            row +=1;
            System.out.println();
            size +=1;
        }
    }
}
