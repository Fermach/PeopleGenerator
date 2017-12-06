/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package peoplegenerator;

/**
 * POJO persona
 * @author Fermach
 */
public class Person {
    private String nombre;
    private String Sexo;
    private String DNI;

    public Person(){}
    
 
    public Person(String nombre, String Sexo, String DNI) {
        this.nombre = nombre;
        this.Sexo = Sexo;
        this.DNI = DNI;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSexo() {
        return Sexo;
    }

    public void setSexo(String Sexo) {
        this.Sexo = Sexo;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    @Override
    public String toString() {
        return "\nPerson{" + "nombre=" + nombre + ", Sexo=" + Sexo + ", DNI=" + DNI + '}';
    }
    
    
}
