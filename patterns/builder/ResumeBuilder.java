package patterns.builder;

public class ResumeBuilder {
    private String name;
    private int age;
    private String qualification;
    private float percentage;
    private String exp;
    private String dob;

    public ResumeBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public ResumeBuilder setAge(int age) {
        this.age = age;
        return this;
    }

    public ResumeBuilder setQualification(String qualification) {
        this.qualification = qualification;
        return this;
    }

    public ResumeBuilder setPercentage(float percentage) {
        this.percentage = percentage;
        return this;
    }

    public ResumeBuilder setExp(String exp) {
        this.exp = exp;
        return this;
    }

    public ResumeBuilder setDob(String dob) {
        this.dob = dob;
        return this;
    }

    public Resume getResume() {
        return new Resume(this.name, this.age, this.qualification, this.percentage, this.exp, this.dob);
    }
}
