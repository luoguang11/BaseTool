package guang.luo.compare;
class A implements Comparable<A>{  
    private String name;  
    private Integer age;
    /**
	 * @param name
	 * @param age
	 */
	public A(String name, Integer age) {
		super();
		this.name = name;
		this.age = age;
	}
	public String getName() {  
        return name;  
    }  
    public void setName(String name) {  
        this.name = name;  
    }  

    public Integer getAge() {  
        return age;  
    }  
    public void setAge(Integer age) {  
        this.age = age;  
    }  
    @Override  
    public String toString() {  
        return "name is "+name+" age is "+age;  
    }
    
	public int compareTo(A a) {
    	return this.age.compareTo(a.getAge());  
	}  
 
} 
