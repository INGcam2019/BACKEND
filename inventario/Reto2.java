/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reto2;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Map;



/**
 *
 * @Camilo_Andres_Muñoz_Mendoza
 */
class Reto2 {

/**
 * @param args the command line arguments
*/
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scanner =new Scanner(System.in);
        String metodo=scanner.nextLine();
        String cadena=scanner.nextLine();
        
        //declaracion arreglo para almacenar datos de producto
        String [] cadenaProductos=cadena.split(" ");
        
/**
 *almacenamiento de variables metodo split 
 */
//declaracion variable codigo ,convertida string a int
        int codigo=Integer.parseInt(cadenaProductos[0]);
        
//declaracion variable nombre
        String nombre=cadenaProductos[1];
        
//declaracion variable precio,convertida string a double 
        double precio=Double.parseDouble(cadenaProductos[2]);
        
//declaracion variable codigo ,convertida string a int
        int inventario=Integer.parseInt(cadenaProductos[3]);
//creacion objeto clase producto y carga de parametros
        Producto producto=new Producto(codigo,nombre,precio,inventario);
        
//creacion objeto clase BaseDatosProductos sin carga de parametros
        BaseDatosProductos baseProductos=new BaseDatosProductos();
        
/**
 *condicion para evaluar si existe el producto,si esta arroja verdadero
 * por eso se niega para entrar a la condicion
 */ 
        if(baseProductos.verificarExistencia(producto)!=true){
//compara el dato en variable metodo con "AGREGAR",si son iguales entra en la condicion
            if(metodo.equals("AGREGAR")){
//llama metodo agregar
               baseProductos.agregar(producto);
//llama metodo generar informes
               baseProductos.generarInforme();
//si no cumple la condicion inicial imprime el mensaje "ERROR"
            }else{
                System.out.println("ERROR");
        
            }
             
/**
 *condicion para evaluar si existe el producto,si esta arroja verdadero
 * por eso se niega para entrar a la condicion
 */ 
        }else if(baseProductos.verificarExistencia(producto)){
//compara el dato en variable metodo con "ACTUALIZAR",si son iguales entra en la condicion
            
            if(metodo.equals("ACTUALIZAR")){
//llama metodo actualizar            
                baseProductos.actualizar(producto);
//llama metodo generar informe
                baseProductos.generarInforme();
//si no entra en la condicion anterior valida si la palabra es "BORRAR"               
            }else if(metodo.equals("BORRAR")){
//llama metodo generar borrar            
                baseProductos.borrar(producto);
//llama metodo generar informe                
                baseProductos.generarInforme();
//sino cumple las amteriores condiciones del else if,imprime "ERROR"
            }else{
         
             System.out.println("ERROR");
             }
//imprime error si la condicion inicial no se cumple        
        }else{
         
             System.out.println("ERROR");
        }
    }
    
}//fin clase reto2

/**
 *
 * @Camilo_Andres_Muñoz_Mendoza
 */
class Producto{
    
//declaracion variable codigo private int
    private int codigo;
//declaracion variable fruta private string
    private String fruta;
//declaracion variable precio private double
    private double precio;
//declaracion variable cantidad private int
    private int cantidad;
/**
 *constructor vacio 
 */

    public Producto() {
    }
/**    
 *constructor con parametros para poder ser instanciado el objeto de la clase producto 
 */
    
    public Producto(int codigo, String fruta, double precio, int cantidad) {
//metodo que permite no cambiar el nombre de la variable codigo con this
        this.codigo = codigo;
//metodo que permite no cambiar el nombre de la variable fruta con this
        this.fruta = fruta;
//metodo que permite no cambiar el nombre de la variable precio con this
        this.precio = precio;
//metodo que permite no cambiar el nombre de la variable cantidad con this
        this.cantidad = cantidad;
    }

        
/**
 *metodo get para obtener el dato de la variable codigo 
 */

   
    public int getCodigo() {
        return codigo;
    }

/**
 *metodo get para fijar el dato de la variable codigo 
 */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

/**
 *metodo get para obtener el dato de la variable fruta 
 */
    public String getFruta() {
        return fruta;
    }

/**
 *metodo get para fijar el dato de la variable codigo 
 */
    public void setFruta(String fruta) {
        this.fruta = fruta;
    }

/**
 *metodo get para obtener el dato de la variable precio 
 */
    public double getPrecio() {
        return precio;
    }

/**
 *metodo get para fijar el dato de la variable precio
 */
    public void setPrecio(double precio) {
        this.precio = precio;
    }

/**
 *metodo get para obtener el dato de la variable cantidad
 */
    public int getCantidad() {
        return cantidad;
    }

/**
 *metodo get para fijar el dato de la variable codigo 
 */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    


}
    //fin clase Producto

/**
 *
 * @Camilo_Andres_Muñoz_Mendoza
 */
