package yzhao.example.com;

class Employee{
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void print(){
        System.out.println(name);
    }
}

class Manager extends Employee{
    private final static int x = 1;

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    @Override
    public void print(){
        super.print();
        System.out.println("X :" + x);
    }
}


public class TestIher {
    public static void main(String[] args){
        Employee employee = new Employee();
        Manager manager = new Manager();

        employee.setName("Yzhao");
        manager.setName("yzhao");
        employee.print();
        manager.print();

        Employee e = new Manager();
        e.setName("haha");
        e.print();
        System.out.println(e.getClass());

        Manager mgr = new Manager();
        Employee emp = mgr;

        Employee ee = new Employee();

        System.out.println(emp.getClass());

        if (emp instanceof Manager){
            mgr = (Manager) emp;
            System.out.println(mgr.getClass());
        }else{
            System.out.println("failed");
        }

//        Manager m = (Manager) new Employee();
//        m.setName("hhhhhh");
//        m.print();
    }
}
