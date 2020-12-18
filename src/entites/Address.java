package entites;

public class Address {

    private String rue;
    private String ville;
    private int num;

    public Address(String rue, String ville, int num) {
        this.rue = rue;
        this.ville = ville;
        this.num = num;
    }

    public Address() {
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "Address{" +
                "rue='" + rue + '\'' +
                ", ville='" + ville + '\'' +
                ", num=" + num +
                '}';
    }
}
