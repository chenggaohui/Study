package com.hhh.study.力扣;

public class _204_计数质数 {

    public static void main(String[] args) {
        System.out.println(countPrimes(10000));
    }

    public static int countPrimes(int n) {

        if (n <= 2) return 0;
        if (n <= 3) return 1;
        if (n <= 5) return 2;
        int result = 2;
        for (int i = 5;i < n;i++){
            int temp = i % 6;
            if (temp != 1 && temp != 5){
                continue;
            }
            boolean sign = true;
            for (int j = 5; j <= (int)Math.sqrt(i); j+=6){
                if (i % j == 0 || i % (j+2) ==0){
                    sign = false;
                    break;
                }
            }
            if (sign){
                result++;
            }
        }

        return  result;
    }

    public static boolean isPrime(int num) {
        if (num <= 3) {
            return num > 1;
        }
        // 不在6的倍数两侧的一定不是质数
        int temp = num % 6;
        if (temp != 1 && temp != 5) {
            return false;
        }
        int sqrt = (int) Math.sqrt(num);
        for (int i = 5; i <= sqrt; i += 6) {
            if (num % i == 0 || num % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }


}
