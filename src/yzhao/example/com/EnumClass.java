package yzhao.example.com;

enum Level1{
    LOW, MEDIUM, HIGH, URGENT;

}

public class EnumClass {
    public static void main(String[] args){
        Level1 s1 = Level1.LOW;
        Level1 s2 = Level1.HIGH;

        int diff = s1.compareTo(s2);

        if(diff>0){
            System.out.println(s1 + " occurs affter " + s2);
        }else{
            System.out.println(s1 + " occurs before " + s2);
        }
    }
}
