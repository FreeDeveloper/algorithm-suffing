package cn.smile.common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 求给定字符的全排列
 * https://leetcode-cn.com/problems/permutations/solution/quan-pai-lie-by-leetcode/
 * */
public class QuanPaiLieSolution {
    public void backtrack(int n,
                          ArrayList<String> nums,
                          List<List<String>> output,
                          int first) {
        // if all integers are used up
        if (first == n)
            output.add(new ArrayList<String>(nums));
        for (int i = first; i < n; i++) {
            // place i-th integer first
            // in the current permutation
            Collections.swap(nums, first, i);
            // use next integers to complete the permutations
            backtrack(n, nums, output, first + 1);
            // backtrack
            Collections.swap(nums, first, i);
        }
    }

    public List<List<String>> permute(String[] nums) {
        // init output list
        List<List<String>> output = new LinkedList();

        // convert nums into list since the output is a list of lists
        ArrayList<String> nums_lst = new ArrayList<String>();
        for (String num : nums)
            nums_lst.add(num);

        int n = nums.length;
        backtrack(n, nums_lst, output, 0);
        return output;
    }

}
