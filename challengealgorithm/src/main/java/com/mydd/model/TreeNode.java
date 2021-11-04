package com.mydd.model;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode() {}
    public TreeNode(int val) { this.val = val; }
    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof TreeNode)) return false;
        if (this.val != ((TreeNode) obj).val) return false;
        if(this.left != null && !this.left.equals(((TreeNode) obj).left)) return false;
        if(this.right != null && !this.right.equals(((TreeNode) obj).right)) return false;
        return true;
    }
}
