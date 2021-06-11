package cource.lesson4;

public class lesson4 {

    public static void main(String[] args) {
        MyLinkedList<String> list = new MyLinkedList<>();

        list.insert("Первый");
        list.insert("Второй");
        list.insert("Третий");

        for(String s : list){
            System.out.println(s);
        }
    }
}

