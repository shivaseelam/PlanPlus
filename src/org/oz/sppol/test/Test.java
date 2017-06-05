package org.oz.sppol.test;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;

/**
 * Created by siva on 12/28/2016.
 */
public class Test {

    public static void main(String[] args) {

     A a = new B("B REF",20,123456);
     a.display();
        B b = new B("B Class",10,12345);
        b.display();

    }
}

class  B extends  A
{
    int phn;
    public B(String name, int age,int phn) {
        this.name = name;
        this.age = age;
        this.phn = phn;
    }
    public void display()
    {
        System.out.println(" B NAME="+name+" B AGE="+age+"phone num="+phn);
    }
}



class  A
{
    public  A(){}
    public A(String name, int age) {
        this.name = name;
        this.age = age;
    }
    String name;
     int age;

    public void display()
    {
        System.out.println("NAME="+name+" AGE="+age);
    }

}

