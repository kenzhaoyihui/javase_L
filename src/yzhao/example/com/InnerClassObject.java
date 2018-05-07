package yzhao.example.com;

public class InnerClassObject {
    public static void main(String[] args) {
        //Car c = new Car();

        Car.Tire t = new Car().new Tire(9);
        System.out.println(t);

    }
}
class Car {
    public class Tire {
        private int size;

        public Tire(int size) {
            this.size = size;
        }

        public String toString() {
            return "Monitor   - Size:" + this.size + "  inch";
        }
    }

}