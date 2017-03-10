//Nombre: Roberto Alain Rivera Bravo
//Matrícula: A01411516
//Carrera: IMT11

package spp.rriverab.a10;
import java.util.Scanner;

public class SPPRRiveraBA10 {

     public static void main(String[] args) {
        //se llama a método menú
        menu();
    }
    
    //Método menu: Da el orden en que se deben de ejecutar los métodos, y los va invocando
    public static void menu(){
        boolean flag;
        
        //ciclo do while para repetir el proceso de sumar matrices
        do{
            System.out.println("<<Suma de matrices>>"); 
            //Método crear Matrices
            crearMatrices();
            //Método salir
            flag=salir();    
        }while(flag==false);
    }
    
    /* Método crear Matrices: invoca a otros métodos para realizar las operaciones de asignar tamaño y 
    asignar valores a las matrices, realizar la suma de ellas y mostrarlas
    */
    public static void crearMatrices(){
        int m,n;
        
        //Se invoca a métodos asignar tamaño
        System.out.println("Introduzca el tamaño mxn de las matrices (serán del mismo tamaño)\n");
        m=asignarTamaño("m (número de filas)");
        n=asignarTamaño("n (número de columnas)");
        
        //se invoca a métodos para asignar valores
        System.out.println("\nValores de la matriz A: ");
        int[][]A=asignarValores(m,n);
        System.out.println("\nValores de la matriz B");
        int[][]B=asignarValores(m,n);
        //se invoca a método para sumar matrices
        int[][]S=sumaDeMatrices(A,B,m,n);
        //se invoca a método para restar matrices
        int[][]R=restaDeMatrices(A,B,m,n);
                
        //se invoca a métodos para mostrar matrices
        System.out.println("\n\nLa suma de la matriz A: ");
        mostrarArray(A);
        System.out.println("\nY la matriz B: ");
        mostrarArray(B);
        System.out.println("\nes: ");
        mostrarArray(S);
        System.out.println("\ny la resta es: ");
        mostrarArray(R);

        if(m==n){
            //se invoca a método para multiplicar matrices AXB
            int[][]M=multiplicacionDeMatrices(A,B,m,n);
            //se invoca a método para multiplicar matrices BXA
            int[][]N=multiplicacionDeMatrices(B,A,m,n);
            
            //se invoca a métodos para mostrar matrices
            System.out.println("\ny la multiplicación AXB es: ");
            mostrarArray(M);
            System.out.println("\ny la multiplicación BXA es: ");
            mostrarArray(N);
        }else{
            System.out.println("\nm y n no son iguales, y no se puede hacer la multiplicación de matrices");
        }
            
    }
    
    /*Método asignar tamaño: verifica que el entero sea positivo para evitar introducir
    valores negativos en el tamaño de la matriz*/
    public static int asignarTamaño(String dimension){
        int x;
        boolean flag;
        System.out.println("Valor de "+dimension);

        //Ciclo do while: ejecuta al menos una vez las instrucciones en do, y evalúa si es cierto en while
        do{
            x=solicitarDatos();
            flag=true;
            //Evalúa si la x es menor a uno, y si lo es, asigna flag=false para repetir el ciclo
            if(x<1){
                System.out.println("Introduzca un entero positivo(no hay longitudes negativas  o nulas de matrices)");
                flag=false;
            }
            
        }while(flag==false);
        
        return x; 
    }
    
    //Método asignar valores: asigna los valores de una matriz con un ciclo for
    public static int[][] asignarValores(int m, int n){
         //Crea el array con el tamaño introducido por el usuario anteriormente
        int[][] matrix = new int [m][n];
        
        //Ciclo for: Nos desplaza en las filas del array
        for (int i = 0; i < matrix.length; i++) {
            //Ciclo for: Nos desplzaza en las columnas del array
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.println("Introduzca valores para la posición "+i+", "+j);
                //Asigna el valor del array en la posición i, j
                matrix [i][j]=solicitarDatos();
            }    
        }
        
