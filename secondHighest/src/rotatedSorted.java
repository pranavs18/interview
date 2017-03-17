public class rotatedSorted {
	
	public static void main(String args[]){
		int a[]= {6,7,8,9,10,11,1};
		int index = searchRotatedSorted(a,1);
		if(index != - 1)
			System.out.println("Element found at index " + index);
		else
			System.out.println("Element not found");
	}
	
	private static int searchRotatedSorted(int a[], int key){
		int low = 0;
		int high = a.length -1;
		while(low <= high){
			int mid = low + ((high-low)/2);
			
			if(a[mid]== key )
				return mid;
			else if(a[low] <= a[mid]){
				if(key >= a[low] && key < a[mid])
					high = mid -1;
				else
					low = mid +1;
			}
			else {
				if(key > a[mid] && key <= a[high])
					low = mid + 1;
				else
					high = mid -1;
			}
		}
		
		return -1;
	}
}