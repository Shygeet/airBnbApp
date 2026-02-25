package exception;

class MyResource implements AutoCloseable {
    @Override
    public void close() {
        System.out.println("Resource closed");
    }
}


public class ViewExceptionHandling {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		try-with-resources closes resources BEFORE control enters catch or finally
		try(MyResource r = new MyResource())
		{
			ViewExceptionHandling v= new ViewExceptionHandling();
			//v=null;
			v.toString();
			
		}
		catch(Exception e)
		{
			System.out.println("Error occured");
			e.printStackTrace();
			System.exit(0);
		}
		/*
		 * finally block executes in all cases except when System.exit() is called, JVM
		 * crashes, or the thread is forcibly terminated.
		 */
		finally {
            System.out.println("Finally block executed"); // ❌ WILL NOT RUN
        }
	}

}
