package Collections.reflect.yzhao;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

class CompareablePerson implements Comparable<CompareablePerson>{
    private int id;
    private String name;

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CompareablePerson(int id, String name){
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "{id: " + this.id + ", name: " + this.name + "}";
        //return super.toString();
    }

    @Override
    public int hashCode() {
        return this.id;
        //return super.hashCode();
    }

    @Override
    public int compareTo(CompareablePerson o) {
        int cpId = o.getId();
        String cpName  = o.getName();

        if(this.getId()< cpId){
            return -1;
        }

        if(this.getId() > cpId){
            return 1;
        }

        if(this.getId() == cpId){
            return this.getName().compareTo(cpName);
        }
        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof CompareablePerson)){
            return false;
        }

        CompareablePerson compareablePerson = (CompareablePerson) obj;
        if (this.id == compareablePerson.getId()){
            return true;
        }
        return false;
        //return super.equals(obj);
    }
}


class MyCompareable implements Comparator<CompareablePerson>{
    @Override
    public int compare(CompareablePerson o1, CompareablePerson o2) {
        //return 0;
        if (o1.getId() < o2.getId()){
            return -1;
        }

        if(o1.getId() > o2.getId()){
            return 1;
        }

        if(o1.getId() == o2.getId()){
            return o1.getName().compareTo(o2.getName());
        }

        return 0;
    }
}
public class PriorityQueue2 {
    public static void main(String[] args){
        int initialCapacity = 5;

        Comparator<CompareablePerson> comparator1 = Comparator.comparing(CompareablePerson::getName);

        MyCompareable compareable2 = new MyCompareable();

        Queue<CompareablePerson> pq1 = new PriorityQueue<>(initialCapacity, comparator1);
        Queue<CompareablePerson> pq2 = new PriorityQueue<>(compareable2);

        pq1.add(new CompareablePerson(1, "Qracle"));
        pq1.add(new CompareablePerson(4, "XML"));
        pq1.add(new CompareablePerson(2, "HTML"));
        pq1.add(new CompareablePerson(3, "CSS"));
        pq1.add(new CompareablePerson(4, "Java"));


        pq2.add(new CompareablePerson(1, "Qracle"));
        pq2.add(new CompareablePerson(4, "XML"));
        pq2.add(new CompareablePerson(2, "HTML"));
        pq2.add(new CompareablePerson(3, "CSS"));
        pq2.add(new CompareablePerson(4, "Java"));


        System.out.println("Priority queue1: " + pq1);
        System.out.println("Priority queue2: " + pq2);

        while (pq1.peek() != null){
            System.out.println("Head element: " +  pq1.peek());
            pq1.remove();
            System.out.println("Priority queue: " + pq1);
        }

        System.out.println("-------------------------------------------------");
        while (pq2.peek() != null){
            System.out.println("HEad2 Element: " +  pq2.peek());
            pq2.remove();
            System.out.println("Priority Queue: " + pq2);
        }


     }

}
