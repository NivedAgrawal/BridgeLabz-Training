package linkedlist;
class Node{
    String content;
    Node prev;
    Node next;

    public Node(String content) {
        this.content = content;
        this.prev = null;
        this.next = null;
    }
}
class TextEditor {
    private Node head;
    private Node current;
    private int size;
    private final int MAX_HISTORY = 10;

    public TextEditor() {
        head = null;
        current = null;
        size = 0;
    }

    
    public void addState(String text) {
        Node newState = new Node(text);

        
        if (current != null && current.next != null) {
            current.next.prev = null;
            current.next = null;
            size = calculateSize();
        }

        if (head == null) {
            head = newState;
            current = newState;
            size = 1;
        } else {
            newState.prev = current;
            current.next = newState;
            current = newState;
            size++;
        }

        if (size > MAX_HISTORY) {
            head = head.next;
            head.prev = null;
            size--;
        }
    }


    public void undo() {
        if (current != null && current.prev != null) {
            current = current.prev;
        } else {
            System.out.println("❌ Undo not possible");
        }
    }

 
    public void redo() {
        if (current != null && current.next != null) {
            current = current.next;
        } else {
            System.out.println("❌ Redo not possible");
        }
    }

    public void displayCurrentState() {
        if (current != null) {
            System.out.println("📄 Current Text: " + current.content);
        } else {
            System.out.println("Editor is empty");
        }
    }


    private int calculateSize() {
        int count = 0;
        Node temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }
}
public class UndoRedo {
    public static void main(String[] args) {

        TextEditor editor = new TextEditor();

        editor.addState("Hello");
        editor.addState("Hello World");
        editor.addState("Hello World!");
        editor.displayCurrentState();

        editor.undo();
        editor.displayCurrentState();

        editor.undo();
        editor.displayCurrentState();

        editor.redo();
        editor.displayCurrentState();

        editor.addState("Hello Java");
        editor.displayCurrentState();

        editor.redo(); 
    }
}
