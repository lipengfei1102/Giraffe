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
	/**ע����ͼ���Ա㵱ģ���޸������ݿ��е���Ա��Ϣʱ���Իص���ͼ��ˢ�½��淽��*/  
    public void addChangeListener(InfoSysView iv)throws RemoteException;

	public void fireModelChangeEvent(Student stu);
}
