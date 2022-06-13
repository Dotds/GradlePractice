package leetCode;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author lyx
 */
public class leetCode {
    public static void main(String[] args) {
        //1.两数之和
        //System.out.println(Arrays.toString(twoSum(new int[]{2, 5, 5, 11}, 10)));

        //2.回文数
        //System.out.println(isPalindrome(11));

        //3.删除数组重复元素，并返回数组长度
        //removeDuplicates(new int[]{1, 1, 2, 2, 3});

        //4.股票最大利益
        //maxProfit(new int[]{7,1,5,3,6,4});

        //5.旋转数组
        //rotate(new int[]{1,2,3,4,5,6,7}, 3);

        //6.判断重复数组
        //System.out.println(containsDuplicate(new int[]{1,1,1,3,3,4,3,2,4,2}));

        //7.找出只出现一次的数字
        //singleNumber(new int[]{1, 3, 2, 4, 5});

        //8.给定罗马数输出数字
        //System.out.println(romanToInt("MCMXCIV"));

        //输出最长公共前缀
        //String[] strs = {"flower","flow","flight"};
        //System.out.println(longestCommonPrefix(strs));

        //删除重复数组元素，输出长度
        //System.out.println(removeElement(new int[]{3, 2, 2, 3},3));
        int len = removeElement(new int[]{0,1,2,2,3,0,4,2},2);
        System.out.println(len);
    }

    /**
     * 1。两数之和
     * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
     * 输入：nums = [2,7,11,15], target = 9
     * 输出：[0,1]
     * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/two-sum
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    private static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (nums[i] + nums[j] == target && i != j) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }

    /**
     * 2.回文数
     * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
     * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
     * 例如，121 是回文，而 123 不是。
     * 示例 1：
     * 输入：x = 121
     * 输出：true
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/palindrome-number
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * String temperature = String.valueOf(msg).substring(1, 5);
     */
    private static boolean isPalindrome(int x) {
        String a = String.valueOf(x);
        List<String> list1 = new ArrayList<String>();
        List<String> list2 = new ArrayList<>();
        for (int i = 0; i < a.length(); i++) {
            String b = a.substring(i, i + 1);
            list1.add(b);
        }
        for (int j = a.length(); j > 0; j--) {
            String c = a.substring(j - 1, j);
            list2.add(c);
        }
        return list1.equals(list2);
    }

