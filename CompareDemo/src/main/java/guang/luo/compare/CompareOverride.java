package guang.luo.compare;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;

import com.alibaba.fastjson.JSON;

/**  
 * All rights Reserved, Designed By LuoGuang
 * @Title:  ObjectCompareOverride.java   
 * @Package    
 * @Description:TODO(Collections.sort()排序详解)   
 * @author: LuoGuang     
 * @date:   2018年3月30日 上午11:17:27   
 * @version V1.0 
 */
public class CompareOverride {

	/**     
	 * @Description TODO(Collections.sort()排序详解)        
	 */
	public static void main(String[] args) {
		//1:类A实现接口Comparable，并实现compareTo()方法,调用Collections.sort(lists)即可实现排序
		List<A> aList = new ArrayList<A>();
		A a1 = new A("小敏",2);
		A a2 = new A("小丽",1);
		aList.add(a1);aList.add(a2);
		System.out.println("排序前A:"+JSON.toJSONString(aList));
		Collections.sort(aList);
		System.out.println("排序后A:"+JSON.toJSONString(aList));
		
		/**------------------------------------------------------------------------------------------------------*/
		//2:Comparator比较器接口
		//Collections.sort(list, new PriceComparator());需要排序的list比较器，
		//实现Comparator接口的类，返回一个int型的值，就相当于一个标志，告诉sort方法按什么顺序来对list进行排序。
		List<B> listB = new ArrayList<B>();
        B b11 = new B();
        b11.setName("b11");
        b11.setOrder("b");
        B b22 = new B();
        b22.setName("b22");
        b22.setOrder("a");
        listB.add(b11);
        listB.add(b22);
        System.out.println("排序前B:"+JSON.toJSONString(listB));
        Collections.sort(listB, new Comparator<B>() {
            public int compare(B b11, B b22) {
                return b11.getOrder().compareTo(b22.getOrder());
            }
        });
		System.out.println("排序后B:"+JSON.toJSONString(listB));
		
		/**------------------------------------------------------------------------------------------------------*/
		//3:第二种演化而来,根据自定义属性比较
		List<Book> list = new ArrayList<Book>(); // 数组序列  
        Book b1 = new Book(10000, "红楼梦", 150.86, new GregorianCalendar(2009,  
                01, 25), "曹雪芹、高鄂");  
        Book b2 = new Book(10001, "三国演义", 99.68, new GregorianCalendar(2008, 7,  
                8), "罗贯中 ");  
        Book b3 = new Book(10002, "水浒传", 100.8, new GregorianCalendar(2009, 6,  
                28), "施耐庵 ");  
        Book b4 = new Book(10003, "西游记", 120.8, new GregorianCalendar(2011, 6,  
                8), "吴承恩");  
        Book b5 = new Book(10004, "天龙八部", 10.4, new GregorianCalendar(2011, 9,  
                23), "搜狐");  
        list.add(b1);  
        list.add(b2);  
        list.add(b3);  
        list.add(b4);  
        list.add(b5);  
        // Collections.sort(list); //没有默认比较器，不能排序  
        System.out.println("数组序列中的元素:");  
        myprint(list);  

        Collections.sort(list, new PriceComparator()); // 根据价格排序  
        System.out.println("按书的价格排序:");  
        myprint(list);  

        Collections.sort(list, new CalendarComparator()); // 根据时间排序  
        System.out.println("按书的出版时间排序:");  
        myprint(list);
	}
	
	// 自定义比较器：按书的价格排序  
    static class PriceComparator implements Comparator<Object> {  
        public int compare(Object object1, Object object2) {// 实现接口中的方法  
            Book p1 = (Book) object1; // 强制转换  
            Book p2 = (Book) object2;  
            return new Double(p1.price).compareTo(new Double(p2.price));  
        }  
    }  

    // 自定义比较器：按书出版时间来排序  
    static class CalendarComparator implements Comparator<Object> {  
        public int compare(Object object1, Object object2) {// 实现接口中的方法  
            Book p1 = (Book) object1; // 强制转换  
            Book p2 = (Book) object2;  
            return p2.calendar.compareTo(p1.calendar);  
        }  
    } 

    // 自定义方法：分行打印输出list中的元素  
    public static void myprint(List<Book> list) {  
        Iterator<Book> it = list.iterator(); // 得到迭代器，用于遍历list中的所有元素  
        while (it.hasNext()) {// 如果迭代器中有元素，则返回true  
            System.out.println("\t" + it.next());// 显示该元素  
        }  
    } 
}
