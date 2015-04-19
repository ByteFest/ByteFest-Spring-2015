import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Four
{
	public MyStr [] toSort;
	public Scanner fIn;
	/**
	 * @param args
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException
	{
		new Four();
	}
	
	public Four() throws FileNotFoundException
	{
		fIn = new Scanner(new File("Four.txt"));
		int counter = 0, times = fIn.nextInt();
		toSort = new MyStr [times];
		
		fIn.nextLine();
		for (int i = 0; i < toSort.length; i++)
		{
			toSort[i] = new MyStr(fIn.nextLine());	
		}
		
		Arrays.sort(toSort);
		
		for (int i = 0; i < toSort.length; i++)
		{
			System.out.println(toSort[i].data);
		}
	}
	
	public class MyStr implements Comparable
	{
		public String data = "";
		
		public MyStr(String data)
		{
			this.data = data;
		}
		
		public int compareTo(Object arg0)
		{
			String rhs = ((MyStr)arg0).data;
			
			if (this.data.charAt(1) < rhs.charAt(1))
			{
				return -1;
			}
			else if(this.data.charAt(1) > rhs.charAt(1))
			{
				return 1;
			}
			else if(this.data.charAt(3) < rhs.charAt(3))
			{
				return -1;
			}
			else if(this.data.charAt(3) > rhs.charAt(3))
			{
				return 1;
			}
			
			return 0;
		}
	}
}
