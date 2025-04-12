import java.util.Scanner;

class Student{
    int Rollnum;
    String name;
    int age;
    char grade;
    Student next;
    public Student(int Rollnum, String name, int age, char grade){
        this.Rollnum = Rollnum;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.next = null;
    }
}
class StudentList{
    private Student head = null;
    public void addatBeginning(Student newStudent){
        newStudent.next = head;
        head = newStudent;
    }
    public void addatEnd(Student newStudent){
        if(head==null){
            head = newStudent;
            return ;
        }
        Student temp = head;
        while(temp.next!=null){
            temp = temp.next;
        }
        temp.next = newStudent;
    }
    public void addatPosition(Student newStudent, int position){
        if(position == 1){
            addatBeginning(newStudent);
            return;
        }
        Student temp = head;
        for(int i=1; temp!=null && i<position-1; i++){
            temp = temp.next;
        }
        if(temp==null){
            System.out.println("Invalid Position");
        }
        newStudent.next = temp.next;
        temp.next = newStudent;
    }
    public void deletebyroll(int roll){
        if(head==null) return ;
        if(head.Rollnum == roll){
            head = head.next;
            return ;
        }
        Student temp = head;
        while(temp.next!=null && temp.next.Rollnum!=roll){
            temp = temp.next;
        }
        if(temp.next==null){
            System.out.println("Roll number not found.");
        }
        else{
            temp = temp.next.next;
        }
    }
    public void searchbyroll(int roll){
        Student temp = head;
        while(temp.next!=null){
            if(temp.Rollnum == roll){
                System.out.println("Found: \n" + "Roll number: " + temp.Rollnum + "\nName: " + temp.name + "\nAge: " + temp.age + "\nGrade: " + temp.grade);
            }
            temp = temp.next;
        }
        System.out.println("Student record not found.");
    }
    public void updategradebyroll(int roll, char newgrade){
        Student temp = head;
        while (temp.next!=null) {
            if(temp.Rollnum == roll){
                temp.grade = newgrade;
                System.out.println("Grade Updated.");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Student record not found.");
    }
    public void display(){
        if(head==null){
            System.out.println("No student records to display.");
            return ;
        }
        Student temp = head;
        while(temp!=null){
            System.out.println("Roll number: " + temp.Rollnum + "\nName: " + temp.name + "\nAge: " + temp.age + "\nGrade: " + temp.grade);
            temp = temp.next;
        }
    }
}
public class StudentRecords{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentList list = new StudentList();
        while (true) {
            System.out.println("\n---- Menu ----");
            System.out.println("1. Add Student at Beginning");
            System.out.println("2. Add Student at End");
            System.out.println("3. Add Student at Position");
            System.out.println("4. Delete Student by Roll Number");
            System.out.println("5. Search Student by Roll Number");
            System.out.println("6. Update Grade by Roll Number");
            System.out.println("7. Display All Students");
            System.out.println("8. Exit");
            System.out.print("Choose an option: ");
            int roll, age, pos;
            String name;
            char grade;
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch(choice){
                case 1:
                    System.out.println("Enter Roll number: "); roll = scanner.nextInt(); scanner.nextLine();
                    System.out.println("Enter Name: "); name = scanner.nextLine();
                    System.out.println("Enter Age: "); age = scanner.nextInt();
                    System.out.println("Enter Grade: "); grade = scanner.next().charAt(0);
                    list.addatBeginning(new Student(roll, name, age, grade));
                    break;
                case 2:
                    System.out.println("Enter Roll number: "); roll = scanner.nextInt(); scanner.nextLine();
                    System.out.println("Enter Name: "); name = scanner.nextLine();
                    System.out.println("Enter Age: "); age = scanner.nextInt();
                    System.out.println("Enter Grade: "); grade = scanner.next().charAt(0);
                    list.addatEnd(new Student(roll, name, age, grade));
                    break;
                
                case 3:
                    System.out.println("Enter Roll number: "); roll = scanner.nextInt(); scanner.nextLine();
                    System.out.println("Enter Name: "); name = scanner.nextLine();
                    System.out.println("Enter Age: "); age = scanner.nextInt();
                    System.out.println("Enter Grade: "); grade = scanner.next().charAt(0);
                    System.out.println("Enter position: "); pos = scanner.nextInt();
                    list.addatPosition(new Student(roll, name, age, grade), pos);
                    break;
            
                case 4:
                    System.out.print("Enter Roll No to Delete: "); roll = scanner.nextInt();
                    list.deletebyroll(roll);
                    break;

                case 5:
                    System.out.print("Enter Roll No to Search: "); roll = scanner.nextInt();
                    list.searchbyroll(roll);
                    break;

                case 6:
                    System.out.print("Enter Roll No to Update Grade: "); roll = scanner.nextInt();
                    System.out.print("Enter New Grade: "); grade = scanner.next().charAt(0);
                    list.updategradebyroll(roll, grade);
                    break;

                case 7:
                    list.display();
                    break;

                case 8:
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid option.");

            }
        }
    }
}