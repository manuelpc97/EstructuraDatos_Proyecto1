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

        size = 0;
    }

    Cola(Object value) {
        head = new ListNode(value);
        last = head;
        size = 1;
    }

    public Object getHead() {
        return head.getValue();
    }

    public void queue(Object object) {
        if (size == 0) {
            head = new ListNode(object);
            last = head;
        } else {
            if (size == 1) {
                head.setNext(new ListNode(object));
                last = head.getNext();
            } else if (size > 1) {
                last.setNext(new ListNode(object));
                last = last.getNext();
            }
        }
        size++;
    }

    public Object DeQueue() {
        ListNode temporal = new ListNode(head.getValue());
        if (size == 1) {
            head = null;
        } else {
            head = head.getNext();
        }
        size--;
        return temporal.getValue();
    }

    public Object peek() {
        return head.getValue();
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        if (size == 0) {
            return true;
        } else {
            return false;
        }
    }
}
