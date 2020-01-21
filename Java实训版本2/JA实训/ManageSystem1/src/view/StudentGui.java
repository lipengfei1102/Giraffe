package view;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import vo.Student;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.Set;
public class StudentGui extends JFrame   {
	//界面的主要窗体组件 
	protected JFrame frame;
	protected Container contentPane;
	protected CardLayout card = new CardLayout();
	protected JPanel cardPan = new JPanel();
	
	//包含各种按钮的选择面板上的组件
	protected JPanel selPan = new JPanel();
	protected JButton stuBt = new JButton("学生详细信息");
	protected JButton allStuBt = new JButton("所有学生清单");
	
	//显示单个学生的面板上的组件
	protected JPanel stuPan=new JPanel(); 
	protected JLabel idLb=new JLabel("ID");
	protected JLabel nameLb=new JLabel("学生姓名");
	protected JLabel ageLb=new JLabel("学生年龄");
	protected JLabel GradeLb=new JLabel("学生成绩");
	
	 public static JTextField idTf=new JTextField(25);
	 public static JTextField nameTf=new JTextField(25);
	 public static JTextField ageTf=new JTextField(25);
	 public static JTextField GradeTf=new JTextField(25);
	
	 protected JButton addBt=new JButton("添加学生");
	 protected JButton delBt=new JButton("删除学生");
	 protected JButton findByIDBt=new JButton("按ID查找学生");
	 protected JButton findByNameBt=new JButton("按姓名关键字查找学生");
	 protected JButton modBt=new JButton("修改学生信息");
	 protected JButton showBt=new JButton("更新信息");
	 
	 //列举所有学生的面板上的组件
	 protected JPanel allStuPan=new JPanel();
	 protected JLabel allStuLb=new JLabel("所有学生清单 ",SwingConstants.CENTER);
	 protected JTextArea allStuTa=new JTextArea();
	 protected JScrollPane allStuSp=new JScrollPane(allStuTa);
	 //table头  
	 String[] tableHeaders={"ID","姓名","年龄","成绩"}; 
	 JTable table;
	 JScrollPane tablePane; 
	 DefaultTableModel tableModel; 
	 /** 构造方法 */ 
	  public StudentGui(){ 
	    buildDisplay(); 
	  } 
	//日志面板上的组件
	 protected JPanel logPan=new JPanel();
	 protected JLabel logLb=new JLabel("操作日志 ",SwingConstants.CENTER);
	 protected static JTextArea logTa=new JTextArea(9,50); 
	 protected JScrollPane logSp=new JScrollPane(logTa); 
	 
	 /** 显示单个学生面板 StuPan */ 
	 public void refreshStuPan(Student stu){ 
		    showCard("student"); 
		    int index = table.getSelectedRow();   //获取选中行
		    stu.putID(table.getValueAt(index,0).toString());
		    stu.putName(table.getValueAt(index,1).toString());
		    stu.putAge(Integer.parseInt((String)table.getValueAt(index,2)));
		    stu.putGrade(Float.parseFloat((String)table.getValueAt(index,3)));
		    if(stu==null || stu.getID().equals(-1)){ 
		      idTf.setText(null); 
		      nameTf.setText(null); 
		      ageTf.setText(null); 
		      GradeTf.setText(null); 
		      return; 
		    } 
		    idTf.setText(stu.getID()); 
		    nameTf.setText(stu.getName().trim()); 
		    ageTf.setText(String.valueOf(stu.getAge())); 
		    GradeTf.setText(String.valueOf(stu.getGrade())); 
		  } 
	 
	 /** 显示所有客户面板 allStuPan */ 
	  public void refreshAllStuPan(Set stus){ 
	    showCard("allstudents"); 
	    
	    String newData[][]; 
	    newData=new String[stus.size()][4]; 
	    Iterator it=stus.iterator(); 
	    int i=0;  
	    while(it.hasNext()){ 
	      Student stu=(Student) it.next(); 
	      newData[i][0]=stu.getID(); 
	      newData[i][1]=stu.getName(); 
	      newData[i][2]=String.valueOf(stu.getAge()); 
	      newData[i][3]=String.valueOf(stu.getGrade());
	      i++;  
	    } 
	    tableModel.setDataVector(newData,tableHeaders); 
	  } 
	  
	  /** 在日志面板 log Pan 中添加日志信息 */ 
	  public static void updateLog(String msg){ 
	    logTa.append(msg+"\n"); 
	  } 
	  
