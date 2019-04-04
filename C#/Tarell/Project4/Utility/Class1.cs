using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Utility
{
   public class IO
    {
        public static decimal getDecimal()
        {
            Console.WriteLine("Enter a decimal number");
            return Convert.ToDecimal(Console.ReadLine());
        }

        public static float getFloat()
        {
            Console.WriteLine("Enter a real number");
            return Convert.ToSingle(Console.ReadLine());
        }


        // means 2 methods have same name but different parameters
        // overloading means you have 2 methods
        //public static int getInt(String prompt)
        //{
        //    Console.Write(prompt);
        //    return Convert.ToInt32(Console.ReadLine());
        //}
    }
}
