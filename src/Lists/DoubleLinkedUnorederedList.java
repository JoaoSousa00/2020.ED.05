package Lists;

import Interfaces.UnorderedListADT;
import Nodes.DoubleNode;
import java.util.Iterator;
import java.util.NoSuchElementException;

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
 */
public class DoubleLinkedUnorederedList<T> extends DoubleLinkedListADT<T> implements UnorderedListADT<T> {

    @Override
    public void addToFront(T element) {
        DoubleNode newNode = new DoubleNode(element);
        if (size() == 0) {
            head = rear = newNode;
        } else {
            newNode.setNext(head);
            head.setPrevious(newNode);
            head = newNode;
        }
        count++;
        modcount++;
    }

    @Override
    public void addToRear(T element) {
        DoubleNode newNode = new DoubleNode(element);
        if (size() == 0) {
            head = rear = newNode;
        } else {
            newNode.setPrevious(rear);
            rear.setNext(newNode);
            rear = newNode;
        }
        count++;
        modcount++;
    }

    @Override
    public void addToAfter(T element, T target) {
        DoubleNode newNode = new DoubleNode(element);
        Comparable compare = (Comparable) target;
        int i = 0;
        boolean found = false;
        DoubleNode tmp = head;
        while (i < size() && !found) {
            if (compare.compareTo(tmp.getElement()) == 0) {
                found = true;
            }
            tmp = tmp.getNext();
            i++;
        }
        if (!found) {
            throw new NoSuchElementException("O elemento target não foi encontrado na lista...");
        }
        //Nunca pode ser adicionado á frente porque ele adiciona after alguma coisa logo isto basta
        if (i == size()) {
            newNode.setPrevious(rear);
            rear.setNext(newNode);
            rear = newNode;
        } else {
            newNode.setNext(tmp);
            newNode.setPrevious(tmp.getPrevious());
            newNode.getPrevious().setNext(newNode);
            newNode.getNext().setPrevious(newNode);
        }
        count++;
        modcount++;
    }

}
