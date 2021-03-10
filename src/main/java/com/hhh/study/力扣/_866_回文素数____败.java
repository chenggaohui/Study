package com.hhh.study.力扣;

public class _866_回文素数____败 {


    public static void main(String[] args) throws InterruptedException {

        System.out.println(primePalindrome(930));
    }


    public static int primePalindrome(int N) throws InterruptedException {

        if (N <= 2) {
            return 2;
        }
        if (N <= 3) {
            return 3;
        }

        int temp = (N / 6) * 6;
        int left,right;
        while(true){
            left = temp - 1;
            right = temp + 1;
            if (left >= N && cehck(left)){
                return left;
            }
            if (right >= N && cehck(right)){
                return right;
            }
            temp += 6;
        }
    }

    public static boolean cehck(int num) throws InterruptedException {


        if (!isPrime(num)){
            return false;
        }
        System.out.println(num);
        Thread.sleep(1000);
        int n = 1;
        int count = 0;
        while(n <= num / 10){
            n *= 10;
            count ++;
        }

        for (int i = 0; i < count; i++){
            if (num > 10 && (num / n != num % 10)){
                return false;
            }
            num %= n;
            num /= 10;
            n /= 10;
        }
        return true;
    }

    public static boolean isPrime(int num) {
        if (num <= 3) {
            return num > 1;
        }
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
