public class DLLSelectSort{
    public static void main(String[] args) {
        DLLNode<Integer> ls = new DLLNode<Integer>(0);
        for(int i = 1; i < 12; i++){
            ls.append((int) ((Math.random())*100));
        }

       ls.printLs();

       selectSort(ls);
       ls.printLs();
    }

    public static void selectSort(DLLNode<Integer> ls){
        DLLNode<Integer> x = ls;
        while(x != null){
            DLLNode<Integer> temp = x.next;
            DLLNode<Integer> minNode = x;

            while(temp != null){
                if (temp.key < minNode.key) {
                    minNode = temp;
                }
                temp = temp.next;
            }
            if(minNode.key != x.key){
                swap(ls, x, minNode); //Swapping pointers 
                DLLNode<Integer> swapName = x; /*Swapping
                                                Names   */
                x = minNode;                     
                minNode = swapName;

            }
            x = x.next;
        }
     }

    
    public static void swap(DLLNode<Integer> ls, DLLNode<Integer> temp1, DLLNode<Integer> temp2){
        // DLLNode<Integer> temp1 = ls.find(x);
        // DLLNode<Integer> temp2 = ls.find(y);

        DLLNode<Integer> temp;
       // System.out.println(ls.tail == temp2);
            if (temp1 == ls.head)
                {
                    //System.out.println("worked!");
                    //Swap previus node
                    temp = temp2.prev;
                    temp2.prev = null;
                    temp1.prev = temp;
                    temp1.prev.next = temp1;
                    //Swap next node
                    if (temp2 == ls.tail){
                        temp = temp1.next;
                        temp1.next = null;
                        temp2.next = temp;
                        temp2.next.prev = temp2;
                        ls.tail = temp1;
                        ls.head = temp2;
                        return;
                    }
                    temp = temp2.next;
                    temp2.next = temp1.next;
                    temp2.next.prev = temp2;
                    temp1.next = temp;
                    temp1.next.prev = temp1;
                    ls.head = temp2;
                    return;
                }
       
        //Nodes next swapped
        temp = temp1.next;
        temp1.next = temp2.next;
        temp2.next = temp;
        //succeding node has a new prev
        if (temp1.next != null)
            temp1.next.prev = temp1;
        if (temp2.next != null)
            temp2.next.prev = temp2;
        //Nodes prev swapped
        temp = temp1.prev;
        temp1.prev = temp2.prev;
        temp2.prev = temp;
     
        if (temp1.prev != null)
            temp1.prev.next = temp1;
        if (temp2.prev != null)
            temp2.prev.next = temp2;
        if (temp2 == ls.tail) {
            ls.tail = temp1;
        }
      
    }
}