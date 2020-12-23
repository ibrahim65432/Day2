import java.util.Arrays;

public class Solution {
    public int[] searchRange(int[] nums, int target) {
        //Base case.
        int[] sol = new int[]{-1,-1};
        //Looking for lower bound.
        int low = binarySearch(nums, target, true);
        //This will be true if Lowerbound was at the end of array or
        //the target was not found, so return the base case.
        if(low==nums.length||nums[low]!=target){
            return sol;
        }
        //This will be the Upperbound, we subtract by 1 since we
        //go 1 over.
        int high = binarySearch(nums, target, false)-1;

        //Solutions inserted.
        sol[0] = low;
        sol[1] = high;

        //Returning the solution.
        return sol;
    }
    /*We do binary search here, so nums is the original array, the target is the
    given number, and isLow is used to denote if the value is for the lower bound.
    What this algorithm does is that it finds the target value using LogN time by
    breaking up the algorithm by half every time we search, so instead of seeing
    every element, we only see LogN as much.
    */
    public int binarySearch(int[] nums, int target, boolean isLow){
        //Signifies the leftmost of the array.
        int low = 0;
        //Signifies the rightmost of the array.
        int high = nums.length;
        //We want to keep searching for values until there is truly none.
        while(low < high){
            //Half since the list is sorted, we can look at the middle to judge if we
            //should look left or right.
            int middle = (low + high)/2;
            //If the value in the array for middle is bigger than our target, we know
            //our target value is towards the left side of the array, so we make the
            //upper bound lower by making it equal to the middle, effectively cutting
            //the search by half. The next OR statement is for when the value is the target
            //and is found, but it is for the lowerbound, then we want to find if there are any
            //element on the lower side to see if there is the leftmost index for target.
            if(nums[middle] > target || isLow && nums[middle]==target){
                high = middle;
            }
            else{
                //The function will come here if the target is larger than the middle of the array,
                //so we should go up. Another case would be when the target is equal to the value in the
                //middle, but we want to see all possible values until we reach the rightmost value for the
                //target.
                low++;
            }
        }
        //Low will be our solution since we will increment it.
        return low;
    }
}
