package 里程碑2;

public abstract class person{
	int  age;
	String name,ID;
	person( String ID,String name, int age){
		this.name=name;
		this.age=age;
		this.ID=ID;
	}
	
	public String getID() {
		return ID;
	}
 
	public void setEmpID(String empNo) {
		this.ID = empNo;
	}
 
	public String getName() {
		return name;
	}
 
	public void setName(String Name) {
		this.name = Name;
	}
 
	public int getAge() {
		return age;
	}
 
	public void setAge(int age) {
		this.age = age;
	}
	
}