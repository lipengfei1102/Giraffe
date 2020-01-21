package controller;

import java.util.List;

import vo.Student;

public interface Controller {
	public void handleAddGesture(Student stu);

	public void handleShowGesture(Student stu) throws Exception;

	public void handleFindByIDGesture(String id)  throws Exception;
	
	public void handleFindByNameGesture(String name) throws Exception;

	public void handleDelGesture(Student stu) throws Exception;

	public void handleModGesture(Student stu) throws Exception;
	
	public Object handleReadGesture() throws Exception;
	
	public void handleSaveGesture(List<Student> it) throws Exception;

	public void handleGetAllStudent();

	
}
