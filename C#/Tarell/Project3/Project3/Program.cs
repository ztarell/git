using System;
using Utility;


class Program
{
    static void Main(string[] args)
        {
          int x = Helper.getInt();
          int y = Helper.getInt();

          if (x>0) Console.WriteLine("Sum:{0}", x + y);
          if (x>0 & y>0) Console.WriteLine("Sum:{0}", x + y);
          if (x>0 && y>0) Console.WriteLine("Sum:{0}", x + y);

          if (x > 0) Console.WriteLine("1st is positive");
          else Console.WriteLine("1st is not positive");

          if (x  >0) if (y > 0) Console.WriteLine("Both Positive");

    }
}