    /**
     * 3.给你一个 升序排列 的数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。元素的 相对顺序 应该保持 一致 。
     * 由于在某些语言中不能改变数组的长度，所以必须将结果放在数组nums的第一部分。更规范地说，如果在删除重复项之后有 k 个元素，那么 nums 的前 k 个元素应该保存最终结果。
     * 将最终结果插入 nums 的前 k 个位置后返回 k 。
     * 输入：nums = [1,1,2]
     * 输出：2, nums = [1,2,_]
     * 解释：函数应该返回新的长度 2 ，并且原数组 nums 的前两个元素被修改为 1, 2 。不需要考虑数组中超出新长度后面的元素。
     * 作者：力扣 (LeetCode)
     * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x2gy9m/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x2gy9m/
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    private static int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int x = 0;
        //新数组长度
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0, k = 0; j < nums.length; j++) {
                if (nums[i] == nums[j] && i < j) {
                    x = x + 1;
                }
            }
        }
        int[] new_nums = new int[nums.length - x];
        int k = 0;
        new_nums[0] = nums[0];
        //复制元素到新数组
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] != nums[i]) {
                new_nums[k + 1] = nums[i];
                k++;
            }
        }
        System.out.println(k + 1);
        //{1,2,1,3,4,4,5})
        System.out.println(x + "个重复元素");
        System.out.println("前:" + Arrays.toString(nums));
        System.out.println("后:" + Arrays.toString(new_nums));
        //String a = new_nums.length + ", nums = " + Arrays.toString(new_nums);
        return k + 1;
    }

    /**
     * 4.给定一个数组 prices ，其中 prices[i] 表示股票第 i 天的价格。
     * 在每一天，你可能会决定购买和/或出售股票。你在任何时候 最多 只能持有 一股 股票。你也可以购买它，然后在 同一天 出售。
     * 返回 你能获得的 最大 利润 。
     * 示例 1:
     * 输入: prices = [7,1,5,3,6,4]
     * 输出: 7
     * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
     *      随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
     * 作者：力扣 (LeetCode)
     * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x2zsx1/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    private static int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        //[7,1,5,3,6,4]
        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i - 1] < prices[i]) {
                max = max + (-prices[i - 1] + prices[i]);
            }
        }
        System.out.println(max);
        return max;
    }

    /**
     * 5.给你一个数组，将数组中的元素向右轮转 k个位置，其中k是非负数。
     * 输入: nums = [1,2,3,4,5,6,7], k = 1
     * 输出: [5,6,7,1,2,3,4]
     * 作者：力扣 (LeetCode)
     * 链接：https://leetcode--cn.com/leetbook/read/top-interview-questions-easy/x2skh7/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    private static void rotate(int[] nums, int k) {

        for (int j = 0; j < k; j++) {
            int a = nums[nums.length - 1];
            for (int i = nums.length - 1; i > 0; i--) {
                nums[i] = nums[i - 1];
            }
            nums[0] = a;
        }
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 6.判断重复数组
     * 给你一个整数数组 nums 。如果任一值在数组中出现 至少两次 ，返回 true ；如果数组中每个元素互不相同，返回 false 。
     *
     * @param nums
     * @return
     */
    private static boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);//降序排列数组数字
        int b = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] == nums[i]) {
                b++;
            }
        }
        return b > 0;
    }

    /**
     * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
     * 输入: [2,2,1]  {4, 1, 2, 1, 2} [1, 1, 2, 2, 4]
     * 输出: 1
     */
    private static int singleNumber(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result ^= nums[i];
        }
        System.out.println(result);
        return result;
    }

    /**
     * 例如， 罗马数字 2 写做 II ，即为两个并列的 1 。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
     * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
     * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
     * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
     * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
     * 给定一个罗马数字，将其转换成整数。
     * 输入: s = "III"
     * 输出: 3
     */
    private static int romanToInt(String s) {
        int num = 0;
        List<String> romeIn = Stream.iterate(0, n -> ++n).limit(s.length()).map(n -> "" + s.charAt(n)).collect(Collectors.toList());
        Integer[] change = new Integer[romeIn.size()];
        for (int i = 0; i < romeIn.size(); i++) {
            if ("I".equals(romeIn.get(i))) {
                if (i != romeIn.size() - 1) {
                    if ("V".equals(romeIn.get(i + 1)) || "X".equals(romeIn.get(i + 1))) {
                        romeIn.set(i, String.valueOf(-1));
                    } else {
                        romeIn.set(i, String.valueOf(1));
                    }
                } else {
                    romeIn.set(i, String.valueOf(1));
                }
                change[i] = Integer.valueOf(romeIn.get(i));
            }
            if ("V".equals(romeIn.get(i))) {
                romeIn.set(i, String.valueOf(5));
                change[i] = Integer.valueOf(romeIn.get(i));
            }
            if ("X".equals(romeIn.get(i))) {
                if (i != romeIn.size() - 1) {
                    if ("L".equals(romeIn.get(i + 1)) || "C".equals(romeIn.get(i + 1))) {
                        romeIn.set(i, String.valueOf(-10));
                    } else {
                        romeIn.set(i, String.valueOf(10));
                    }
                } else {
                    romeIn.set(i, String.valueOf(10));
                }
                change[i] = Integer.valueOf(romeIn.get(i));
            }
            if ("L".equals(romeIn.get(i))) {
                romeIn.set(i, String.valueOf(50));
                change[i] = Integer.valueOf(romeIn.get(i));
            }
            if ("C".equals(romeIn.get(i))) {
                if (i != romeIn.size() - 1) {
                    if ("D".equals(romeIn.get(i + 1)) || "M".equals(romeIn.get(i + 1))) {
                        romeIn.set(i, String.valueOf(-100));
                    } else {
                        romeIn.set(i, String.valueOf(100));
                    }
                } else {
                    romeIn.set(i, String.valueOf(100));
                }
                change[i] = Integer.valueOf(romeIn.get(i));
            }
            if ("D".equals(romeIn.get(i))) {
                romeIn.set(i, String.valueOf(500));
                change[i] = Integer.valueOf(romeIn.get(i));
            }
            if ("M".equals(romeIn.get(i))) {
                romeIn.set(i, String.valueOf(1000));
                change[i] = Integer.valueOf(romeIn.get(i));
            }
        }
        for (Integer integer : change) {
            num = num + integer;
        }
        System.out.println(Arrays.toString(change));
        return num;
    }

    /**
     * 根据逗号拆分字符串   ->   拆分每一个字母   ->    for循环比较
     *编写一个函数来查找字符串数组中的最长公共前缀。
     * 如果不存在公共前缀，返回空字符串""。
     * 输入：strs = ["flower","flow","flight"]
     * 输出："fl"
     * 示例 2
     * 输入：strs = ["dog","racecar","car"]
     * 输出：""
     * 解释：输入不存在公共前缀。
     */
    private static String longestCommonPrefix(String[] strs) {
        String local = "";
        List<List<String>> list = new ArrayList<>();
        for (String s : strs) {
            List<String> getChars = Stream.iterate(0, n -> ++n).limit(s.length()).map(n -> "" + s.charAt(n)).collect(Collectors.toList());
            list.add(getChars);
        }
        for (int i = 0; i < list.size(); i++) {
            Object one = list.get(i);
            System.out.println(one);

        }
        return local;
    }

    /*
      输入：nums = [3,2,2,3], val = 3
      输出：2, nums = [2,2]
      解释：函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。
      你不需要考虑数组中超出新长度后面的元素。例如，函数返回的新长度为 2 ，而 nums = [2,2,3,3] 或 nums = [2,2,0,0]，也会被视作正确答案。
     */
    private static int removeElement(int[] nums, int val) {
        int index = 0;
        for(int num : nums){
            if(num != val){
                nums[index++] = num;
                //System.out.println(nums[index++]);
            }
        }
        return index;
/*        List<Integer> list = new ArrayList<>();
        for (int numsVal : nums) {
            if (!(numsVal == val)) {
                list.add(numsVal);
            }
        }
        Integer[] integers  = list.toArray(new Integer[0]);
        int[] newNums = Arrays.stream(integers).mapToInt(Integer::valueOf).toArray();
        System.out.println(Arrays.toString(newNums));
        return newNums.length;*/

    }
}
