package algorithm.practice;

public class DeleteLinkedListNode {
    public static void main(String[] args) {
        int[] array = {30, 40, 20, 11, 34, 23, 10, 34, 56, 23, 45, 32, 64, 51, 39, 81};
        Node head = null;
        for (int i = 0; i < array.length; i++) {
            if (head == null) {
                head = new Node(array[i]);
            } else {
                insertNode(head, array[i]);
            }
        }
        printList(head);

        head = deleteNode(head, 34);
        printList(head);

        head = deleteNode(head, 30);
        printList(head);

        head = deleteNode(head, 81);
        printList(head);

        head = deleteNode(head, 81);
        printList(head);

        head = deleteNode(head, 39);
        printList(head);

        insertNode(head, 34);
        printList(head);

        insertNode(head, 30);
        printList(head);

        insertNode(head, 81);
        printList(head);

        insertNode(head, 81);
        printList(head);

        insertNode(head, 39);
        printList(head);
    }

    private static Node deleteNode(Node head, int item) {
        Node returnHead = head;
        if (head != null) {
            Node tempHead = head;
            if (tempHead.getData() == item) {
                 returnHead = tempHead.getNext();
                 tempHead.setNext(null);
            } else {
                Node prev = tempHead;
                boolean found = false;
                while (tempHead != null && !found) {
                    if (tempHead.getData() == item) {
                        prev.setNext(tempHead.getNext());
                        found = true;
                    } else {
                        prev = tempHead;
                        tempHead = tempHead.getNext();
                    }
                }
            }
        }
        return returnHead;
    }

    private static void printList(Node head) {
        while (head != null) {
            System.out.print(head.getData() + " ");
            head = head.getNext();
        }
        System.out.print("\n");
    }

    private static void insertNode(Node head, int data) {
        while (head.getNext() != null) {
            head = head.getNext();
        }
        head.setNext(new Node(data));
    }
}

class Node {
    int data;
    Node next;
    Node(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public void setData(int data) {
        this.data = data;
    }
}
