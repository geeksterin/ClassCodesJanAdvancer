import java.util.*;

public class Dp{
    public static void main(String[] args){
        // long startTime = System.currentTimeMillis();
        int n =5;
        int[] strg = new int[n+1];
        // System.out.println(fibBtr(n,strg));
        // long endTime = System.currentTimeMillis();
 
        // long timeElapsed = endTime - startTime;
        // System.out.println(timeElapsed);
        System.out.println(climbDown(n));
        System.out.println(climbDownMem(n,strg));
        System.out.println(climbDownTabulation(n));
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

    public static int climbDown(int n){
        if(n<0){
            return 0;
        }

        if(n==1||n==0){
            return 1;
        }
        return climbDown(n-1)+climbDown(n-2)+climbDown(n-3);
    }

    public static int climbDownMem(int n,int[] strg){
        if(n<0){
            return 0;
        }

        if(n==1||n==0){
            return 1;
        }

        if(strg[n]!=0){
            return strg[n];
        }
        return strg[n] = climbDownMem(n-1,strg)+climbDownMem(n-2,strg)+climbDownMem(n-3,strg);
    }

    public static int climbDownTabulation(int n){
        int[] strg = new int[n+1];

        strg[0] = 1;
        strg[1] = 1;
        strg[2] = 2;
        for(int i=3;i<=n;i++){
            strg[i] = strg[i-1]+strg[i-2]+strg[i-3];
        }

        return strg[n];
    }
}