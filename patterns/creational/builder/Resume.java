package patterns.creational.builder;

public class Resume {
    private String name;
    private int age;
    private String qualification;
    private float percentage;
    private String exp;
    private String dob;

    public Resume(String name, int age, String qualification, float percentage, String exp, String dob) {
        this.name = name;
        this.age = age;
        this.qualification = qualification;
        this.percentage = percentage;
        this.exp = exp;
        this.dob = dob;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Name = " + this.name + "\n");
        sb.append("Age = " + this.age + "\n");
        sb.append("Qualification = " + this.qualification + "\n");
        sb.append("Percentage = " + this.percentage + "\n");
        sb.append("Exp = " + this.exp + "\n");
        sb.append("DOB = " + this.dob + "\n");
        return sb.toString();
    }
}
