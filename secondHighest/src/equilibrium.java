public class equilibrium{
	
	
	private static int findEquilibriumPoints(int a[][]){
		int count =0;
		int totalSum=0;
		int row[] = new int[3];
		int col[] = new int[3];
		for(int i=0;i<a.length;i++){
			for(int j=0;j<a[0].length;j++){
			  row[i] += a[i][j];
			  col[j] += a[j][i];
			  totalSum += a[i][j];
			}
			
		}
		
		
		int sum_left =0;
		int sum_up =0;
		int sum_down = totalSum;
		int sum_right = 0;
		for(int i=0;i<a.length;i++){
			sum_left = 0;
			sum_right = totalSum;
		    sum_down =  sum_down - row[i];
			for(int j=0;j<a[0].length;j++){
				sum_right = sum_right - col[j];
				if(sum_left == sum_right && sum_down == sum_up) 
					count++;
				sum_left += col[j];
				
			}
			sum_up += row[i];
		}
		
		/*
		
		for(int i=0;i<a.length;i++){
			sum_down=0;
			for(int j=0;j<a[0].length;j++){
				int sum_up = col[colIndex] - sum_down - a[j][i];
				if(sum_down == sum_up) count++;
				sum_down += a[j][i];
				
			}
			colIndex++;
		}*/
		return count;
	}
	
	
	public static void main(String args[]){
		int a[][] = new int[3][3];
		
		a[0][0] = 1;
		a[0][1] = 2;
		a[0][2] = 1;
		a[1][0]= -1;
		a[1][1] = 0;
		a[1][2] = -1;
		a[2][0] = 1;
		a[2][1] = 1;
		a[2][2] = 2;
		
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				System.out.print(a[i][j] + "    ");
			}
			System.out.println();
		}
		
		int x = findEquilibriumPoints(a);
		System.out.println("Number of equilibrium points " + x);
		
	}
}