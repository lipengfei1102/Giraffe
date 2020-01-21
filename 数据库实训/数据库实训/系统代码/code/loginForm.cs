using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using System.Data.SqlClient;
using System.Configuration;
namespace test1
{
    public partial class loginForm : Form
    {
       // public static string connectionString = "uid=sa;pwd=123456;initial catalog=student;data source=127.0.0.1;Connect Timeout=900";
        public static string connectionString = "Persist Security Info=False;Integrated Security=SSPI;database=student;server=JACK-PC";
        public static  string name;
        public static string role;
       
        public loginForm()
        {
            

            InitializeComponent();

        }

        private void button1_Click(object sender, EventArgs e)
        {
          

            if (name == "" || textBoxpasswd.Text.Trim() == "" || this.comboBoxrole.SelectedItem.ToString() == "")
            {
                MessageBox.Show("请将信息输入完整");
            }
            else
            {
                name = textBoxname.Text.Trim();
                role = this.comboBoxrole.SelectedItem.ToString();
                string connectionString = ConfigurationManager.ConnectionStrings["connect"].ConnectionString;
                SqlConnection conn = new SqlConnection(connectionString);
                conn.Open();
                string sql = "";
                if(role == "用户")
                {
                     sql = "select * from 用户信息表 where 用户名 = '" + textBoxname.Text + "'" + "and 用户密码 = '" + textBoxpasswd.Text + "'" ;
                }
                else if(role == "管理员")
                {
                    sql = "select * from 管理员信息表 where 管理员姓名 = '" + textBoxname.Text + "'" + "and 管理员密码 = '" + textBoxpasswd.Text + "'";
                }
                
                //SqlDataAdapter adp = new SqlDataAdapter(sql, conn);
                //DataSet ds = new DataSet();
                //adp.Fill(ds);
               // if (ds.Tables[0].Rows.Count > 0)
                {

                    MainForm mainframe = new MainForm();
                    mainframe.BringToFront();
                    mainframe.Show();
                    this.Hide();
                }
                //else
                //{
                //    MessageBox.Show("用户名或密码错误！");
                //}
                conn.Close();       
                   
               
            }   

        }






        private void textBox1_TextChanged(object sender, EventArgs e)
        {

        }

        private void button2_Click(object sender, EventArgs e)
        {
            Application.Exit();
        }


        private void loginForm_Load(object sender, EventArgs e)
        {
           
            
        }

        private void comboBoxrole_SelectedIndexChanged(object sender, EventArgs e)
        {

        }

        public static  String getStudent()
        {
            String stuxuehao = "";
            stuxuehao = loginForm.name;
            return stuxuehao;
        }

        public static String getRole()
        {
            String role1 = "";
            role1 = role;
            return role1;
        }

        private void splitContainer1_Panel1_Paint(object sender, PaintEventArgs e)
        {

        }

        private void splitContainer1_Panel1_MouseClick(object sender, MouseEventArgs e)
        {

        }

        private void splitContainer1_SplitterMoved(object sender, SplitterEventArgs e)
        {

        }

        private void button2_Click_1(object sender, EventArgs e)
        {
            this.Close();
        }

        private void groupBox1_Enter(object sender, EventArgs e)
        {

        }

     

       

       


      

       
       


    }
}
