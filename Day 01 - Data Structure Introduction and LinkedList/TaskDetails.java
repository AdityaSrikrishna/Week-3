class Task{
    int taskid;
    String taskname;
    int priority;
    String duedate;
    Task next;
    public Task(int taskid, String taskname, int priority, String duedate){
        this.taskid = taskid;
        this.taskname = taskname;
        this.priority = priority;
        this.duedate = duedate;
        this.next = null;
    }
}
class TaskScheduler{
    private Task head = null;
    private Task tail = null;
    private Task current = null;
    public void addatBeginning(Task newTask){
        if(head==null){
            head = tail = newTask;
            newTask.next = newTask;
        }
        else{
            newTask.next = head;
            tail.next = newTask;
            head = newTask;
        }
    }
    public void addatEnd(Task newTask){
        if(head==null){
            addatBeginning(newTask);
        }
        else{
            newTask.next = head;
            tail.next = newTask;
            tail = newTask;
        }
    }
    public void addatPosition(Task newTask, int position){
        if(position<=1 && head==null){
            addatBeginning(newTask);
            return;
        }
        Task temp = head;
        int index = 1;
        while(index<position-1 && temp.next!=head){
            temp = temp.next;
            index++;
        }
        newTask.next = temp.next;
        temp.next = newTask;
        if (tail==null) {
           tail = newTask; 
        }
    }
    public void removebyid(int id){
        if(head==null){
            System.out.println("No nodes to remove.");
            return;
        }
        Task temp = head;
        Task prev = tail;
        boolean found = false;
        do { 
            if(temp.taskid == id){
                found = true;
                if(temp==head){
                    head = head.next;
                    tail.next = head;
                    if(temp==tail){
                        head = tail = null;
                    }
                }else if (temp == tail) {
                    tail = prev;
                    tail.next = head;
                }else{
                    prev.next = temp.next;
                }
                if (current == temp) {
                    current = temp.next;
                }
                System.out.println("Task ID " + id + " removed.");
                return;
            }
            prev = temp;
            temp = temp.next;
        } while (temp != head);

        if (!found) {
            System.out.println("Task ID " + id + " not found.");
        }
    }

    public void viewAndMoveNext() {
        if (current == null) {
            current = head;
        }

        if (current == null) {
            System.out.println("No tasks scheduled.");
            return;
        }

        System.out.println("Current Task:");
        displayTask(current);
        current = current.next;
    }
    public void displayAll(){
        if(head==null){
            System.out.println("No tasks to display");
            return;
        }
        Task temp = head;
        System.out.println("All Scheduled Tasks:");
        do {
            displayTask(temp);
            temp = temp.next;
        } while (temp != head);
    }
    public void searchByPriority(int priority) {
        if (head == null) {
            System.out.println("No tasks to search.");
            return;
        }

        boolean found = false;
        Task temp = head;
        do {
            if (temp.priority == priority) {
                displayTask(temp);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);

        if (!found) {
            System.out.println("No task found with priority: " + priority);
        }
    }
    private void displayTask(Task task) {
        System.out.println("ID: " + task.taskid + ", Name: " + task.taskname +
                ", Priority: " + task.priority + ", Due: " + task.duedate);
    }
}
public class TaskDetails {
    public static void main(String[] args) {
        TaskScheduler scheduler = new TaskScheduler();

        scheduler.addatEnd(new Task(1, "Write Report", 2, "2025-04-14"));
        scheduler.addatBeginning(new Task(2, "Fix Bug", 1, "2025-04-13"));
        scheduler.addatPosition(new Task(3, "Email Client", 3, "2025-04-15"), 2);

        scheduler.displayAll();

        scheduler.viewAndMoveNext(); // Should show 2
        scheduler.viewAndMoveNext(); // Should show 3
        scheduler.viewAndMoveNext(); // Should show 1

        scheduler.searchByPriority(2);

        scheduler.removebyid(2);
        scheduler.displayAll();
    }
}