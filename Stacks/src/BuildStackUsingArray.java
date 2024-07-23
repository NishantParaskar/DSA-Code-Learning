public class BuildStackUsingArray {

    int size = 10000;
    int arr[] = new int[size];
    int top = -1;

    public void push(int x) {
        if (top == size - 1) {
            System.out.println("Stack overflow");
        } else {
            top++;
            arr[top] = x;
            System.out.println(x + " : Element has been pushed to stack");
        }
    }

    public int pop() {
        if (top == -1) {
            System.out.println("Stack underflow");
            return -1;
        } else {
            int x = arr[top];
            top--;
            System.out.println(x + " : Element has been popped from stack");
            return x;
        }
    }

    public int top() {
        if (top == -1) {
            System.out.println("Stack is empty");
            return -1;
        } else {
            int x = arr[top];
            System.out.println(x + " : Element is at the top of the stack");
            return x;
        }
    }

    public int size() {
        System.out.println("Size of stack: " + (top + 1));
        return top + 1;
    }

    public static void main(String[] args) {
        BuildStackUsingArray stack = new BuildStackUsingArray();

        // Test cases
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.top();    // Should print "30 : Element is at the top of the stack"
        stack.pop();    // Should print "30 : Element has been popped from stack"
        stack.size();   // Should print "Size of stack: 2"
        stack.pop();    // Should print "20 : Element has been popped from stack"
        stack.pop();    // Should print "10 : Element has been popped from stack"
        stack.pop();    // Should print "Stack underflow"
    }
}
