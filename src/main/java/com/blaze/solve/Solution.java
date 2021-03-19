package com.blaze.solve;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author ServiceYun
 * @date 2021/3/18 11:02
 */
public class Solution {

	/**
	 * LeetCode 1
	 */
	public int[] twoSum(int[] nums, int target) {
		if (nums == null || nums.length == 0) return new int[0];
		Map<Integer, Integer> hashMap = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (hashMap.containsKey(target - nums[i])) {
				return new int[]{hashMap.get(target - nums[i]), i};
			}
			hashMap.put(nums[i], i);
		}

		// int n = nums.length;
		// for (int i = 0; i < n; i++) {
		//     for (int j = i + 1; j < n; j++) {
		//         if (nums[i] + nums[j] == target) {
		//             return new int[]{i, j};
		//         }
		//     }
		// }
		return new int[0];
	}

	/**
	 * LeetCode 2
	 */
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode head = null, tail = null;
		int carry = 0;
		while (l1 != null || l2 != null) {
			int n1 = l1 != null ? l1.val : 0;
			int n2 = l2 != null ? l2.val : 0;
			int sum = n1 + n2 + carry;
			if (head == null) {
				head = tail = new ListNode(sum % 10);
			} else {
				tail.next = new ListNode(sum % 10);
				tail = tail.next;
			}
			carry = sum / 10;
			if (l1 != null) {
				l1 = l1.next;
			}
			if (l2 != null) {
				l2 = l2.next;
			}
		}
		if (carry > 0) {
			tail.next = new ListNode(carry);
		}
		return head;
	}

	/**
	 * LeetCode 3
	 */
	public int lengthOfLongestSubstring(String s) {
		if (s == null || s.length() == 0) return 0;
		Set<Character> set = new HashSet<>();
		int n = s.length();
		int rk = -1, ans = 0;
		for (int i = 0; i < n; i++) {
			if (i != 0) {
				set.remove(s.charAt(i - 1));
			}
			while (rk + 1 < n && !set.contains(s.charAt(rk + 1))) {
				set.add(s.charAt(rk + 1));
				rk++;
			}
			ans = Math.max(ans, rk - i + 1);
		}

		return ans;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();

//		ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
//		ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
//		ListNode l3 = new Solution().addTwoNumbers(l1, l2);
//		while (l3 != null) {
//			System.out.print(l3.val);
//			l3 = l3.next;
//		}

		System.out.println(solution.lengthOfLongestSubstring("dvdf"));
	}
}
