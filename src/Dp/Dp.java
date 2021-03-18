public class Dp{
    public static void main(String[] args){
        int n = 600;
        int[] strg = new int[n+1];
        System.out.println(fibBtr(n,strg));
    }

    public static int fib(int n){

        if(n==1||n==2){
            return n-1;
        }
        int fbn1 = fib(n-1);
        int fbn2 = fib(n-2);

        int fibn = fbn1 + fbn2;
        return fibn;
    }

    public static int fibBtr(int n,int strg[]){

        if(n==1||n==2){
            return n-1;
        }

        if(strg[n]!=0){
            return strg[n];
        }
        int fbn1 = fibBtr(n-1,strg);
        int fbn2 = fibBtr(n-2,strg);

        int fibn = fbn1 + fbn2;
        strg[n] = fibn;
        return fibn;
    }
}