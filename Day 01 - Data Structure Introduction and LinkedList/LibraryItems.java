class Library{
    String title;
    String author;
    String genre;
    int bookid;
    boolean available;
    Library prev;
    Library next;
    public Library(String title, String author, String genre, int bookid){
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.bookid = bookid;
        this.available = false;
        this.prev = null;
        this.next = null;
    }
}
class LibraryList{
    Library head = null;
    Library tail = null;
    public void addatBeginning(Library newnode){
        if(head==null){
            head = tail = newnode;
        }
        else{
            newnode.next = head;
            head.prev = newnode;
            head = newnode;
        }
    }
    public void addatEnd(Library newnode){
        if(tail==null){
            head = tail = newnode;
        }else{
            tail.next = newnode;
            newnode.prev = tail;
            tail = newnode;
        }
    }
    public void addatPosition(Library newnode, int position){
        if(head==null || position<=1){
            addatBeginning(newnode);
            return;
        }
        Library temp = head;
        for(int i=0; temp.next!=null && i<=position-1; i++){
            temp = temp.next;
        }
        if(temp.next==null){
            addatEnd(newnode);
        }
        else{
            newnode.next = temp.next;
            newnode.prev = temp;
            temp.next.prev = newnode;
            temp.next = newnode;
        }
    }
    public void deletebyid(int id){
        Library temp = head;
        while(temp!=null) { 
            if(temp.bookid == id){
                if(temp == head){
                    head = head.next;
                    if(head!= null) head.prev = null;
                    else tail = null;
                }
                else if(temp==tail){
                    tail = tail.prev;
                    tail.next = null;
                }
                else{
                    temp.prev.next = temp.next;
                    temp.next.prev = temp.prev;
                }
                System.out.println("Book was deleted.");
                return;
            }
            temp = temp.next;          
        }
        System.out.println("Requested book not found.");
    }
    public void getbytitle(String Title){
        Library temp = head;
        while(temp!=null){
            if(temp.title.equalsIgnoreCase(Title)){
                System.out.println("Book found:");
                System.out.println("Book name: " + temp.title + " Book id: " + temp.bookid + " Book author: " + temp.author + " Genre: " + temp.genre);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Requested book not found.");
    }
    public void getbyauthor(String Author){
        Library temp = head;
        while(temp!=null){
            if(temp.author.equalsIgnoreCase(Author)){
                System.out.println("Book found:");
                System.out.println("Book name: " + temp.title + " Book id: " + temp.bookid + " Book author: " + temp.author + " Genre: " + temp.genre);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Requested book not found.");
    }
    public void updatestatus(int Id, boolean newavail){
        Library temp = head;
        while(temp!=null && temp.bookid!=Id){
            temp = temp.next;
        }
        if(temp==null){
            System.out.println("Requested book not found.");
        }
        else{
            temp.available = newavail;
            System.out.println("Availability status updated.");
        }
    }
    public void displayforward(){
        Library temp = head;
        while(temp!=null){
            displayBooks(temp);
            temp = temp.next;           
        }
    }
    public void displaybackward(){
        Library temp = tail;
        while(temp!=null){
            displayBooks(temp);
            temp  = temp.prev;
        }
    }
    public int countBooks(){
        Library temp = head;
        int count = 0;
        while(temp!=null){
            temp = temp.next;
            count++;
        }
        return count;
    }
    public void displayBooks(Library book){
        System.out.println("Name: " + book.title + ", Id: " + book.bookid + ", Genre: " + book.genre + ", Author: " + book.author + ", Available: " + book.available);
    }
}
public class LibraryItems{
    public static void main(String[] args) {
        LibraryList library = new LibraryList();
        library.addatBeginning(new Library("Sherlock Holmes", "Sir Arthur Conan Doyle", "Detective", 101));
        library.addatEnd(new Library("Adventures of Faraway tree", "Enid Blyton", "Fantasy", 102));
        library.addatPosition(new Library("Journey to the centre of the Earth", "Jules Verne", "Adventure", 103), 2);
        library.deletebyid(103);
        library.getbytitle("Sherlock Holmes");
        library.getbyauthor("Jules Verne");
        library.displayforward();
        library.displaybackward();
        int Count = library.countBooks();
        System.out.println("Number of books are: " + Count);
    }
}