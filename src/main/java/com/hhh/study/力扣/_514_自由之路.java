package com.hhh.study.力扣;

public class _514_自由之路 {

    public static void main(String[] args) {
        String ring = "iotfo";
        String key = "fioot";
        System.out.println(findRotateSteps2(ring,key));


    }

    public static int findRotateSteps2(String ring, String key) {
        System.out.println("钥匙："+ ring);
        System.out.println("密码："+ key);

        int result = 0;
        int index = 0;
        int left = -1;
        int right = 0;
        int length = ring.length();

        char[] ringChars = ring.toCharArray();
        for (int i = 0; i < key.length(); i++){
            char c = key.charAt(i);
            right = index;
            left = index-1;
            for (int j = 0; j < length/2 +1; j++){
                right = right > length-1 ? 0 : right;
                left = left < 0 ? length-1 : left;
                if (ringChars[right] == c){
                    int count = right - index >= 0 ? right - index : length - (index - right);
                    result += count;
                    index = right;
                    System.out.println(c+"使用的下标："+index+" -> 右拧 :"+count+"下");
                    break;
                }
                if (ringChars[left] == c){
                    int count = index - left > 0 ? index - left : length - (left - index);
                    result += count;
                    index = left;
                    System.out.println(c+"使用的下标："+index+" -> 左拧 :"+count+"下");
                    break;
                }
                right++;
                left--;
            }
        }

        return result + key.length();
    }




//    public static int findRotateSteps(String ring, String key) {
//        char[] rings = ring.toCharArray();
//        char[] keys = key.toCharArray();
//
//        int[][] dp = new int[key.length()][ring.length()];
//
//        for (int i = 0; i< key.length() ; i++){
//            for (int j = 0;j<ring.length();j++){
//
//            }
//        }
//
//    }
}
