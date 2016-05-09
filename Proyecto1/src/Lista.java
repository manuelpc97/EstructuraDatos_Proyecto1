/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author manuel
 */
public class Lista {
    ListNode head;
    int size;

    public Lista(int value) {
        head = new ListNode(value);
        size = 1;
    }

    public ListNode getHead() {
        return head;
    }

    public void setHead(ListNode value) {
        head = value;
    }

    public void insert(int value, int position) {
        if (position >= 0 && position < size) {
            ListNode current = head;
            if (position == 0) {
                this.setHead(new ListNode(value));
                head.setNext(current);
            } else {
                for (int i = 0; i < position - 1; i++) {
                    current = current.getNext();
                }

                if (current.hasNext() == false) {
                    current.setNext((new ListNode(value)));
                } else {
                    ListNode second = current.getNext();
                    current.setNext(new ListNode(value));
                    current.getNext().setNext(second);
                }
            }
            size++;
        }
    }

    public int getSize() {
        return size;
    }

    public int find(int value) {
        ListNode current = head;

        for (int i = 0; i < size; i++) {
            if (current.getValue() == value) {
                return i;
            }
            current = current.getNext();
        }
        return -1;
    }

    public int get(int position) {
        ListNode current = head;

        for (int i = 0; i < size; i++) {
            if (i == position) {
                return current.getValue();
            }

            current = current.getNext();
        }
        return -1;
    }

    public int first() {
        return head.getValue();
    }

    public void concat(Lista nueva) {
        ListNode current = head;
        while (current.hasNext()) {
            current = current.getNext();
        }

        current.setNext(nueva.getHead());
        size = size + nueva.getSize();
    }

    public void push(int value) {
        if (head.hasNext() == true) {
            ListNode current = head;

            while (current.hasNext()) {
                current = current.getNext();
            }

            current.setNext(new ListNode(value));
        } else {
            head.setNext(new ListNode(value));
        }
        size++;
    }

    public void remove(int position) {
        if (position >= 0 && position < size) {
            if (position == 0) {
                this.setHead(head.getNext());
            } else {
                ListNode current = head;
                for (int i = 0; i < position - 1; i++) {
                    current = current.getNext();
                }

                if (current.getNext().hasNext()) {
                    ListNode second = current.getNext().getNext();
                    current.setNext(second);
                } else {
                    current.setNext(null);
                }
            }
            size--;
        }
    }

    public void showList() {
        ListNode current = head;
        for (int i = 0; i < size; i++) {
            System.out.println(current.getValue());
            current = current.getNext();
        }
    }
}
