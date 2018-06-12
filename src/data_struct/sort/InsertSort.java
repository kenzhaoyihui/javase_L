package data_struct.sort;

/**
 * Stable
 * O(n^2)
 */

public class InsertSort {

    public static void insertSort(int[] a){
        int len = a.length;
        int insertNum;

        for (int i=1; i<len; i++){
            insertNum = a[i];

            int j;

            for(j=i; j>0&&insertNum<a[j-1];j--){
                a[j] = a[j-1];
            }


            a[j] = insertNum;
        }

    }

    public void print(int[] a) {
        for (int i=0; i<a.length; i++){
            System.out.print(a[i] + " ");
        }
    }

    public static void main(String[] args){
        int[] a = {12, 2, 34, 1, 65, 24, 76, 0};

        InsertSort obj = new InsertSort();
        obj.print(a);

        insertSort(a);

        System.out.println("\n");
        obj.print(a);



    }

}
