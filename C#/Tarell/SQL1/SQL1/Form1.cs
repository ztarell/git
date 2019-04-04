using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.Data.Common;
using System.Data; // System.Data is the root namespace for ADO.NET
using System.Data.OleDb; // Access we

namespace SQL1
{
    public partial class Form1 : Form
    {
        DbCommand dbcmd; // These commands are compatible with OleDb or SQL
        DbConnection dbconn;

        OleDbCommand cmd;
        OleDbConnection conn;
        public Form1()
        {
            InitializeComponent();
            // To send queiries tyou need a Connection Object and a command
            OleDbConnectionStringBuilder strBuilder = new OleDbConnectionStringBuilder();
            // Provider = Microsoft.Jet.OLEDB.4.0      Data Source = F:\C#\Tarell\SQL1\SQL1\db2.mdb
            strBuilder.Provider = "Microsoft.Jet.OLEDB.4.0";
            strBuilder.DataSource = @"F:\C#\Tarell\SQL1\SQL1\db2.mdb";
            conn = new OleDbConnection(strBuilder.ConnectionString);
            cmd = new OleDbCommand("Select * from Worker", conn);

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
            OleDbDataAdapter da = new OleDbDataAdapter(cmd);
            da.Fill(ds);
            dataGridView1.DataSource = ds;
            dataGridView1.DataMember = ds.Tables[0].TableName;
            System.IO.StringWriter sw = new System.IO.StringWriter();
            ds.WriteXml(sw);
            MessageBox.Show(sw.ToString());
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

            OleDbDataAdapter da = new OleDbDataAdapter(cmd);
            da.SelectCommand = cmd;
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
                OleDbDataAdapter da = new OleDbDataAdapter(cmd);
                DataSet ds = new DataSet();
                da.Fill(ds);
                dataGridView1.DataSource = ds;
                dataGridView1.DataMember = ds.Tables[0].TableName;
            }
        }
    }
}
