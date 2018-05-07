package Collections.reflect.yzhao;


import sun.reflect.generics.tree.Tree;

import java.util.Comparator;
import java.util.TreeSet;

class Person implements Comparable{
    private int id;
    private String name;

    public Person(int id, String name){
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

//    @Override
//    public int compareTo(Object o) {
//        return 0;
//    }


    @Override
    public int hashCode() {
        //return super.hashCode();
        return this.id;
    }

    @Override
    public boolean equals(Object obj) {
        //return super.equals(obj);
        if (!(obj instanceof Person)){
            return false;
        }

        Person person = (Person) obj;

        if (this.id == person.id){
            return true;
        }

        return false;
    }

    @Override
    public String toString() {
        //return super.toString();
        return "(" + this.id + ", " + this.name + ")";
    }

    @Override
    public int compareTo(Object o) {
        //return this;
        if (o instanceof Person){
            Person person = (Person) o;
            return this.id - person.id;
        }else{
            throw new ClassCastException("Cannot cast to the Person class...");
        }
    }
}


class MyCompare implements Comparator<Person>{
    @Override
    public int compare(Person o1, Person o2) {
        return o1.getName().length() - o2.getName().length();
    }
}

public class ComparatorLambda {
    public static void main(String... args){

        MyCompare myCompare = new MyCompare();
        //TreeSet<Person> set1 = new TreeSet<>(Comparator.comparing(Person::getName));

        TreeSet<Person> set2 = new TreeSet<>(Comparator.comparing(Person::getName));
        TreeSet<Person> set1  =  new TreeSet<>(myCompare);
        set1.add(new Person(2, "zyh"));
        set1.add(new Person(1, "lj"));
        set1.add(new Person(4, "hah"));
        set1.add(new Person(10, "hahahaha"));
        set1.add(new Person(5, "zzzz"));
        set1.add(new Person(3, "qqqqqqqqqqqqqqqqqqqqqqqqqqq"));

        set2.add(new Person(2, "zyh"));
        set2.add(new Person(1, "lj"));
        set2.add(new Person(4, "hah"));
        set2.add(new Person(10, "hahahaha"));
        set2.add(new Person(5, "zzzz"));
        set2.add(new Person(3, "qqqqqqqqqqqqqqqqqqqqqqqqqqq"));

        System.out.println(set1);

        System.out.println(set2);
    }
}
