package bear;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;


/**
 * @Auther: lyf
 * @Date: 2019-07-26 9:56
 * @Description:
 */
class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}

class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}

public class TestMain {

    @Test
    public void test() {
        System.out.println(countSituation(5, 2));
    }

    //正整数数对(x, y),x和y均不大于n, 并且x除以y的余数大于等于k
    //余数大于等于k(条件)
    public static long countSituation(int n, int k) {
        long count = 0;
        //y的取值必须大于k
        for (int y = k + 1; y <= n; y++) {
            //计算每一部分中余数大于k的取值情况,另一部分需要通过mod值来进行判断
            count += (n / y) * (y - k);
            //余数
            int mod = n % y;
            count += mod >= k ? (mod - k + 1) : 0;
        }
        if (k==0){
            count-=n;
        }
        return count;
    }

    public static String lastDirection(String direction) {
        char dir = 'N';
        for (int i = 0; i < direction.length(); i++) {
            if (direction.charAt(i) == 'L') {
                //向左转
                if (dir == 'E') {
                    dir = 'N';
                } else if (dir == 'W') {
                    dir = 'S';
                } else if (dir == 'S') {
                    dir = 'E';
                } else {
                    dir = 'W';
                }

            } else {
                //向右转
                if (dir == 'E') {
                    dir = 'S';
                } else if (dir == 'W') {
                    dir = 'N';
                } else if (dir == 'S') {
                    dir = 'W';
                } else {
                    dir = 'E';
                }
            }
        }
        return String.valueOf(dir);
    }

    //贪心算法,保证当前选择是最优选择就可以了
    public static int countLight(String road) {
        int count = 0;
        for (int i = 0; i < road.length(); i++) {
            if (road.charAt(i) == '.') {
                count++;
                i += 2;
            }
        }
        return count;
    }

