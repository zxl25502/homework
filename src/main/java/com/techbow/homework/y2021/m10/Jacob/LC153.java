package com.techbow.homework.y2021.m10.Jacob;

public class LC153 {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int left = 0;
        int right = nums.length -1;
        while (left + 1 < right) {
            int mid = left + (right - left) /2;
            if(nums[mid] > nums[nums.length -1]) {
                left = mid;
            } else {
                right = mid; //1
            }
        }
        if(nums[left] < nums[right]) { //compare left and right find minimun.
            return nums[left];
        } else {
            return nums[right];
        }
        //return nums[left];
    }
}

