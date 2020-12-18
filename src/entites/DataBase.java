package entites;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataBase {

    private Connection connection;
    private Statement preparedStatement;
    private ResultSet resultSet;

    public DataBase(List<Person> personList) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        this.connection = DriverManager.getConnection("jdbc:mysql://localhost/junitFormation","root","");
        verify(personList);
    }

    public Connection getConnection() {
        return connection;
    }

    public List<Person> findAll() throws SQLException {
        String sql =  "select * from person";
        preparedStatement = connection.createStatement();
        resultSet = preparedStatement.executeQuery(sql);

        List<Person> personList = new ArrayList<>();
        while (resultSet.next()){
            Person person =
                    new Person(resultSet.getInt(1),resultSet.getString(2),resultSet.getInt(3));
            personList.add(person);
        }
        return personList;
    }
    public void verify(List<Person> newList) throws SQLException {
        List<Person> oldList= findAll();
        if(newList.size() > oldList.size())
            add(newList);
        else if(newList.size() < oldList.size())
            delete(newList);
        else
            System.out.println("nothing");
    }

    private int add(List<Person> newList) throws SQLException {
        List<Person> oldList= findAll();
        System.out.println(newList.size()+"//"+oldList.size());
        for(int i=oldList.size();i<newList.size();i++){
            String sql =
                    "INSERT INTO person(mat,nom,age) VALUES("+newList.get(i).getMatricule()+",'"+newList.get(i).getNom()+"',"+newList.get(i).getAge() +")";
            preparedStatement = connection.createStatement();
            preparedStatement.executeUpdate(sql);
        }

        return 1;
    }

    public int delete(List<Person> newlist) throws SQLException {
        List<Person> oldList= findAll();
        System.out.println(newlist.size()+"//"+oldList.size());
        for (int i=newlist.size();i<oldList.size();i++){
            String sql =
                    "DELETE FROM person where mat="+oldList.get(i).getMatricule();
            preparedStatement = connection.createStatement();
            preparedStatement.executeUpdate(sql);
        }

        return 1;
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        List<Person> personList = new ArrayList<>();
        personList.add(new Person(1,"nom",23));
//        personList.add(new Person(2,"nom1",23));
//        personList.add(new Person(3,"nom2",23));
//        personList.add(new Person(4,"nom",23));
//        personList.add(new Person(5,"nom1",23));
//        personList.add(new Person(6,"nom2",23));

        Pays pays = new Pays("String label", personList, 5);
        pays.enregister();

    }

}
