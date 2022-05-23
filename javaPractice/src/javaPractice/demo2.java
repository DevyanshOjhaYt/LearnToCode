package javaPractice;
public class demo2 {
	
	int sum(int n)
	{
		if(n==0)
			return 0;
		return sum(n-1)+n;
	}
	
	
public static void main(String[] args) {
	int n=5;
	demo2 obj=new demo2();
	System.out.println(obj.sum(n));
}
}
