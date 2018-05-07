package yzhao.example.com;

enum LLL{
    LOW("Low level", 30){
        public double getDistance(){
            return 30.0;
        }
    },

    MEDIUM("Medium Level", 15){
        public double getDistance(){
            return 15.0;
        }
    },

    HIGH("High Level", 44){
        public double getDistance(){
            return 44.0;
        }
    },

    URGENT("Urgent Level", 56){
        public double getDistance(){
            return 56.0;
        }
    };

    private int levelValue;
    private String description;

    private LLL(String description, int levelValue){
        this.description = description;
        this.levelValue = levelValue;
    }

    public int getLevelValue() {
        return levelValue;
    }

    @Override
    public String toString(){
        return this.description;
    }

    public abstract double getDistance();
}


public class EnumLevel {
    public static void main(String[] args){
        for(LLL s: LLL.values()){
            System.out.println("LEVEL: " + s.getLevelValue() + " ; Distance: " + s.getDistance());
        }
    }
}
