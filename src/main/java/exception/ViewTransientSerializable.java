package exception;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class User implements Serializable {
	    int id;
	    String name;
	    transient String password;   // ❌ not serialized

	    User(int id, String name, String password) {
	        this.id = id;
	        this.name = name;
	        this.password = password;
	    }
	}

	public class ViewTransientSerializable {
	    public static void main(String[] args) throws Exception {

	        User u = new User(1, "Shivanshu", "secret123");

	        // Serialize
	        ObjectOutputStream out =
	                new ObjectOutputStream(new FileOutputStream("user.ser"));
	        out.writeObject(u);
	        System.out.println("Serialized value is "+out);
	        out.close();

	        // Deserialize
	        ObjectInputStream in =
	                new ObjectInputStream(new FileInputStream("user.ser"));
	        User u2 = (User) in.readObject();

	        System.out.println(u2.id);       // 1
	        System.out.println(u2.name);     // Shivanshu
	        System.out.println(u2.password); // null
//	        transient fields get default values after deserialization
//
//	        null, 0, false
	    }
	

}
