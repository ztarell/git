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
using People;
using System.Text.RegularExpressions;

namespace Program6
{
    public partial class Form1 : Form
    {
        /*SalaryEmployee[] employees = {
            new SalaryEmployee("Ram", 60, 24000),
            new SalaryEmployee("Joe", 42, 12000),
            new SalaryEmployee("Sam", 89, 42000),
            new SalaryEmployee("Dave", 24, 2000),
            new SalaryEmployee("Zach", 45, 25000) };*/

        EmployeeList employees = new EmployeeList();
        public Form1()
        {
            InitializeComponent();
            employees.Add(new SalaryEmployee("Ram", 60, 24000));
            employees.Add(new SalaryEmployee("Joe", 42, 12000));
            employees.Add(new SalaryEmployee("Sam", 89, 42000));
            employees.Add(new SalaryEmployee("Dave", 24, 2000));
            employees.Add(new HourlyEmployee("Tina", 45, 17.50m, 50));
        }

        protected override void OnPaint(PaintEventArgs e)
        {
            base.OnPaint(e);
            Graphics g = e.Graphics;
            Font fnt = new Font("MonoType Corsiva", 42.0f);
            g.DrawString("Name", fnt, Brushes.Blue, 20, 20);
            g.DrawString("Age", fnt, Brushes.Blue, 200, 20);
            g.DrawString("Salary", fnt, Brushes.Green, 420, 20);  
            for (int i = 0; i < employees.Length; i++)
            {
                g.DrawString(employees[i].Name, fnt, Brushes.Black, 20, 80 + i * fnt.Height); // employees[i] + "",
                g.DrawString(employees[i].Age + "", fnt, Brushes.Black, 200, 80 + i * fnt.Height);

                //var emp = employees[i] as SalaryEmployee;
                StringFormat sf = new StringFormat();
                sf.Alignment = StringAlignment.Far;
                g.DrawString(String.Format("{0:c0}", employees[i].getIncome()), fnt, Brushes.Black, 560, 80 + i * fnt.Height, sf);
            }
            if (employees.Length >= 0)
            {
                g.DrawString(String.Format("Average:{0:c0}", getAverage()), fnt, Brushes.Black, 70, 80 + employees.Length * fnt.Height);
                g.DrawString(String.Format("Highest:{0:c0}", getHighest()), fnt, Brushes.Black, 70, 150 + employees.Length * fnt.Height);
                g.DrawString(String.Format("Lowest:{0:c0}", getLowest()), fnt, Brushes.Black, 70, 220 + employees.Length * fnt.Height);
            }
            
            
        }

        private void newToolStripMenuItem_Click(object sender, EventArgs e)
        {
            InputBox input = new InputBox();
            if (input.ShowDialog() == DialogResult.OK)
            {
                String s = input.Item;
                // Clears to the new button
                employees.Clear();
                employees.AddRange(s);
                Refresh();  // tells the screen to update itself
            }
        }

        private void nameToolStripMenuItem_Click(object sender, EventArgs e)
        {
            /*
            var q = from emp in employees
                orderby emp.Name
                select emp;
            employees = q.ToArray();*/
            employees.SortByName();
            Refresh();
            
        }

        private void ageToolStripMenuItem_Click(object sender, EventArgs e)
        {
            /*
            var q = from emp in employees
                    orderby emp.Age descending
                    select emp;
            employees = q.ToArray();*/
            employees.SortByAge();
            Refresh();
        }

        private void incomeToolStripMenuItem_Click(object sender, EventArgs e)
        {
            /*
            var q = from emp in employees
                    orderby emp.Salary descending
                    select emp;
            employees = q.ToArray();*/
            employees.SortByIncome();
            Refresh();
        }

        private void exitToolStripMenuItem_Click(object sender, EventArgs e)
        {
            Application.Exit();
        }
        
        private void aboutToolStripMenuItem_Click(object sender, EventArgs e)
        {
            //MessageBox.Show("This Application Collects & Sorts Names, Ages, and Incomes." +
            //    "\nWritten for Program 6 and 7 in Ramiro's C# Class." +
            //    "\n\nCopyright \u00a9 2017\nBy Zach Tarell", "About");
            new AboutBox1().ShowDialog();
        }

        private void addToolStripMenuItem_Click(object sender, EventArgs e)
        {
            InputBox input = new InputBox();
            if (input.ShowDialog() == DialogResult.OK)
            {
                String s = input.Item;
                String[] data = System.Text.RegularExpressions.Regex.Split(s.Trim(), @"\s+");
                for (int i = 0; i < data.Length; i += 3)
                    if (i + 3 < data.Length && Regex.IsMatch(data[i + 3], @"\d+(\.\d*)?"))
                    {
                        employees.Add(new HourlyEmployee(data[i], 
                            Convert.ToInt32(data[i + 1]), 
                            Convert.ToDecimal(data[i + 2]), 
                            Convert.ToDecimal(data[i + 3])));
                        i++;
                    }
                    else 
                        employees.Add(new SalaryEmployee(data[i], 
                            Convert.ToInt32(data[i + 1]), 
                            Convert.ToDecimal(data[i + 2])));
                Refresh(); 
            }
        }

        private void openToolStripMenuItem_Click(object sender, EventArgs e)
        {
            OpenFileDialog ofd = new OpenFileDialog();
            if (ofd.ShowDialog()==DialogResult.OK)
            {
                StreamReader sr = new StreamReader(ofd.FileName);
                fileName = ofd.FileName;
                String s = sr.ReadToEnd();
                sr.Close();
                // Clears to the new button
                employees.Clear();
                employees.AddRange(s);
                Refresh();
            }
        }

        private void saveAsToolStripMenuItem_Click(object sender, EventArgs e)
        {
            SaveFileDialog sfd = new SaveFileDialog();
            if (sfd.ShowDialog() == DialogResult.OK)
            {
                StreamWriter sw = new StreamWriter(sfd.FileName);
                sw.Write(employees.ToString());
                sw.Close();
            }
        }
        String fileName;
        private void saveToolStripMenuItem_Click(object sender, EventArgs e)
        {
            if (fileName==null)
            {
                SaveFileDialog sfd = new SaveFileDialog();
                if (sfd.ShowDialog() == DialogResult.OK)
                {
                    fileName = sfd.FileName;
                }
                else return;
            }
            StreamWriter sw = new StreamWriter(fileName);
            sw.Write(employees.ToString());
            sw.Close();
        }

        decimal getAverage()
        {
            decimal total = 0;
            for (int i = 0; i < employees.Length; i++)
                total += employees[i].getIncome();
            return total / employees.Length;
        }

        decimal getHighest()
        {
            decimal high = employees[0].getIncome();
            for (int i = 1; i < employees.Length; i++)
                if (employees[i].getIncome() > high)
                    high = employees[i].getIncome();
            return high;
        }

        decimal getLowest()
        {
            decimal low = employees[0].getIncome();
            for (int i = 0; i < employees.Length; i++)
                if (employees[i].getIncome() < low)
                    low = employees[i].getIncome();
            return low;
        }
    }
}
