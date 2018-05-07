package yzhao.redhat.com;

class MaxTest{
    public int max(int n1, int n2, int... m){
        int max = n1>n2?n1:n2;
        if (m.length == 2){
            return max;
        }else{
            for(int i: m){
                if(i>max){
                    max = i;
                }
            }
        }

        return max;
    }
}


public class Max {
    public static void main(String... args){
        MaxTest max1 = new MaxTest();
        System.out.println(max1.max(9,7));
        System.out.println(max1.max(1,2,3,4,5));


    }
}
