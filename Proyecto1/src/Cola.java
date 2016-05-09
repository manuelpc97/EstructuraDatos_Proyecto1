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

    Cola(int value) {
        head = new ListNode(value);
        size = 1;
    }

    public int getHead() {
        return head.getValue();
    }

    public void queue(int number) {
        ListNode nuevo = new ListNode(number);
        if(head.hasNext() == false){
            head.setNext(nuevo);
            last = nuevo;
        }else{
            last.setNext(nuevo);
            last = nuevo;
        }
        size++;
    }

    public int DeQueue() {
        ListNode retorno = head;
        head = head.getNext();
        size--;
        return retorno.getValue();
    }

    public int peek() {
        return head.getValue();
    }

    public int getSize() {
        return size;
    }
}
