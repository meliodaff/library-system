package Dashboard;

import Model.Publisher;

import java.util.List;
import java.util.Scanner;

public class PublishersDashboard {
    Scanner scanner = new Scanner(System.in);
    public byte publishersDashboard(){
        System.out.println("++ Publishers ++");
        System.out.println("[1] View Publishers");
        System.out.println("[2] View Specific Publisher");
        System.out.println("[3] View Publisher Books");
        System.out.println("[4] Add Publisher");
        System.out.println("[5] Update Publisher");
        System.out.println("[6] Delete Publisher");
        System.out.println("[7] Back");
        System.out.println("-------------------------");
        byte choice = scanner.nextByte();
        scanner.nextLine();
        return choice;
    }

    public void displayPublishers(List<Publisher> publishers){
        for(Publisher publisher : publishers){
            System.out.println("Publisher's ID: " + publisher.getId());
            System.out.println("Publisher's name: " + publisher.getName());
            System.out.println("Publisher's email: " + publisher.getEmail());
            System.out.println("Publisher's address: " + publisher.getAddress());
            System.out.println("-----------------------------------");
        }
    }

    public void displaySpecificPublisher(Publisher publisher){
        System.out.println("Publisher's ID: " + publisher.getId());
        System.out.println("Publisher's name: " + publisher.getName());
        System.out.println("Publisher's email: " + publisher.getEmail());
        System.out.println("Publisher's address: " + publisher.getAddress());
    }

    public void displayPublisherBooks(List<Publisher> publisher) {
        byte i = 1;
        if (publisher == null || publisher.isEmpty()) { // i think isEmpty can handle this expression
            System.out.println("publisher has no books");
        }
        for (Publisher publisherBooks : publisher) {
            if (i > 0) {
                System.out.println("Publisher's name: " + publisherBooks.getName());
                System.out.println("Publisher's email: " + publisherBooks.getEmail());
                System.out.println("Publisher's address: " + publisherBooks.getAddress());
                i--;
            }
            System.out.println("------------------");
            System.out.println(publisherBooks.getBooks());
            System.out.println("------------------");
        }
    }
}
