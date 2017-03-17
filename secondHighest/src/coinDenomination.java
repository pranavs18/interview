/*public class coinDenomination{
	// Recursive Solution
	private static int countWays(int change[], int size, int amount){
		
		if(amount < 0)
			return 0;
		
		if(amount == 0)
			return 1;
		
		if(size <=0 && amount >=1 )
			return 0;
		
		return countWays(change,size, amount - change[size-1]) + countWays(change,size-1, amount);
	}
  
	// dynamic programming
	
	private static int dynamicCount(int n , int MEM[], int coins[]) {
        if(n < 0)
            return 0;
        else if(n == 0)
            return 0;
        else if(MEM[n] != 0)    // If solved previously already
            return MEM[n];
        else {
            // Look for the minimal among the different denominations
            MEM[n] = 1+ dynamicCount(n-coins[0], MEM, coins);
            for(int i = 1; i < coins.length; i++)
                MEM[n] = Math.min(MEM[n], 1+ dynamicCount(n-coins[i], MEM, coins));
            return MEM[n];
        }
    }
	
	
     
	public static void main(String args[]){
		int change[] = {1, 3, 9,10};
		int amount = 15;
		int size = change.length-1;
		int MEM[] = new int[amount+1];
		int res = countWays(change, size, amount);
		int x = dynamicCount(amount, MEM, change);
		System.out.println(res+ " " + x);
	}
}
*/

public class coinDenomination {
	private static int dynamicCount(int n , int MEM[], int coins[]) {
        if(n < 0)
            return Integer.MAX_VALUE;
        else if(n == 0)
            return 0;
        else if(MEM[n] != -1)    // If solved previously already
            return MEM[n];
        else {
            // Look for the minimal among the different denominations
            int temp = dynamicCount(n-coins[0], MEM, coins);
            for(int i = 1; i < coins.length; i++)
            	temp = Math.min(temp, dynamicCount(n-coins[i], MEM, coins));
            
            MEM[n] = temp + 1;
            return MEM[n];
        }
    }
	public static void main(String ar[]) {
		int []denom= {1,2};
		int amount = 3;
		int MEM[] = new int [amount+1];
		for (int i = 0; i< MEM.length; i ++)
			MEM[i] = -1;
		
		System.out.println(dynamicCount(amount, MEM, denom));
	}
}