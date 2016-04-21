import java.util.Random;


public class Variable 
{
	static double[][] myInput = new double[3][1];//3X1
	static double[][] w1 = new double[3][3];//3X3
	static double[][] b1 = new double[3][1];//3X1
	static double[][] w2 = new double[1][3];//3X3
	static double[][] b2 = new double[1][1];//3X1
	
	private static void randomFill(double[] arr,int limit)
	{
		Random random = new Random();
	    for (int i = 0; i < arr.length; i++) 
	    	arr[i] = (int) (random.nextInt(limit-(-1*limit)+1)-limit);
	}
	protected static void randomFill2D(double[][] arr,int limit)
	{
	    for (int i = 0; i < arr.length; i++)
	    	randomFill(arr[i],limit);
	}
	private static void printArr(double[] arr)
	{
	    for (int i = 0; i < arr.length; i++) 
	    {
	    	System.out.print(arr[i]);
	    	System.out.print("\t");
	    }
	}
	protected static void printArr2D(double[][] arr)
	{
	    for (int i = 0; i < arr.length; i++) 
	    {
	    	printArr(arr[i]);
	    	System.out.println();
	    }
	}
	private static void constFill(double[] arr)
	{
		for (int i = 1; i <= arr.length; i++)
	    	arr[i-1]=i;
	}
	protected static void constFill2D(double[][] arr)
	{
		for (int i = 1; i <= arr.length; i++)
	    	constFill(arr[i-1]);
	}
	protected static void initVar()
	{
		randomFill2D(myInput,20);
		randomFill2D(w1,10);
		randomFill2D(b1,10);
		randomFill2D(w2,10);
		randomFill2D(b2,20);
	}
	protected static void printVar()
	{
		System.out.println("\nInput");
		printArr2D(myInput);
		System.out.println("\n\nWeight1");
		printArr2D(w1);
		System.out.println("\nBias1");
		printArr2D(b1);
		System.out.println("\n\nWeight2");
		printArr2D(w2);
		System.out.println("\nBias2");
		printArr2D(b2);
	}
}
