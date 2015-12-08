using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SayHello
{
    class Program
    {
        static void Main(string[] args)
        {
            for (int i = 0; i < 10; i++)
            {
                //Console.WriteLine(System.DateTime.Now);
                Console.WriteLine("Hello World");
                //System.Threading.Thread.Sleep(500);
            }
            System.Environment.Exit(0);
        }
    }
}
