package 里程碑1;
public class student extends Person{
	float score;
	student(String name, int age, int ID, float score){
		super(name, age, ID);
		this.score=score;
	}
	void set(String name, int age, int ID, float score){
		this.name=name;
		this.age=age;
		this.ID=ID;
		this.score=score;
	}
	void print(){
		System.out.println("姓名"+name+" 年龄:"+age+" ID:"+ID+" 分数:"+score);
	}
	boolean search(int id) {
		boolean f=false;
		if(ID==id) f=true;
		return f;
	}
}