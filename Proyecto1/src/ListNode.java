/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author manuel
 */
public class ListNode {
    int value;
    ListNode next;
    ListNode previous;
    
    public ListNode(int value){
        this.value = value;
        next = null;
        previous = null;
    }
    
    public int getValue(){
        return value;
    }
    
    
    public ListNode getPrevious(){
        return previous;
    }
    
    public void setPrevious(ListNode nuevo){
        previous = nuevo;
    }
    
    public ListNode getNext(){
        return next;
    }
    
    public void setNext(ListNode nuevo){
        next = nuevo;
    }
    
    public boolean hasNext(){
        if(next == null){
            return false;
        }else{
            return true;
        }
    }
}
