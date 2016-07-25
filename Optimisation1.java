import java.util.*;

public class Optimisation1
{
	private static Scanner read;
	double a,b,t,e;
	
	public Optimisation1()
	{
		read = new Scanner(System.in);
		System.out.print("Enter the value of a: ");
		a = read.nextDouble();
		System.out.print("\nEnter the value of b: ");
		b = read.nextDouble();
		System.out.print("\nEnter the value of t: ");
		t = read.nextDouble();
		System.out.print("\nEnter the error value: ");
		e = read.nextDouble();
		
		
		//solution using Dichotomous method;
		System.out.println("===================================================");
		System.out.println("|Maximizing -x2-2x using Dichotomous Search Method|");
		System.out.println("===================================================");
		double dic_a, dic_b,dic_t,dic_e;
		dic_a = this.a;
		dic_b = this.b;
		dic_t = this.t;
		dic_e = this.e;
		
		double tt = Math.abs(((Math.log((dic_b-dic_a)  / dic_t) )/ Math.log(2)));
		
		int n = (tt > ((int) tt) ? (int)++tt : (int) tt);
		
		double dic_x1, dic_x2, dic_fx1, dic_fx2, dic_x, dic_fx;
		
		System.out.println("n\t    a\t\t  b\t\t  x1\t\t  x2\t\t  f(x1)\t\t  f(x2)\n");
		for(int i=0; i<n; i++)
		{
			dic_x1 = ((dic_a + dic_b)/2) - dic_e;
			dic_x2 = ((dic_a + dic_b)/2) + dic_e;
			dic_fx1 = -(dic_x1 * dic_x1) - 2 * dic_x1;
			dic_fx2 = -(dic_x2 * dic_x2) - 2 * dic_x2;
			
			System.out.printf("%d\t%.4f  \t%.4f  \t%.4f  \t%.4f  \t%.4f  \t%.4f\n", i, dic_a, dic_b, dic_x1, dic_x2, dic_fx1, dic_fx2);
			if(dic_fx1 > dic_fx2)
			dic_b = dic_x2;
			if(dic_fx2 > dic_fx1)
			dic_a = dic_x1;
		}
		System.out.printf("%d\t%.4f  \t%.4f\n\n", n, dic_a, dic_b);
		dic_x = (dic_a + dic_b)/2;
		dic_fx = -(dic_x * dic_x) - 2*dic_x;
		System.out.println("X* = " + dic_x);
		System.out.println("f(x*) = " + dic_fx);
		
		
		// solution using GoldenSection method
		System.out.println("======================================================");
		System.out.println("|Maximizing -x2-2x using Golden Section Search Method|");
		System.out.println("======================================================");
		double gol_r, gol_x1, gol_x2, gol_fx1, gol_fx2, gol_fx, gol_x;
		double gol_a, gol_b, gol_t, gol_e;
		gol_a = this.a;
		gol_b = this.b;
		gol_t = this.t;
		gol_e = this.e;
		gol_r = 0.618034;
		int count =0;
		
		System.out.println("n\t    a\t\t  b\t\t  x1\t\t  x2\t\t  f(x1)\t\t  f(x2)\n");
		while((gol_b - gol_a) > gol_t)
		{
			gol_x1 = gol_a + (1 - gol_r) * (gol_b - gol_a);
			gol_x2 = gol_a + gol_r * (gol_b - gol_a);
			
			gol_fx1 = -(gol_x1 * gol_x1) - 2 * gol_x1;
			gol_fx2 = -(gol_x2 * gol_x2) - 2 * gol_x2;
			
			System.out.printf("%d\t%.4f  \t%.4f  \t%.4f  \t%.4f  \t%.4f  \t%.4f\n", count++, gol_a, gol_b, gol_x1, gol_x2, gol_fx1, gol_fx2);
			
			if(gol_fx1 > gol_fx2)
			gol_b = gol_x2;
			if(gol_fx2 > gol_fx1)
			gol_a = gol_x1;
		}
		System.out.printf("%d\t%.4f  \t%.4f\n\n", count, gol_a, gol_b);
		gol_x = (gol_a + gol_b)/2;
		gol_fx = -(gol_x * gol_x) - 2 * gol_x;
		System.out.println("X* = " + gol_x);
		System.out.println("f(x*) = " + gol_fx);
		
		//solution using Fibonachi method
		System.out.println("=================================================");
		System.out.println("|Maximizing -x2-2x using Fibonacci Search Method|");
		System.out.println("=================================================");
		double fib_r, fib_x1, fib_x2, fib_fx1, fib_fx2, fib_fx, fib_x;
		int fn;
		double fib_a, fib_b, fib_t, fib_e;
		fib_a = this.a;
		fib_b = this.b;
		fib_t = this.t;
		fib_e = this.e;
		int fib_n =0;
		for(int i=0; i<100; i++)
		{
			if(!(recursion(i) <= (1 / fib_e)))
			{
				fib_n = --i;
				break;
			}
		}
		fn = recursion(fib_n + 1);
		
		System.out.println("n\tFn\t    a\t\t  b\t\t  x1\t\t  x2\t\t  f(x1)\t\t  f(x2)");
		System.out.println((fib_n + 1)+"\t" + fn);
		for(int i= fib_n; i>1; i--)
		{
			fib_x1 = fib_a + ((double)recursion(i-1) / (double)recursion(i+1)) * (fib_b - fib_a);
			fib_x2 = fib_a + ((double)recursion(i) / (double)recursion(i+1)) * (fib_b - fib_a);
			fn = recursion(i);
			
			fib_fx1 = -(fib_x1 * fib_x1) - 2 * fib_x1;
			fib_fx2 = -(fib_x2 * fib_x2) - 2 * fib_x2;
			
			System.out.printf("%d\t%d\t%.4f  \t%.4f  \t%.4f  \t%.4f  \t%.4f  \t%.4f\n",  i,fn, fib_a, fib_b, fib_x1, fib_x2, fib_fx1, fib_fx2);
			
			if(fib_fx1 > fib_fx2)
			fib_b = fib_x2;
			if(fib_fx2 > fib_fx1)
			fib_a = fib_x1;
		}
		System.out.printf("1\t1\t%.4f  \t%.4f\n\n", fib_a, fib_b);
		
		fib_x = (fib_a + fib_b)/2;
		fib_fx = -(fib_x * fib_x) - 2 * fib_x;
		System.out.println("X* = " + fib_x);
		System.out.println("f(x*) = " + fib_fx);
	}
	
	private int recursion(int num)
	{
		if(num ==0 || num ==1 )
			return num;
		else
		return recursion(num-1) + recursion(num-2);
	}
	
	public static void main(String [] ismummy)
	{
		new Optimisation1();
	}
}