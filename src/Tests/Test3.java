package Tests;

import Exceptions.EmptyArrayException;
import Exceptions.NotFoundException;
import Interfaces.OrderedListADT;
import Lists.DoubleLinkedOrderedList;
import Nodes.LinearNode;

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
 * 
 * </p>
 */

public class Test3 {
    
    
    public static void main(String[] args) throws EmptyArrayException, NotFoundException {
        
        System.out.println("\t\t*Teste de Lista Duplamente Ligada e Ordenada..*\n");
        OrderedListADT<Integer> Lista1 = new DoubleLinkedOrderedList<>();
        
        Lista1.add(1);
        Lista1.add(2);
        Lista1.add(3);
        Lista1.add(4);
        Lista1.add(5);
        
        System.out.println(Lista1.toString());
        Lista1.removeFirst();
        Lista1.remove(4);
        Lista1.removeLast();
        System.out.println(Lista1.toString());
        
    }
    
}
