package IntList;

public class IntList {
    public int first;
    public IntList rest;

    public IntList(int f, IntList r){
        first = f;
        rest = r;

    }

    public int size() {
         if ( rest == null){
             return 1;
         }
         return 1+this.rest.size();
    }

    public int iterativesize(){
        IntList p = this;
        int totalsize = 0;
        while (p != null){
            totalsize +=1;
            p = p.rest;
        }
        return totalsize;
    }


    public int get(int i){
        if (i == 0 ){
            return first;
        }
        return this.rest.get(i-1);
    }
    public static void main(String[] args){
        IntList L = new IntList(10,null);

    }
}
