package entites;

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

    public Person update(Person person){
        int size = personList.size();
        for (int i=0;i<size;i++)
            if (person.getMatricule() == personList.get(i).getMatricule()) {
                personList.get(i).setAddress(person.getAddress());
                personList.get(i).setAge(person.getAge());
                personList.get(i).setNom(person.getNom());
                return personList.get(i);
            }
        return null;
    }
}
