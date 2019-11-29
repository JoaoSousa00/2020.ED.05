package Lists;

import Interfaces.OrderedListADT;

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
public class ArrayOrderedList<T> extends ArrayListADT<T> implements OrderedListADT<T> {

    @Override
    public void add(T element) {
        if (size() == list.length) {
            expandCapacity();
        }
        Comparable<T> temp = (Comparable<T>) element;
        int i = 0;
        while (i <= rear && temp.compareTo(list[i]) > 0) {
            i++;
        }
        for (int j = size(); j > i; j--) {
            list[j] = list[j - 1];
        }
        list[i] = element;
        rear++;
        modcount++;

    }

}
