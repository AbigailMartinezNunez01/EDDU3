
package eva3_1_ordenamiento;


public class EVA3_1_ORDENAMIENTO {

    
    public static void main(String[] args) {
        // TODO code application logic here
          int [] datos=new int[10];
         
         Llenar(datos);
         long ini,fin,tiempo;
         imprimir(datos);
         
         int[] copia = copiar(datos);
         selectionSort(copia);
         imprimir(copia);
         //SELECTION SORT
         System.out.println("Selection sort");
         int[]selection=copiar(datos);
         ini=System.nanoTime();
         selectionSort(selection);//ordenamos el arreglo
         fin=System.nanoTime();
         tiempo=fin-ini;
         imprimir(selection);
         System.out.println("Tiempo en imprimir el selection Sort"+tiempo);
         //INSERTION sORT
         System.out.println("Insertion sort");
         int[] insertion = copiar(datos);

        ini = System.nanoTime();
        insertionSort(insertion);
        fin = System.nanoTime();

        tiempo = fin - ini;

        imprimir(insertion);

        System.out.println("Tiempo en imprimir el insertion Sort " + tiempo);
        //BUBBLE sORT
         System.out.println("Bubble Sort");
         int[] bubble = copiar(datos);

        ini = System.nanoTime();
        bubbleSort(bubble);
        fin = System.nanoTime();

        tiempo = fin - ini;

        imprimir(bubble);

        System.out.println("Tiempo en imprimir el Bubble Sort " + tiempo);
        //QUICK SORT
        System.out.println("Quick Sort");

        int[] quick = copiar(datos);

        ini = System.nanoTime();
        quickSort(quick, 0, quick.length - 1);
        fin = System.nanoTime();

        tiempo = fin - ini;

        imprimir(quick);

        System.out.println("Tiempo en imprimir el Quick Sort " + tiempo);
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
    public static int [] copiar (int[] arreglo){
        int[] copia=new int [arreglo.length];
        long ini,fin,tiempo;
        //ini=System.nanoTime();
        for (int i = 0; i < arreglo.length; i++) {
            copia[i]=arreglo[i];
        }
        /*fin=System.nanoTime();
        tiempo=fin-ini;//tiempo en hacer el proceso 
        System.out.println("Tiempo en llenar el algoritmo: "+tiempo);*/
        return copia;
            
        }
    //DEPENDE DE VARIAS COSAS EL ORDENAMIENTO DE UN ALGORITMO
    //comparaciones vs intercambios
    //CANTIDAD DE ELEMENTOS AVECES , PARA POCOS ELEMENTOS, UN ALGORITMO O(N2) ES MAS EFICIENTE
    //estado de los datos
    //INTERCAMBIOS O(N)
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
    public static void insertionSort(int[]arreglo){
        //EFICIENCIA O(N2) 
        //comparacionesO(N2)
        //intercambiosO(N2)
        //INSERTION SORT COMPARA POCO PERO INTERCAMBIA MUCHO 
        //este se usa depende de los datos, si son muy grandes los datos, conviene selection, porque luego los intercambios cuestAN mas
        
        for (int i = 1; i < arreglo.length; i++) { //i ahora inicia en 1
            int temp=arreglo[i];//temp tiene el valor a insertar
            int insP= i; //InsP ahora es i, (el primer elemento en desorden del arreglo),posicion actual
            while(insP>0 && arreglo[insP-1]>temp){//mientras haya elementos a la izquierda y sean mayor que TEMP
             arreglo[insP] = arreglo[insP - 1]; //movemos a la derecha
             insP--; //retrocedemos
                
       }
            arreglo[insP] = temp;//insertamos temp en la posicion correcta
        }
        
    }
    public static void bubbleSort(int[]arreglo){
        //bubble sort es el peor, su eficiencia es O(n2)
        //compara mucho , intercambia mucho
        for (int i = 0; i < arreglo.length; i++) {
            for (int j = 0; j < arreglo.length -1; j++) {
                if(arreglo[j]>arreglo[j+1]){//si la posicion actual es menor, intercambio
                    int temp=arreglo[j];
                    arreglo[j]=arreglo[j+1];
                    arreglo[j+1]=temp;
                }//tiene que hacer n pasadas para recorrer los elementos 
                
            }
            
        }
    }
    public static void quickSort(int[]arreglo, int ini, int fin){
        if(ini < fin){

        int pivote = arreglo[fin]; // Ell último elemento como pivote
        int i = ini - 1; // indice del último elemento menor o igual al pivote

        for (int j = ini; j < fin; j++) { // Recorremos el arreglo desde inicio hasta antes del pivote

            if(arreglo[j] <= pivote){ // Comprueba si el elemento actual es menor o igual al pivote
                i++; // Avanza el índice de los elementos menores

                int temp = arreglo[i]; // Guarda temporalmente el valor de arreglo[i]
                arreglo[i] = arreglo[j]; // Colocamos el elemento menor en la parte izquierda
                arreglo[j] = temp; // Coloca el valor guardado en la posición de j
            }
        }

        int temp = arreglo[i + 1]; // Guarda temporalmente el valor donde irá el pivote
        arreglo[i + 1] = arreglo[fin]; // Coloca el pivote en su posición correcta
        arreglo[fin] = temp; // Movemos el valor anterior al final del arreglo

        int posPivote = i + 1; // posicion final del pivote

        //depues de todo el algoritmo
        quickSort(arreglo,ini,posPivote-1);//lado izquierdo
        quickSort(arreglo,posPivote+1,fin);//lado derecho
        //inicio pivote-1 a la derecha pivote +1


    }
}}

