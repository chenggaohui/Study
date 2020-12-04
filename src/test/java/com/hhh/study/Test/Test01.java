package com.hhh.study.Test;



import com.hhh.study.属性覆盖.Fathor;
import org.junit.jupiter.api.Test;
import org.springframework.util.ReflectionUtils;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Consumer;

public class Test01 {

    @Test
    public void testSchedule(){
//        ReflectionUtils.makeAccessible();
        System.out.println(null == null);
    }

    private static final Map<String, Consumer> map;

    private static final ExecutorService executorService;


    static {
        executorService = Executors.newCachedThreadPool();
        map = new ConcurrentHashMap<>();
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {

//        ReentrantLock reentrantLock = new ReentrantLock();
//
//        Thread t1 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//
//                try {
//                    reentrantLock.lock();
//                    while (true) {
//                    }
//                } finally {
//                    reentrantLock.unlock();
//                }
//            }
//        }, "T1");
//        t1.start();
//
//        Thread t2 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//
//                try {
//                    reentrantLock.lock();
//                    while (true) {
//                    }
//                } finally {
//                    reentrantLock.unlock();
//                }
//            }
//        }, "T2");
//        t2.start();
//
//        t1.join();
//        t2.join();

        ReentrantLock lock = new ReentrantLock();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                lock.lock();
                    System.out.println("前。。。");
                    try {
                        TimeUnit.MILLISECONDS.sleep(10000000);
                    } catch (Exception e) {
                        System.out.println("异常");
                    }
                    lock.unlock();

                    System.out.println("后。。。");
                }

        });


        thread.start();

    }

    @Test
    public void testThreadPool(){
        ExecutorService executorService = Executors.newCachedThreadPool();


        Future<String> result = executorService.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("111");

            }
        }, "result");
        try{
            System.out.println(result.get());
        }catch (Exception e){
            System.out.println(e);
        }


    }

    @Test
    public void testRedis() throws UnsupportedEncodingException {

        String a = "a我b中c孎";
        byte[] abytes = a.getBytes("utf-8");
        for (byte b:abytes){
            System.out.println(b);
        }
//        byte[] bb = new byte[abytes.length-1];
//        byte[] bytes = Arrays.copyOf(abytes, abytes.length - 1);
//        String s = new String(bytes);
//        System.out.println(s);
    }

    @Test
    private int strToHexByte(String hexString) {
        if (hexString == null){
            return 0;
        }
        hexString = hexString.replace(" ","");
        char[] chars = hexString.toCharArray();
        boolean sign = chars[0] == '-';
        StringBuilder sb = new StringBuilder();
        for (char c : chars){
            StringBuilder s = new StringBuilder();
            if ((c>='0'&&c<='9')||(c>='a'&&c<='f')){
                for (int i = 0; i< 4; i++){
                    
                }
            }
        }
        return 0;
    }

    @Test
    public void searchNum(){
        int[] ints = {5,12,6,3,9,2,1,7};
        System.out.println(search(ints,13));
    }
    public List<List<Integer>> search(int[] arr,int count){
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(arr);
        for (int i = 0; i<arr.length-1;i++){
            int temp = count-arr[i];
            int j=i+1;
            int k=arr.length-1;
            while(j<k){
                int target = arr[j] + arr[k];
                if (j<k && target>temp){
                    k--;
                    continue;
                }
                if (j<k && target<temp){
                    j++;
                    continue;
                }
                if (j<k){
                    List<Integer> list = Arrays.asList(arr[i], arr[j], arr[k]);
                    result.add(list);
                    j++;
                    k--;
                }
            }
        }
        return result;
    }

    @Test
    public void testDouble(){
        String str1=("String" + new String("Intern")).intern();
        String str2=("String" + new String("Intern")).intern();
        System.out.println(str1 == str2);


    }

    public long getway(long i,long count){
        if(i<0){
            return 0L;
        }
        if (i<=2){
            return i;
        }

        return getway(i-1,count)+getway(i-2,count);
    }





}
