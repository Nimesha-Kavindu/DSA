import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    static Node head;
    
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int count = 0;
        int data,possision,choice=0;

        while (choice != 9) {

        System.out.println("=====================Linked List Menu =====================");
        System.out.println("1. Add element to the beginning.");
        System.out.println("2. Add element to the end.");
        System.out.println("3. Add element to specific position.");
        System.out.println("4. Delete element from the beginning.");
        System.out.println("5. Delete element from the end.");
        System.out.println("6. Delete element from specific position.");
        System.out.println("7. Search element's position.");
        System.out.println("8. Print the Link list.");
        System.out.println("9. Exit");

        System.out.print("Enter your choice: ");
        choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the element to be added: ");
                    data = sc.nextInt();
                    count = insertEnd(data, count);
                    System.out.println();
                    break;
                case 2:
                    System.out.print("Enter the element to be added: ");
                    data = sc.nextInt();
                    count = insertStart(data, count);
                    System.out.println();
                    break;
                case 3:
                    System.out.print("Enter the element to be added: ");
                    data = sc.nextInt();
                    System.out.print("Enter the position to be added: ");
                    possision = sc.nextInt();
                    count = insertSpecificPosition(data,count,possision-1);
                    System.out.println();
                    break;
                case 4:
                    count = deleteStart(count);
                    System.out.println("Deleted 1st element successfully.");
                    System.out.println();
                    break;
                case 5:
                    count = deleteEnd(count);
                    System.out.println("Deleted last element successfully.");
                    System.out.println();
                    break;
                case 6:
                    System.out.println("Enter the position to be added: ");
                    possision = sc.nextInt();
                    count = deleteSpecificPosition(count,possision);
                    System.out.println("Deleted last element successfully.");
                    System.out.println();
                    break;
                case 7:
                    System.out.print("Enter the element to be searched: ");
                    data = sc.nextInt();
                    search(data);
                    System.out.println();
                    break;
                case 8:
                    printList();
                    System.out.println();
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }

    }

    //============================ INSERT VALUES INTO LINK LIST ===================================
    public static int insertEnd(int data,int count) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;

        }else {
            Node temp = head;

            while (temp.next != null) {
                temp = temp.next;
            }

            temp.next = newNode;
        }
        return ++count;
    }

    public static int insertStart(int data,int count) {
        Node newNode = new Node(data);
        Node temp = head;
        head = newNode;
        head.next = temp;

        return ++count;
    }

    public static int insertSpecificPosition(int data, int count, int pos) {

        if (pos > count || pos < 0) {
            System.out.println("Invalid position: " + pos);
            return count;
        }

        Node newNode = new Node(data);

        if (pos == 0) {
            newNode.next = head;
            head = newNode;
        } else {
            Node temp = head;

            for (int i = 1; i < pos-1; i++) {
                temp = temp.next;
            }

            newNode.next = temp.next;
            temp.next = newNode;
        }
        return ++count;
    }

    //============================ END OF THE INSERTION METHODS ====================================

    //============================ DELETE VALUES FROM LINK LIST ====================================

    public static int deleteStart(int count) {
        head = head.next;
        return --count;
    }

    public static int deleteEnd(int count) {
        Node temp = head;
        for (int i = 1; i < count - 2; i++) {
            temp = temp.next;
        }

        temp.next = null;
        return count - 1;
    }

    public static int deleteSpecificPosition(int count, int pos) {
        if (pos > count || pos < 0) {
            System.out.println("Invalid position: " + pos);
            return count;
        }else {
            Node temp = head;
            int i=0;
            while (i<pos-1){
                temp = temp.next;
                i++;
            }
            temp.next = temp.next.next;

            return --count;
        }
    }

    //============================ END OF THE DELETION METHODS =====================================

    //============================ SEARCH AN ELEMENT IN LINKED LIST ================================
    public static void search(int data){
        Node temp = head;
        int i =1;

        while (temp != null) {
            if (temp.data == data) {
                System.out.println("Element found. It is the " + i + "th element.");
                return;
            }
            temp = temp.next;
            i++;
        }
        System.out.println("Element is not found.");
    }

    //============================ RETRIEVE VALUES FROM LINK LIST ==================================
    public static void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
    //============================ END OF THE RETRIEVE METHOD =======================================
}