class BaseDatosProductos{
//creacion de un objeto de tipo HashMap
    
//   private HashMap<Integer,Producto> ListaProductos=new HashMap<>();
    private Map<Integer,Producto> ListaProductos=new HashMap<>();
//constructor clase BaseDatosProductos sin parametros y asignando valores un objeto de tipo HashMap
   public BaseDatosProductos() {
       
       //private Map<Integer,Producto> ListaProductos=new HashMap<>();

        ListaProductos=new HashMap<>();
        ListaProductos.put(1,new Producto(1,"Naranjas",9000.0,99));
        ListaProductos.put(2,new Producto(2,"Limones",2500.0,15));
        ListaProductos.put(3,new Producto(3,"Peras",2700.0,65));
        ListaProductos.put(4,new Producto(4,"Arandanos",9300.0,34));
        ListaProductos.put(5,new Producto(5,"Tomates",2100.0,42));
        ListaProductos.put(6,new Producto(6,"Fresas",9100.0,20));
        ListaProductos.put(7,new Producto(7,"Helado",4500.0,41));
        ListaProductos.put(8,new Producto(8,"Galletas",500.0,8));
        ListaProductos.put(9,new Producto(9,"Chocolates",4500.0,80));
        ListaProductos.put(10,new Producto(10,"Jamon",19000.0,499));
    
       
    
    }
/**
 *
 * 
 * @metodo que trae como parametro clave de producto de hashmap
 * retorna un valor booleano
 *metodo containsKey verifica que la clave no este en el hashmap
 */
    public boolean verificarExistencia(Producto k){
        return ListaProductos.containsKey(k.getCodigo());
    }

/**
 * metodo agregar datos al  hashmap
 */
      
    public void agregar(Producto k){
        ListaProductos.put(k.getCodigo(),k);
    }
/** 
 * metodo actualizar datos al  hashmap
 */
    
    public void actualizar(Producto k){
        //Producto K,trae instancia de Producto que es k,y con ella actualiza
        //nuevo codigo k.getCodigo y agrega todo el objeto de Producto k
        ListaProductos.replace(k.getCodigo(),k);
    }

/** 
 *metodo agregar datos al  hashmap 
 */ 
    public void borrar(Producto k){
        ListaProductos.remove(k.getCodigo());
    }
/**
 * metodo generarInforme que imprime datos del  hashmap
 */


    public void generarInforme(){

//declaracion variable nombremayor String
        String nombremayor=precioMayor();

//declaracion variable nombremayor String
        String nombremenor=precioMenor();

//declaracion variable promedio String
        String promedio=promedio();

//declaracion variable total String
        String total=total();
        System.out.println( nombremayor+" "+nombremenor+" "+promedio+" "+total);
        
    
    }
    
/**
 *metodo para obtener precio mayor 
 */
    private String precioMayor(){
//variable que almacena dato al cumplir la condicion
        String actualizar="";
//variable que permite acttualizar precio mayor        
        double variableAuxiliar=0;
        //for que pregunta si el precio es mayor a variableAuxiliar, si es asi
        //obtiene nombre de producto=Fruta y actualiza variableAuxiliar para 
        //seguir preguntando
        for (Producto k:ListaProductos.values()){
//compara la variable precio del objeto producto con variableauxiliar
            if(k.getPrecio()>variableAuxiliar){
//si cumple aisgna variable fruta en actualizar
                actualizar=k.getFruta();
//asigna variable precio en variable auxiliar para seguir comparando
                variableAuxiliar=k.getPrecio();
        
        
            }
        }
//retorna el ultimo valor almacenado en actualizar
        return actualizar;
    }
/**
 *metodo para obtener precio menor 
 */
    
    private String precioMenor(){

//variable que almacena dato al cumplir la condicion
        String actualizar="";
//trae el valor mas alto para comparar de mayor a menor
        double variableAuxiliar=ListaProductos.values().iterator().next().getPrecio();
//for que pregunta si el precio es mayor a variableAuxiliar, si es asi
//obtiene nombre de producto=Fruta y actualiza variableAuxiliar para 
//seguir preguntando
        for (Producto k:ListaProductos.values()){
//compara la variable precio del objeto producto con variableauxiliar
            if(k.getPrecio()<variableAuxiliar){
//asigna variable precio en variable auxiliar para seguir comparando
                actualizar=k.getFruta();

//asigna variable precio en variable auxiliar para seguir comparando
                variableAuxiliar=k.getPrecio();
        
        
            }
        }

//retorna el ultimo valor almacenado en actualizar
        return actualizar;
    }
    
/**
 *metodo para obtener promedio 
 */

    private String promedio(){
//variable resultadp
        double resultado=0;
//variable double total
        double total=0;
//itera objeto producto con lista para sumar el total de precio
        for(Producto k:ListaProductos.values()){
//almacena en variable resultado todos los precios
            resultado+=k.getPrecio();
    
        }
//toma la suma de precio y  los divide por la cantidad de elemantos que existan con el metodo.size
        total=resultado/ListaProductos.size();
//retorna el total tipo string en formato de 1 decimal
        return String.format("%.1f",total);
    }
/**
 *metodo que imprime total del inventario 
 */ 

    private String total(){
//variable double resultado que almacenara cada iteracion entre el producto de precio y cantidad
        double resultado=0;
//variable double total que almacenara en cada iteracion el reultado de suma 
        double total=0;
//for que recorre el objeto producto y los valores de hasmap
        for(Producto k:ListaProductos.values()){
//almacena cada iteracion de resultado
            resultado=k.getPrecio()*k.getCantidad();
//acumula el valor de resultado
            total+=resultado;
        
        }
//retorna un string con formato de un decimal de la variable total
        return String.format("%.1f",total);
    
    }
    

}//fin clase BaseDatosProductos