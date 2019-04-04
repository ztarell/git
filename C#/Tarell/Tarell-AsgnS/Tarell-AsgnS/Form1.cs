using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Tarell_AsgnS
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void btnExit_Click(object sender, EventArgs e)
        {
            this.Close();
        }

        private void btnClear_Click(object sender, EventArgs e)
        {
            this.txtPennies.Text = "0";
            this.txtNickels.Text = "0";
            this.txtDimes.Text = "0";
            this.txtQuarters.Text = "0";
            this.lblMessage.Text = "";
        }

        private void btnCalc_Click(object sender, EventArgs e)
        {
            try
            {
                lblMessage.Text = "";
                int numPennies = Convert.ToInt16(txtPennies.Text);
                int numNickels = Convert.ToInt16(txtNickels.Text);
                int numDimes = Convert.ToInt16(txtDimes.Text);
                int numQuarters = Convert.ToInt16(txtQuarters.Text);

                double total = 0;

                if (CheckRange(numPennies) && CheckRange(numNickels) && CheckRange(numDimes) && CheckRange(numQuarters))
                {
                    total = numPennies * .01 + numNickels * .05 + numDimes * .10 + numQuarters * .25;
                    lblMessage.Text += "Your total amount is " + total.ToString("c");
                }
                else
                    lblMessage.Text = "Coins must be between 0 and 500. Try Again...";

            }
            catch (Exception ex)
            {
                lblMessage.Text = "Values must be numbers without decimals. Try Again...";
            }
        }

        private bool CheckRange(int coin)
        {
            if (coin < 0 || coin > 500)
                return false;
            return true;
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            btnClear_Click(sender, e);
        }
    }
}
