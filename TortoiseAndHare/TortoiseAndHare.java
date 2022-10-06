package TortoiseAndHare;

class TortoiseAndHare {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);

        node1.next = node2;
        node2.next = node3;
        node4.next = node1;

        System.out.println(hasCycle(node1));
    }

    public static boolean hasCycle(ListNode head) {
        ListNode rabbit = head;
        ListNode turtle = head;
        while(rabbit != null && rabbit.next != null) {
            rabbit = rabbit.next.next;
            turtle = turtle.next;
            if (rabbit == turtle) {
                return true;
            }
        }
        return false;
    }
}

 class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}