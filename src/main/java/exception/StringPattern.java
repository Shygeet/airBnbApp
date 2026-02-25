package exception;

public class StringPattern {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String str="s1ivanshu";
		System.out.println(str.charAt(1));
		if(str.charAt(1) % 2==0)
		{
			System.out.println("inside if");
		}
		String newStr="";
		
		removecharFromString(str,newStr);
		newStr=removesubstrFromString(str);
		System.out.println(newStr);

	}
	
	private static String removesubstrFromString(String str) {
		if(str.isEmpty())
		{
			return "";
		}
		if(str.startsWith("shiv"))
		{
			return removesubstrFromString(str.substring(5));
		}
		else
		{
			return str.charAt(0)+ removesubstrFromString(str.substring(1));
		}
	}

	public static void removecharFromString(String str ,String newStr)
	{
		if(str.isEmpty())
		{
			System.out.println(newStr);
			return;
		}
		
		char ch=str.charAt(0);
		if(ch=='s')
		{
			removecharFromString(str.substring(1),newStr);
		}
		else
		{
			removecharFromString(str.substring(1),newStr+ch);
		}
		
	}

}
