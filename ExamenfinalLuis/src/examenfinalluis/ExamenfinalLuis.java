package examenfinalluis;

public class ExamenfinalLuis {
    //EJERCICIO 1
    public static void main(String[] args) {
        List l = new List();
        l.insert("S");
        l.insert("A");
        l.insert("L");
        l.insert("U");
        l.insert("D");
        l.insert("O");
        l.insert("S");
        
        System.out.println("La lista tiene " + l.count() + " elementos.");
    }
    public static class Node {
    
         private Node next,previous;
         private String v;

         public Node getNext() {
             return next;
         }

         public Node getPrevious() {
             return previous;
         }

         public void setPrevious(Node previous) {
             this.previous = previous;
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

        public List()  {
            head = null;
            tail = null;
        }
        public int count() {
        int counter = 0;

         Node aux = tail;
         while (!isEmpty() && aux != null && aux.getPrevious()!= tail ){ 
             aux= aux.getPrevious();
             counter++;
         }
         return counter;
    }
    boolean isEmpty(){
        return head == null;
    }
        public void insert(String v) {
            Node aux = new Node();
            aux.setV(v);
            if(head ==null) {
                head = aux;
                tail = head;
            }else {
                Node temp = tail;
                tail = aux;
                tail.setPrevious(temp);
                temp.setNext(aux);
                tail.setNext(head);
            }
        }
    }
}
