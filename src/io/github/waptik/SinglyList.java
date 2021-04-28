package io.github.waptik;



class Node {
    private String data;
    private Node next;
    
    public Node(String data){
        this.data = data;
        next = null;
    }
    public String getData(){
        return data;
    }
    public void setData(String data){
        this.data = data;
    }
    public Node getNext(){
        return next;
    }
    public void setNext(Node next){
        this.next = next;
    }
}


public class SinglyList {

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        
        list.insertAtHead("John");
        list.insertAtEnd("Ama");
        list.navigate();
        list.navigate();
        
        System.out.println(list.addAfterGivenNode("John", "Solo"));
        System.out.println(list.search("John"));
        
        list.navigate();
	// write your code here
    }
}

 class LinkedList {
    //head
    private Node head;
    //tail
    private Node tail;
    //size - number of nodes in linked list
    private int size;
    
    public boolean isEmpty(){
        return head == null;
    }
    public int size(){
        return size;
    }
    
    //insert at the top
    public void insertAtHead(String element){
        Node node = new Node(element);
        if(isEmpty()){
            head = node;
            tail = node;
        }
        else{
            node.setNext(head);
            head = node;
        }
        size++;
    }
    
    //insert at the bottom
    public void insertAtEnd(String element){
        Node node = new Node(element);
        if(isEmpty()){
            head = node;
            tail = node;
        }
        else{
            tail.setNext(node);
            tail = node;
        }
        size++;
    }
    
    //delete at the top
    public Node DeleteFromHead(){
        Node deleted = null;
        if(!isEmpty()){
            deleted = new Node(head.getData());
            //single node, we have to update head as well tail
            if(size == 1){ // if(head == tail)
                head = null;
                tail = null;
            }
            //multiple nodes, then head only update
            else{
                head = head.getNext();
            }
            size--;
        }
        return deleted;
    }
    
    //traverse through the list
    public void navigate(){
        System.out.println("printing linked list elements");
        System.out.print("head -->");
        Node temp = head;
        while (temp != null){
            System.out.print(temp.getData() + "-->");
            temp = temp.getNext();
        }
        System.out.println("null");
    }
    
    //deleteLast
    public Node deleteFromEnd(){
        Node deleted = null;
        if(!isEmpty()){
            deleted = new Node(tail.getData());
            //traversing and finding the second last node
            Node temp = head;
            Node previous = null;
            while (temp.getNext() != null){
                previous = temp;
                temp = temp.getNext();
            }
            if(previous == null){
                //single node
                head = null;
                tail = null;
            }
            else{
                //multiple node
                previous.setNext(null);
                tail = previous;
            }
            size--;
        }
        return deleted;
    }
    
    //insert at last, without using tail reference
    //O(n)
    public void addLastWithOutUsingTail(String element){
        Node node = new Node(element);
        if(isEmpty()){
            head = node;
            //update tail also
            tail = node;
        }
        else{
            Node temp = head;
            while(temp.getNext() != null){
                temp = temp.getNext();
            }
            temp.setNext(node);
            //update tail
            tail = node;
        }
        size++;
    }
    //search
    public boolean search(String searchElement){
        boolean response = false;
        Node temp = head;
        while(temp != null){
            if(temp.getData().equals(searchElement)){
                response = true;
                break;
            }
            temp = temp.getNext();
            
        }
        return response;
    }
    //insertAfterGivenNode
    public boolean addAfterGivenNode(String element, String givenElement){
        boolean response = false;
        Node temp = head;
        while (temp != null){
            if(temp.getData().equals(givenElement)){
                break;
            }
            temp = temp.getNext();
        }
        if(temp != null){
            Node node = new Node(element);
            node.setNext(temp.getNext());
            temp.setNext(node);
            response = true;
            size++;
            //check if temp is last node, then tail must refer to node
            if(temp == tail){
                tail = node;
            }
        }
        return response;
    }
    
    //addBeforeGivenNode
    //InsertInBetween
    public boolean addBeforeGivenNode(String element, String givenElement){
        boolean response = false;
        Node temp = head;
        Node previous = null;
        while (temp != null){
            if(temp.getData().equals(givenElement)){
                break;
            }
            previous = temp;
            temp = temp.getNext();
        }
        if(temp != null){
            Node node = new Node(element);
            node.setNext(temp);
            response = true;
            size++;
            if(previous == null){
                //adding at head
                head = node;
            }
            else{
                previous.setNext(node);
            }
        }
        
        
        return response;
    }
    
    //deleteGivenElement
    public Node removeGivenNode(String givenElement){
        Node deleted = null;
        Node temp = head;
        Node previous = null;
        while (temp != null){
            if(temp.getData().equals(givenElement)){
                break;
            }
            previous = temp;
            temp = temp.getNext();
        }
        //if givenElement is present in linked list
        if(temp != null){
            deleted = new Node(temp .getData());
            //deleting node is head
            if(previous == null){
                head = head.getNext();
                //if only single node and is deleted, head becomes null
                if(head == null){
                    tail = null;
                }
            }
            else{
                previous.setNext(temp.getNext());
                //if temp is the last node, update the tail
                if(temp == tail){
                    tail = previous;
                }
            }
            size--;
        }
        
        return deleted;
    }
}
