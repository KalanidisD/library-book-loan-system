public class user {

    public int id;
    public String name;
    public String surname;
    public String mail;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void User(int id, String name, String surname, String email){
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.mail = email;
    }
}
