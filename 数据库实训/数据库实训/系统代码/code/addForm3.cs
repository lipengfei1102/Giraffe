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
    public partial class addForm3 : Form
    {
        public addForm3()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            // SqlConnection conn = new SqlConnection(loginForm.connectionString);
             string connectionString = ConfigurationManager.ConnectionStrings["connect"].ConnectionString;
             SqlConnection conn = new SqlConnection(connectionString);
                    conn.Open();
                    string sql = "select * from 学历信息表 where 员工编号 = " + "'" + form1_textBox1.Text.Trim() + "'";
                    SqlDataAdapter adp = new SqlDataAdapter(sql, conn);
                    DataSet ds = new DataSet();
                    adp.Fill(ds);
                    if (ds.Tables[0].Rows.Count > 0)
                    {
                        MessageBox.Show("已经存在的员工编号！");
                    }

                    else
                    {
                        SqlCommand cmd = new SqlCommand();
                        cmd.Connection = conn;
                       // sql = "insert into 学历信息表 values('" + form1_textBox1.Text.Trim() + "','" + form1_textBox2.Text.Trim() + "','" + form1_textBox3.Text.Trim() + "','" + form1_textBox4.Text.Trim() +  "','" + form1_textBox5.Text.Trim() + "')";
                        if (form1_textBox5.Text != "")
                        {
                            sql = "insert into 学历信息表 values('" + form1_textBox1.Text.Trim() + "','" + form1_textBox2.Text.Trim() + "','" + form1_textBox3.Text.Trim() + "','" + form1_textBox4.Text.Trim() + "','" + form1_textBox5.Text.Trim() + "')";
                        }
                        else if (form1_textBox4.Text != "")
                        {
                            sql = "insert into 学历信息表 values('" + form1_textBox1.Text.Trim() + "','" + form1_textBox2.Text.Trim() + "','" + form1_textBox3.Text.Trim() + "','" + form1_textBox4.Text.Trim() + "')";
                        }
                        else
                        {
                            sql = "insert into 学历信息表 values('" + form1_textBox1.Text.Trim() + "','" + form1_textBox2.Text.Trim() + "','" + form1_textBox3.Text.Trim() + "')";
                        }
                        cmd.CommandText = sql;
                        cmd.ExecuteNonQuery();
                        MessageBox.Show("添加成功！");
                    }
                    conn.Close();
                }

        private void button2_Click(object sender, EventArgs e)
        {
            this.Close();
        }
     
        }
    }

