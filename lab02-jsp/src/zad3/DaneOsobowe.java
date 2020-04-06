package zad3;

public class DaneOsobowe
{
    private String username;
    private String passw;
    private String name;
    private String surname;
    private String email;

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public DaneOsobowe(String username, String passw, String name, String surname, String email)
    {
        this.username = username;
        this.passw = passw;
        this.name = name;
        this.surname = surname;
        this.email = email;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getPassw()
    {
        return passw;
    }

    public void setPassw(String passw)
    {
        this.passw = passw;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getSurname()
    {
        return surname;
    }

    public void setSurname(String surname)
    {
        this.surname = surname;
    }
}
