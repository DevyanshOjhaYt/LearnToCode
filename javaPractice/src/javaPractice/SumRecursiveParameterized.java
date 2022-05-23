package javaPractice;

public class SumRecursiveParameterized {

	void sum(int n, int s) {
		if (n == 0) {
			System.out.print(s);
			return;
		}
		sum(n - 1, s + n);
	}

	public static void main(String[] args) {
		int n = 3;
		int s = 0;
		SumRecursiveParameterized obj = new SumRecursiveParameterized();
		obj.sum(n, s);
	}

}
