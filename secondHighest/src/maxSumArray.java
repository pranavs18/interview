public class maxSumArray{
	
	
	
	private static int findMaxSum(int a[]){
		int sum=0;
		int negMax = Integer.MIN_VALUE;
		int max = Integer.MIN_VALUE;
		boolean flag = false;
		for(int i=0;i<a.length;i++){
			if(a[i]< 0){
				negMax = Math.max(a[i],negMax);
			}
			sum+= a[i];
			flag = true;
			if(sum > max){
				max = sum;
			}
			if(sum < 0){
				sum =0;
			}
		}
		if(flag == false)
			return negMax;
		else
			return max;
	}
	
	private static int maxProductArray(int a[]){
		if(a.length == 0)
			return Integer.MIN_VALUE;
		int local_max = a[0];
		int local_min = a[0];
		int global_max = a[0];
		
		for(int i=1;i<a.length;i++){
			int copy_localmax = local_max;
			local_max = Math.max(Math.max(a[i]*local_max,a[i]), a[i]*local_min);
			local_min = Math.min(Math.min(a[i] *copy_localmax,a[i]),a[i]*local_min);
			global_max = Math.max(global_max, local_max);
		}
		
		return global_max;
	}
	
	public static void main(String args[]){
		int a[] = {10, -4, 2, 5, 3};
		int num = findMaxSum(a);
		int pro = maxProductArray(a);
		System.out.println(num + "  " + pro);
	}
}