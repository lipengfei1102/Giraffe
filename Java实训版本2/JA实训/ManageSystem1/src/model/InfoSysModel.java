package model;
import java.rmi.RemoteException;
import java.util.List;
import java.util.Set;

import InfoSys.InfoSysException;
import view.InfoSysView;
import vo.*;

public interface InfoSysModel {
	public void add(Student stu) throws InfoSysException,Exception;

	public void show(Student stu) throws InfoSysException,Exception;

	public Student findByID(String id)  throws InfoSysException,Exception;
	
	public Student findByName(String name) throws InfoSysException,Exception;

	public void del(Student stu) throws InfoSysException,Exception;

	public void update(Student stu) throws InfoSysException,Exception;
	
	public Object read() throws InfoSysException,Exception;
	
	public void save(List<Student> it) throws InfoSysException,Exception;
  
    public  Set<Student> getAllStudent()throws InfoSysException,Exception;
	/**注册视图，以便当模型修改了数据库中的人员信息时可以回调视图的刷新界面方法*/  
    public void addChangeListener(InfoSysView iv)throws RemoteException;

	public void fireModelChangeEvent(Student stu);
}
