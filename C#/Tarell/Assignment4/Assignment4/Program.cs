using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Display;

// Zach Tarell - Assignment 4 
    class Program
    {
        static void Main(string[] args)
        {  
            decimal num1 = IO.getNums();
            decimal num2 = IO.getNums();
            if (num1 > 0 && num2 > 0)IO.put(String.Format("Sum: {0, 7:c2}", num1 + num2));
        
            float num3 = IO.getReals();
            float num4 = IO.getReals();
            if (num3 < 0 ^ num4 < 0)IO.put(String.Format("Product: {0, 7:f2}", num3 * num4));
            else if (num3 < 0 && num4 < 0)IO.put(String.Format("Quotient: {0, 7:f2}", num3 / num4));
       }
    }

