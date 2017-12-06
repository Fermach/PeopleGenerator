 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package peoplegenerator;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * POJO con un ArrayList de personas
 * @author Fermach
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ListOfPeople {
    ArrayList<Person> listOfPeople =new ArrayList<>();

    public ListOfPeople() {
    }
    
    public ListOfPeople(ArrayList<Person> peopleList){
    
      this.listOfPeople=peopleList;
    }

    public ArrayList<Person> getPeopleList() {
        return listOfPeople;
    }

    public void setPeopleList(ArrayList<Person> peopleList) {
        this.listOfPeople = peopleList;
    }

    @Override
    public String toString() {
        return listOfPeople.toString() ;
    }
    
    public int size() {
      
        return listOfPeople.size();
    }
    
}
