package exception;

public class ViewDay2P1MoveZeroToEndArray {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[]= {0,23,0,0,4,50,45};
		
		//following approach does not work with continuous 0
	/*	for(int i=0; i<a.length;i++)
		{ int temp=a[i];
			if(a[i]==0) {
				for(int j=i; j<a.length-1;j++)
				{
					a[j]=a[j+1];
				}
				a[a.length-1]=temp;
			}
		}*/
		
		int index = 0;

		for (int i = 0; i < a.length; i++) {
		    if (a[i] != 0) { // also think notequl logic while thing equal 
		        a[index] = a[i];
		        index++;
		    }
		}

		while (index < a.length) {
		    a[index++] = 0;
		}
		
		for(int j :a) {
			System.out.println(j);
		}
		
	}
}
