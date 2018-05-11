package StreamIO.yzhao.com;

import java.io.*;

class Person implements Serializable{
    private int age;
    private String name;
    private String sex;

    public Person(int age, String name, String sex){
        this.age = age;
        this.name = name;
        this.sex = sex;
    }

    @Override
    public String toString() {
        //return super.toString();
        return "Name: " + this.name + " , Age: " + this.age + ", Sex: " + this.sex;
    }
}

public class ObjectStream1 {
    public static void main(String[] args){
        Person p1= new Person(23, "zyh", "male");
        Person p2 = new Person(23, "lj", "female");
        Person p3 = new Person(6, "OurChild", "male");

        //File fileOject = new File("person.txt");
        try{
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("person.txt"));

            objectOutputStream.writeObject(p1);
            objectOutputStream.writeObject(p2);
            objectOutputStream.writeObject(p3);

            objectOutputStream.flush();
            objectOutputStream.close();
        }catch (IOException e){
            e.printStackTrace();
        }

        try{
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("person.txt"));


            Person x = (Person) objectInputStream.readObject();
            Person y = (Person) objectInputStream.readObject();
            Person z = (Person) objectInputStream.readObject();
            //Person z1 = (Person) objectInputStream.readObject();

            System.out.println(x);
            System.out.println(y);
            System.out.println(z);
            //System.out.println(z1);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