    //求拼装数据范围内的被3整除的个数
    public int getResult(int l, int r) {
        if (l < 1 || r > Math.pow(10, 9) || l > r)
            return -1;
        int count = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < l; i++) {
            sb.append(i);
        }
        for (int i = l; i <= r; i++) {
            sb.append(i);
            Integer value = Integer.valueOf(sb.toString());
            if (value % 3 == 0) {
                count++;
            }
        }
        return count;
    }

    public void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int key : array) {
            Integer value = map.get(key);
            if (value == null) {
                map.put(key, 1);
            } else {
                map.put(key, value + 1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                if (num1[0] == 0) {
                    num1[0] = entry.getKey();
                } else {
                    num2[0] = entry.getKey();
                }
            }
        }
    }

    //判断输入二叉树是否是平衡二叉树
    //左子树一定比右子树小
    //两棵的高度差的绝对值不大于1
    public boolean IsBalanced_Solution(TreeNode root) {
        if (root == null)
            return true;
        //计算子树的深度适合从根节点出发
        //所以递归操作是从上往下
        int left = TreeDepth(root.left);
        int right = TreeDepth(root.right);
        if (Math.abs(left - right) > 1)
            return false;
        return IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right);
    }

    //求二叉树的深度
    public int TreeDepth(TreeNode root) {
        if (root == null)
            return 0;
        //每次取最长的路径作为深度
        return Math.max(TreeDepth(root.left), TreeDepth(root.right)) + 1;
    }

    public int FirstNotRepeatingChar(String str) {
        if (StringUtils.isBlank(str))
            return -1;
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            Integer value = map.get(str.charAt(i) + "");
            if (value != null) {
                map.put(str.charAt(i) + "", -1);
            } else {
                map.put(str.charAt(i) + "", i);
            }
        }
        List<Integer> list = map.values().stream().filter(e -> e >= 0).sorted().limit(1).collect(Collectors.toList());
        return list.get(0);
    }

    //输入数组{3,32,321},则打印出这三个数字能排成的最小数字为321323
    //动态拼装字符串进行比较
    public String PrintMinNumber(int[] numbers) {
        if (numbers == null || numbers.length == 0)
            return "";
        List<Integer> list = new ArrayList<>(numbers.length);
        for (int value : numbers) {
            list.add(value);
        }
        StringBuilder sb = new StringBuilder();
        Collections.sort(list, (o1, o2) -> {
            String str1 = o1 + "" + o2;
            String str2 = o2 + "" + o1;
            return str1.compareTo(str2);
        });
        for (Integer value : list) {
            sb.append(value);
        }
        return sb.toString();
    }


    //统计1-n之间所有出现的1的个数
    public int NumberOf1Between1AndN_Solution(int n) {
        if (n <= 0)
            return 0;
        int count = 0;
        while (n > 0) {
            String value = String.valueOf(n);
            for (int i = 0; i < value.length(); i++) {
                if (value.charAt(i) == '1')
                    count++;
            }
            n--;
        }
        return count;
    }

    //给一个数组，返回它的最大连续子序列的和
    public int FindGreatestSumOfSubArray(int[] array) {
        if (array == null || array.length == 0)
            return -1;
        if (array.length == 1)
            return array[0];
        int max = Integer.MIN_VALUE;
        int sum;
        for (int i = 0; i < array.length; i++) {
            sum = 0;
            for (int j = i; j < array.length; j++) {
                sum += array[j];
                if (sum > max) {
                    max = sum;
                }
                if (sum <= 0) {
                    break;
                }
            }
        }
        return max;
    }

    //输入n个整数,找出其中最小的K个数
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        //防止出现超出范围的情况
        if (k <= 0 && k > input.length)
            return new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>(k);
        for (int i = 0; i < k; i++) {
            list.add(getTheNumberKValue(input, i, 0, input.length - 1));
        }
        return list;
    }

    //获取到数组arr第k个大的数值
    private int getTheNumberKValue(int[] arr, int k, int start, int end) {
        //如果不存在就返回-1
        if (start > end)
            return -1;
        if (end > start) {
            //使选值具备随机性
            Random rand = new Random();
            //Random接收的参数不能小于等于0,否则将会出现异常
            swap(arr, rand.nextInt(end - start) + start, end);
        }
        //维持4个区域
        int m = start, n = start - 1;
        for (int i = start; i < end; i++) {
            //较大值区域
            if (arr[i] > arr[end]) {
                m++;
            } else {
                //较小值区域
                swap(arr, m++, ++n);
            }
        }
        //不需要考虑有没有较小值区域
        int i = n + 1;
        swap(arr, i, end);
        if (i == k) {
            return arr[i];
        } else if (i > k) {
            //在左边找
            return getTheNumberKValue(arr, k, start, i - 1);
        } else {
            //在右边找
            return getTheNumberKValue(arr, k, i + 1, end);
        }
    }

    //进行值的交换操作
    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    //找出出现次数大于1半的数字,如果没有超过一半就返回0
    public int MoreThanHalfNum_Solution(int[] array) {
        if (array == null || array.length == 0)
            return 0;
        Map<Integer, Integer> map = new HashMap<>(array.length * 3 / 4);
        for (int i : array) {
            Integer value = map.get(i);
            if (value == null) {
                map.put(i, 1);
            } else {
                map.put(i, value + 1);
            }
        }
        int key = -1, value = -1;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > value) {
                value = entry.getValue();
                key = entry.getKey();
            }
        }
        return value * 2 > array.length ? key : 0;
    }

    //将一棵二叉搜索树转换成一个排序的双向链表
    //就是使用left,right引用来建立索引关系
    public TreeNode Convert(TreeNode root) {
        boolean isFirst = true;
        TreeNode node = root;
        //用来保存前一个节点
        TreeNode pre = null;
        Stack<TreeNode> stack = new Stack<>();
        while (node != null || !stack.isEmpty()) {
            //使用循环校验
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            if (isFirst) {
                isFirst = false;
                //更新头部地址信息
                root = node;
                pre = root;
            } else {
                pre.right = node;
                node.left = pre;
                pre = node;

            }
            node = node.right;
        }
        //经过转换过后,变成了一条单链表
        return root;
    }


    //使用map映射来实现复杂链表的复制操作
    public RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null)
            return null;
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode head = new RandomListNode(pHead.label);
        RandomListNode headTemp = head;
        RandomListNode pHeadTemp = pHead;
        map.put(pHeadTemp, headTemp);
        while (pHeadTemp.next != null) {
            pHeadTemp = pHeadTemp.next;
            headTemp.next = new RandomListNode(pHeadTemp.label);
            headTemp = headTemp.next;
            map.put(pHeadTemp, headTemp);
        }
        headTemp = head;
        while (pHead != null) {
            headTemp.random = map.get(pHead.random);
            headTemp = headTemp.next;
            pHead = pHead.next;
        }
        return head;
    }

    //二叉树中和为某一值的路径
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (root == null)
            return result;
        ArrayList<ArrayList<Integer>> path = findPath(root, target);
        for (Iterator<ArrayList<Integer>> it = path.iterator(); it.hasNext(); ) {
            ArrayList<Integer> next = it.next();
            if (next.get(0).equals(target)) {
                next.remove(0);
                Collections.reverse(next);
                result.add(next);
            }
        }
        Collections.sort(result, Comparator.comparingInt(ArrayList::size));
        Collections.reverse(result);
        return result;
    }

    //要考虑地址域问题
    private ArrayList<ArrayList<Integer>> findPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        //要考虑到递归的底层原理,就是压栈出栈
        if (root.left != null) {
            ArrayList<ArrayList<Integer>> leftList = findPath(root.left, target);
            if (leftList != null && !leftList.isEmpty())
                list.addAll(leftList);
        }
        if (root.right != null) {
            ArrayList<ArrayList<Integer>> rightList = findPath(root.right, target);
            if (rightList != null && !rightList.isEmpty())
                list.addAll(rightList);
        }
        //到达叶子节点
        if (root.left == null && root.right == null) {
            if (root.val <= target) {
                ArrayList<Integer> path = new ArrayList<>();
                //第一个位置上保存的是路径的总和
                path.add(root.val);
                path.add(root.val);
                list.add(path);
            }
        } else {
            //对list集合进行迭代判断
            for (Iterator<ArrayList<Integer>> it = list.iterator(); it.hasNext(); ) {
                ArrayList<Integer> path = it.next();
                //值相等就直接进行下一轮循环操作
                if (path.get(0).equals(target)) {
                    continue;
                } else if (path.get(0) + root.val > target) {
                    //如果值超过了就表明不再匹配
                    it.remove();
                } else {
                    path.set(0, path.get(0) + root.val);
                    path.add(root.val);
                }
            }
        }
        return list;
    }

    //判断数组是否是二叉排序树的后续遍历操作
    public boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence == null || sequence.length == 0)
            return false;
        return checkIsBinaryTree(sequence, 0, sequence.length - 1);
    }

    //三种情况,只有左子树,只有右子树,左右子树都有
    private boolean checkIsBinaryTree(int[] arr, int start, int end) {
        //只剩下一个节点的情况的话就直接进行返回
        if (start >= end) {
            return true;
        }
        //下面是至少存在两个节点以上的情况
        int i = start;
        for (; i < end; i++) {
            if (arr[i] > arr[end]) {
                break;
            }
        }
        int j = i;
        for (; j < end; j++) {
            if (arr[j] < arr[end]) {
                return false;
            }
        }
        return checkIsBinaryTree(arr, start, i - 1) && checkIsBinaryTree(arr, i, end - 1);
    }

    //层次遍历
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        LinkedList<TreeNode> list = new LinkedList<>();
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null)
            return result;
        list.add(root);
        levelTraversal(list, result);
        return result;
    }

    //层次遍历一般使用LinkedList来进行数据的存储操作
    private void levelTraversal(LinkedList<TreeNode> list, ArrayList<Integer> result) {
        if (list.isEmpty())
            return;
        TreeNode node = list.removeFirst();
        result.add(node.val);
        //需要进行非空校验,只有非空的才能存进去
        if (node.left != null) {
            list.addLast(node.left);
        }
        if (node.right != null) {
            list.addLast(node.right);
        }
        levelTraversal(list, result);
    }

    //判断popA是否是pushA的弹栈序列
    public boolean IsPopOrder(int[] pushA, int[] popA) {
        Stack<Integer> stack = new Stack<>();
        int idx = 0;
        for (int value : pushA) {
            stack.push(value);
            for (int i = idx; i < popA.length; i++) {
                if (stack.empty())
                    break;
                if (stack.peek().equals(popA[i])) {
                    stack.pop();
                    idx++;
                } else {
                    //不符合条件就进行继续插入操作
                    break;
                }
            }
        }
        return stack.empty();
    }


    //对二叉树进行镜像操作,使用先序遍历操作,没向下遍历一次就进行左右子树的交换操作
    public void Mirror(TreeNode root) {
        if (root == null)
            return;
        TreeNode temp = root.right;
        root.right = root.left;
        root.left = temp;
        //交换完成之后,继续向下调用进行递归操作
        Mirror(root.left);
        Mirror(root.right);
    }

    //输入两棵二叉树A,B,判断B是不是A的子结构.。（ps:我们约定空树不是任意一个树的子结构）
    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null)
            return false;
        return checkIsSubTree(root1, root2);
    }

    //需要考虑递归涉及到的场景
    private boolean checkIsSubTree(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 != null) {
            return false;
        }
        if (root2 == null) {
            return true;
        }
        boolean flag = false;
        if (root1.val == root2.val) {
            flag = checkIsSubTree(root1.left, root2.left) && checkIsSubTree(root1.right, root2.right);
        }
        if (!flag) {
            flag = checkIsSubTree(root1.left, root2) || checkIsSubTree(root1.right, root2);
        }

        return flag;
    }

    //使用位运算来读取n里面二进制的1的个数
    public int NumberOf1Bit(int n) {
        int count = 0;
        int flag = 1;
        while (flag != 0) {
            if ((n & flag) != 0)
                count++;
            flag = flag << 1;
        }
        return count;
    }

    //将数组拆分成两部分,奇数在前面,偶数在后面
    public void reOrderArray(int[] array) {
        int[] t1 = new int[array.length];
        int[] t2 = new int[array.length];
        int m = 0, n = 0;
        for (int i = 0; i < array.length; i++) {
            int value = array[i];
            if (value % 2 != 0) {
                t1[m++] = value;
            } else {
                t2[n++] = value;
            }
        }
        for (int i = 0; i < n; i++) {
            t1[m++] = t2[i];
        }
        for (int i = 0; i < array.length; i++) {
            array[i] = t1[i];
        }
    }

    //正数与负数的二进制区别就是,取反加1
    //输入一个整数,输出该数二进制表示中1的个数
    //其中负数用补码表示
    public int NumberOf1(int n) {
        String value = Integer.toBinaryString(n);
        int count = 0;
        for (int i = 0; i < value.length(); i++) {
            if (value.charAt(i) == '1')
                count++;
        }
        return count;
    }

    //我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形
    //请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形,总共有多少种方法?
    public int RectCover(int target) {
        //能不用递归进行实现的就不同递归实现,因为执行效率差很大
        if (target == 0 || target == 1 || target == 2)
            return target;
        int f1 = 1, f2 = 2, result = 0;
        for (int i = 3; i <= target; i++) {
            result = f1 + f2;
            f1 = f2;
            f2 = result;
        }
        return result;
    }


    //一只青蛙一次可以跳上1级台阶,也可以跳上2级……它也可以跳上n级
    //求该青蛙跳上一个n级的台阶总共有多少种跳法

    //解法:每个台阶可以看作一块木板,让青蛙跳上去,n个台阶就有n块木板,最后一块木板是青蛙到达的位子
    //必须存在，其他 (n-1) 块木板可以任意选择是否存在,则每个木板有存在和不存在两种选择
    //(n-1) 块木板 就有 [2^(n-1)] 种跳法,可以直接得到结果
    public int JumpFloorII(int target) {
        //使用位移的效率更高
        return 1 << (target - 1);
    }

    //一只青蛙一次可以跳上1级台阶,也可以跳上2级
    //求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）
    public int JumpFloor(int target) {
        if (target < 0) {
            throw new RuntimeException("target不能为负数");
        }
        if (target == 0)
            return 0;
        if (target == 1)
            return 1;
        if (target == 2)
            return 2;
        //斐波那契数列
        return JumpFloor(target - 1) + JumpFloor(target - 2);
    }

    //斐波那契数列
    public int fibonacci(int n) {
        if (n > 39 || n <= 0) {
            throw new RuntimeException("n不符合要求!");
        }
        if (n == 0)
            return 0;
        if (n == 1 || n == 2)
            return 1;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    //这里没有要求必须是平衡二叉树
    //使用前缀和中缀表达式来构建二叉树(要求所有的值都互异)
    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (pre.length == 0) {
            return null;
        }
        if (pre.length == 1) {
            return new TreeNode(pre[0]);
        }
        //进行递归调用
        TreeNode node = new TreeNode(pre[0]);
        int head = pre[0];
        int mid = -1;
        for (int i = 0; i < in.length; i++) {
            if (in[i] == head) {
                mid = i;
                break;
            }
        }
        if (mid == -1) {
            throw new RuntimeException("个数不符合要求!");
        }
        //获取子串
        int[] leftPre = new int[mid];
        int[] leftIn = new int[mid];
        int[] rightPre = new int[pre.length - mid - 1];
        int[] rightIn = new int[pre.length - mid - 1];
        for (int i = 1; i < pre.length; i++) {
            if (i <= mid) {
                leftPre[i - 1] = pre[i];
            } else if (i > mid) {
                rightPre[i - mid - 1] = pre[i];
            }
        }
        for (int i = 0; i < in.length; i++) {
            if (i < mid) {
                leftIn[i] = in[i];
            } else if (i > mid) {
                rightIn[i - mid - 1] = in[i];
            }
        }
        node.right = reConstructBinaryTree(rightPre, rightIn);
        node.left = reConstructBinaryTree(leftPre, leftIn);
        return node;
    }

    //将字符串中的空格替换成“%20”
    public String replaceSpace(StringBuffer str) {
        StringBuilder sb = new StringBuilder();
        String value = str.toString();
        for (int i = 0; i < value.length(); i++) {
            if (value.charAt(i) == 32) {
                sb.append("%20");
            } else {
                sb.append(value.charAt(i));
            }
        }
        return sb.toString();
    }

    //判断target是否存在与二维数组中
    public boolean find(int target, int[][] array) {
        for (int i = 0; i < array[0].length; i++) {
            if (target < array[0][i]) {
                return false;
            } else if (target == array[0][i]) {
                return true;
            } else {
                for (int j = 1; j < array.length; j++) {
                    if (target < array[j][i]) {
                        continue;
                    } else if (target == array[j][i]) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
