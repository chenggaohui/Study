package com.hhh.study.方法重载;

public class MethodReloadTest {

    public static void main(String[] args) {
        MethodReloadTest test = new MethodReloadTest();
    }

    public void sout(){
        System.out.println("null");
    }

    public void sout(int[] arr){
        System.out.println("int[]");
    }

    public void sout(byte b){
        System.out.println("byte");
    }
    public void sout(Byte b){
        System.out.println("Byte Object");
    }

    public void sout(short s){
        System.out.println("short");
    }
    public void sout(Short s){
        System.out.println("Short Object");
    }

    public void sout(char c){
        System.out.println("char");
    }
    public void sout(Character character){
        System.out.println("Character");
    }

    public void sout(int i){
        System.out.println("int");
    }
    public void sout(Integer integer){
        System.out.println("Integer");
    }

    public void sout(long i){
        System.out.println("long");
    }
    public void sout(Long l){
        System.out.println("Long Object");
    }

    public void sout(float i){
        System.out.println("float");
    }
    public void sout(Float integer){
        System.out.println("Float Object");
    }

    public void sout(double i){
        System.out.println("double");
    }
    public void sout(Double d){
        System.out.println("Double Object");
    }

    public void sout(String i){
        System.out.println("String");
    }
    public void sout(Object integer){
        System.out.println("Object");
    }

}
