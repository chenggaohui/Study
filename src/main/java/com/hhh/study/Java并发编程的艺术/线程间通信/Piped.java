package com.hhh.study.Java并发编程的艺术.线程间通信;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

public class Piped {

    public static void main(String[] args) throws IOException {
        PipedWriter writer = new PipedWriter();
        PipedReader reader = new PipedReader();

        reader.connect(writer);

        Thread thread = new Thread(new Print(reader),"reader线程");
        thread.start();

        int temp = 0;
        while((temp = System.in.read()) != -1){
            writer.write(temp);
        }
    }

    public static class Print implements Runnable {

        private PipedReader reader;

        public Print(PipedReader reader) {
            this.reader = reader;
        }

        @Override
        public void run() {
            int temp = 0;
            try {
                while((temp = reader.read()) != -1){
                    System.out.print((char) temp);
                }
            }catch (IOException e){
                System.err.println(e);
            }
        }
    }
}
