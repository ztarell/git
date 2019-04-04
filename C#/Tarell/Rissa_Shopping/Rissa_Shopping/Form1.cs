using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Rissa_Shopping
{
    public partial class Form1 : Form
    {
        decimal x, y;

        public Form1()
        {
            InitializeComponent();
            webBrowser1.Navigate("www.amazon.com");
        }

        private void exitToolStripMenuItem_Click(object sender, EventArgs e)
        {
            this.Close();
        }
        //public static decimal getCalc(decimal a, decimal b)
        //{

        //    return a - b;
        //}

        private void copyToolStripMenuItem_Click(object sender, EventArgs e)
        {
            MessageBox.Show("Copyright \u00a9 2017 - Zach Tarell", "About");
        }

        private void button1_Click(object sender, EventArgs e)
        {
            x = Convert.ToDecimal(textBox2.Text);
            y = Convert.ToDecimal(textBox3.Text);
            Refresh();
            
        }

        private void tabPage2_Paint(object sender, PaintEventArgs e)
        {
           
            Graphics g = e.Graphics;
            String text = "Baby! You spent $" + y + " today?! WTF\nNow we only have $" + (x - y) + " in our account!\nOur lives are over!!";
            g.DrawString(text, Font, Brushes.Red, 40, 500);
            
        }

        private void button2_Click(object sender, EventArgs e)
        {

            this.Close();
            
        }

        private void openToolStripMenuItem_Click(object sender, EventArgs e)
        {
            OpenFileDialog ofd = new OpenFileDialog();
            if (ofd.ShowDialog() == DialogResult.OK)
            {
                System.IO.StreamReader sr = new System.IO.StreamReader(ofd.FileName);
                String t = sr.ReadToEnd();
                sr.Close();
                textBox1.Text = t;
            }
            else
            {
                String s = "No File Selected";
                textBox1.Text = s;
            }
        }
    }
}
