
package eva3_2_ordenamiento_collections;

import java.util.Comparator;
import java.util.LinkedList;


public class EVA3_2_ORDENAMIENTO_COLLECTIONS {

    
    public static void main(String[] args) {
        // TODO code application logic here
         LinkedList<Integer> datos = new LinkedList<Integer>();
        datos.add((int)(Math.random() * 100));
        datos.add((int)(Math.random() * 100));
        datos.add((int)(Math.random() * 100));
        datos.add((int)(Math.random() * 100));
        datos.add((int)(Math.random() * 100));
        datos.add((int)(Math.random() * 100));
        datos.add((int)(Math.random() * 100));
        datos.add((int)(Math.random() * 100));
        datos.add((int)(Math.random() * 100));
        datos.add((int)(Math.random() * 100));
        System.out.println(datos);
        // Creamos un Comparator para definir el ordenamiento
        Comparator comparator = new Comparator() {
            
            @Override // Sobrescribe el método compare
            public int compare(Object o1, Object o2) {
                
                int resu = 0; // Variable auxiliar (realmente no se usa)
                int val1, val2; // Variables para guardar los valores
                
                // Convertimos los objetos a int
                val1 = (int)o1;
                val2 = (int)o2;
                
                // Si val1 es menor -> negativo
                // Si son iguales -> 0
                // Si val1 es mayor -> positivo
                return val1 - val2;
            }
        };     
        
        // Ordena la lista usando el Comparator
        datos.sort(comparator);
        
        // Imprime la lista ordenada
        System.out.println(datos); 
    } 
    }
    

