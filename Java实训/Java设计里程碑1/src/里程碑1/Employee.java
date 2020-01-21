package 里程碑1;
public class Employee extends Person{
	String job;
	float salary;
	Employee(String name, int age, int ID, String job, float salary){
		super(name, age, ID);
		this.job=job;
		this.salary=salary;
	}
	void set(String name, int age, int ID, String job, float salary){
		this.name=name;
		this.age=age;
		this.ID=ID;
		this.job=job;
		this.salary=salary;
	}
	void print(){
		System.out.println("������"+name+" ����:"+age+" ID:"+ID+" ����:"+job+" ����:"+salary);
	}
	boolean search(int id) {
		boolean f=false;
		if(ID==id) f=true;
		return f;
	}
}