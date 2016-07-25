import java.util.*;
public class Solution
{
	private Scanner input;
	private int n,m,x,y;
	private Set<Integer> output, propose;
	public Solution()
	{
		input = new Scanner(System.in);
		n = input.nextInt();
		m = input.nextInt();
		output = new LinkedHashSet<>(n);
		propose = new LinkedHashSet<>(n);
		
		for(int i=0; i<m; i++)
		{
			x = input.nextInt();
			y = input.nextInt();
			output.add(x);
			output.add(y);
		}
		for(int i=0; i<n; i++)
			propose.add(input.nextInt());
			
		System.out.println((propose.equals(output) ? "YES" : "NO"));
	}
	public static void main(String [] args)
	{
		new Solution();
	}
}