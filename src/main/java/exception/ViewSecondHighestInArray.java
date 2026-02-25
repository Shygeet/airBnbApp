package exception;

public class ViewSecondHighestInArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = {22, 3,45,-7,-1,17, 5};
		int max=Integer.MIN_VALUE;
		int secMax=Integer.MIN_VALUE;
		
		
	for( int i:a) {
		if(i>max) {
			secMax=max;
			max=i;
			
		}
		else if (secMax<i && i<max) {
			secMax=i;
		}
	}System.out.println(max+" "+secMax);
	}

}
