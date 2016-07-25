import java.util.*;

public class Optimisation3
{
	private static Scanner read;
	double a,b,t,e;
	int calc;
	
	public Optimisation3()
	{
		read = new Scanner(System.in);
		System.out.println("Press 1-To solve using fibonachi method\n2- To solve using Golden search method\n3- To solve using dicotomous method\n");
		calc = read.nextInt();
		
		
		System.out.print("Enter the value of a: ");
		a = read.nextDouble();
		System.out.print("\nEnter the value of b: ");
		b = read.nextDouble();
		System.out.print("\nEnter the value of t: ");
		t = read.nextDouble();
		System.out.print("\nEnter the error value: ");
		e = read.nextDouble();
		
		if(calc == 1)
		Fibonachi();
		else if(calc == 2)
		GoldenSection();
		else if(calc == 3)
		Dichotomous();
		
	}
	private void Dichotomous()
	{
		System.out.println("===================================================");
		System.out.println("|Maximizing -x2-2x using Dichotomous Search Method|");
		System.out.println("===================================================");
		double a,b,t,e;
		a = this.a;
		b = this.b;
		t = this.t;
		e = this.e;
		
		double tt = Math.abs(((Math.log((b-a)  / t) )/ Math.log(2)));
		
		int n = (tt > ((int) tt) ? (int)++tt : (int) tt);
		
		double x1,x2, fx1, fx2, x, fx;
		
		System.out.println("n\t    a\t\t  b\t\t  x1\t\t  x2\t\t  f(x1)\t\t  f(x2)\n");
		for(int i=0; i<n; i++)
		{
			x1 = ((a+b)/2) - e;
			x2 = ((a+b)/2) + e;
			fx1 = -(x1*x1) - 2*x1;
			fx2 = -(x2*x2) - 2*x2;
			
			System.out.printf("%d\t%.4f  \t%.4f  \t%.4f  \t%.4f  \t%.4f  \t%.4f\n", i,a,b,x1,x2,fx1,fx2);
			if(fx1 > fx2)
			b = x2;
			if(fx2 > fx1)
			a = x1;
		}
		System.out.printf("%d\t%.4f  \t%.4f\n\n", n,a,b);
		x = (a + b)/2;
		fx = -(x*x) - 2*x;
		System.out.println("X* = " + x);
		System.out.println("f(x*) = " + fx);
	}
	private void GoldenSection()
	{
		System.out.println("======================================================");
		System.out.println("|Maximizing -x2-2x using Golden Section Search Method|");
		System.out.println("======================================================");
		double r,x1,x2,fx1,fx2,fx,x;
		double a,b,t,e;
		a = this.a;
		b = this.b;
		t = this.t;
		e = this.e;
		r = 0.618034;
		int count =0;
		
		System.out.println("n\t    a\t\t  b\t\t  x1\t\t  x2\t\t  f(x1)\t\t  f(x2)\n");
		while((b-a) > t)
		{
			x1 = a + (1-r)*(b-a);
			x2 = a +r*(b-a);
			
			fx1 = -(x1*x1) - 2*x1;
			fx2 = -(x2*x2) - 2*x2;
			
			System.out.printf("%d\t%.4f  \t%.4f  \t%.4f  \t%.4f  \t%.4f  \t%.4f\n", count++,a,b,x1,x2,fx1,fx2);
			
			if(fx1 > fx2)
			b = x2;
			if(fx2 > fx1)
			a = x1;
		}
		System.out.printf("%d\t%.4f  \t%.4f\n\n", count,a,b);
		x = (a + b)/2;
		fx = -(x*x) - 2*x;
		System.out.println("X* = " + x);
		System.out.println("f(x*) = " + fx);
	}
	private int recursion(int num)
	{
		if(num ==0 || num ==1 )
			return num;
		else
		return recursion(num-1) + recursion(num-2);
	}
	private void Fibonachi()
	{
		System.out.println("=================================================");
		System.out.println("|Maximizing -x2-2x using Fibonacci Search Method|");
		System.out.println("=================================================");
		double r,x1,x2,fx1,fx2,fx,x;
		int fn;
		double a,b,t,e;
		a = this.a;
		b = this.b;
		t = this.t;
		e = this.e;
		int n =0;
		for(int i=0; i<100; i++)
		{
			if(!(recursion(i)<=(1/e)))
			{
				n = --i;
				break;
			}
		}
		fn = recursion(n+1);
		
		System.out.println("n\tFn\t    a\t\t  b\t\t  x1\t\t  x2\t\t  f(x1)\t\t  f(x2)");
		System.out.println((n+1)+"\t" + fn);
		for(int i=n; i>1; i--)
		{
			x1 = a + ((double)recursion(i-1)/(double)recursion(i+1))*(b-a);
			x2 = a + ((double)recursion(i)/(double)recursion(i+1))*(b-a);
			fn = recursion(i);
			
			fx1 = -(x1*x1) - 2*x1;
			fx2 = -(x2*x2) - 2*x2;
			
			System.out.printf("%d\t%d\t%.4f  \t%.4f  \t%.4f  \t%.4f  \t%.4f  \t%.4f\n",  i,fn,a,b,x1,x2,fx1,fx2);
			
			if(fx1 > fx2)
			b = x2;
			if(fx2 > fx1)
			a = x1;
		}
		System.out.printf("1\t1\t%.4f  \t%.4f\n\n", a,b);
		
		x = (a + b)/2;
		fx = -(x*x) - 2*x;
		System.out.println("X* = " + x);
		System.out.println("f(x*) = " + fx);
	}
	public static void main(String [] ismummy)
	{
		new Optimisation3();
	}
}