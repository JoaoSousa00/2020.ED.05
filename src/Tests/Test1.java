 package Tests;

import Exceptions.EmptyArrayException;
import Exceptions.NotFoundException;
import Interfaces.ListADT;
import Interfaces.OrderedListADT;
import Lists.ArrayOrderedList;
import java.util.Iterator;

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
public class Test1 {

    public static void main(String[] args) throws NotFoundException, EmptyArrayException {
        
        System.out.println("\t\t*Teste de Lista Ordenada..*\n");
        OrderedListADT<String> Lista1 = new ArrayOrderedList<>();
        Lista1.add("Ana");
        Lista1.add("José");
        Lista1.add("João");
        Lista1.add("Manel");
        System.out.println(Lista1.toString());
        Lista1.remove("José");
        System.out.println(Lista1.toString());
        System.out.println("\nFirst:" + Lista1.first());
        System.out.println("Last:" + Lista1.last());
        System.out.println("Número de elementos:" + Lista1.size()+"\n\n");
        
        Iterator it = Lista1.iterator();
        while (it.hasNext()) {     
            System.out.println(it.next());
        }
        
    }

}
