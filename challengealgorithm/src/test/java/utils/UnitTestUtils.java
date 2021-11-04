package utils;

import com.mydd.model.ListNode;
import com.mydd.model.TreeNode;

import java.util.List;

public class UnitTestUtils {

    public static ListNode gln(int[] a) {
        return generateListNode(a);
    }
    public static ListNode generateListNode(int[] input) {
        int len = input.length;
        if(len == 0) return new ListNode();
        ListNode head = new ListNode(input[0]);
        ListNode prev = head;
        for(int i = 1; i < len; i++) {
            ListNode node = new ListNode(input[i]);
            prev.next = node;
            prev = node;
        }
        return head;
    }

    public static TreeNode gtn(List<Integer> a) {
        if(a == null || a.size() == 0) return null;
        return gtn(a, 1);
    }


    private static TreeNode gtn(List<Integer> a, int index) {
        TreeNode node = a.get(index - 1) != null ? new TreeNode(a.get(index - 1)) : null;
        if(node == null) return node;
        int tmp = 2 * index;
        if (tmp <= a.size()) node.left = gtn(a, 2 * index);
        if (tmp + 1 <= a.size()) node.right = gtn(a, 2 * index + 1);
        return node;
    }
}
