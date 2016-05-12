/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author manuel
 */
public class Cola {
    ListNode head;
    ListNode last;
    int size;

    public Cola() {
        head = null;
    }

    
    Cola(Object value) {
        head = new ListNode(value);
        size = 1;
    }

    public Object getHead() {
        return head.getValue();
    }

    public void queue(Object object) {
        ListNode nuevo = new ListNode(object);
        if(head == null){
            head = nuevo;
            last = nuevo;
        }else{
            if(head.hasNext() == false){
                head.setNext(nuevo);
                last = nuevo;
            }else{
                last.setNext(nuevo);
                last = nuevo;
            }
        }
        size++;
    }

    public Object DeQueue() {
        ListNode retorno = head;
        head = head.getNext();
        size--;
        return retorno.getValue();
    }

    public Object peek() {
        return head.getValue();
    }

    public int getSize() {
        return size;
    }
}
