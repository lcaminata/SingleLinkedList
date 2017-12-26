
/** *******************************************************************
 * Purpose/Description: <This program will add and remove elements, check if an
 * element is inside the list, and return the size of the list using the Node class
 * to assist the search for elements inside the list.>
 * Certification: I hereby certify that this work is my own and none of it is
 * the work of any other person.
 * ******************************************************************
 */
public class MySingleLinkedList {

    Node head;
    int size;

    /**
     * Constructs the MySingleLinkedList for any object in the main class.
     */
    public MySingleLinkedList() {
        head = new Node(null);
        size = 0;
    }

    private class Node<Object> {

        Node() {
            this(null, null);
        }

        Node(Object d) {
            this(d, null);
        }

        Node(Object d, Node n) {
            data = d;
            next = n;
        }

        Object data;
        Node next;
    }

    /**
     * Size of the list is edited by the add and remove methods.
     *
     * @return size of the list.
     */
    int size() {
        return size;
    }

    /**
     * Will run through the list encapsulating the element in each node in
     * between brackets printing the entire list.
     */
    void print() {
        Node<Object> currentNode = head.next;
        String output = "";
        while (currentNode != null) {
            output += "[" + currentNode.data + "]";
            currentNode = currentNode.next;
        }
        System.out.println(output);
    }

    /**
     * Boolean method that checks for the element input in the list.
     *
     * @param element value being searched.
     * @return true if the element is found in the list, false if it is not.
     */
    boolean contains(Object element) {
        Node<Object> currentNode = head;
        while (currentNode.next != null) {
            if (currentNode.next.data == element) {
                return true;
            }
            currentNode = currentNode.next;
        }
        return false;
    }

    /**
     * Boolean method set up to add an element at the end of the list if it is
     * not already on the list.
     *
     * @param element value the user intends to add.
     * @return true if the value is not already on the list and can be added,
     * false if the value is already on the list.
     */
    boolean add(Object element) {
        Boolean check = true;
        Node<Object> elementNode = new Node<Object>(element);
        Node<Object> currentNode = head;
        while (currentNode.next != null) {
            if (contains(element)) {
                return false;
            }
            currentNode = currentNode.next;
        }
        if (check) {
            currentNode.next = elementNode;
            size++;
        }
        return check;
    }

    /**
     * Boolean method set up to remove an element if it is found inside the
     * list.
     *
     * @param element value the user intends to remove
     * @return true if the value if found on the list, false if it is not found.
     */
    boolean remove(Object element) {
        Node<Object> currentNode = head;
        while (currentNode.next != null) {
            if (currentNode.next.data == element) {
                currentNode.next = currentNode.next.next;
                size--;
                return true;
            } else {
                currentNode = currentNode.next;
            }
        }
        return false;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MySingleLinkedList list = new MySingleLinkedList();
        final int FIRST_ELEMENT = 0;
        final int LAST_ELEMENT = 5;
        for (int addElement = FIRST_ELEMENT; addElement <= LAST_ELEMENT; addElement++) {
            list.add(addElement);
        }
        list.print();
        System.out.println();
        final int ADD_TRIAL = 6;
        if (!list.add(ADD_TRIAL)) {
            System.out.println(ADD_TRIAL + " is already in the list, it will not"
                    + " be added again.\nThe add boolean method is set up to only "
                    + "add new element onto the list.");
        } else {
            System.out.println("New list:");
            list.print();
        }
        System.out.println();
        final int CONTAINS_TRIAL = 3;
        if (list.contains(CONTAINS_TRIAL)) {
            System.out.println(CONTAINS_TRIAL + " is found on the list.");
        } else {
            System.out.println(CONTAINS_TRIAL + " is not found on the list.");
        }
        System.out.println();
        final int REMOVE_TRIAL = 5;
        if (!list.remove(REMOVE_TRIAL)) {
            System.out.println(REMOVE_TRIAL + " was not found on the list, therefore"
                    + " it cannot be removed.");
        }
        System.out.println("This will be the list once " + REMOVE_TRIAL + " is removed.");
        list.print();
        System.out.println();
        int size = list.size();
        System.out.println("Finally, the program will return the size of the list "
                + "using the size int method.");
        System.out.println("Size: " + size);
    }

}
