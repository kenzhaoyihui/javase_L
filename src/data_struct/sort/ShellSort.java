package data_struct.sort;

import java.util.Arrays;

/**
 * Unstable
 * O(nlogn)
 */
public class ShellSort {

    public static void shellSort(int[] a){
        int len = a.length;


        while (len>=1){
            len = len/2;

            for (int i=0; i<len; i++){
                for (int j=i+len;j<a.length; j+=len){

                    int k = j-len;//k为有序序列最后一位的位数
                    int temp = a[j];

                    while (k>=0&&temp<a[k]){
                        a[k+len] = a[k];
                        k -= len;
                    }

                    a[k+len] = temp;
                }
            }

        }

    }

    public static void main(String[] args){
        int[] a = {54, 35, 48, 36, 27, 12, 44, 44, 8, 14, 26, 17, 28};
        shellSort(a);

        System.out.println(Arrays.toString(a));
    }
}
