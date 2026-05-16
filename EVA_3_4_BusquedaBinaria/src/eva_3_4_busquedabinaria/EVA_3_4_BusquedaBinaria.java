
package eva_3_4_busquedabinaria;

import java.util.Scanner;


public class EVA_3_4_BusquedaBinaria {

   
    public static void main(String[] args) {
        // TODO code application logic here
        int [] datos=new int[10];
         
         Llenar(datos);
         long ini,fin,tiempo;
         imprimir(datos);
         selectionSort(datos);
         Scanner captu=new Scanner(System.in);
         System.out.println("valor a buscar?");
         int valor=captu.nextInt();
         System.out.println("resultado"+ busquedaBinaria(datos, 0,datos.length -1,valor));
    }
     public static void Llenar(int[]arreglo){
        
        for (int i = 0; i < arreglo.length; i++) {
            arreglo[i] = (int) (Math.random()*100);
        }
    }
    public static void imprimir(int[]arreglo){
        
        for (int i = 0; i < arreglo.length; i++) {
            System.out.println("["+ arreglo[i] +"]");
        }
      
        System.out.println("  "); 
    }
      

       public static void selectionSort(int[] arreglo){//eficiencia de O(N2) compara mucho intercambia poco
        //COMPARACIONES para saber donde acomodar,SON el cuadrado de n
        //INTERCAMBIOS, y los intercambios son n
        for (int i = 0; i < arreglo.length ; i++) {//el primer valor es el min
            int min=i;//el minimo de inicio es el primer elemento(parte en desorden)
            for (int j = i+1; j < arreglo.length; j++) {//una posicion adelante la j
                if(arreglo[j] < arreglo[min]){//buscamos el min, el valor mas pequeño del arreglo
                     min=j;//nuevo min
                     //terminamos de comparar todo el arreglo   
                }
            }
            //intercambio--->swap intercambiamos min por i 
            int temp=arreglo[min];//temp es nuestra variable auxiliar
                     arreglo[min]=arreglo[i];//movemos al minimo al inicio
                     arreglo[i]=temp;   
        }
       }
//busqueda binaria O(nlogn)----> en un arreglo ordenado
 public static int busquedaBinaria(int[]arreglo, int ini, int fin, int valor){
    //COMO RESUELVEN EL PROBLEMA
        int resu= -1;//por default no lo encontramos
        if(ini<=fin){
         int mid=(ini+(fin-ini)/2);
    //Llamada Recursiva
        if(valor==arreglo[mid])
        resu=mid;
        //Llamada recursiva
        
        
    else if(valor < arreglo[mid]){
//llamada recursiva   
   return  busquedaBinaria(arreglo, ini, mid - 1, valor);
}
    
    else if(valor>arreglo[mid]){
         return  busquedaBinaria(arreglo,mid + 1,fin,valor);
    }
    }
    return resu;
 }
}
    //COMO DETIENEN LA RECURSIVIDAD
    




    

