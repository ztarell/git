using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Program1
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Enter 2 real numbers");  // Enter 2 reals
            float a = Convert.ToSingle(Console.ReadLine());
            float b = Convert.ToSingle(Console.ReadLine());
            Console.WriteLine("Sum: {0,7:f2}", (a + b));
            Console.WriteLine("Diff: {0,7:f2}", (a - b));
            Console.WriteLine("Product: {0,7:f2}", (a * b));
            Console.WriteLine("Quotient: {0,7:f2}", (a / b));
            Console.WriteLine("Mod: {0,7:f2}", (a % b));

            Console.WriteLine("\nEnter 2 decimal numbers"); // Enter 2 decimals
            decimal x = Convert.ToDecimal(Console.ReadLine());
            decimal y = Convert.ToDecimal(Console.ReadLine());
            Console.WriteLine("Sum: {0,7:c2}", (a + b));
            Console.WriteLine("Diff: {0,7:c2}", (a - b));
            Console.WriteLine("Product: {0,7:c2}", (a * b));
            Console.WriteLine("Quotient: {0,7:c2}", (a / b));
            Console.WriteLine("Mod: {0,7:c2}", (a % b));
        }
    }
}
