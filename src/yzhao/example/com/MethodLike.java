package yzhao.example.com;

class TestMethod{
    static <T, V extends T> boolean isTn(T x, V[] y){
        for(int i=0; i<y.length; i++){
            if (x.equals(y[i])){
                return true;
            }
        }

        return false;
    }
}


public class MethodLike {
    public static void main(String... args){
        Integer nums[] = {1,2,3,4,5};

        if (TestMethod.isTn("2", nums)){
            System.out.println("2 is in nums");
        }

        String strs[] = {"one", "two", "three"};
        if (TestMethod.isTn("two", strs)){
            System.out.println("not in strs");
        }
    }
}
