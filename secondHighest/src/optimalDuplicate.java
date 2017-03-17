public class optimalDuplicate{
	// find first index of a duplicate in O(log n) time
	public static void main(String args[]){
		
		//int a[] = {1,1,2,2,2,4,4,4,4,5,5,5,5,5,5,5,5,5,5,5,6,6,6,7,8,8,8,9};
		int a[] = {0,0,2,3,3,3,3,4,7,7,9};
		int key = 5;
		int index  = findFirstIndex(a,key);
		int lastindex = findLastIndex(a,key);
		if(index != -1  && lastindex !=-1){
			System.out.println("First index of the element is " + index + " and last index is " +lastindex);
		}
		else
			System.out.println("Element not found " + index + " " + lastindex);
		
	}
	
	private static int findFirstIndex(int a[], int key){
		int low =0;
		
		int high = a.length -1;
		int start=0,end=0,count=0;
		while(low <= high){
			int mid =  low + (high - low)/2;
			if(a[mid] == key){
				if(count == 0){
					end = mid;
					count++;
				}
				if(mid > 0 && a[mid-1] != key ) {
					start = mid;
					System.out.println("START " + start);
					return mid;
				}
				else{
				    if(mid == 0)
				    	return mid;
					high = mid -1;
				}
			}
			else if(key < a[mid]){
				high = mid -1;
			}
			else
				low = mid+1 ;
		}
		
		return -1;
	}
	
	private static int findLastIndex(int a[], int key){
		int low =0;
		
		int high = a.length -1;
		int start=0,end=0,count=0;
		while(low <= high){
			int mid =  low + (high - low)/2;
			if(a[mid] == key){
				
				if(mid > 0 && a[mid+1] != key ) {
					end = mid;
					System.out.println("END " + end);
					return mid;
				}
				else{
				    if(mid == a.length-1)
				    	return mid;
					low = mid +1;
				}
			}
			else if(key < a[mid]){
				high = mid -1;
			}
			else
				low = mid+1 ;
		}
		
		return -1;
	}
	
}