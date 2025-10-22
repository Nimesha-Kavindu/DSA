// LinkedList.java
public class LinkedList {
    Node head; // Head of the list

    // Method to insert a new node
    public void insert(int data) {
        // Create a new node with given data
        Node new_node = new Node(data);

        // If the Linked List is empty, make the new node as head
        if (this.head == null) {
            this.head = new_node;
        } else {
            // Else traverse till the last node and insert the new_node there
            Node last = this.head;
            while (last.next != null) {
                last = last.next;
            }
            // Insert the new_node at last node
            last.next = new_node;
        }
    }

    // Method to print the LinkedList
    public void printList() {
        Node currNode = this.head;

        System.out.print("LinkedList: ");

        // Traverse through the LinkedList
        while (currNode != null) {
            // Print the data at current node
            System.out.print(currNode.data + " ");

            // Go to next node
            currNode = currNode.next;
        }
        System.out.println();
    }
}

