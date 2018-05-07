package yzhao.example.com;

class Test{
    private int value = 1;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public class Inner{
        private int value = 2;

        public void printValue(){
            System.out.println(value);
            System.out.println(this.value);
            System.out.println(Inner.this.value);
            System.out.println(Test.Inner.this.value);
            System.out.println(Test.this.value);
        }
    }

    public void printValue(){
        System.out.println("Outer: " + value);
    }

}

public class InnerClassObject1 {

    public static void main(String[] args){
        Test test = new Test();
        Test.Inner inner = test.new Inner();

        test.printValue();
        inner.printValue();
    }
}
