public class Person {
    private final String name;
    private final String surname;
    private final Integer age;
    private final Sex sex;
    private final Education education;

    public Person(String name, String surname, int age, Sex sex, Education education) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.sex = sex;
        this.education = education;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Integer getAge() {
        return age;
    }

    public Sex getSex() {
        return sex;
    }

    public Education getEducation() {
        return education;
    }

    @Override
    public String toString() {
        return  "Имя - " + name +
                ", Фамилия - " + surname +
                ", Возраст - " + age +
                ", Пол - " + sex +
                ", Образование - " + education + "\n";
    }
}
