package lettcode1_10.two_sum;

import java.util.HashMap;

public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] res = twoSum(nums, target);
        System.out.print("[ ");
        for (int i: res){
            System.out.print(i + " ");
        }
        System.out.print("]");
    }

    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        int res[] = {0, 0};

        for (int i=0; i<nums.length; i++){
            if (map.get(nums[i]) != null) {
                res[0] = map.get(nums[i]);
                res[1] = i;
                return res;
            }

            map.put(target-nums[i], i);
        }

        return res;
    }
}
