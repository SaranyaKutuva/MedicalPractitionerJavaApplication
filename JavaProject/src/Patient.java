//import java.util.ArrayList;
//import java.util.PrimitiveIterator;
//import java.util.Scanner;
//
//public class Patient extends Doctor implements Person
//{
//    static public ArrayList<Patient> mypatientlist = new ArrayList<>();
//    private String name,street_Name,suburb;
//    private String medicareno;
//    private int age;
//    private int phoneno;
//    // prefeddoc : Doctor object;
//
//     public Patient(name,street_Name,suburb,medicareno,age,phoneno)
//     {
//         this.name = name;
//         this.street_Name = street_Name;
//         this.suburb = suburb;
//         this.medicareno = medicareno;
//         this.age = age;
//         this.phoneno = phoneno;
//
//     }
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public void setStreet_Name(String street_Name) {
//        this.street_Name = street_Name;
//    }
//
//    public void setSuburb(String suburb) {
//        this.suburb = suburb;
//    }
//
//    public void setMedicareno(String medicareno) {
//        this.medicareno = medicareno;
//    }
//
//    public void setPhoneno(int phoneno) {
//        this.phoneno = phoneno;
//    }
//
//    public void setAge(int age) {
//        this.age = age;
//    }
//
//    public String getSuburb() {
//        return suburb;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public String getMedicareno() {
//        return medicareno;
//    }
//
//    public int getAge() {
//        return age;
//    }
//
//    public int getPhoneno() {
//        return phoneno;
//    }
//
//    public String getStreet_Name() {
//        return street_Name;
//    }
//
//    public Patient addpatient(Patient p)
//    {
//    Scanner scanner = new Scanner(System.in);
//    System.out.println("Enter the Medicare No:");
//    String medicareno = scanner.next();
//    System.out.println(" Please Enter the name of Patient");
//    String name = scanner.next();
//    System.out.println(" Please Enter the  age of Patient");
//    int age = scanner.nextInt();
//    System.out.println("Please Enter the street no and name of the patient");
//    String street_Name = scanner.next();
//    System.out.println("Please Enter the Suburb of the Patient");
//    String suburb = scanner.next();
//    System.out.println("Enter the phone no of the patient");
//    int phoneno = scanner.nextInt() ;
//    Patient patient = new Patient(name,street_Name,suburb,medicareno,age,phoneno,medicareno);
//    mypatientlist.add(patient);
//    return patient;
//    }
//
//    public String deletepatient(Patient p)
//    {
//
//        for ( int index =0; index< mypatientlist.size();index++) {
//
//            System.out.println("Enter the Name of the patient to delete the Record");
//            Scanner scanner = new Scanner(System.in);
//            String name = scanner.next();
//            if (Patient.mypatientlist.get(index).getName().equals(name))
//                System.out.println(" Your Patient is at location \t" + index);
//            mydoctorlist.remove(index); // delete of student from list
//            //mypatientlist.get(index).setName("abc");// update of name
//            break;
//        }
//        return "Patient Record Deleted";
//        //System.out.println("Patient Record Deleted");
//    }
//
//    public String showdoctorpatientlist()
//    {
//        for ( int index =0; index< mypatientlist.size();index++)
//        {
//            System.out.println(mypatientlist.contains(Patient.mypatientlist));
//        }
//    }
//
//    @Override
//    public boolean isAnAdult() {
//
//    System.out.println("Enter the age of the Person");
//        Scanner scanner = new Scanner(System.in);
//        int age = scanner.nextInt();
//        if (age > 18)
//            return true;
//        else
//            return false;
//
//    }
//
//
//    @Override
//    public String toString() {
//        return super.toString();
//    }
//}

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Patient
{static int doccounter = 20005;
    static public ArrayList<Patient> mypatientlist = new ArrayList<>();
    private String id,firstName,lastName,street_Name,suburb;
    private String medicareno;
    private int age;
    private Doctor docname;
    private String phoneno;

    // prefeddoc : Doctor object;
    Patient() {
        this.id= id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.street_Name = street_Name;
        this.suburb = suburb;
        this.medicareno = medicareno;
        this.age = age;
        this.docname = docname;
        this.phoneno = phoneno;
//        //String myString = "20005";
//        doccounter++;
//        //String myId = myString+doccounter;
//        //System.out.println(myId);
//
//        this.setId(doccounter+"");
        doccounter++;
        String myId = Integer.toString(doccounter);
        setId(myId);

    }
        Patient(String id,String firstName,String lastName,String street_Name,String suburb,String medicareno,int age,Doctor docname,String phoneno)
    {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.street_Name = street_Name;
        this.suburb = suburb;
        this.medicareno = medicareno;
        this.age = age;
        this.docname = docname;
        this.phoneno = phoneno;
        //String myString = "20005";
      //  doccounter++;
       // String myId = Integer.toString(doccounter);
      //  setId(myId);

    }

    public void setDocname(Doctor docname) {
        this.docname = docname;
    }

    public Doctor getDocname() {
        return docname;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return this.id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPhoneno(String phoneno) {
        this.phoneno = phoneno;
    }

    public void setStreet_Name(String street_Name) {
        this.street_Name = street_Name;
    }

    public void setSuburb(String suburb) {
        this.suburb = suburb;
    }

    public void setMedicareno(String medicareno) {
        this.medicareno = medicareno;
    }


    public void setAge(int age) {
        this.age = age;
    }

    public String getSuburb() {
        return suburb;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMedicareno() {
        return medicareno;
    }

    public String getAge() {
           String msg ="";
        Person person = (age )-> {
            if (age > 18) {
                //System.out.print("Adult");
                return true;
            } else {
               // System.out.println("Minor, Need parent Permission");
                return false;
            }
        };
        if (person.isAnAdult(age)){
            msg = " Adult";
        }else{
            msg =" Minor, Need parent Permission";
        }
        //System.out.print(" " + age+ (person.isAnAdult(age)));
        return  age+ msg;
    }

    public String getPhoneno() {
        return phoneno;
    }

    public String getStreet_Name() {
        return street_Name;
    }

    public String addpatient(Patient p)
    {
        Scanner scanner = new Scanner(System.in);
//        System.out.println("Please Enter the id of the Patient");
//        String id = getId();
//        System.out.println(id);

        try {
            System.out.println("Please Enter the First Name of Patient");
             firstName = scanner.nextLine();
            for(int i = 0; i<firstName.length(); i++)
            {
                if(!Character.isLetter(firstName.charAt(i)))
                {
                    System.out.println("Given Name does not contain only letters!");
                    return "";
                }
            }
        }
        catch(Exception e)
        {
            System.out.println("Invalid First Name");
            return "";
        }
        try {
            System.out.println("Please Enter the Last Name of Patient");
             lastName = scanner.nextLine();
            for(int i = 0; i<lastName.length(); i++)
            {
                if(!Character.isLetter(lastName.charAt(i)))
                {
                    System.out.println("Given Name does not contain only letters!");
                    return "";
                }
            }
        }
        catch(Exception e)
        {
            System.out.println("Invalid Last Name");
            return "";
        }

        System.out.println("Please Enter the street Address of the patient(Input will be like No, Street Name)");
        String street_Name = scanner.nextLine();
        try {
            System.out.println("Please Enter the Suburb of the Patient");
            suburb = scanner.nextLine();
            for(int i = 0; i<suburb.length(); i++)
            {
                if(!Character.isLetter(suburb.charAt(i)))
                {
                    System.out.println("Given Suburb does not contain only letters!");
                    return "";
                }
            }
        }
        catch(Exception e)
        {
            System.out.println("Invalid Suburb");
            return "";
        }
        try {
            System.out.println("Enter the Medicare No");
             medicareno = scanner.nextLine();
            for(int i = 0; i<medicareno.length(); i++)
            {
                if(!Character.isDigit(medicareno.charAt(i)))
                {
                    System.out.println("Given medicare no does not contain only Numbers!");
                    return "";
                }
            }
        }
        catch(Exception e)
        {
            System.out.println("Invalid Medicare no");
            return "";
        }

        try {
            System.out.println("Please Enter the age of Patient");
            age = scanner.nextInt();
            scanner.nextLine();
            if(age<=0 || age>100)
            {
                System.out.println("Invalid Age");
                return "Invalid Age";
            }
        }
        catch(Exception e)
        {
            return "Not a valid input ";
        }
        int doctorIndex=-1;
        Doctor doctor = new Doctor();
        try {
            System.out.println("Enter the name of the doctor");
            String docname = scanner.next();
            for (int index = 0; index < doctor.mydoctorlist.size(); index++) {
               // System.out.println(Doctor.mydoctorlist.get(index).getName() + " " +doctor.mydoctorlist.size());
                if (Doctor.mydoctorlist.get(index).getName().equalsIgnoreCase(docname)) {
                    //System.out.println(" Your Doctor is at location \t" + index);
                    doctorIndex = index;
                    break;
                } else if(!Doctor.mydoctorlist.get(index).getName().equalsIgnoreCase(docname)){
                    //System.out.println("Doctor Could not be Found");
                    //return "Doctor Could not be found";
                    doctorIndex=-1;
                }
                else
                {
                    System.out.println("Something went wrong");
                    return "Something went Wrong";
                }
            }
            if (doctorIndex==-1){
                throw new Exception("");
            }
        }
        catch(Exception e)
        {
            System.out.println("Doctor Could not be Found " + e.getMessage());
            return "Doctor Could not be found";
        }

        try {
            System.out.println("Enter the phone no of the patient");
            phoneno = scanner.next();
            scanner.nextLine();
            for(int i = 0; i<phoneno.length(); i++)
            {
                if(!Character.isDigit(phoneno.charAt(i)))
                {
                    System.out.println("Given phone no does not contain only Numbers!");
                    break;
                }
            }
        }
        catch(Exception e)
        {
            System.out.println("Invalid Phone no");
        }


        Patient patient = new Patient(getId(),firstName,lastName,street_Name,suburb,medicareno,age,doctor.mydoctorlist.get(doctorIndex),phoneno);
        mypatientlist.add(patient);
        printHeader();
       // System.out.println(patient.toString());
        p.mypatientlist = p.showdoctorpatientlist();
        //System.out.println(mypatientlist);
        return  getId();
    }

    public String deletepatient(Patient p)
    {
        System.out.println("Enter the ID of the patient to delete the Record");
        Scanner scanner = new Scanner(System.in);
        String id = scanner.nextLine();
        //System.out.println(p.mypatientlist.size());
        for ( int index =0; index< p.mypatientlist.size();index++) {

            //System.out.println("hi " + p.mypatientlist.get(index).getId());
            if (p.mypatientlist.get(index).getId().equals(id)) {
                System.out.println(" Your Patient is at location \t" + index);
                printHeader();
                //System.out.println(p.toString());
                p.mypatientlist.remove(index); // delete of student from list
                p.mypatientlist = p.showdoctorpatientlist();
                //mypatientlist.get(index).setName("abc");// update of name
               break;
            }
//            else
//            {
//                return "No Record Found";
//            }
        }
        return "No Record Found";
        //System.out.println("Patient Record Deleted");
    }

    public ArrayList showdoctorpatientlist()
    {
        Iterator i = mypatientlist.iterator();
        while(i.hasNext())
        {
            System.out.println(i.next());
        }
        return mypatientlist;
    }

    public static String padRight(String s, int n) {
        return String.format("%1$-" + n + "s", s);
    }

    public static String padLeft(String s, int n) {
        return String.format("%1$" + n + "s", s);
    }

    public void printHeader(){
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println(padLeft("Patient Details",52));
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println(padRight("ID",10)
                +padRight("First Name",15)
                + padRight("Last Name",15)
                +padRight("Street Name",20)
                +padRight("Suburb",15)
                +padRight("Medicare No",15)
                +padRight("Age",33)
                +padRight("Preferred Doctor",17)
                +padRight("Phone Number",12)
        );
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------");
    }


    @Override
    public String toString() {
        return padRight(getId(),10)
                +padRight(getFirstName(),15)
                + padRight(getLastName(),15)
                +padRight(getStreet_Name(),20)
                +padRight(getSuburb(),15)
                +padRight(getMedicareno(),15)
                +padRight(getAge()+"",33)
                +padRight(getDocname().getName(),17)
                +padRight(getPhoneno(),12)
                ;
    }



}
