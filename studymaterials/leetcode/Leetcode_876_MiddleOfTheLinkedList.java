package leetcode;

public class Leetcode_876_MiddleOfTheLinkedList {

	public ListNode middleNode(ListNode head) {
		ListNode s = head;
		ListNode f = head;

		while (f != null && f.next != null) {
			s = s.next;
			f = f.next.next;
		}
		return s;
	}

	public static void main(String[] args) {
		// Test case 1: Odd number of nodes
		ListNode head1 = new ListNode(1);
		head1.next = new ListNode(2);
		head1.next.next = new ListNode(3);
		head1.next.next.next = new ListNode(4);
		head1.next.next.next.next = new ListNode(5);

		Leetcode_876_MiddleOfTheLinkedList solution = new Leetcode_876_MiddleOfTheLinkedList();
		ListNode middle1 = solution.middleNode(head1);
		System.out.println("Middle node of test case 1: " + middle1.val); // Output: 3

		// Test case 2: Even number of nodes
		ListNode head2 = new ListNode(1);
		head2.next = new ListNode(2);
		head2.next.next = new ListNode(3);
		head2.next.next.next = new ListNode(4);
		head2.next.next.next.next = new ListNode(5);
		head2.next.next.next.next.next = new ListNode(6);

		ListNode middle2 = solution.middleNode(head2);
		System.out.println("Middle node of test case 2: " + middle2.val); // Output: 4
	}
}

class ListNode {
	int val;
	ListNode next;

	ListNode(int val) {
		this.val = val;
	}
}

//Given the head of a singly linked list, return the middle node of the linked list.
//
//If there are two middle nodes, return the second middle node.
//
// 
//
//Example 1:
//
//
//Input: head = [1,2,3,4,5]
//Output: [3,4,5]
//Explanation: The middle node of the list is node 3.
//Example 2:
//
//
//Input: head = [1,2,3,4,5,6]
//Output: [4,5,6]
//Explanation: Since the list has two middle nodes with values 3 and 4, we return the second one.
// 
//
//Constraints:
//
//The number of nodes in the list is in the range [1, 100].
//1 <= Node.val <= 100