/**  
 * @Description:TODO(java反射Demo)   
 * @author: LuoGuang     
 * @date:   2018年3月26日 下午2:31:09   
 */
package com.reflection.demo;

class Student{
	String name;
	String sex;
	Integer age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
}

public class ReflectionDemo {

	public static void main(String[] args) throws Exception{  
		//获取类的三种方式
		Student demo=new Student();
		System.out.println(Student.class.newInstance());
        System.out.println(demo.getClass().newInstance());
        System.out.println(Class.forName("com.reflection.demo.Student").newInstance());
	}
}
