package yzhao.example.com;

interface  Command{
    void execute();
}

//class Person{
//    public enum Level implements Command{
//        LOW{
//            public void execute(){
//                System.out.println("Low...");
//            }
//        },
//
//        HIGH{
//            public void execute(){
//                System.out.println("High...");
//            }
//        };
//
//    }
//}


enum Level implements Command{
    LOW{
        public void execute(){
            System.out.println("Low");
        }
    },

    HIGH{
        public void execute(){
            System.out.println("HIGH");
        }
    };
}

public class EnumCommand {
    public static void main(String [] args){
//        Person.Level l1 = Person.Level.LOW;
//        Person.Level l2 = Person.Level.HIGH;
//
//        l1.execute();
//        l2.execute();

        for (Level cmd: Level.values()){
            cmd.execute();
        }
    }
}
