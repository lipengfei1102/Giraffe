package view;

import java.rmi.Remote;
import java.rmi.RemoteException;

import InfoSys.InfoSysException;
import controller.Controller;
import vo.Student;

public interface InfoSysView extends Remote  
{  
    /**注册处理用户动作的监听器*/  
    public void addUserGestureListener(Controller ctrl)throws InfoSysException,RemoteException;  
    /**在图形界面上显示数据，参数display指定显示的数据*/  
    public  void showDisplay(Object display)throws InfoSysException,RemoteException ;
    public void handleStudentChange(Student cust)throws InfoSysException,RemoteException;
}  