public class QueueTest {
    public static void main(String[] args) {
        Queue queue = new Queue();

        System.out.println("Running test cases...");

        // Insert at beginning test
        queue.insertAtBegining(10);
        queue.insertAtBegining(20);
        assert queue.head.value == 20 : "Insert at beginning failed";
        assert queue.head.next.value == 10 : "Insert at beginning order incorrect";

        // Insert at end test
        queue.insertAtEnd(30);
        queue.insertAtEnd(40);
        assert queue.head.next.next.value == 30 : "Insert at end failed";
        assert queue.head.next.next.next.value == 40 : "Insert at end order incorrect";

        // Remove at beginning test
        int removed1 = queue.removeAtBegining();
        assert removed1 == 20 : "Remove at beginning failed";
        assert queue.head.value == 10 : "Head update after remove at beginning failed";

        // Remove at end test
        int removed2 = queue.removeAtEnd();
        assert removed2 == 40 : "Remove at end failed";
        assert queue.head.next.next == null : "Last element not properly removed";

        // Edge case: Single element insert and remove
        queue.insertAtBegining(99);
        assert queue.head.value == 99 : "Single element insert failed";
        int removed3 = queue.removeAtBegining();
        assert removed3 == 99 && queue.head == null : "Single element remove failed";

        // Edge case: Removing last remaining element
        queue.insertAtEnd(77);
        int removed4 = queue.removeAtEnd();
        assert removed4 == 77 && queue.head == null : "Removing last element failed";

        // Edge case: Remove until empty
        queue.insertAtEnd(50);
        queue.insertAtEnd(60);
        queue.insertAtEnd(70);
        queue.removeAtBegining();
        queue.removeAtBegining();
        queue.removeAtEnd();
        assert queue.head == null : "Remove until empty failed";

        // Handling empty queue exception
        try {
            queue.removeAtBegining();
            assert false : "Exception expected but not thrown for empty queue (removeAtBegining)";
        } catch (RuntimeException e) {
            assert e.getMessage().equals("queue is empty") : "Incorrect exception message for removeAtBegining";
        }

        try {
            queue.removeAtEnd();
            assert false : "Exception expected but not thrown for empty queue (removeAtEnd)";
        } catch (RuntimeException e) {
            assert e.getMessage().equals("queue is empty") : "Incorrect exception message for removeAtEnd";
        }

        System.out.println("✅ All test cases passed!");
    }
}
