package PackageTesteLeandro;

import java.util.Random;

public class returnRandom {
	
	static Random rand = new Random();
	static int randomizedInt;
			public static int getRandom(int howManyLoops)
			{
			
				if (howManyLoops!=108)
				{
				return 55;
				}
				else
				{
					throw new IllegalArgumentException("108 não!!");
				}
				
			}
			
			
			public static void main(String[] args) 
			{
				System.out.println(getRandom(5));
				System.out.println("Isso!");
			}
			
}



