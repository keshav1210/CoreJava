
public class LinearSerach {
	 public static int search(int arr[], int x) {
	int n=arr.length;
	for(int i=0;i<n;i++) {
		if(arr[i]==x) {
			return i;
		}
	}
	return -1;
	}
public static void main(String[] args) {
	int arr[]= {2,10,5,15,20};
	int x=0;
	   int result = search(arr, x);
       if (result == -1)
           System.out.print(
               "Element is not present in array");
       else
           System.out.print("Element is present at index "
                            + result);
   }
	
}

