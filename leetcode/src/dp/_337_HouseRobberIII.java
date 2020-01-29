package dp;

import java.util.HashMap;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class _337_HouseRobberIII {

    HashMap<TreeNode, Integer> memo = new HashMap<>();

    public int rob(TreeNode root) {
        int[] res = robDP(root);
        return Math.max(res[0], res[1]);
        // return robRe(root);
    }

    public int[] robDP(TreeNode root) {
        if (root == null) return new int[2];
        int[] left = robDP(root.left);
        int[] right = robDP(root.right);

        int[] res = new int[2];
        res[0] = root.val + left[1] + right[1];
        res[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        return res;
    }

    public int robRe(TreeNode root) {
        if (root == null) return 0;
        if (memo.containsKey(root)) return memo.get(root);
        int money = root.val;
        if (root.left != null) {
            money += robRe(root.left.left) + robRe(root.left.right);
        }
        if (root.right != null) {
            money += (robRe(root.right.left) + robRe(root.right.right));
        }

        int res = Math.max(money, robRe(root.left) + robRe(root.right));
        memo.put(root, res);
        return res;
    }
}
