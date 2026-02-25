package exception;
public class chkSum {
	
	public static void main(String[] args)
	{
		int a[] = {1,0,-2,5};
	    int x = 3;
	    boolean b=chkSum(a,x);
	}
	
   

    
	
	static boolean chkSum(int a[],int x)
	{
		int arrLen=a.length;
		for(int i=0;i<arrLen;i++)
		{
			for(int j=1;j<arrLen-1;j++)
			{
				if(a[i]+a[j]==x)
				{
					System.out.println(a[i]+"and"+a[j]);
					return true;
					
				}
		    }
		}
		return false;
	}
	

}
