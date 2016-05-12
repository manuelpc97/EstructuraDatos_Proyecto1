/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author manuel
 */
public class Pila {
    ListNode top;
    int size;

    public Pila() {
        top = null;
        size = 0;
    }

    public Pila(int value) {
        top = new ListNode(value);
        size = 1;
    }

    public void push(int value) {
        if(size == 0){
            top = new ListNode(value);
        }else{
            top.setNext(new ListNode(value));
            top.getNext().setPrevious(top);
            top = top.getNext();
        }
        size++;
    }

    public boolean isEmpty() {
        if (size == 0) {
            return true;
        } else {
            return false;
        }
    }

    public Object pop() {
        ListNode last = top;
        top = top.getPrevious();
        top.setNext(null);
        return last.getValue();
    }
    
    public Object peek(){
        return top.getValue();
    }
}
