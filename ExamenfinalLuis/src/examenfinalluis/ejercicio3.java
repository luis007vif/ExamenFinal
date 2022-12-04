package examenfinalluis;

public class ejercicio3 {
    //EJERCICIO3
    public static void main(String[] args) {
        
        List l= new List();
        l.insert("A");
        l.insert("M");
        l.insert("O");
        l.insert("R");
        
        l.showreverse();
    }
    public static class Node {
    
    private Node next;
    private String v;

    public Node getNext() {
        return next;
    }
    public String getV() {
        return v;
    }
    public void setNext(Node next) {
        this.next = next;
    }
    public void setV(String v) {
        this.v = v;
    }   
}
    public static class List {
        private Node head, tail;
        private int c;

        public List() {
            head = null;
            tail = null;
        }
        public Node getHead() {
            return head;
        }
        public void insert(String p) {

            Node n = new Node();
            n.setV(p);

            if (head == null) {
                head = n;
                head.setNext(head);
                tail = head;

            } else {
                tail.setNext(n);
                n.setNext(head);
                tail = n;
            }
            c++;
        }
        public boolean isEmpty(){
            return this.head == null;
        }
        private void reverse(Node n, int v){
            if (v > 0) {
                Node ant = this.head;
                while(ant.getNext() != this.tail) ant = ant.getNext();
                System.out.println(n.getV());
                n.setNext(this.head);
                this.head = n;
                this.tail = ant;
                this.tail.setNext(null);

                this.reverse(ant, v - 1);
            } 
        }
        public void showreverse(){
            this.reverse(this.tail, this.c);
        }
    } 
}

    

