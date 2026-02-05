package top.tangtian.algorithm.binarysearch;

/**
 * @program: algorithm-journey
 * @description: 二分查找
 * @author: tangtian
 * @create: 2026-02-05 16:19
 **/
public class Search {

    /**
     * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target ，
     * 写一个函数搜索 nums 中的 target，如果 target 存在返回下标，否则返回 -1。
     * @param nums 给定一个 n 个元素有序的（升序）整型数组 nums
     * @param target 一个目标值 target
     * @return 如果 target 存在返回下标，否则返回 -1。
     */
   public int search(int[] nums, int target){
       int n = nums.length;
       int left = 0, right = n - 1;
       while(left <= right){
           int mid = left + (right - left) / 2;
           int midValue = nums[mid];
           if(target < midValue){
               right = mid - 1;
           }else if(target > midValue){
               left = mid + 1;
           }else {
               return  mid;
           }
       }
       return  -1;
   }
}
