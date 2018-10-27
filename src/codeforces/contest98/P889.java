package codeforces.contest98;

import java.util.HashSet;


class P889 {


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode parent;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode constructFromPrePost(int[] pre, int[] post) {

        HashSet<Integer> checkSet = new HashSet<>();

        TreeNode root = new TreeNode(pre[0]);
        TreeNode current = root;
        int postIdx = 0;

        for (int i = 1; i < pre.length; i++) {

            while (current.left != null && current.right != null) {
                current = current.parent;
            }

            while(postIdx<post.length && checkSet.contains(post[postIdx])){
                postIdx++;
            }

            if(postIdx==post.length){
                break;
            }


            if (post[postIdx] != pre[i]) {
                if (current.left == null) {
                    TreeNode newNode = new TreeNode(pre[i]);
                    newNode.parent = current;
                    current.left = newNode;
                    current = newNode;
                    checkSet.add(pre[i]);
                } else if (current.right == null) {
                    TreeNode newNode = new TreeNode(pre[i]);
                    newNode.parent = current;
                    current.right = newNode;
                    current = newNode;
                    checkSet.add(pre[i]);
                }

            } else {
                if (current.left == null) {
                    TreeNode newNode = new TreeNode(pre[i]);
                    newNode.parent = current;
                    current.left = newNode;
                    checkSet.add(pre[i]);
                } else if (current.right == null) {
                    TreeNode newNode = new TreeNode(pre[i]);
                    newNode.parent = current;
                    current.right = newNode;
                    checkSet.add(pre[i]);
                }
                postIdx++;
            }
        }

        return root;
    }

    public static void main(String[] args) {
        int[] pre = {3,4,1,2   };
        int[] post = {1,4,2,3};
        TreeNode tmp = new P889().constructFromPrePost(pre, post);

        System.out.println(tmp);
    }
}
