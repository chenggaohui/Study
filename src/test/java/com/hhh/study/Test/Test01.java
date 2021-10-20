package com.hhh.study.Test;



import com.hhh.study.属性覆盖.Fathor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanUtils;
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


    public int[] findSingle(int[] arr){

        if (arr == null || arr.length <= 1){
            return arr;
        }

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i : arr){
            min = min <= i ? min : i;
            max = max >= i ? max : i;
        }
        int length = max - min;
        int[] index = new int[length];
        for (int i : arr){
            index[i-min]++;
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < length; i++){
            if (index[i] == 1){
                list.add(i+min);
            }
        }
        return list.stream().mapToInt(Integer::valueOf).toArray();

    }

    @Test
    public void testString(){

        int[] arr = {5,4,9,1,6,8,10,7,2,3};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public void sort(int[] arr){

        for (int i = 0; i < arr.length; i++){
            if ((arr[i] & 1) == 1){
                int temp = arr[i];
                int j = i-1;
                for (; j >= 0; j--){
                    if ((arr[j] & 1) == 0){
                        arr[j+1] = arr[j];
                    }else{
                        break;
                    }
                }
                arr[j+1] = temp;
            }
        }

    }


    @Test
    public void testRetry(){

        retry:
        for (int i = 1; i <= 20; i++){
            for(int j = 1; j <= 20; j++){
                    break retry;
                }
            }
        }

//        for (int i = 1; i <= 20; i++){
//            System.out.println("____"+i);
//            if (i%5==0){
//                continue retry;
//            }
//        }




    @Test
    public void testThread() throws InterruptedException {

        Thread thread = new Thread(()->{
            System.out.println("线程启动");
        });

        System.out.println("首次启动线程,启动前线程状态："+thread.getState().name());
        thread.start();
        thread.join();
        System.out.println("再次启动线程,启动前线程状态："+thread.getState().name());
        thread.start();
    }

    @Test
    public void testTest(){
        int[] arr = {0,3,4,2,1};
        sort1(arr);
        System.out.println(Arrays.toString(arr));

    }

    public void sort1(int[] arr){

        if (arr == null || arr.length <=1) return;

        for (int i = 1; i < arr.length-1; i++){
            for (int j = 0; j < arr.length-i; j++){
                if (arr[j] > arr[j+1]){
                    arr[j] ^= arr[j+1];
                    arr[j+1] ^= arr[j];
                    arr[j] ^= arr[j+1];
                }
            }
        }
    }




}
