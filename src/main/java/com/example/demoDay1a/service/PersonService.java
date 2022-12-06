package com.example.demoDay1a.service;

import org.springframework.stereotype.Service;
import com.example.demoDay1a.model.Person;
import java.util.*;


@Service
public class PersonService {
    
    private List<Person> persons = new ArrayList<Person>();

    public PersonService() {
        persons.add(new Person("Khant", "Zaw Hein"));
        persons.add(new Person("Matt", "Long"));
    }

    public List<Person> getPersons(){
        return this.persons;
    }

    public void addPerson(Person newPerson){
        persons.add(new Person(newPerson.getFirstName(),newPerson.getLastName()));
    }

    public void removePerson(Person personToDelete){
        Person foundPerson = persons.stream().filter(p->p.getId().equals(personToDelete.getId())).findAny().orElse(null);
        persons.remove(foundPerson);
    }

    public void updatePerson(Person personToUpdate){
        Person foundPerson = persons.stream().filter(p->p.getId().equals(personToUpdate.getId())).findAny().orElse(null);
        // foundPerson.setFirstName(personToUpdate.getFirstName());
        // foundPerson.setLastName(personToUpdate.getLastName());
        Person updatPerson = new Person();
        updatPerson.setId(personToUpdate.getId());
        updatPerson.setFirstName(personToUpdate.getFirstName());
        updatPerson.setLastName(personToUpdate.getLastName());
        removePerson(foundPerson);
        addPerson(updatPerson);
    }

}
