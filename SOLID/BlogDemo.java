package MongoDB.SOLID;
//q:IBaseUser is general interface. It has a set of common methods for each successor type. In this example, the Admin and Writer have a common method for editing blog posts. But readers don’t they can only read posts. Also, only the admin can block posts. The Reader and Writer classes have to implement the methods they don’t use.
//Now, new users are added with a set of methods related to them. Hence IBaseUser interface becomes more and more complex. All the classes that implement IBaseUser grow relatively. So,
//1.	How to solve this problem? 
//2.	Which SOLID principle is not considered while designing this system? 
//3.	Design new system to tackle this issue.

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Separate Interfaces
interface IUser {
    String getName();
}

interface IEditable {
    void editPost(String post);
}

interface IReadable {
    void readPost(String post);
}

interface IBlockable {
    void blockPost(String post);
}

// Base User Class
class BaseUser implements IUser {
    private String name;

    public BaseUser(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

// Implementing Classes
class Admin extends BaseUser implements IEditable, IBlockable {
    public Admin(String name) {
        super(name);
    }

    public void editPost(String post) {
        System.out.println("Admin " + getName() + " is editing post: " + post);
    }

    public void blockPost(String post) {
        System.out.println("Admin " + getName() + " is blocking post: " + post);
    }

     public void readPost(String post) {
        System.out.println("Admin " + getName() + " is reading post: " + post);
    }
}

class Writer extends BaseUser implements IEditable, IReadable {
    public Writer(String name) {
        super(name);
    }

    public void editPost(String post) {
        System.out.println("Writer " + getName() + " is editing post: " + post);
    }

    public void readPost(String post) {
        System.out.println("Writer " + getName() + " is reading post: " + post);
    }
}

class Reader extends BaseUser implements IReadable {
    public Reader(String name) {
        super(name);
    }

    public void readPost(String post) {
        System.out.println("Reader " + getName() + " is reading post: " + post);
    }
}

public class BlogDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<IUser> users = new ArrayList<>();

        System.out.println("Blog Application");

        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Add User");
            System.out.println("2. Edit Post (Admin/Writer)");
            System.out.println("3. Block Post (Admin)");
            System.out.println("4. Read Post (Reader/Writer/Admin)");
            System.out.println("5. List Users");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter user name: ");
                    String userName = scanner.nextLine();
                    System.out.print("Enter user type (Admin/Writer/Reader): ");
                    String userType = scanner.nextLine();
                    IUser newUser = null;
                    switch (userType.toLowerCase()) {
                        case "admin":
                            newUser = new Admin(userName);
                            break;
                        case "writer":
                            newUser = new Writer(userName);
                            break;
                        case "reader":
                            newUser = new Reader(userName);
                            break;
                        default:
                            System.out.println("Invalid user type.");
                            break;
                    }
                    if (newUser != null) {
                        users.add(newUser);
                        System.out.println("User " + userName + " added as " + userType);
                    }
                    break;
                case 2:
                    System.out.print("Enter user name: ");
                    String editorName = scanner.nextLine();
                    System.out.print("Enter post to edit: ");
                    String postToEdit = scanner.nextLine();
                    for (IUser user : users) {
                        if (user.getName().equals(editorName) && user instanceof IEditable) {
                            ((IEditable) user).editPost(postToEdit);
                            break;
                        }
                         else if (user.getName().equals(editorName) && !(user instanceof IEditable)) {
                            System.out.println("User "+ editorName + " cannot edit post.");
                            break;
                        }
                    }

                    break;
                case 3:
                    System.out.print("Enter admin name: ");
                    String adminName = scanner.nextLine();
                    System.out.print("Enter post to block: ");
                    String postToBlock = scanner.nextLine();
                     for (IUser user : users) {
                        if (user.getName().equals(adminName) && user instanceof IBlockable) {
                            ((IBlockable) user).blockPost(postToBlock);
                            break;
                        }
                        else if (user.getName().equals(adminName) && !(user instanceof IBlockable)) {
                            System.out.println("User "+ adminName + " cannot block post.");
                            break;
                        }
                    }
                    break;
                case 4:
                    System.out.print("Enter user name: ");
                    String readerName = scanner.nextLine();
                    System.out.print("Enter post to read: ");
                    String postToRead = scanner.nextLine();
                    for (IUser user : users) {
                        if (user.getName().equals(readerName) && user instanceof IReadable) {
                            ((IReadable) user).readPost(postToRead);
                            break;
                        }
                        else if (user.getName().equals(readerName) && !(user instanceof IReadable)) {
                            System.out.println("User "+ readerName + " cannot read post.");
                            break;
                        }
                    }
                    break;
                case 5:
                    System.out.println("Users:");
                    for (IUser user : users) {
                        System.out.println(user.getName());
                    }
                    break;
                case 6:
                    System.out.println("Exiting application.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

