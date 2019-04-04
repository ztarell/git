using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Display
{
    public class IO
    {

        public static decimal getNums()
        {
            Console.WriteLine("Enter a decimal number");
            return Convert.ToDecimal(Console.ReadLine());
        }

        public static void put(String output)
        {
            Console.WriteLine(output);
        }
        
        public static float getReals()
        {
            Console.WriteLine("Enter a real number");
            return Convert.ToSingle(Console.ReadLine());
        }

    }
}
