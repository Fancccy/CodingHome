package com.ming;

public class A {

    private int id;

    private String name;

    private double weight;

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    private  B b; //一定要定义setter方法

    public A(){

    }
    //使用构造方法注入DI
    public A(B b){
        this.b = b;
    }
//    public A(B b,int id,String name, double weight){
//        this.b = b;
//        this.id = id;
//        this.name = name;
//        this.weight = weight;
//    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }

    public B getB() {
        return b;
    }
    //    public B getB() {
//        return b;
//    }
//
    public void setB(B b) {
        this.b = b;
    }


    public void callByMethod(){
        System.out.println(b.sayHello("handsome"));
    }
}
