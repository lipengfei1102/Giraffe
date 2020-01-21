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
    public partial class MainForm : Form
    {
        public MainForm()
        {
            InitializeComponent();
        }

      

        private void Form1_Load(object sender, EventArgs e)
        {
            //loginForm login = new loginForm();
            //login.ShowDialog();
        }

        private void panel2_Paint(object sender, PaintEventArgs e)
        {

        }

        private void form_close(object sender, FormClosedEventArgs e)
        {
            Application.Exit();
        }

        private void 添加ToolStripMenuItem1_Click(object sender, EventArgs e)
        {

            addForm1 f3 = new addForm1();
            f3.TopLevel = false;
            f3.FormBorderStyle = FormBorderStyle.None;
            f3.WindowState = FormWindowState.Maximized;

            panel2.Controls.Add(f3);
            f3.Show();
        }

        private void 查询ToolStripMenuItem1_Click(object sender, EventArgs e)
        {
            modForm1 f = new modForm1();
            f.TopLevel = false;
            f.FormBorderStyle = FormBorderStyle.None;
            f.WindowState = FormWindowState.Maximized;

            panel2.Controls.Add(f);
            f.Show();
        }

        private void 添加ToolStripMenuItem2_Click(object sender, EventArgs e)
        {
            addForm2 f3 = new addForm2();
            f3.TopLevel = false;
            f3.FormBorderStyle = FormBorderStyle.None;
            f3.WindowState = FormWindowState.Maximized;

            panel2.Controls.Add(f3);
            f3.Show();
        }

        private void 查询ToolStripMenuItem2_Click(object sender, EventArgs e)
        {
            modForm2 f = new modForm2();
            f.TopLevel = false;
            f.FormBorderStyle = FormBorderStyle.None;
            f.WindowState = FormWindowState.Maximized;

            panel2.Controls.Add(f);
            f.Show();
        }

        private void 添加ToolStripMenuItem3_Click(object sender, EventArgs e)
        {
            addForm3 f3 = new addForm3();
            f3.TopLevel = false;
            f3.FormBorderStyle = FormBorderStyle.None;
            f3.WindowState = FormWindowState.Maximized;

            panel2.Controls.Add(f3);
            f3.Show();
        }

        private void 查询ToolStripMenuItem3_Click(object sender, EventArgs e)
        {
            modForm3 f = new modForm3();
            f.TopLevel = false;
            f.FormBorderStyle = FormBorderStyle.None;
            f.WindowState = FormWindowState.Maximized;

            panel2.Controls.Add(f);
            f.Show();
        }

        private void 添加ToolStripMenuItem4_Click(object sender, EventArgs e)
        {
            addForm4 f3 = new addForm4();
            f3.TopLevel = false;
            f3.FormBorderStyle = FormBorderStyle.None;
            f3.WindowState = FormWindowState.Maximized;

            panel2.Controls.Add(f3);
            f3.Show();
        }

        private void 查询ToolStripMenuItem4_Click(object sender, EventArgs e)
        {
            modForm4 f = new modForm4();
            f.TopLevel = false;
            f.FormBorderStyle = FormBorderStyle.None;
            f.WindowState = FormWindowState.Maximized;

            panel2.Controls.Add(f);
            f.Show();
        }

        private void 添加ToolStripMenuItem5_Click(object sender, EventArgs e)
        {
            addForm5 f3 = new addForm5();
            f3.TopLevel = false;
            f3.FormBorderStyle = FormBorderStyle.None;
            f3.WindowState = FormWindowState.Maximized;

            panel2.Controls.Add(f3);
            f3.Show();
        }

        private void 查询ToolStripMenuItem5_Click(object sender, EventArgs e)
        {
            modForm5 f = new modForm5();
            f.TopLevel = false;
            f.FormBorderStyle = FormBorderStyle.None;
            f.WindowState = FormWindowState.Maximized;

            panel2.Controls.Add(f);
            f.Show();
        }

      




          

   


    


      


       

       
    }
}
