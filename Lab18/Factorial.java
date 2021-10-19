package Lab18;

import com.sun.jdi.VMOutOfMemoryException;
import edu.princeton.cs.introcs.In;

import java.util.Scanner;

public class Factorial {
	public static void main(String[] arg) {
		int n = 1, factorial = 1;
		Scanner scan = new Scanner(System.in);
		boolean valid = true;

		do {
			valid = true;
			try {
				n = Integer.parseInt(scan.next());
				if (n < 0)
					throw new Exception("number must be positive or zero");
			} catch (NumberFormatException e)
			{
				System.out.println("Number must be an integer");
				valid = false;
			}
			catch (Exception e)
			{
				System.out.println(e.getMessage());
				valid = false;
			}

			try {
				factorial = 1;
				for (int i = 2; i <= n; i++)
				{
					if (Integer.MAX_VALUE - factorial * factorial * i <= 10)
						throw new Exception("The number is too big to be calculated");
					else
					factorial *= i;
				}
			} catch (Exception e)
			{
				valid = false;
				System.out.println(e.getMessage());
			}

		} while (!valid);

		System.out.println("Factorial of " + n + " : " + factorial);
	}
}
