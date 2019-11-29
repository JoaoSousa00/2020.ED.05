package Tests;

import Interfaces.UnorderedListADT;
import Lists.DoubleLinkedUnorederedList;

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
public class Test4 {

    public static void main(String[] args) {

        System.out.println("\t\t*Teste de Lista Duplamente Ligada e Desordenada..*\n");
        UnorderedListADT<Integer> Lista1 = new DoubleLinkedUnorederedList<>();
        
        Lista1.addToFront(3);
        Lista1.addToFront(0);
        Lista1.addToFront(5);
        Lista1.addToAfter(7, 5);
        Lista1.addToRear(4);
        System.out.println(Lista1.toString());

    }

}
