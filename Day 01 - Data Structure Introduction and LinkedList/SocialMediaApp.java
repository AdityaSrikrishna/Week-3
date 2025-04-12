import java.util.*;

class User {
    int userId;
    String name;
    int age;
    List<Integer> friendIds; // Friend list
    User next;

    public User(int userId, String name, int age) {
        this.userId = userId;
        this.name = name;
        this.age = age;
        this.friendIds = new ArrayList<>();
    }
}

class SocialNetwork {
    private User head;

    public void addUser(int userId, String name, int age) {
        User newUser = new User(userId, name, age);
        if (head == null) {
            head = newUser;
        } else {
            User temp = head;
            while (temp.next != null) temp = temp.next;
            temp.next = newUser;
        }
    }

    public User findUserById(int userId) {
        User temp = head;
        while (temp != null) {
            if (temp.userId == userId) return temp;
            temp = temp.next;
        }
        return null;
    }

    public List<User> findUserByName(String name) {
        List<User> matches = new ArrayList<>();
        User temp = head;
        while (temp != null) {
            if (temp.name.equalsIgnoreCase(name)) matches.add(temp);
            temp = temp.next;
        }
        return matches;
    }

    public void addFriendConnection(int id1, int id2) {
        if (id1 == id2) {
            System.out.println("Cannot add self as friend.");
            return;
        }

        User user1 = findUserById(id1);
        User user2 = findUserById(id2);

        if (user1 == null || user2 == null) {
            System.out.println("User not found.");
            return;
        }

        if (!user1.friendIds.contains(id2)) user1.friendIds.add(id2);
        if (!user2.friendIds.contains(id1)) user2.friendIds.add(id1);

        System.out.println("Friend connection added between " + user1.name + " and " + user2.name);
    }

    public void removeFriendConnection(int id1, int id2) {
        User user1 = findUserById(id1);
        User user2 = findUserById(id2);

        if (user1 == null || user2 == null) {
            System.out.println("User not found.");
            return;
        }

        user1.friendIds.remove(Integer.valueOf(id2));
        user2.friendIds.remove(Integer.valueOf(id1));

        System.out.println("Friend connection removed between " + user1.name + " and " + user2.name);
    }

    public void displayAllFriends(int userId) {
        User user = findUserById(userId);
        if (user == null) {
            System.out.println("User not found.");
            return;
        }

        System.out.println("Friends of " + user.name + ":");
        for (int fid : user.friendIds) {
            User friend = findUserById(fid);
            if (friend != null) {
                System.out.println("ID: " + friend.userId + ", Name: " + friend.name);
            }
        }
    }

    public void findMutualFriends(int id1, int id2) {
        User user1 = findUserById(id1);
        User user2 = findUserById(id2);

        if (user1 == null || user2 == null) {
            System.out.println("User not found.");
            return;
        }

        System.out.println("Mutual Friends between " + user1.name + " and " + user2.name + ":");
        for (int fid : user1.friendIds) {
            if (user2.friendIds.contains(fid)) {
                User friend = findUserById(fid);
                if (friend != null) {
                    System.out.println("ID: " + friend.userId + ", Name: " + friend.name);
                }
            }
        }
    }

    public void countFriendsOfEachUser() {
        User temp = head;
        while (temp != null) {
            System.out.println(temp.name + " has " + temp.friendIds.size() + " friend(s).");
            temp = temp.next;
        }
    }

    public void displayAllUsers() {
        User temp = head;
        while (temp != null) {
            System.out.println("User ID: " + temp.userId + ", Name: " + temp.name + ", Age: " + temp.age);
            temp = temp.next;
        }
    }
}

public class SocialMediaApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SocialNetwork network = new SocialNetwork();

        // Sample data
        network.addUser(1, "Alice", 25);
        network.addUser(2, "Bob", 30);
        network.addUser(3, "Charlie", 22);
        network.addUser(4, "Diana", 27);

        network.addFriendConnection(1, 2);
        network.addFriendConnection(1, 3);
        network.addFriendConnection(2, 3);
        network.addFriendConnection(2, 4);

        while (true) {
            System.out.println("\n--- Social Media Friend System ---");
            System.out.println("1. Add Friend Connection");
            System.out.println("2. Remove Friend Connection");
            System.out.println("3. Display All Friends");
            System.out.println("4. Find Mutual Friends");
            System.out.println("5. Search User by ID");
            System.out.println("6. Search User by Name");
            System.out.println("7. Count Friends of Each User");
            System.out.println("8. Display All Users");
            System.out.println("9. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter User ID 1: ");
                    int uid1 = sc.nextInt();
                    System.out.print("Enter User ID 2: ");
                    int uid2 = sc.nextInt();
                    network.addFriendConnection(uid1, uid2);
                    break;

                case 2:
                    System.out.print("Enter User ID 1: ");
                    uid1 = sc.nextInt();
                    System.out.print("Enter User ID 2: ");
                    uid2 = sc.nextInt();
                    network.removeFriendConnection(uid1, uid2);
                    break;

                case 3:
                    System.out.print("Enter User ID: ");
                    uid1 = sc.nextInt();
                    network.displayAllFriends(uid1);
                    break;

                case 4:
                    System.out.print("Enter User ID 1: ");
                    uid1 = sc.nextInt();
                    System.out.print("Enter User ID 2: ");
                    uid2 = sc.nextInt();
                    network.findMutualFriends(uid1, uid2);
                    break;

                case 5:
                    System.out.print("Enter User ID: ");
                    uid1 = sc.nextInt();
                    User user = network.findUserById(uid1);
                    if (user != null)
                        System.out.println("User Found: " + user.name + ", Age: " + user.age);
                    else
                        System.out.println("User not found.");
                    break;

                case 6:
                    System.out.print("Enter Name: ");
                    sc.nextLine(); // clear buffer
                    String name = sc.nextLine();
                    List<User> results = network.findUserByName(name);
                    if (results.isEmpty()) {
                        System.out.println("No user found with that name.");
                    } else {
                        for (User u : results) {
                            System.out.println("ID: " + u.userId + ", Name: " + u.name + ", Age: " + u.age);
                        }
                    }
                    break;

                case 7:
                    network.countFriendsOfEachUser();
                    break;

                case 8:
                    network.displayAllUsers();
                    break;

                case 9:
                    System.out.println("Exiting.");
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
