package nowcoder.com;

public class Find1 {
    public boolean Find(int[][] array, int target) {
        int i = 0;
        int len = array.length-1;

        while((len>=0)&& (i<array[0].length)) {
            if (array[len][i]>target){
                len--;
            }else if(array[len][i]<target){
                i++;
            }else {
                return true;
            }
        }
        return false;
    }
}
