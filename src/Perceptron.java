public class Perceptron 
{
	private static final int TEST = 0;
	
	private static double[][] sigmoid(double[][] a) 
	{
		double result[][] = new double[a.length][a[0].length];
		for(int i =0;i<a.length;i++)
			for(int j = 0; j < a[0].length; j++)
				result[i][j] = (1/( 1 + Math.pow(Math.E,(-1*a[i][j]))));
		return result;
	}
	private static double[][] matProduct(double[][] a, double[][] b)
	{
		if(a[0].length != b.length){
			throw new IllegalArgumentException("The dimensions are not equal!");
		}
		double result[][] = new double[a.length][b[0].length];
		for(int i =0;i<a.length;i++)
			for(int j = 0; j < b[0].length; j++)
				for(int k = 0; k < a[0].length; k++)
				{
					Sum temp1 = new Sum(a[i][k],b[k][j]);
					Product temp2 = new Product(result[i][j],temp1.operate());
					result[i][j] = temp2.operate();
				}
		return result;
	}
	private static double[][] matSum(double[][] a, double[][] b)
	{
		if(a.length != b.length || a[0].length != b[0].length){
			throw new IllegalArgumentException("The dimensions are not equal!");
		}
		double result[][] = new double[a.length][a[0].length];
		for(int i =0;i<a.length;i++)
			for(int j = 0; j < a[0].length; j++)
			{
				Product temp1 = new Product(a[i][j],b[i][j]);
				result[i][j] = temp1.operate();
			}
		return result;
	}

	public static void main(String[] args) 
	{
		if(TEST == 1)
		{
			TestVariable.testVar();
		}
		else
			Variable.initVar();
		
		Variable.printVar();
	
		double[] h1;
		h1 = sigmoid(matSum(matProduct(Variable.myInput,Variable.w1),Variable.b1));
		System.out.println("\nHidden");
		Variable.printArr2D(h1);
		
		double[][] myOutput;
		myOutput = sigmoid(matProduct(matSum(Variable.w2,h1),Variable.b2));
		System.out.println("\nOutput");
		Variable.printArr2D(myOutput);	
		
	}

}