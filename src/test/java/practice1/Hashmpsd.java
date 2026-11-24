package practice1;

import java.util.*;

public class Hashmpsd {
	public static void main (String []args) throws InterruptedException
{
	HashMap<Integer, String> map=new HashMap<>();
	Integer i=new Integer(10);
	map.put(i, "Test");
	System.out.println(map);
	i=null;
	  System.gc();
	Thread.sleep(3000);
	System.out.println(map);
	
}

}
