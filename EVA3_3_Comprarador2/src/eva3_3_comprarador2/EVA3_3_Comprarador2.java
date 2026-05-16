
package eva3_3_comprarador2;

import java.util.Comparator;
import java.util.LinkedList;


public class EVA3_3_Comprarador2 {

    public static void main(String[] args) {
        // TODO code application logic here
        LinkedList<String> datos = new LinkedList<String>();
        datos.add("Adios");
        datos.add("Mundo");
        datos.add("Cruel");
        datos.add("!!");
        Comparator comparator = new Comparator(){
            @Override
            public int compare(Object o1, Object o2) {
               int resu = 0;
               // + --> o1 > o2
               // 0 --> o1 = o2
               // - --> o1 < o2
               String cade1 = (String)o1; 
               String cade2 = (String)o2; 
               resu = cade1.compareTo(cade2);
               return resu;    
            }
        };
        //sort --> utiliza MergeSort --> O(nLogn)
        //nosotros debemos espicificar el criterio de ordenamiento
          datos.sort(comparator);
          System.out.println(datos);
    }
    
}
    
