
import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;

public abstract class Employee
{
    private String id,name,desc,street_name,suburb,phone_no;
    private int age;
    private LocalDate hire_date;

    public Employee(String id,
                    String name,
                    String desc,
                    String street_name,
                    String suburb,
                    String phone_no,
                    int age,
                    LocalDate hire_date
                   )
    {
        this.id =id;
        this.name = name;
        this.desc = desc;
        this.street_name = street_name;
        this.suburb = suburb;
        this.phone_no = phone_no;
        this.age = age;
        this.hire_date = hire_date;
    }
    public Employee() {
        this.id = id;
        this.name = name;
        this.desc = desc;
        this.street_name = street_name;
        this.suburb = suburb;
        this.phone_no = phone_no;
        this.age = age;
        this.hire_date = hire_date;
    }

    public void setPhone_no(String phone_no) {
        this.phone_no = phone_no;
    }

    public String getPhone_no() {
        return phone_no;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setAge(int age) {
        this.age = age;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setStreet_name(String street_name) {
        this.street_name = street_name;
    }

    public void setSuburb(String suburb) {
        this.suburb = suburb;
    }

    public void setHire_date(LocalDate hire_date) {
        this.hire_date = hire_date;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    public String getId() {
        return id;
    }

    public LocalDate getHire_date() {
        return hire_date;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public String getSuburb() {
        return suburb;
    }

    public String getStreet_name() {
        return street_name;
    }

    public abstract double computePay();

    @Override
    public String toString() {
        return getId();
    }
}