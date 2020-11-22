  
package pack;

public class Student {
    private String name;
    private String number;
    private String team;
    void setName(String Name){
        this.name = Name;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

    public String getTeam() {
        return team;
    }
    public String toString() {
        return "Ñ§ÉúÎª{"+getName()+"  "+getTeam()+"  "+getNumber()+ '}';
    }
}