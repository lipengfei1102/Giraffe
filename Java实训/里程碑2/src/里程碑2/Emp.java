package 里程碑2;


public class Emp extends person{
	
	private double empsal;
	private String job;
	
	public Emp(String ID,String name,int age,String job,double empsal) {
		super(ID,name,age);
		this.empsal=empsal;
		this.job=job;
	}
	

	public double getEmpsal() {
		return empsal;
	}
 
	public void setEmpsal(double empsal) {
		this.empsal = empsal;
	}
	
	
	
	public String getJob() {
		return job;
	}
 
	public void setJobl(String job) {
		this.job=job;
	}
	
	
 
}

