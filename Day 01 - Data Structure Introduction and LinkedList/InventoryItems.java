class Inventory{
    String name;
    int id;
    int quantity;
    double price;
    Inventory next;
    public Inventory(String name, int id, int quantity, double price){
        this.name = name;
        this.id = id;
        this.quantity = quantity;
        this.price = price;
        this.next = null;
    }
}
class InventoryList{
    private Inventory head = null;
    public void addatBeginning(Inventory newinv){
        newinv.next = head;
        head = newinv;
    }
    public void addatEnd(Inventory newinv){
        if(head==null){
            head = newinv;
            return ;
        }
        Inventory temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = newinv;
    }
    public void addatPosition(Inventory newinv, int position){
        if(head==null || position==1){
            addatBeginning(newinv);
            return ;
        }
        Inventory temp = head;
        for(int i=1; temp!=null && i<position-1; i++){
            temp = temp.next;
        }
        if(temp==null){
            System.out.println("Invalid position");
            return;
        }
        newinv.next = temp.next;
        temp.next = newinv;
    }
    public void removebyid(int Id){
        Inventory temp = head;
        if(head==null)return;
        if(head.id == Id){
            head = head.next;
        }
        while (temp.next != null) {
            if (temp.next.id == Id) {
                temp.next = temp.next.next;
                return;
            }
            temp = temp.next;
        }
        System.out.println("Inventory record not found");
    }
    public void updateitem(int id, int newQuantity){
        Inventory temp = head;
        while(temp.next!=null){
            if(temp.next.id == id){
                temp.next.quantity = newQuantity;
                System.out.println("Quantity of id:" + id + " updated to:" + newQuantity);
                return;
            }
            temp = temp.next;
        }
    }
    public void searchbyid(int Id){
        Inventory temp = head;
        boolean found  =false;
        while(temp!=null){
            if(temp.id == Id){
                System.out.println("Record found:");
                System.out.println("Item name: " + temp.name);
                System.out.println("Item id: " + temp.id);
                System.out.println("Item price: " + temp.price);
                found = true;
                return;
            }
            temp = temp.next;
        }
        if(!found){
            System.out.println("Requested item not found");
        }
    }
    public void getbyname(String Name){
        Inventory temp = head;
        boolean found = false;
        while(temp!=null){
            if(temp.name.equals(Name)){
                System.out.println("Record found:");
                System.out.println("Item name: " + temp.name);
                System.out.println("Item id: " + temp.id);
                System.out.println("Item price: " + temp.price);
                System.out.println("Item quantity: " + temp.quantity);
                found = true;
                return;
            }
            temp = temp.next;
        }
        if(!found){
            System.out.println("Requested item not found");
        }
    }
    public double gettotalprice(){
        Inventory temp = head;
        double total = 0;
        while(temp!=null){
            double tempPrice = temp.price*temp.quantity;
            total += tempPrice;
            temp = temp.next;
        }
        return total;
    }
    public void displaydetails(){
        Inventory temp = head;
        while(temp!=null){
            System.out.println("Name: " + temp.name + " ID: " + temp.id + " Quantity: " + temp.quantity + " Price: " + temp.price);
            temp = temp.next;
        }
    }
    public void Sortitems(String field, String order){
        if(head==null) System.out.println("No items to sort");
        if(head.next==null) System.out.println("Not enough items to sort");
        boolean swapped = false;
        do { 
            Inventory current = head;
            Inventory prev = null;
            while(current.next!=null){
                boolean shouldSwap = false;
                if(field.equalsIgnoreCase("name")){
                    int compare = current.name.compareToIgnoreCase(current.next.name);
                    shouldSwap = order.equalsIgnoreCase("asc") ? compare > 0 : compare < 0;
                }
                if(field.equalsIgnoreCase("price")){
                    shouldSwap = order.equalsIgnoreCase("asc") ? current.price>current.next.price : current.next.price>current.price; 
                }
                if(shouldSwap){
                    Inventory nextNode = current.next;
                    current.next = nextNode.next;
                    nextNode.next = current;
                    if(prev==null){
                        head = nextNode;
                    }
                    else{
                        prev.next = nextNode;
                    }
                    swapped = true;
                    prev = nextNode;
                }else{
                    prev = current;
                    current = current.next;
                }
            }
        }while(swapped);
    }
}
public class InventoryItems{
    public static void main(String[] args) {
       InventoryList inv = new InventoryList();
       inv.addatBeginning(new Inventory("Mouse", 101, 3, 50));
       inv.addatEnd(new Inventory("TV", 102, 2, 150));
       inv.addatPosition(new Inventory("Laptop", 103, 2, 60), 1);
       inv.displaydetails();
       inv.searchbyid(101);
       inv.gettotalprice();
       inv.Sortitems("name", "asc");
       inv.displaydetails();
       inv.Sortitems("price", "desc");
       inv.displaydetails();
    }
}