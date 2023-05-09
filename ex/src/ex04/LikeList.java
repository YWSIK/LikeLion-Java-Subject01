package ex04;

public class LikeList {
    private Node head;
    private int size;

    private class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            next = null;
        }
    }

    public void insert(int index, int data) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }

        if (index == 0) {
            Node newNode = new Node(data);
            newNode.next = head;
            head = newNode;
        } else {
            Node prevNode = getNode(index - 1);
            Node newNode = new Node(data);
            newNode.next = prevNode.next;
            prevNode.next = newNode;
        }

        size++;
    }

    public void delete(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        if (index == 0) {
            head = head.next;
        } else {
            Node prevNode = getNode(index - 1);
            prevNode.next = prevNode.next.next;
        }

        size--;
    }

    public void print() {
        Node node = head;
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    private Node getNode(int index) {
        Node node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    public static void main(String[] args) {
        LikeList list = new LikeList();

        list.insert(0, 10);
        list.insert(1, 20);
        list.insert(2, 30);
        list.print();

        list.delete(2);
        list.print();

        Node value = list.getNode(1);
        System.out.println(value);

    }
}

