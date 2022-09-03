package org.example;

import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {
    public static void main(String[] args)
    {
        String classPath="classpath:applicationContext.xml";

        GenericXmlApplicationContext ctx=new GenericXmlApplicationContext(classPath);

        Transpot transpot=ctx.getBean("tWalk",Transpot.class);

        transpot.move();

        ctx.close();
    }
}