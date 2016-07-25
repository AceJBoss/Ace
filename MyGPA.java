// Program To Calculate GPA For Student

import java.util.Scanner;

public class MyGPA
{
	public static void main( String[]args )
	{
		String matric;
		int n,cos,sco,unit,sunit,spoint;
		float gpa;
		sunit=0;	spoint=0;
		Scanner input = new Scanner(System.in);
		System.out.println("Supply the total number of the Student " );
		n = input.nextInt();
		System.out.println("Supply the total number of course offered ");
		cos = input.nextInt();
		for(int i=1; i<=n; i++)
		 {
			System.out.println("Supply your matric number as student " + i);
			matric = input.next();
		for(int j=1; j<=cos; j++)
		{
			System.out.println("Supply ur score and the unit of the course " +j );
			sco = input.nextInt();
			unit = input.nextInt();
			
			// Making decision for the Grade
			if((sco>=70)&&(sco<=100))
			 {
				sunit+=unit;
				spoint+=unit*5;
			 }
			else if((sco>=60)&&(sco<=69))
				{
					sunit+=unit;
					spoint+=unit*4;
				}
			else if((sco>=50)&&(sco<=59))
				{
					sunit+=unit;
					spoint+=unit*3;
				}
			else if((sco>=45)&&(sco<=49))
				{
					sunit+=unit;
					spoint+=unit*2;
				}
			else if((sco>=40)&&(sco<=44))
				{
					sunit+=unit;
					spoint+=unit*1;
				}
			else
				{
					sunit+=unit;
					spoint+=unit*0;
				}
		}
			gpa=(spoint/sunit);
			System.out.println( "Matric No: " + matric + "\n your GPA is : " + gpa );
		 }
	}
}