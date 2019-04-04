using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Utility;



    class Program
    {
        static void Main(string[] args)
        {
            decimal x = IO.getDecimal();
            decimal y = IO.getDecimal();

                if (x > 0 && y > 0)
                {
                Console.WriteLine("Sum: {0}", x + y);
                }

        float a = IO.getFloat();
        float b = IO.getFloat();

            if (a < 0 ^ b < 0)
            {
                string s = String.Format("Product: {0,7:f2}", a * b);
                Console.WriteLine(s);
            }
            else if (a<0 && b<0)
            {
                string s = String.Format("Quotient: {0,7:f2}", a / b);
                Console.WriteLine(s);
            }
        }

    }

