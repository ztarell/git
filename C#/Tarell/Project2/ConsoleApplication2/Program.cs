using System;


class Ram
{
    static void Main(string[] args)
    {
        // Enter real floats and convert floats to single
        Console.Write("Enter a real number: ");
        String s = Console.ReadLine();
        float x = Convert.ToSingle(s);
        Console.Write("Enter another real number: ");
        s = Console.ReadLine();
        float y = Convert.ToSingle(s);

        Console.WriteLine("Sum: {0,-10:f2}", x+y);
        Console.WriteLine("Difference: {0,-10:f2}", x-y);
        Console.WriteLine("Product: {0,-10:f2}", x*y);
        Console.WriteLine("Quotient: {0,-10:f2}", x/y);
        Console.WriteLine("Modulus: {0,-10:f2}", x%y);

        // Enter decimals and convert string to decimals
        Console.Write("Enter a decimal number: ");
        String d = Console.ReadLine();
        decimal a = Convert.ToDecimal(d);
        Console.Write("Enter another decimal number: ");
        d = Console.ReadLine();
        decimal b = Convert.ToDecimal(d);

        Console.WriteLine("Sum: {0,-10:c2}", a+b);
        Console.WriteLine("Difference: {0,-10:c2}", a-b);
        Console.WriteLine("Product: {0,-10:c2}", a*b);
        Console.WriteLine("Quotient: {0,-10:c2}", a/b);
        Console.WriteLine("Modulus: {0,-10:c2}", a%b);

    }
}