	  /** 获得学生面板 stuPan 上用户输入的 ID */ 
	  public String getStuIdOnStuPan(){ 
		    try{ 
		        return idTf.getText().trim(); 
		      }catch(Exception e){ 
		        updateLog(e.getMessage()); 
		        return null; 
		      } 
		   } 
	  
	 
	 /** 显示单个客户面板 stuPan 或者所有客户面板 allStuPan */ 
	  void showCard(String cardStr){ 
		
	    card.show(cardPan,cardStr); 
	    allStuPan.setVisible(true);
	  } 
	  
	 
	  
	  /** 创建图形界面 */ 
	  private void buildDisplay(){ 
	   //frame=new JFrame("学生信息管理系统"); 
	   setTitle("学生信息管理系统");
	   buildSelectionPanel(); 
	   buildStuPanel(); 
	   buildAllStuPanel(); 
	   buildLogPanel(); 

	   /** carPan 采用 CardLayout 布局管理器，包括 stuPan 和
	   allStuPan 两张卡片 */ 
      cardPan.setLayout(card); 
      cardPan.add(stuPan,"student"); 
      cardPan.add(allStuPan,"allstudents"); 
      //向主窗体中加入各种面板 
      
      this.setLayout(new BorderLayout()); 
      add(cardPan,BorderLayout.CENTER); 
      add(selPan,BorderLayout.NORTH); 
      add(logPan,BorderLayout.SOUTH); 
      this.pack(); 
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
      this.setVisible(true);
     
	  }   
	  //获得单个人员面板上用户输入的人员信息  
	    public Student getStudentOnStuPanel()  
	    {  
	        try  
	        {  
	            String custid=idTf.getText().trim();  
	            String cid = custid.equals("")?"0":custid;  
	            return new Student(cid,
	            		nameTf.getText(),
	            		Integer.parseInt(ageTf.getText().trim()),
	            		Float.parseFloat(GradeTf.getText()));
	        }catch(Exception e)  
	        {  
	            updateLog(e.getMessage());  
	            return null;  
	        }  
	    }  
	  /** 创建选择面板 selPan */  
	  private void buildSelectionPanel(){
		  selPan.add(stuBt);  
	      selPan.add(allStuBt);  
	  } 
	  
	  /** 为选择面板 selPan 中的两个按钮注册监听器 */ 
	  public void addSelectionPanelListeners(ActionListener a[]){ 
	   int len=a.length; 
	   if(len!=2){ return;} 
	   stuBt.addActionListener(a[0]); 
	   allStuBt.addActionListener(a[1]); 
	  } 
	  public static void main(String[]args)  
	    {  
	        new StudentGui().setVisible(true);;  
	          
	    }  
	  /**  创建单个客户stuPan 面板 */ 
	  private void buildStuPanel(){
	  	stuPan.setLayout(new GridLayout(7,2,2,2));  
	  	stuPan.add(idLb);  
	  	stuPan.add(idTf);  
	  	stuPan.add(nameLb);  
	  	stuPan.add(nameTf);  
	  	stuPan.add(ageLb);  
	  	stuPan.add(ageTf);  
	  	stuPan.add(GradeLb);  
	  	stuPan.add(GradeTf);  
	  	stuPan.add(addBt);  
	  	stuPan.add(delBt);  
	  	stuPan.add(findByIDBt);  
	  	stuPan.add(findByNameBt); 
	  	stuPan.add(modBt);  
	  	stuPan.add(showBt); 
	  } 
	   
	  /** 为单个客户面板 stuPan 中的6 个按钮注册监听器 */ 
	  public void addStuPanelListeners(ActionListener a[]){ 
	   addBt.addActionListener(a[0]); 
	   delBt.addActionListener(a[1]); 
	   findByIDBt.addActionListener(a[2]); 
	   findByNameBt.addActionListener(a[3]); 
	   modBt.addActionListener(a[4]); 
	   showBt.addActionListener(a[5]); 
	  } 
	  
	  /** 创建所有学生 allStuPan 面板 */ 
	  private void buildAllStuPanel(){ 
	    allStuPan.setLayout(new BorderLayout()); 
	    allStuPan.add(allStuLb,BorderLayout.NORTH);
	    allStuTa.setText("all student display"); 
	    tableModel=new DefaultTableModel(tableHeaders,10); 
	    table=new JTable(tableModel); 
	    tablePane=new JScrollPane(table); 
	    allStuPan.add(tablePane,BorderLayout.CENTER); 
	    Dimension dim=new Dimension(500,150); 
	    table.setPreferredScrollableViewportSize(dim); //设置此表视口的首选大小。
	  } 
	   
	  /** 创建日志面板*/ 
	  private void buildLogPanel(){
		logPan.setLayout(new BorderLayout());  
        logSp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);  
        logSp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);  
        logPan.add(logLb,BorderLayout.NORTH);  
        this.logPan.add(logSp,BorderLayout.CENTER);  } 
	
  

}
