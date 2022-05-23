package javaPractice;

public class Student {

	private int rollNo;
	private String sname;
	public int getRollNo() {
		return rollNo;
	}
	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	@Override
	public String toString() {
		return "Student [rollNo=" + rollNo + ", sname=" + sname + "]";
	}
	
}
