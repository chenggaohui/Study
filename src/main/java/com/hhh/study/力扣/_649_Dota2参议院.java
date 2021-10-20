package com.hhh.study.力扣;

import java.util.LinkedList;
import java.util.Queue;

public class _649_Dota2参议院 {

    public static void main(String[] args) {

        String str = "RDD";
        System.out.println(predictPartyVictory(str));
    }


    public static String predictPartyVictory(String senate) {


        if (senate == null || senate.length() <=0){
            return "";
        }

        Queue<Character> queue = new LinkedList<>();
        int signR = 0,signD = 0;
        int countR = 0,countD = 0;
        for (char c : senate.toCharArray()){
            if (c == 'R'){
                if (signR >= 0){
                    countR++;
                    queue.add(c);
                    signD--;
                }else{
                    signR++;
                }
            }else{
                if (signD >= 0){
                    countD++;
                    queue.add(c);
                    signR--;
                }else{
                    signD++;
                }
            }
        }

        while(queue.size() > 1 && countD > 0 && countR > 0){
            Character c = queue.poll();
            if (c == 'R'){
                countR--;
                if (signR >= 0){
                    countR++;
                    queue.add(c);
                    signD--;
                }else{
                    signR++;
                }
            }else{
                countD--;
                if (signD >= 0){
                    countD++;
                    queue.add(c);
                    signR--;
                }else{
                    signD++;
                }
            }
        }

        return queue.peek() == 'R' ? "Radiant" : "Dire";
    }
}
