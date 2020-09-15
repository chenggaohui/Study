package com.hhh.study.Test;

import com.hhh.study.属性覆盖.Fathor;
import org.junit.jupiter.api.Test;
import org.springframework.util.ReflectionUtils;

import java.util.Map;
import java.util.concurrent.*;
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
//        Future<Object> future = executorService.submit(new Callable<Object>() {
//            @Override
//            public Object call() throws Exception {
//                Thread.sleep(3000);
//                return "123";
//            }
//        });
//        System.out.println(future.get());
        System.out.println(Fathor.address);


    }
}