        return matrix; //regresa el objeto matrix
    }
    
    /*Método verificar Int Positivo: verifica que el entero sea positivo para evitar introducir
    valores negativos en el tamañi de la matriz*/
    public static int verificarIntPositivo(){
        int x;
        boolean flag;
        
        //Ciclo do while: ejecuta al menos una vez las instrucciones en do, y evalúa si es cierto en while
        do{
            x=solicitarDatos();
            flag=true;
            //Evalúa si la x es menor a uno, y si lo es, asigna flag=false para repetir el ciclo
            if(x<1){
                System.out.println("Introduzca un entero positivo(no hay longitudes negativas  o nulas de matrices)");
                flag=false;
            }
            
        }while(flag==false);
        
        return x; //regresa el valor int verificado
    }
    
    
    //Método solicitar datos: permite verificar que los datos sean correctos y los captura
    public static int solicitarDatos(){
        Scanner teclado = new Scanner (System.in);
        boolean flag;
        int x=0;
        //Ciclo do while: ejecuta al menos una vez las instrucciones en do, y evalúa si es cierto en while
        do{      
            try{ //Intenta realizar las instrucciones 
                x = teclado.nextInt(); 
                flag = true;
            }catch (Exception ex) { //Evita que el programa falle en caso de error y muestra el error
                flag = false;
                System.out.println("\nEl valor insertado es inválido. Introduzca un entero válido.\n" +ex+ "\n");
                teclado.nextLine(); //Limpia el buffer del teclado  
            }
            
        }while(flag==false); //Evalua si la condición es verdadera o falsa, para volver a hacer las operaciones o no

        return x; //regresa el valor int verificado
    }
    
    //Método suma de matrices: regresa una matriz que es suma de otras 2 que llegan al método
    public static int[][]sumaDeMatrices(int[][]A, int[][]B,int m,int n){
        int[][]S = new int [m][n];
        //Recorre las "i" filas del array
        for(int i=0; i<S.length; i++){
            //Recorre las "j" columnas del array
            for (int j=0; j<S[i].length; j++){
                S[i][j]= A[i][j]+B[i][j];    
            }
        }
        return S; //regresa el array que es suma de las matrices
    }
    
    //Método suma de matrices: regresa una matriz que es resta de otras 2 que llegan al método
    public static int[][]restaDeMatrices(int[][]A, int[][]B,int m,int n){
        int[][]S = new int [m][n];
        //Recorre las "i" filas del array
        for(int i=0; i<S.length; i++){
            //Recorre las "j" columnas del array
            for (int j=0; j<S[i].length; j++){
                S[i][j]= A[i][j]-B[i][j];    
            }
        }
        return S; //regresa el array que es resta de las matrices
    }
    
    //Método multiplicación de matrices: regresa una matriz que es producto matricial de AXB
     public static int[][]multiplicacionDeMatrices(int[][]A, int[][]B,int m,int n){
        int[][]S = new int [m][n];
        //Recorre las "i" filas del array
        for(int i=0; i<S.length; i++){
            //Recorre las "j" columnas del array
            for (int j=0; j<S[i].length; j++){
                for (int k = 0; k < S.length; k++) {
                    S[i][j]+=A[i][k]*B[k][j];
                }  
            }
        }
        return S; //regresa el array que es multiplicación de las matrices
    }    

    //Método mostrar Array: muestra en pantalla la matriz creada
    public static void mostrarArray(int [][]matrix){ //Se recibe el objeto matrix
        //Recorre las "i" filass del array
        for(int i=0; i<matrix.length; i++){
            //Recorre las "j" columnas del array
            for (int j=0; j<matrix[i].length; j++){
                System.out.print("["+matrix[i][j]+"]");
                /*Introduce un salto de línea cada que se rebase la cantidad de columnas del array
                para que se vea el arreglo en orden en pantalla*/
                if (j+2>matrix[i].length){
                    System.out.println("\t");
                }  
            }
        } 
        
    }
    
    //Método salir: da opción de terminar o reiniciar los cálculos
    public static boolean salir(){
        Scanner teclado = new Scanner (System.in);
        String letra;
        boolean flag;
    
        System.out.println("\n¿Desea continuar?");
        System.out.println("No: Presione E");
        System.out.println("Sí: Presione cualquier otra tecla");
        letra = teclado.nextLine(); 
        
        //verifica si el String es igual a "E"
        if(!letra.equals("E")){
            //Se manda el valor booleano para volver a ejecutar el programa
            System.out.println("\n\n");
            flag=false;
        }else{
            flag=true;
        }
        
        return flag;
    } 
    
}
