package entites;

import java.sql.SQLException;

public class Person {

    private int matricule;
    private Address address;
    private String nom;
    private int age;

    public Person(int matricule, String nom, int age) {
        this.matricule = matricule;
        this.nom = nom;
        this.age = age;
    }

    public Person(int matricule, Address address, String nom, int age) {
        this.matricule = matricule;
        this.address = address;
        this.nom = nom;
        this.age = age;
    }

    public Person() {
    }

    public int getMatricule() {
        return matricule;
    }

    public void setMatricule(int matricule) {
        this.matricule = matricule;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "matricule=" + matricule +
                ", address=" + address +
                ", nom='" + nom + '\'' +
                ", age=" + age +
                '}';
    }


}
