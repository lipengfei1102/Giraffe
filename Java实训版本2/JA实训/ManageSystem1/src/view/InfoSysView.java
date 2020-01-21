package view;

import java.rmi.Remote;
import java.rmi.RemoteException;

import InfoSys.InfoSysException;
import controller.Controller;
import vo.Student;

public interface InfoSysView extends Remote  
{  
    /**ע�ᴦ���û������ļ�����*/  
    public void addUserGestureListener(Controller ctrl)throws InfoSysException,RemoteException;  
    /**��ͼ�ν�������ʾ���ݣ�����displayָ����ʾ������*/  
    public  void showDisplay(Object display)throws InfoSysException,RemoteException ;
    public void handleStudentChange(Student cust)throws InfoSysException,RemoteException;
}  