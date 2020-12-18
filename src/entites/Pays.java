package entites;

import java.sql.SQLException;
import java.util.List;

public class Pays {

    private String label;
    private List<Person> personList;
    private int nbrMax;

    public Pays(String label, List<Person> personList, int nbrMax) {
        this.label = label;
        this.personList = personList;
        this.nbrMax = nbrMax;
    }

    public Pays() {
    }

    public boolean add(Person person){
        return personList.add(person);
    }

    public boolean delete(int matricule){
        int size = personList.size();
        for(int i=0;i<size;i++)
            if(matricule == personList.get(i).getMatricule())
                return personList.remove(personList.get(i));
        return false;
    }

    public boolean update(Person person){
        int size = personList.size();
        for (int i=0;i<size;i++)
            if (person.getMatricule() == personList.get(i).getMatricule()) {
                personList.get(i).setAddress(person.getAddress());
                personList.get(i).setAge(person.getAge());
                personList.get(i).setNom(person.getNom());
                return true;
            }
        return false;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public List<Person> getPersonList() {
        return personList;
    }

    public void setPersonList(List<Person> personList) {
        this.personList = personList;
    }

    public int getNbrMax() {
        return nbrMax;
    }

    public void setNbrMax(int nbrMax) {
        this.nbrMax = nbrMax;
    }

    public void enregister() throws SQLException, ClassNotFoundException {
        DataBase db = new DataBase(personList);
    }
}
