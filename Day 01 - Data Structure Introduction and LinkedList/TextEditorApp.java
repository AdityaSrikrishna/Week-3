import java.util.Scanner;

class TextState {
    String content;
    TextState prev, next;

    public TextState(String content) {
        this.content = content;
    }
}

class TextEditor {
    private TextState head = null;
    private TextState tail = null;
    private TextState current = null;
    private int maxHistorySize = 10;
    private int currentSize = 0;

    public void performAction(String newContent) {
        TextState newState = new TextState(newContent);

        // Remove all redo states
        if (current != null && current.next != null) {
            current.next.prev = null;
            current.next = null;
            tail = current;
        }

        // Append the new state
        if (head == null) {
            head = tail = current = newState;
        } else {
            current.next = newState;
            newState.prev = current;
            current = newState;
            tail = newState;
        }

        currentSize++;

        // Trim history if exceeding max allowed states
        if (currentSize > maxHistorySize) {
            head = head.next;
            if (head != null) head.prev = null;
            currentSize--;
        }

        System.out.println("Action performed. Current text: " + current.content);
    }

    public void undo() {
        if (current != null && current.prev != null) {
            current = current.prev;
            System.out.println("Undo performed. Current text: " + current.content);
        } else {
            System.out.println("No more undo available.");
        }
    }

    public void redo() {
        if (current != null && current.next != null) {
            current = current.next;
            System.out.println("Redo performed. Current text: " + current.content);
        } else {
            System.out.println("No more redo available.");
        }
    }

    public void showCurrentState() {
        if (current != null) {
            System.out.println("Current Text: " + current.content);
        } else {
            System.out.println("Editor is empty.");
        }
    }
}

public class TextEditorApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TextEditor editor = new TextEditor();

        while (true) {
            System.out.println("\n--- Text Editor ---");
            System.out.println("1. Type New Text / Perform Action");
            System.out.println("2. Undo");
            System.out.println("3. Redo");
            System.out.println("4. Show Current State");
            System.out.println("5. Exit");
            System.out.print("Choose: ");
            int choice = sc.nextInt();
            sc.nextLine(); // clear buffer

            switch (choice) {
                case 1:
                    System.out.print("Enter new content: ");
                    String newContent = sc.nextLine();
                    editor.performAction(newContent);
                    break;

                case 2:
                    editor.undo();
                    break;

                case 3:
                    editor.redo();
                    break;

                case 4:
                    editor.showCurrentState();
                    break;

                case 5:
                    System.out.println("Exiting editor.");
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
