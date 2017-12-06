/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package peoplegenerator;

import java.io.File;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;


/**
 * Generador de personas aleatorias que nos permite generar una lista de
 * personas con DNI,nombre completo y sexo ÚNICAS(por DNI) y aleatorias, 
 * y exportarlas a un archivo XML
 * 
 * @author Fermach
 */
public class PeopleGenerator {

    /**
     * Main para probar el funcionamiento de mi generador de nombres
     * ,imprimir mi lista de nombres generados por consola y generar el 
     * XML con la lista
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        ListOfPeople myList= new ListOfPeople(generatePeople(10));
        
        System.out.println("Lista de nombres generados: "+ myList.toString() +"\n"
                    +"Longitud de la lista: "+ myList.size());
        try {
          
            /*Cargamos la configuración para que el "Marshaller" sepa como convertir el POJO a XML,
            para eso necesito la clase que previamente estaba con anotaciones JBXB*/
            JAXBContext jbc_people_list = JAXBContext.newInstance(myList.getClass());
            
            /* Creamos el marshaller que es el encargado de volcar el objeto a
            fichero XML*/
            Marshaller jbcm = jbc_people_list.createMarshaller();
            jbcm.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            //Creo el archivo XML con la lista de personas ne la dirección raíz de mi proyecto
            jbcm.marshal(myList, new File("List_Of_People.xml"));
            
            System.out.println("\n\nEl marshalling de mi lista se ha realizado correctamente !!");
        
        } catch (JAXBException ex) {
            
            System.out.println("\n\nError al intentar realizar el Marshalling  !!");
            Logger.getLogger(PeopleGenerator.class.getName()).log(Level.SEVERE, null, ex);
            
        }

       
    }
    
    /**
     * Método que nos permite generar nombres Pesonas con DNI y sexo 
     * de forma aleatoria usando StringBuffer.
     * 
     * Las personas de mi lista son UNICAS ya que no se puede repetir el DNI
     * ,pero si que pueden existir dos personas con el mismo nombre completo
     * 
     * @param people_Number
     * @return people_List
     */
    public static ArrayList<Person> generatePeople(int people_Number) {
      ArrayList<Person> people_List=new ArrayList<>();
      Person person = new Person();
      
      String[] names_man ={"Fernando","Francisco","Luis","Manuel","Javier","Alvaro","Alfonso","Antonio","David","José"};
      String[] names_woman ={"Irene","Teresa","Maria","Ramona","Alba","Sonia","Ana","Lucia","Celeste","Marta"};
      String[] last_names={"Cuadros","Hornos","Rodríguez","Calabria","Garcia","Bermudez","Torres","Escobar","Rajoy","Iglesias"};
      String[] last_names2={"Cuadros","Hornos","Rodríguez","Calabria","Garcia","Bermudez","Torres","Escobar","Rajoy","Iglesias"};
     
      //Uso StringBuffer para optimizar el rendmiento de mi aplicación
      StringBuffer nameBuffer= new StringBuffer();
      String name;
      int sexo;
      Boolean itsInMyList;
      
      //hasta que la lista tenga el tamaño que le pasas como parámetro
      while(people_List.size() <= (people_Number -1)){
         
         itsInMyList=false;
         nameBuffer.delete(0, nameBuffer.length());
         //genera un número aleatorio 0 o 1
         sexo =(int) (Math.random() * 2);
          
         if(sexo==0){
            
            //Genero un nombre completo combinando mis arrays
            name=names_man[(int) (Math.random() * 10)] + " " + last_names[(int) (Math.random() * 10)] + " " + last_names2[(int) (Math.random() * 10)] ;
          
             nameBuffer.append(name);
             person= new Person(nameBuffer.toString(),"hombre", calculateRandomDNI());
          
          
         }else{
         
            //Genero un nombre completo combinando mis arrays
            name=names_woman[(int) (Math.random() * 10)] + " " + last_names[(int) (Math.random() * 10)] + " " + last_names2[(int) (Math.random() * 10)] ;
          
             nameBuffer.append(name);
             person= new Person(nameBuffer.toString(),"mujer",calculateRandomDNI());
          
           }
         
          //compruebo si ese DNI ya está en mi lista 
         for (Person personInMyList : people_List) {
                if(person.getDNI().equals(personInMyList.getDNI())){
                   itsInMyList=true;
              
                 }
            }
          //si no está en mi lista añado la persona a la lista
         if(!itsInMyList){
           
            people_List.add(person);
          
            }
      }
     
      return people_List;
    }

    /**
     * Método que nos permite calcular un DNI válido
     * 
     * @return DNI válido
     */
    public static String calculateRandomDNI(){
        
        StringBuffer dni = new StringBuffer();
        int num;
        //calculo 8 numero aleatorios
        for(int i=0;i<8;i++){
         num=(int) (Math.random()*10);
         dni.append(num);
        }
        //calculo la letra para crear un DNI válido
        char letras[] = {'T','R','W','A','G','M','Y','F','P','D','X','B','N','J','Z','S','Q','V','H','L','C','K','E'};
        int resto = (Integer.parseInt(""+dni))%23;
        char letra= letras[resto];
        dni.append(letra);
       
        return (""+dni);
    }
      
     
    
    
    
    
}
