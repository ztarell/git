using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace WindowsFormsApplication1
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
         //   webBrowser1.Navigate("www.google.com");
         //   axWindowsMediaPlayer1.URL = @"C:\Users\student\Downloads\MontalbanMission.wmv";
        }

        private void exitToolStripMenuItem_Click(object sender, EventArgs e)
        {
            this.Close();
        }

        // ShowDialog displays a form in modal mode
        // modal means you must dismiss the dialog
        // before you can continue using the app
        private void aboutToolStripMenuItem_Click(object sender, EventArgs e)
        {
            new AboutBox1().ShowDialog();
        }

        private void panel1_Paint(object sender, PaintEventArgs e)
        {
            Graphics g = e.Graphics;
            Font fnt = new Font("MonoType Corsiva", 42, FontStyle.Italic);
            g.DrawString("this is a test", fnt, Brushes.Black, 40, 40);

            Pen pen = new Pen(Brushes.CornflowerBlue, 20);
            pen.StartCap = System.Drawing.Drawing2D.LineCap.RoundAnchor;
            pen.EndCap = System.Drawing.Drawing2D.LineCap.ArrowAnchor;
            g.DrawLine(pen, 20, 140, 300, 140);
        }
    }
}
