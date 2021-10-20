package com.hhh.study.力扣;

public class _738_单调递增的数字 {
    public static void main(String[] args) {

        System.out.println(monotoneIncreasingDigits2(1256346722));

    }

    public static int monotoneIncreasingDigits(int N) {

        int result = N;
        if (result < 10){
            return result;
        }

        int temp = N;
        int sign = 1;
        while(temp >= 10){
            sign *= 10;
            temp /=10;
        }
        boolean change = false;
        int left,right;
        while (sign >= 10){
            left = N / sign;
            N %= sign;
            sign /= 10;
            right = N / sign;
            if (left > right){
                change = true;
                break;
            }
        }
        sign *= 10;
        if (change){
            result = (result / sign) * sign -1;
        }
        return result;

    }


    public static int monotoneIncreasingDigits2(int N) {

        if (N < 10){
            return N;
        }

        int sign = 10;

        int left,right;
        while(sign <= N){
            left = N / sign % 10;
            right = N % sign / (sign / 10);
            if (left > right){
                N = (N / sign) * sign -1;
                System.out.println("中间结果："+N);
            }
            sign *= 10;
        }


        return N;

    }

}
