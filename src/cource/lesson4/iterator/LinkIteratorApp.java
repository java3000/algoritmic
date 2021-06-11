package cource.lesson4.iterator;

public class LinkIteratorApp {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        LinkInterator itr = new LinkInterator(list);
        itr.insertAfter("Artem", 20);
        itr.insertBefore("Sergey", 10);

        list.display();
        System.out.println("-----------");

        itr.insertBefore("Vasiya", 30);

        list.display();
        System.out.println("-----------");

        System.out.println(itr.getCurrent().name);

        System.out.println("-----------");

        itr.deleteCurrent();

        list.display();
        System.out.println("-----------");

        itr.nextLink();
        itr.insertAfter("Artem", 50);

        list.display();
        System.out.println("-----------");

        itr.reset();
        itr.insertBefore("Artem", 80);

        list.display();
        System.out.println("-----------");

    }
}
