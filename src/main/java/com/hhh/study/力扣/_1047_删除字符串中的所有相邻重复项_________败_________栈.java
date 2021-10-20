package com.hhh.study.力扣;

public class _1047_删除字符串中的所有相邻重复项_________败_________栈 {

    public static void main(String[] args) {

        String str = "ibfjcaffccadidiaidchakchchcahabhibdcejkdkfbaeeaecdjhajbkfebebfea";
        System.out.println(removeDuplicates3(str));
    }



    public static String removeDuplicates(String S) {

        if (S == null || S.length() <= 1){
            return S;
        }


        int[] dp = new int[S.length()];
        dp[0] = S.charAt(0);

        for (int i = 1; i < S.length(); i++){
            dp[i] = dp[i - 1] ^ S.charAt(i);
        }

        StringBuilder sb = new StringBuilder();

        return "";

    }

    public static String removeDuplicates2(String S) {

        if (S == null || S.length() <= 1){
            return S;
        }
        StringBuilder sb = new StringBuilder();

        int left = 0,right = 1;
        int preIndex = left;
        boolean sign = false;
        for (;right < S.length(); right++){
            if (S.charAt(right) != S.charAt(left)){
                if (sign){
                    for (int i = preIndex;i <= left;i++){
                        sb.append(S.charAt(i));
                    }
                    left = right;
                    preIndex = left;
                    sign = false;
                    continue;
                }
                left = right;
            }else{
                sign = true;
                left--;
                if (left < preIndex){
                    left = ++right;
                    preIndex = left;
                    sign = false;
                }
                continue;
            }
        }
        for (int j = preIndex; j <= left && j < S.length(); j++){
            sb.append(S.charAt(j));
        }
        return sb.toString();
    }

    public static String removeDuplicates3(String S) {


        if (S == null || S.length() <= 1){
            return S;
        }
        StringBuilder sb = new StringBuilder();

        int left = 0,right = 1;
        int preIndex = left;
        boolean sign = false;
        for (;right < S.length(); right++){
            if (S.charAt(right) != S.charAt(left)){
                if (sign){
                    for (int i = preIndex;i <= left;i++){
                        sb.append(S.charAt(i));
                    }
                    left = right;
                    preIndex = left;
                    sign = false;
                    continue;
                }
                left = right;
            }else{
                sign = true;
                left--;
                if (left < preIndex){
                    left = ++right;
                    preIndex = left;
                    sign = false;
                }
                continue;
            }
        }
        for (int j = preIndex; j <= left && j < S.length(); j++){
            sb.append(S.charAt(j));
        }
        return sb.toString();

    }
}
