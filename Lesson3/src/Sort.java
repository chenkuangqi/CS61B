public class Sort {
    public static void sort(String[] x){
        // find the smallest item
        //move it to the front
        // selection sort the rest (using recursion??)
        sort(x, 0);

    }
/** sort x starting at position start */
    private static void sort(String[] x, int start){
        if ( start == x.length){
            return;
        }
        int smallestIndex = findSmallest(x,start);
        swap(x, start, smallestIndex);
        sort(x, start +1);
    }
    public static void swap(String[] x, int a , int b){
        String temp = x[a];
        x[a] = x[b];
        x[b] = temp;
    }

//    return the index of the smallest
    public  static int findSmallest(String[] x, int start){
        int smallestIndex = start;
        for (int i = start ; i <x.length; i+=1){
            int cmp = x[i].compareTo(x[smallestIndex]);
            if (cmp < 0 ){
                smallestIndex = i;
            }
        }

        return smallestIndex;
    }
}
