package exception;


class Employee2 implements Cloneable {

    int id;
    String name;

    Employee2(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // 1️⃣ toString()
    @Override
    public String toString() {
        return "Employee2{id=" + id + ", name='" + name + "'}";
    }

    // 2️⃣ equals()
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Employee2)) return false;
        Employee2 e = (Employee2) obj;
        return id == e.id && name.equals(e.name);
    }

    // 3️⃣ hashCode()
    @Override
    public int hashCode() {
        return id + name.hashCode();
    }

    // 5️⃣ clone()
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    // 6️⃣ finalize() (Deprecated – for demo only)
    @Override
    protected void finalize() {
        System.out.println("Finalize called");
    }
}

public class ViewObjectClassMethods {

    public static void main(String[] args) throws Exception {

        // Create objects
        Employee2 e1 = new Employee2(1, "John");
        Employee2 e2 = new Employee2(1, "John");

        // equals() vs ==
        System.out.println("equals(): " + e1.equals(e2));
        System.out.println("== : " + (e1 == e2));

        // hashCode()
        System.out.println("hashCode e1: " + e1.hashCode());
        System.out.println("hashCode e2: " + e2.hashCode());

        // toString()
        System.out.println("toString(): " + e1);

        // getClass()
        System.out.println("getClass(): " + e1.getClass().getName());

        // clone()
        Employee2 e3 = (Employee2) e1.clone();
        System.out.println("Cloned object: " + e3);

        // wait(), notify(), notifyAll()
        final Object lock = new Object();

        Thread t1 = new Thread(() -> {
            synchronized (lock) {
                try {
                    System.out.println("Thread waiting...");
                    lock.wait();
                    System.out.println("Thread resumed");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (lock) {
                System.out.println("Notifying thread");
                lock.notify();
            }
        });

        t1.start();
        Thread.sleep(1000);
        t2.start();

        // finalize() demo (NOT guaranteed)
        e1 = null;
        e2 = null;
        System.gc();
    }
}

