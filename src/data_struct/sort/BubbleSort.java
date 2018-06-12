package data_struct.sort;

import java.util.Arrays;

/**
 * Stable
 * O(n^2)
 */
public class BubbleSort {

    public static void bubbleSort(int[] a){

        int len = a.length;

        for (int i=0; i<len; i++){
            for (int j=0; j<len-i-1; j++){
                if(a[j] > a[j+1]){
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                }
            }
        }
    }

    public static void main(String[] args){
        int[] a = {54, 35, 48, 36, 27, 12, 44, 44, 8, 14, 26, 17, 28};

        bubbleSort(a);
        System.out.println(Arrays.toString(a));
    }
}
