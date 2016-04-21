
public abstract class Operation 
{
	double a;
	double b;
	public  Operation(double a,double b) 
	{
		this.a = a;
		this.b = b;
	}
	abstract protected int operate();
}
