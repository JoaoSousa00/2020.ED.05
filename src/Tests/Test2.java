package Tests;

import Exceptions.EmptyArrayException;
import Exceptions.NotFoundException;
import Interfaces.UnorderedListADT;
import Lists.ArrayUnorderedList;
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

public class Test2 {
    
    
    public static void main(String[] args) throws NotFoundException, EmptyArrayException {
        System.out.println("\t\t*Teste de Lista Ordenada..*\n");
        UnorderedListADT<String> Lista1 = new ArrayUnorderedList<>();
        
        Lista1.addToFront("Ana");
        Lista1.addToFront("José");
        Lista1.addToFront("João");
        Lista1.addToFront("Manel");
        Lista1.addToRear("Bruno");
        Lista1.addToRear("Zeze");
        Lista1.addToAfter("Quim", "João");
        Lista1.addToAfter("QuimZé", "Quim");
        System.out.println(Lista1.toString());
        Lista1.remove("José");
        System.out.println(Lista1.toString());
        System.out.println("\nFirst:" + Lista1.first());
        System.out.println("Last:" + Lista1.last());
        System.out.println("Número de elementos:" + Lista1.size()+"\n\n");
    }
    
}
