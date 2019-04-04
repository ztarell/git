using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Proj3
{
    public partial class Form1 : Form
    {
        Image image;
        public Form1()
        {
            InitializeComponent();

            this.ResizeRedraw = true;
        }
        private void aboutToolStripMenuItem_Click(object sender, EventArgs e)
        {
            new AboutBox1().ShowDialog();
        }

        decimal x, y, z;
        private void inputToolStripMenuItem_Click(object sender, EventArgs e)
        {
            InputBox inputBox = new InputBox();
            if (inputBox.ShowDialog() == DialogResult.OK)
            {
                x = Convert.ToDecimal(inputBox.Items[0]);
                y = Convert.ToDecimal(inputBox.Items[1]);
                z = Convert.ToDecimal(inputBox.Items[2]);
                if ( x > 0 && y > 0 && z > 0)
                {
                    MessageBox.Show("Sum: " + (x + y + z), "Results");
                }
                else if (x<0 && y>0 && z>0)
                {
                    MessageBox.Show("2 positives product: " + (y * z), "Results");
                }
                else if (x > 0 && y < 0 && z > 0)
                {
                    MessageBox.Show("2 positives product: " + (x * z), "Results");
                }
                else if (x > 0 && y > 0 && z < 0)
                {
                    MessageBox.Show("2 positives product: " + (x * y), "Results");
                }
                Refresh();

            }
        }

        private void timer1_Tick(object sender, EventArgs e)
        {
            Refresh();
        }

        private void openToolStripMenuItem_Click(object sender, EventArgs e)
        {
            OpenFileDialog ofd = new OpenFileDialog();
            if (ofd.ShowDialog() == DialogResult.OK)
            {
                image = Image.FromFile(ofd.FileName);
                Refresh();
            }
        }

        private void exitToolStripMenuItem_Click(object sender, EventArgs e)
        {
            this.Close();
        }

        float angle;
        protected override void OnPaint(PaintEventArgs e)
        {
            
            base.OnPaint(e);
            Graphics g = e.Graphics;
            if (image != null)
                g.DrawImage(image, 40, 50, ClientSize.Width-40, ClientSize.Height-50);
            Brush br = new SolidBrush(Color.FromArgb(128, Color.Black));
            g.FillRectangle(br, 40, 200, 600, 200);
            
            Font fnt = new Font("MonoType Corsiva", 42);
            g.DrawString("Hot Yoga", fnt, Brushes.White, 40, 240);
            
            g.TranslateTransform(Width / 2, Height / 2);
            g.RotateTransform(angle);
            angle += 5;
            Pen pigPen = new Pen(Color.Blue, 20);
            pigPen.StartCap = System.Drawing.Drawing2D.LineCap.RoundAnchor;
            pigPen.EndCap = System.Drawing.Drawing2D.LineCap.ArrowAnchor;
            g.DrawLine(pigPen, 0, 0, 300, 200);
            g.FillRectangle(Brushes.Black, 20, 20, 100, 100);
        }


    }
}
