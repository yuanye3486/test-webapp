package com.fengqiliu.test.hightqualitycode.item1_25.com.company.section1;

/**
 *   http://www.jusfortechies.com/core-java/static-blocks.html
 * @author Administrator
 *
 */
public class ConstructorBlockExample{

    {
        System.out.println("This is first constructor block");
    }

    public ConstructorBlockExample(){
        System.out.println("This is no parameter constructor");
    }

    public ConstructorBlockExample(String param1){
        System.out.println("This is single parameter constructor");
    }

    public ConstructorBlockExample(String param1, String param2){
        System.out.println("This is two parameters constructor");
    }

    {
        System.out.println("This is second constructor block");
    }

    public static void main(String[] args){
        ConstructorBlockExample constrBlockEx = 
		             new ConstructorBlockExample();
        ConstructorBlockExample constrBlockEx1 = 
		             new ConstructorBlockExample("param1");
        ConstructorBlockExample constrBlockEx2 = 
		             new ConstructorBlockExample("param1", "param2");
    }
}