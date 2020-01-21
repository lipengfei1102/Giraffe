package 里程碑2;



public class Stu extends person {
	double grade;
	Stu(String ID, String name, int age, double grade){
		super(ID,name,age);
		this.grade=grade;
	}
	
	
	public double getGrade() {
		return grade;
	}
 
	public void setGrade(double grade) {
		this.grade= grade;
	}
	
}
