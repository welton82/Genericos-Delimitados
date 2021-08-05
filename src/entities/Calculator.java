package entities;

import java.util.List;

public class Calculator {

    public static <T extends Comparable<T>> T calcularMaior(List<T> lista){

        if(lista.isEmpty()){
            try {
                throw  new IllegalStateException("Lista nâo pode ser Vazia");


            } catch (IllegalStateException e) {
                e.printStackTrace();
            }
        }

        T max = lista.get(0);
        for(T item: lista){
            if(item.compareTo(max) > 0){
                max = item;
            }

        }

        return max;
    }

}
