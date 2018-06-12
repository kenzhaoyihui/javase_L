package data_struct.sort;

import java.util.Arrays;

/**
 * Stable
 * O(n^2)
 */
public class SelectSort {

    public static void selectSort(int[] a){

        int len = a.length;
        for (int i=0; i<len; i++){
            int value = a[i];
            int position = i;

            for (int j=i+1; j<len; j++){
                if (a[j]<value){
                    value = a[j];
                    position = j;
                }
            }

            a[position] = a[i];
            a[i] = value;
        }
    }

    public static void main(String[] args){
        int[] a = {54, 35, 48, 36, 27, 12, 44, 44, 8, 14, 26, 17, 28};

        selectSort(a);
        System.out.println(Arrays.toString(a));
    }
}
