package Lists;

import Exceptions.EmptyArrayException;
import Exceptions.NotFoundException;
import Interfaces.ListADT;
import Nodes.DoubleNode;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * <h3>
 * ESTG - Escola Superior de Tecnologia e Gestão<br>
 * IPP - Instituto Politécnico do Porto<br>
 * LEI - Licenciatura em Engenharia Informática<br>
 * PP - Paradigmas de Programação<br>
 * </h3>
 * <p>
 * <strong>Author: </strong><br>
 * Joao Sousa<br>
 * <strong>Description: </strong><br>
 * Class that represents
 * </p>
 *
 * @param <T>
 */
public class DoubleLinkedListADT<T> implements ListADT<T>, Iterable<T> {

    protected DoubleNode head;
    protected DoubleNode rear;
    protected int count;
    protected int modcount;

    private class BasicIterator implements Iterator {

        private DoubleNode current;
        private int expectedmodcount;

        public BasicIterator() {
            this.current = head;
            this.expectedmodcount = modcount;
        }

        @Override
        public boolean hasNext() {
            if (expectedmodcount != modcount) {
                throw new Error();
            }
            return (current != null);
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new Error();
            }
            T tmp = (T) current.getElement();
            current = current.getNext();
            return tmp;
        }

        @Override
        public void remove() {
            if(!hasNext()) {
                throw new Error();
            }
            try {
                DoubleLinkedListADT.this.remove(next());
            } catch (NotFoundException | EmptyArrayException ex) {
                Logger.getLogger(DoubleLinkedListADT.class.getName()).log(Level.SEVERE, null, ex);
            }
            expectedmodcount++;
        }

    }

    /**
     * Creates a empty DoubleLinkedList
     */
    public DoubleLinkedListADT() {
        this.head = null;
        this.rear = null;
        this.count = 0;
        this.modcount = 0;
    }

    @Override
    public T removeFirst() throws EmptyArrayException {
        if (isEmpty()) {
            throw new EmptyArrayException("A lists está vazia, não pode remover...");
        }
        T toremove = (T) head.getElement();
        if (size() == 1) {
            head = rear = null;
        } else {
            head = head.getNext();
            head.setPrevious(null);
        }
        count--;
        modcount++;
        return toremove;
    }

    @Override
    public T removeLast() throws EmptyArrayException {
        if (isEmpty()) {
            throw new EmptyArrayException("A lists está vazia, não pode remover...");
        }
        T toremove = (T) rear.getElement();
        if (size() == 1) {
            head = rear = null;
        } else {
            rear = rear.getPrevious();
            rear.setNext(null);
        }
        count--;
        modcount++;
        return toremove;
    }

    @Override
    public T remove(T element) throws NotFoundException, EmptyArrayException {
        if(isEmpty())
            throw new EmptyArrayException();
        if(!contains(element))
            throw new NotFoundException();
        DoubleNode<T> temp=find(element);
        if(size()==1){
            head=null;
            rear=null;
        } else if(temp.getPrevious()==null){
            head=head.getNext();
            head.setPrevious(null);
        } else if(temp.getNext()==null){
            rear=rear.getPrevious();
            rear.setNext(null);
        } else{
            temp.getPrevious().setNext(temp.getNext());
            temp.getNext().setPrevious(temp.getPrevious());
        }
            
        count--;
        modcount++;
        return temp.getElement();
    } 

    @Override
    public T first() throws EmptyArrayException {
        if (isEmpty()) {
            throw new EmptyArrayException("A lista está vazia...");
        }
        return (T) head.getElement();
    }

    @Override
    public T last() throws EmptyArrayException {
        if (isEmpty()) {
            throw new EmptyArrayException("A lista está vazia...");
        }
        return (T) rear.getElement();
    }

    @Override
    public boolean contains(T target) {
        boolean found = false;
        Iterator it = iterator();
        while (it.hasNext() && !found) {
            Comparable tmp = (Comparable) it.next();
            if (tmp.compareTo(target) == 0) {
                found = true;
            }
        }
        return found;
    }

    @Override
    public boolean isEmpty() {
        return (size() == 0);
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public Iterator<T> iterator() {
        return new BasicIterator();
    }
        
    private DoubleNode<T> find(T element){
        boolean found=false;
        DoubleNode<T> temp=head;
        while(temp!=null && !found){
            Comparable tempElement=(Comparable) temp.getElement();
            if(tempElement.compareTo(element)==0)
                found=true;
            else
                temp=temp.getNext();
        }
        if(!found)
            temp=null;
        return temp;
    }
    
    @Override
    public String toString() {
        String result = "\n\t-----To String-----";
        Iterator it = iterator();
        while (it.hasNext()) {
            result += "\n" + it.next();
        }
        return result;
    }

}
