package patterns.creational.builder;

public class TestBuilder {
    public static void main(String[] args) {
        ResumeBuilder rb = new ResumeBuilder();
        Resume rs = rb.setName("Suresh").setAge(45).setExp("20 years").setQualification("MCA").setPercentage((float) 8.54).setDob("31-Jan-1976").getResume();
        System.out.println(rs);
    }
}
