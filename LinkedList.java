public class LinkedList implements List {
    private Node head;
    private int size;

    public LinkedList(){
        size = 0;
    }

    public void add(Object obj) throws Exception{
        Node addNode =  new Node(obj);
        if(size==0)
            head = addNode;
        else {
            Node currNode = head;
            while(currNode.next!=null)
                currNode = currNode.next;
            currNode.next = addNode;
        }
        size++;
    }

    public void add(int pos, Object obj) throws Exception{
        if(pos>size){
            throw new Exception("Theres nothing to link them!");
        }
        else if(size==0){
            head = new Node(obj);
            size++;
        }
        else if(size==1&&pos==1){
            head.next = new Node(obj);
            size++;
        }
        else if(pos==size){
            Node currNode = head;
            for(int i=0;i<pos-1;i++)
                currNode = currNode.next;
            currNode.next = new Node(obj);
            size++;
        }
        else{
            Node addNode = new Node(obj);
            Node currNode = head;
            for(int i=0;i<pos;i++)
                currNode = currNode.next;
            addNode.next = currNode.next;
            currNode.next = addNode;
            size++;
            System.out.println((String)currNode.data + ", " + (String)currNode.next.data);
        }
    }
    public Object get(int pos) throws Exception{
        if(pos>size-1)
            throw new Exception("There's nothing at that position!");
        else if(pos==0)
            return head.data;
        else if(pos==size-1){
            Node currNode = head;
            while(currNode.next!=null)
                currNode = currNode.next;
            return currNode.data;
        }
        else{
            Node currNode = head;
            for(int i=0;i<pos-1;i++)
                currNode = currNode.next;
            return currNode.next.data;
        }

    }
    public Object remove(int pos) throws Exception{
        if(pos>size-1)
            throw new Exception("There's nothing at that position!");
        else if(pos==0){
            Object returnData = head.data;
            head = head.next;
            size--;
            return returnData;
        }
        else {
            Node currNode = head;
            for(int i=0;i<pos-1;i++)
                currNode = currNode.next;
            Node returnNode = currNode.next;
            currNode.next = currNode.next.next;
            size--;
            return returnNode.data;
        }
    }

    public int size(){
        return size;
    }
}
