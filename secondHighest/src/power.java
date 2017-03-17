public class power {
	
	private static double powerBinary(double a, int b){
		
		if(b == 0)
			return 1;
		if(b == 1)
			return a;
		else if(b%2 == 0)
			return powerBinary(a,b/2) * powerBinary(a,b/2);
		else
			return a* powerBinary(a,b/2) * powerBinary(a,b/2);
		
	}
	
	public static void main(String args[]){
		
		double a = 3;
		int b = 5;
		double res = powerBinary(a,b);
		System.out.println(res);
	}
}