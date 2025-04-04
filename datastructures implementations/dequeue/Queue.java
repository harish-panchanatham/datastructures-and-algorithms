class Node {

    public int value;
    public Node next;

    public Node(int value) {

        this.value = value;
    }
}

class Queue {

    public Node head;
    public int length;

    public void insertAtBegining(int value) {

        Node node = new Node(value);

        if(length == 0) {
            this.head = node;
        } else {
            node.next = head;
            this.head = node;
        }

        length++;

    }

    public void insertAtEnd(int value) {

        Node node = new Node(value);

        if(length == 0) {
            this.head = node;
        } else {

            Node currentNode = this.head;
            for(int i=0; i<length-1; i++) {
                currentNode = currentNode.next;
            }

            currentNode.next = node;

        }

        length ++;
    }

    public int removeAtBegining() throws RuntimeException {

        if(length == 0) {
            throw new RuntimeException("queue is empty");
        } else {

            int result = this.head.value;
            this.head = this.head.next;

            length --;
            return result;
        }

    }

    public int removeAtEnd() {
        
        if(length == 0) {
            throw new RuntimeException("queue is empty");
        } else if (length == 1) {
            int result = this.head.value;
            this.head = null;

            length --;
            return result;
        } else {

            Node currentNode = this.head;
            while(currentNode.next.next != null) {

                currentNode = currentNode.next;
            }

            int result = currentNode.next.value;
            currentNode.next = null;

            length --;
            return result;
        }




        }
    }
