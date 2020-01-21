package vo;

public abstract class Person {
	private String ID;
	private String name;
	protected int age;
	public Person(String ID,String name,int age){
		this.name=name;
		this.age=age;
		this.ID=ID;
	}
	  public Person(String id) {
		this.ID  = id;
	  }
	  public void putID(String ID){
		  this.ID=ID;
	  }
	  public void putName(String name){
		  this.name=name;
	  }
	  public void putAge(int age){
			this.age=age;
		}
	  public String getName(){
			return name;
		}
	  public String getID(){
			return ID;
		}
	  public int getAge(){
			return age;
		}
}
