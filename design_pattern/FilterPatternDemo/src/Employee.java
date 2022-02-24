public class Employee {
    private String name;
    private String sex;
    private String position;

    public Employee(String name, String sex, String position) {
        this.name = name;
        this.sex = sex;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "NAME: " + name + " SEX: " + sex + " POSITION : " + position;
    }
}
