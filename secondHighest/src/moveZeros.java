public class moveZeros {
	
	private static void swap(int a[], int i,int j){
		int temp=0;
		temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	private static void shuffle(int a[]){
	  int len = a.length-1;
	  int i=0;
	  int j = len;
	  int pivot = len/2;
	  while(i<= pivot){
		  if(a[i] ==0) {
			  swap(a,i,j);
			  j--;
		  }
		  else
			  i++;	  
	  }
		
	}
	
	public static void main(String args[]){
		
	   int a[] = {1, 0, 8, 4, 0, 0, 2, 7, 0, 6, 0};	
	   shuffle(a);
	   for(int i=0;i<a.length;i++){
		   
		   System.out.println(a[i] + " ");
	   }
	}	
}