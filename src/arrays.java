import java.util.Arrays;
public class arrays {
    public static int max(int[] m){
        Arrays.sort(m);
        return 0;
    }

    public static int forMax(int[] m) {

        return 0;
    }
    public static void main(String[] args){
        int[] numbers = new int[]{1,5,2,7,9};
        max(numbers);
        System.out.println("排序后的数组内容如下：");
        for (int i = 0;i < numbers.length; i++){
            System.out.print(numbers[i]+"\t");
        }

    }
}
