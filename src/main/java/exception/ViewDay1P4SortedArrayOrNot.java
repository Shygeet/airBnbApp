package exception;

public class ViewDay1P4SortedArrayOrNot {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[]= {0,1,2,4};
		
		//int i = 0;
		boolean isSorted = true;

		/*while (i < a.length - 1) {
		    if (a[i] > a[i + 1]) {
		        isSorted = false;
		        break;
		    }
		    i++;
		}*/
		for (int i = 0; i < a.length - 1; i++) {
		    if (a[i] > a[i + 1]) {
		        isSorted = false;
		        break;
		    }
		}
		System.out.println(isSorted ? "sorted" : "not sorted");
	
	}
}
