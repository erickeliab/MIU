public interface IPerson {

    public default void myDefault(){
        System.out.println("From default method");
    }

    public static void myStatic(){
        System.out.println("From static method");
    }

    abstract void myAbstract();

}