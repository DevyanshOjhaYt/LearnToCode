import designPatternInJava.OS;
import designPatternInJava.OSFactory;

public class FactoryMain {

	public static void main(String[] args) {
		OSFactory osj = new OSFactory();
        OS obj=osj.getInstance("Android");
        obj.specs();
	}
}
