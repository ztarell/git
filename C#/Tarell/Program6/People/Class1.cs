using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace People
{
    //abstract is always a base class
    //you can never instantiate it
    public abstract class Employee: IComparable<Employee>
    {
        public String Name { get; set; }
        public int Age { get; set; }
        public Employee(String name, int age)
        {
            Name = name;
            Age = age;
        }
        //You want to compare names to names
        public int CompareTo(Employee e)
        {
            return Name.CompareTo(e.Name);
        }
        public Employee() : this("", 0) { }
        public override string ToString()
        {
            return String.Format(" {0} {1}", Name, Age);
        }
        public abstract Decimal getIncome();
    }
    public class SalaryEmployee:Employee
    {
        public decimal Salary { get; set; }
        public SalaryEmployee(String name, int age, decimal salary) : base(name,age)
        {
            Salary = salary;
        }
        public SalaryEmployee() : this("", 0, 24000) { }
        public override string ToString()
        {
            return base.ToString() + String.Format(" {0:f2}", Salary); 
        }
        public override Decimal getIncome()
        {
            return Salary;
        }
    }
    public class HourlyEmployee : Employee
    {
        public decimal Hours { get; set; }
        public decimal Wage { get; set; }

        public HourlyEmployee(String name, int age, decimal wage, decimal hrs) : base(name, age)
        {
            Hours = hrs;
            Wage = wage;
        }
        public HourlyEmployee() : this("", 0, 12.50m, 40) { }  // 12.50m - the "m" is decimal like "f" for float
        public override string ToString()
        {
            return base.ToString() + String.Format(" {0:f2} {1:f2}", Wage, Hours);
        }
        public override Decimal getIncome()
        {
            return Wage * Hours * 52;
        }
    }
    public class EmployeeList
    {
        List<Employee> employees = new List<Employee>();
        public int Length
        {
            get { return employees.Count; }
        }
        // there is a special property called indexer
        // you can use [] notation for any type of collection
        // the reason this works is because of indexers
        public Employee this [int n]
        {
            get
            {
                return employees[n];
            }
            set
            {
                employees[n] = value;
            }
        }
        public void Add(Employee emp)
        {
            employees.Add(emp);
        }
        public void AddRange(String s)
        {
            String[] data = System.Text.RegularExpressions.Regex.Split(s.Trim(), @"\s+");
            
            for (int i = 0; i < data.Length; i += 3)
                if ((i + 3 < data.Length) && System.Text.RegularExpressions.Regex.IsMatch(data[i + 3], @"\d+(\.\d*)?"))
                {
                    employees.Add(new HourlyEmployee(data[i],
                        Convert.ToInt32(data[i + 1]),
                        Convert.ToDecimal(data[i + 2]),
                        Convert.ToDecimal(data[i + 3])));
                    i++;
                }
                else
                    //employees = new SalaryEmployee[data.Length / 3];
                    employees.Add(new SalaryEmployee(data[i], 
                        Convert.ToInt32(data[i + 1]), 
                        Convert.ToDecimal(data[i + 2])));
            // THERE'S 2 WAYS TO DO BELOW
            //for (int i = 0; i < employees.Length; i++)
            //    employees[i] = new SalaryEmployee(data[3 * i], Convert.ToInt32(data[3 * i + 1]), Convert.ToDecimal(data[3 * i + 2]));
        }
        public void Clear()
        {
            employees.Clear();
        }
        public void SortByName()
        {
            employees.Sort(); // Automatically uses default compare
        }
        public void SortByAge()
        {                   // lambda exp. A shorthand way to write functions
            employees.Sort((e1, e2) => e2.Age.CompareTo(e1.Age)); // function with no name i.e. (Employee e1, Employee e2) ASCENDING DO e1 first
        }
        public void SortByIncome()
        {
            employees.Sort((e1, e2) => e2.getIncome().CompareTo(e1.getIncome()));
        }
        public override string ToString()
        {
            String result = "";
            for (int i = 0; i < Length; i++)
                result += this[i] + "\n";
            return result;
        }
    }
}
