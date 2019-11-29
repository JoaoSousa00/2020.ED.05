package Lists;

import Interfaces.OrderedListADT;
import Nodes.DoubleNode;
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
public class DoubleLinkedOrderedList<T> extends DoubleLinkedListADT<T> implements OrderedListADT<T> {

    @Override
    public void add(T element) {
        int i = 0;
        DoubleNode<T> newNode = new DoubleNode<>(element);
        DoubleNode<T> temp = head;
        Comparable tempElement = (Comparable) element;

        if (super.size() == 0) {
            head = rear = newNode;
        } else {

            while (i < super.size() && tempElement.compareTo(temp.getElement()) > 0) {
                i++;
                temp = temp.getNext();
            }
            if (i == 0) { //Este havia de ser testado antes de fazer o while
                head.setPrevious(newNode);
                newNode.setNext(head);
                head = newNode;
            } else if (i == super.size()) { //Este havia de ser testado antes de fazer o while
                rear.setNext(newNode);
                newNode.setPrevious(rear);
                rear = newNode;
            } else {
                newNode.setNext(temp);
                newNode.setPrevious(temp.getPrevious());
                temp.setPrevious(newNode);
                newNode.getPrevious().setNext(newNode);
            }
        }
        count++;
        modcount++;
    }

}
