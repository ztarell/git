using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.IO;

namespace Program5
{
    public partial class Form1 : Form
    {
        decimal[] incomes = { 1000, 2000, 5000, 5200 };    // it's an array
        
        public Form1()
        {
            InitializeComponent();

        }

        decimal getAverage()
        {
            decimal total = 0;

            for (int i = 0; i < incomes.Length; i++)
            {
                total += incomes[i];
            }
            
            return total / incomes.Length;
        }

        decimal getHighest()
        {
            decimal high = incomes[0];
            for (int i = 1; i < incomes.Length; i++)
                if (incomes[i] > high)
                    high = incomes[i];
            return high;
        }

        decimal getLowest()
        {
            decimal low = incomes[0];
            for (int i = 0; i < incomes.Length; i++)
                if (incomes[i] < low)
                    low = incomes[i];
            return low;
        }


        protected override void OnPaint(PaintEventArgs e)
        {
            base.OnPaint(e);
            System.Drawing.Drawing2D.LinearGradientBrush lgb = new System.Drawing.Drawing2D.LinearGradientBrush(new Point(0, 0), new Point(0, 150), Color.White, Color.FromArgb(192, 192, 255)); // lgb is the new linear gradient

            Font fnt = new Font("MonoType Corsiva", 60);
            Graphics g = e.Graphics;

            lgb.WrapMode = System.Drawing.Drawing2D.WrapMode.TileFlipXY;   // Shows where the gradient makes go back up where it came from
            g.FillRectangle(lgb, 0, 0, Width, Height);             // Width and Height covers the WHOLE thing
            g.DrawString("Incomes:", fnt, Brushes.Black, 70, 100);

            StringFormat sf = new StringFormat();
            sf.Alignment = StringAlignment.Far;
            

            for (int i = 0; i < incomes.Length; i++)
            {
                g.DrawString(String.Format("{0:c0}", incomes[i]), fnt, Brushes.Black, 330, 180 + i * fnt.Height, sf);
            }
            if (incomes.Length > 0)
            {
                g.DrawString(String.Format("Average:{0:c0}", getAverage()), fnt, Brushes.Black, 70, 180 + incomes.Length * fnt.Height);
                g.DrawString(String.Format("Highest:{0:c0}", getHighest()), fnt, Brushes.Black, 70, 250 + incomes.Length * fnt.Height);
                g.DrawString(String.Format("Lowest:{0:c0}", getLowest()), fnt, Brushes.Black, 70, 320 + incomes.Length * fnt.Height);
            }
        }

        private void Form1_Load(object sender, EventArgs e)
        {

        }

        private void processIncomes(String text)
        {
            String[] data = System.Text.RegularExpressions.Regex.Split(text.Trim(), @"\s+");
            incomes = new Decimal[data.Length];
            for (int i = 0; i < data.Length; i++)
            {
                incomes[i] = Convert.ToDecimal(data[i]);
            }
            Refresh();

        }

        private void button1_Click(object sender, EventArgs e)
        {
            processIncomes(textBox1.Text);
            
        }

        private void ascendingToolStripMenuItem_Click(object sender, EventArgs e)
        {
            //var query = from x in incomes
            //            orderby x
            //            select x;
            //incomes = query.ToArray();
            //System.Array.Sort(incomes);                   // Default Sort is Ascending

            for (int i = 0; i < incomes.Length - 1; i++)      // sort Ascending with code
                for (int j = 0; j < incomes.Length - 1; j++)      
                    if (incomes[j+1] < incomes[j])            // [j+1] is the incomes[] that comes after the one before it
                    {
                        decimal temp = incomes[j + 1];           // temporary hold while sorting
                        incomes[j + 1] = incomes[j];
                        incomes[j] = temp;
                    }

            Refresh();
        }

        private void descendingToolStripMenuItem_Click(object sender, EventArgs e)
        {
            //var query = from x in incomes
            //            orderby x descending
            //            select x;
            //incomes = query.ToArray();

            //System.Array.Sort(incomes);
            //System.Array.Reverse(incomes);                // Reverse is Descending

            for (int i = 0; i < incomes.Length - 1; i++)      // sort Descending with code
                for (int j = 0; j < incomes.Length - 1; j++)
                    if (incomes[j + 1] > incomes[j])            // [j+1] is the incomes[] that comes after the one before it and switch the < to > for descending
                    {
                        decimal temp = incomes[j + 1];          // temporary hold while sorting
                        incomes[j + 1] = incomes[j];
                        incomes[j] = temp;
                    }

            Refresh();
        }

        private void openToolStripMenuItem_Click(object sender, EventArgs e)
        {
            OpenFileDialog ofd = new OpenFileDialog();
            if (ofd.ShowDialog() == DialogResult.OK)       // can be Show or ShowDialog
            {
                StreamReader sr = new StreamReader(ofd.FileName);      // class that reads stream
                String s = sr.ReadToEnd();
                sr.Close();
                processIncomes(s);




            }
        }

        private void exitToolStripMenuItem_Click(object sender, EventArgs e)
        {
            this.Close();
        }
    }
}
