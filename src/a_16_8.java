
public class a_16_8
{
    /* Write a method called switchPairs that switches the order of values in the list in a pairwise fashion. Your method
    should switch the order of the first two values, then switch the order of the next two, switch the order of the next
    two, and so on. If the list contains an odd number of values, the final element is not moved. For example, if the list
    initially stores [10, 25, 31, 47, 52, 68, 77], your method should switch the first pair (10 and 25), the second
    pair (31 and 47), and the third pair (52 and 68) to yield [25, 10, 47, 31, 68, 52, 77].*/

    //initiate standard variables
    private ListNode front;

    //too test the method
    public void run()
    {
        //I have made an add-method to ListNode
        addNodeToList(0,10);
        addNodeToList(1,25);
        addNodeToList(2,31);
        addNodeToList(3,47);
        addNodeToList(4,52);
        addNodeToList(5,68);
        addNodeToList(6,77);

        //I have made a print list data method
        printList();
        switchPairs();
        printList();
    }

    //switch pairs positions
    public void switchPairs()
    {
        //initiate variables
        int copyA = 0;
        int copyB = 0;

        //the for-loop finds the pairs and switch their position
        for (ListNode current = front; current != null; current = current.next)
        {
            //checks if current has a partner
            if (current.next != null)
            {
                //need to copy data inorder to set the right position
                copyA = current.data;
                copyB = current.next.data;

                current.data = copyB;
                current.next.data = copyA;

                //to go to next pair
                current = current.next;
            }
        }
    }

    //an add-method to ListNode that adds a value to the list
    public void addNodeToList(int index, int value)
    {
        //if index is 0, then add value to front
        if(index == 0)
        {
            front = new ListNode(value, front);
        }
        // else add a value to the end of list
        else
        {
            ListNode current = front;
            for (int i = 0; i < index-1; i++)
            {
                current = current.next;
            }
            current.next = new ListNode(value,current.next);
        }
    }

    //prints the list
    public void printList()
    {
        //the for-loop that prints the list data out
        System.out.print("[ ");
        for (ListNode current = front; current != null; current = current.next)
        {
            System.out.print(current.data + ", ");
        }
        System.out.println("]" + "\n");
    }
}
