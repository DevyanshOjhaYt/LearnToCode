package designPatternInJava;

public class OSFactory {

	public OS getInstance(String str) {
		if (str.equals("Android"))
			return new Android();
		else if (str.equals("IOS"))
			return new Ios();

		else
			return new Ios(); // just default added

	}

}
