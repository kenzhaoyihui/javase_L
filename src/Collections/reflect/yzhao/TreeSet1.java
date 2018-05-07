package Collections.reflect.yzhao;

import java.util.Comparator;
import java.util.TreeSet;

class Emp implements Comparable<Emp>{
    private int id;
    private String name;
    private int salary;

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public int getSalary() {
        return salary;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Emp(int id, String name, int salary){
        super();
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String toString() {
        //return super.toString();
        return "{Number: " + this.id + " Name: " +this.name + " Salary: " + this.salary + "}";
    }

    @Override
    public int compareTo(Emp o) {
        return this.salary - o.salary;
    }
}

class MyComparator implements Comparator{

    @Override
    public int compare(Object o1, Object o2) {
        if (o1 instanceof Emp && o2 instanceof Emp){
            Emp emp1 = (Emp) o1;
            Emp emp2 = (Emp) o2;
            return emp1.getId() - emp2.getId();
        }else{
            throw new ClassCastException("Cannot cast to Emp...");
        }
    }
}


public class TreeSet1 {
    public static void main(String[] args){
        MyComparator myComparator = new MyComparator();

        TreeSet tree1 = new TreeSet();

        TreeSet tree2 = new TreeSet(myComparator);

        Emp emp1 = new Emp(200, "zyh", 10000);
        Emp emp2 = new Emp(100, "lj", 20000);
        Emp emp3 = new Emp(300, "hah", 30000);

        tree1.add(emp1);
        tree1.add(emp2);
        tree1.add(emp3);

        tree2.add(emp1);
        tree2.add(emp2);
        tree2.add(emp3);

        System.out.println(tree1);

        System.out.println(tree2);

    }



}
