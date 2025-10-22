import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    static int size,front,choice=0,rear=-1;
    static int[] queue;

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("Enter the size of queue: ");
        size = input.nextInt();
        queue = new int[size];

        while (choice!=5){
            System.out.println("================= Queue ==================");
            System.out.println("1. Insert Value in to queue ");
            System.out.println("2. Delete Value from the queue ");
            System.out.println("3. Print Queue ");
            System.out.println("4. Get peek value ");
            System.out.println("5. Exit ");
            System.out.print("Enter your choice: ");
            choice = input.nextInt();

            switch (choice){
                case 1:
                    System.out.print("Enter the value to insert: ");
                    enQueue(input.nextInt());
                    System.out.println();
                    break;
                case 2:
                    deQueue();
                    System.out.println();
                    break;
                case 3:
                    printQueue();
                    System.out.println();
                    break;
                case 4:
                    System.out.println("Peek value is: " + queue[front]);
                    System.out.println();
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    public static boolean isFull(){
        return size==rear+1;
    }

    public static void enQueue(int data){
        if (isFull()){
            System.out.println("Queue is full...");
        }else {
            rear=rear+1;
            queue[rear]=data;
        }
    }

    public static boolean isEmpty(){
        return rear<front;
    }

    public static void deQueue(){
        if (isEmpty()){
            System.out.println("Queue is empty...");
        }else {
            for (int i = 0; i < rear; i++) {
                queue[i] = queue[i + 1];
            }

            rear--;
        }
    }

    public static void printQueue(){
        for (int i=front;i<=rear;i++){
            System.out.print(queue[i]+" ");
        }
    }
}