package yzhao.example.com;

public class InnerClass {
    public static void main(String... args) {
        int x;
        final int y = 2;

        {
            x = 101;
        }

        class LocalInner {
            final static int z = 20;

            // inner class cannot have the static declaration, but can have the "final static int x = 20;"

//            static void fun(){
//                System.out.println("Hello");
//            }
//
            void print() {
                System.out.println("x = " + x);
                System.out.println("y = " + y);
                System.out.println("z = " + z);
            }
        }
        /*
         * Uncomment the following statement will make the variable x no longer
         * an effectively final variable and the LocalIneer class will not compile.
         */
        //x = 100;

        LocalInner li = new LocalInner();
        li.print();
    }
}