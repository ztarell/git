using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.Data;
using System.Data.SqlClient;
using System.Data.OleDb;

namespace SQLServer
{
    public partial class Form1 : Form
    {
        //Data Source = (LocalDB)\MSSQLLocalDB;
        //AttachDbFilename=F:\C#\Tarell\SQL1\SQLServer\Database1.mdf;
        //Integrated Security=True;
        //Connect Timeout=30

        SqlConnection conn;
        SqlCommand cmd;
        public Form1()
        {
            InitializeComponent();
            var strBuilder = new SqlConnectionStringBuilder();
            strBuilder.DataSource = @"(LocalDB)\MSSQLLocalDB";
            strBuilder.AttachDBFilename = @"F:\C#\Tarell\SQL1\SQLServer\Database1.mdf";
            strBuilder.IntegratedSecurity = true;
            strBuilder.ConnectTimeout = 30;
            conn = new SqlConnection(strBuilder.ConnectionString); // you can put the entire connection string here w/ out strBuilder
            cmd = new SqlCommand("Select * from People", conn);
            // we will use a DataSet and a DataAdapter

            treeView1.Nodes.Add(new TreeNode("db2.mdb"));
            conn.Open();
            DataTable dt = conn.GetSchema("Tables");
            conn.Close();
            foreach (DataRow dr in dt.Rows)
            {
                String tableName = dr["table_name"].ToString();
                if (char.IsLetter(tableName[0]) && dr["table_type"].Equals("TABLE"))
                    treeView1.Nodes[0].Nodes.Add(tableName);
            }

            DataSet ds = new DataSet();
            SqlDataAdapter da = new SqlDataAdapter(cmd);
            da.Fill(ds);
            dataGridView1.DataSource = ds;
            dataGridView1.DataMember = ds.Tables[0].TableName;



        }

        private void Form1_Load(object sender, EventArgs e)
        {
            // TODO: This line of code loads data into the 'database1DataSet.People' table. You can move, or remove it, as needed.
            this.peopleTableAdapter.Fill(this.database1DataSet.People);

        }

        private void button1_Click(object sender, EventArgs e)
        {
            DataSet ds = new DataSet();

            String query = textBox1.Text.Trim();
            String oldquery = cmd.CommandText;
            cmd.CommandText = query;
            if (!query.ToLower().StartsWith("select"))
            {
                conn.Open();
                cmd.ExecuteNonQuery();
                conn.Close();
                
                cmd.CommandText = oldquery;
            }
            
            SqlDataAdapter da = new SqlDataAdapter(cmd);
            da.Fill(ds);
            dataGridView1.DataSource = ds;
            dataGridView1.DataMember = ds.Tables[0].TableName;

        }

        private void treeView1_AfterSelect(object sender, TreeViewEventArgs e)
        {
            if (!treeView1.SelectedNode.Equals(treeView1.Nodes[0]))
            {
                String query = "Select * from " + treeView1.SelectedNode.Text;
                cmd.CommandText = query;
                SqlDataAdapter da = new SqlDataAdapter(cmd);
                DataSet ds = new DataSet();
                da.Fill(ds);
                dataGridView1.DataSource = ds;
                dataGridView1.DataMember = ds.Tables[0].TableName;
            }
        }
    }
}
