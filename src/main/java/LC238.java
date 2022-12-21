import java.util.Arrays;

public class LC238 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(productExceptSelf(new int[]{1, 2, 3, 4})));
        System.out.println(Arrays.toString(productExceptSelf(new int[]{-1,1,0,-3,3})));

        System.out.println(Arrays.toString(optimalProductExceptSelf(new int[] {1,2,3,4})));
        System.out.println(Arrays.toString(optimalProductExceptSelf(new int[] {-1,1,0,-3,3})));
    }

    //Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
    //
    //The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
    //
    //You must write an algorithm that runs in O(n) time and without using the division operation.


    //Example 1:
    //
    //Input: nums = [1,2,3,4]
    //Output: [24,12,8,6]
    //Example 2:
    //
    //Input: nums = [-1,1,0,-3,3]
    //Output: [0,0,9,0,0]
//Time and Space Complexity is O(n).
    public static int[] productExceptSelf(int[] nums){
        int[] left = new int[nums.length];
        left[0] = 1;
        int[] right = new int[nums.length];
        right[nums.length-1] = 1;

        for(int i  = 1;i<nums.length;i++){
            left[i] = left[i-1] * nums[i-1];
        }

        for(int i = nums.length-2;i>=0;i--){
            right[i] = right[i+1] * nums[i+1];
        }

        int[] ans = new int[nums.length];

        for(int i = 0;i<nums.length;i++){
            ans[i] = left[i] * right[i];
        }

        return ans;


    }

    //We can optimize for O(1) space
    //Time Complexity is still O(n)

    public static int[] optimalProductExceptSelf(int[] nums){
        //We can construct the product array on the fly, without storing
        //all of the prefix products in two separate arrays

        int[] answer = new int[nums.length];
        answer[0] = 1;
        //we have all of our left product prefixes
        for(int i = 1;i<nums.length;i++){
            answer[i] = answer[i-1] * nums[i-1];
        }

        //now we can store a variable that will update the right product prefix, and as we are updating it
        //we can reassign our answer array to match the final result of product prefix except self.

        int rPrefix = 1;

        for(int i = nums.length-1;i>=0;i--){
            answer[i] = answer[i] * rPrefix;
            rPrefix *= nums[i];
        }

        return answer;
    }
}
