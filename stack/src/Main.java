import java.security.spec.RSAOtherPrimeInfo;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int[] stack = new int[10];
        int top = -1;

        int number;
        boolean flag = true;

        while (flag){
            System.out.println("1. Enter value in to stack");
            System.out.println("2. Remove value from stack");
            System.out.println("3. Check stack is empty");
            System.out.println("4. Check stack is full");
            System.out.println("5. Get peek value");
            System.out.println("6. Show stack");
            System.out.println("7. Exit");
            System.out.print("Enter number: ");
            number = sc.nextInt();

            System.out.println("");
            switch (number){
                case 1:
                    top = push(top, stack);
                    break;
                case 2:
                    top = pop(top, stack);
                    break;
                case 3:
                    if (isEmpty(top, stack)){
                        System.out.println("Stack is empty");
                    }else {
                        System.out.println("Stack isn't empty");
                    }
                    break;
                case 4:
                    if (isFull(top, stack)){
                        System.out.println("Stack is full");
                    }else {
                        System.out.println("Stack isn't full");
                    }
                    break;
                case 5:
                    peek(top, stack);
                    break;
                case 6:
                    show(top, stack);
                    break;
                case 7:
                    flag = false;
                    break;
                default:
                    System.out.println("Enter valid number....");
            }
        }
    }

    public static int push(int top,int[] stack){
        Scanner sc = new Scanner(System.in);
        if (!isFull(top, stack)){
            top++;
            System.out.print("Enter value: ");
            stack[top] = sc.nextInt();
        }else{
            System.out.println("Stack is Full");
        }

        return top;
    }

    public static int pop(int top,int[] stack){
        if (!isEmpty(top, stack)){
            top--;
        }else {
            System.out.println("Stack is Empty");
        }
        return top;
    }

    //check stack empty
    public static boolean isEmpty(int top,int[] stack){
        if (top==-1){
           return true;
        }else{
            return false;
        }
    }

    //check stack is full
    public static boolean isFull(int top,int[] stack){
        if (top==(stack.length-1)){
            return true;
        }else {
            return false;
        }
    }
    public static void peek(int top,int[] stack){
        System.out.println(stack[top]);
    }

    // retrieve stack
    public static void show(int top,int[] stack){
        for (int i = top; i > 0; i--){
            System.out.print(stack[i]+" ");
        }
        System.out.println("");
    }
}