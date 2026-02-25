package exception;

public class ViewDay1P2ReverseArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[]= {0,23,2,4,50,45};
		
		
		/*wrong logic need to use two pinters or 
		 * for(int j=a.length-1;j>=0;j--) { a[i]=a[j]; System.out.println(a[i]); i++;
		 * 
		 * }
		 */
		int[] rev = new int[a.length];

		int i = 0;
		for (int j = a.length - 1; j >= 0; j--) {
		    rev[i++] = a[j];
		}

		System.out.print("using new array");
		for (int x : rev) {
		    System.out.print(x + " ");
		}
		
		
		System.out.print("Using double pointers");
		int ii = 0; int jj = a.length - 1;

		while (ii < jj) {
		    int temp = a[ii];
		    a[ii] = a[jj];
		    a[jj] = temp;
		    ii++;
		    jj--;
		   
		}
		for (int x : a) {
		    System.out.print(x + " ");
		}
		
		//3rf way using collections.reverse

	}

}
