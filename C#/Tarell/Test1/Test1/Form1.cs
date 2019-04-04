using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Test1
{
    public partial class Form1 : Form
    {
        decimal x, y;
        public Form1()
        {
            InitializeComponent();
            webBrowser1.Navigate("www.google.com");
        }
        //public static decimal getSum ()
        //{
        //    decimal sum = 0;
        //   // decimal x = Convert.ToDecimal(textBox1.Text);
        //   // decimal y = Convert.ToDecimal(textBox2.Text);
        //    sum = x + y;
        //    return Convert.ToDecimal(sum);
        //}

        private void exitToolStripMenuItem_Click(object sender, EventArgs e)
        {
            this.Close();
        }

        private void aboutToolStripMenuItem_Click(object sender, EventArgs e)
        {
            MessageBox.Show("Copyright \u00a9 2017 - Zach Tarell", "About");
        }

        private void tabPage1_Paint(object sender, PaintEventArgs e)
        {

            
            Graphics g = e.Graphics;
            String text = "Sum: " + (x+y);
            g.DrawString(text, Font, Brushes.Black, 40, 200);
        }

        private void openToolStripMenuItem_Click(object sender, EventArgs e)
        {
            OpenFileDialog ofd = new OpenFileDialog();
            if (ofd.ShowDialog()==DialogResult.OK)
            {
                System.IO.StreamReader sr = new System.IO.StreamReader(ofd.FileName);
                String t = sr.ReadToEnd();
                sr.Close();
                textBox3.Text = t;
            }
            else
            {
                String s = "No File Selected";
                textBox3.Text = s;
            }
        }

        private void button1_Click(object sender, EventArgs e)
        {

            x = Convert.ToDecimal(textBox1.Text);
            y = Convert.ToDecimal(textBox2.Text);
            Refresh();

           
            
        }
    }
}
