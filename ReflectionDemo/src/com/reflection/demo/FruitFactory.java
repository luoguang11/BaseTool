package com.reflection.demo;

/**
 * 
 * @Title:  FruitFactory.java   
 * @Package com.reflection.demo   
 * @Description:TODO(工厂模式，反射机制动态创建所需类)   
 * @author: LuoGuang     
 * @date:   2018年3月26日 下午3:27:29   
 * @version V1.0
 */
interface Fruit{
    public abstract void eat();
}

class Apple implements Fruit{
    public void eat(){
        System.out.println("Apples");
    }
}

class Orange implements Fruit{
    public void eat(){
        System.out.println("Orange");
    }
}

class Factory{
    public static Fruit getInstance(String ClassName){
    	Fruit f=null;
        try{
            f=(Fruit)Class.forName(ClassName).newInstance();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return f;
    }
}

public class FruitFactory {
	public static void main(String[] a){
		//"com.reflection.demo.Apple"可以定义在配置文件中或者常量中，根据参数调用
    	Fruit f=Factory.getInstance("com.reflection.demo.Apple");
    	//Apple f1=(Apple)Factory.getInstance("com.reflection.demo.Apple");
        if(f!=null){
            f.eat();
        }
    }
}
