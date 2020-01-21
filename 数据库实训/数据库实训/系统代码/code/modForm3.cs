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
    public partial class modForm3 : Form
    {
        public modForm3()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            while (dataGridView1.Rows.Count != 0)
            {
                dataGridView1.DataSource = null;
            }
            if (textBox1.Text == "" && textBox2.Text == "")
            {
                //SqlConnection conn = new SqlConnection(loginForm.connectionString);
                string connectionString = ConfigurationManager.ConnectionStrings["connect"].ConnectionString;
                SqlConnection conn = new SqlConnection(connectionString);
                conn.Open();
                string sql = "select * from 学历信息表 ";
                SqlDataAdapter adp1 = new SqlDataAdapter(sql, conn);
                DataSet ds = new DataSet();
                adp1.Fill(ds);
                //载入基本信息
                dataGridView1.DataSource = ds.Tables[0].DefaultView;
                conn.Close();
            }
            else if (textBox1.Text != "" && textBox2.Text == "")
            {
                //SqlConnection conn = new SqlConnection(loginForm.connectionString);
                string connectionString = ConfigurationManager.ConnectionStrings["connect"].ConnectionString;
                SqlConnection conn = new SqlConnection(connectionString);
                conn.Open();
                string sql = "select * from 学历信息表 where 员工编号 = '" + textBox1.Text.ToString() + "'";
                SqlDataAdapter adp1 = new SqlDataAdapter(sql, conn);
                DataSet ds = new DataSet();
                adp1.Fill(ds);
                //载入基本信息
                dataGridView1.DataSource = ds.Tables[0].DefaultView;
                conn.Close();
            }
            else if (textBox2.Text != "" && textBox1.Text == "")
            {

                string connectionString = ConfigurationManager.ConnectionStrings["connect"].ConnectionString;
                SqlConnection conn = new SqlConnection(connectionString);
                conn.Open();
                //textBox1.Text.Trim()  textBox2.Text.Trim()
                string sql = "select * from 学历信息表 where 学历 = '" + textBox2.Text.ToString() + "'";
                SqlDataAdapter adp1 = new SqlDataAdapter(sql, conn);
                DataSet ds = new DataSet();
                adp1.Fill(ds);
                //载入基本信息
                dataGridView1.DataSource = ds.Tables[0].DefaultView;
                conn.Close();


            }
            else if (textBox2.Text != "" && textBox1.Text != "")
            {

                string connectionString = ConfigurationManager.ConnectionStrings["connect"].ConnectionString;
                SqlConnection conn = new SqlConnection(connectionString);
                conn.Open();
                //textBox1.Text.Trim()  textBox2.Text.Trim()
                string sql = "select * from 学历信息表 where 员工编号 = '" + textBox1.Text.ToString() + "' and 学历 = '" + textBox2.Text.ToString() + "'";
                SqlDataAdapter adp1 = new SqlDataAdapter(sql, conn);
                DataSet ds = new DataSet();
                adp1.Fill(ds);
                //载入基本信息
                dataGridView1.DataSource = ds.Tables[0].DefaultView;
                conn.Close();

            }
        }
    
        private void dataGridView1_RowHeaderMouseClick(object sender, DataGridViewCellMouseEventArgs e)
        {
            textBoxmod1.Text = dataGridView1.SelectedRows[0].Cells[0].Value.ToString();
            textBoxmod2.Text = dataGridView1.SelectedRows[0].Cells[1].Value.ToString();
            textBoxmod3.Text = dataGridView1.SelectedRows[0].Cells[2].Value.ToString();
            textBoxmod4.Text = dataGridView1.SelectedRows[0].Cells[3].Value.ToString();
            
        }

        private void dataGridView1_CellContentClick(object sender, DataGridViewCellEventArgs e)
        {

        }

        private void button3_Click(object sender, EventArgs e)
        {
          
            string connectionString = ConfigurationManager.ConnectionStrings["connect"].ConnectionString;
            SqlConnection conn = new SqlConnection(connectionString);
            conn.Open();
            string sql = "update 学历信息表 set 学历 =  " + "'" + textBoxmod2.Text + "'" + " ,毕业学校 = " + "'" + textBoxmod3.Text + "'" + " ,毕业时间 = " + "'" + textBoxmod4.Text + "'" + " where 员工编号 =" + "'" + textBoxmod1.Text + "'";
            SqlCommand cmd = new SqlCommand(sql, conn);
            cmd.CommandText = sql;
            if (cmd.ExecuteNonQuery() > 0)
            {
                MessageBox.Show("更改成功！");
            }
            conn.Close();
        }

        private void button2_Click(object sender, EventArgs e)
        {
            //this.Close();
            string connectionString = ConfigurationManager.ConnectionStrings["connect"].ConnectionString;
            SqlConnection conn = new SqlConnection(connectionString);
            conn.Open();
            string sql = "delete from  学历信息表 where 员工编号 =" + "'" + textBoxmod1.Text + "'";
            SqlCommand cmd = new SqlCommand(sql, conn);
            cmd.CommandText = sql;
            if (cmd.ExecuteNonQuery() > 0)
            {
                MessageBox.Show("删除成功！");
            }
            conn.Close();
        }

    
    }
}
