import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;

public class Doctor extends Employee implements Person
{ static int doccounter = 10000;
    static public ArrayList<Doctor> mydoctorlist = new ArrayList<>();
    private String[] deptNames = {"General", "Surgery", "Basic Nursing", "Psychologist"};
    private LocalTime workingTime;
    private String departName;
    private LocalTime wstartTime;
    private LocalTime wendTime;
    int wHoursValidation =0;

    public Doctor(
              String id
            , String name
            , String desc
            , String street_Name
            , String suburb
            , String phone_no
            , int age
            , LocalDate hire_Date
            , String deptName
            //, LocalTime workingTime
              ,LocalTime wstartTime
              ,LocalTime wendTime



    )
    {
       // this.setId(id);
        this.setName(name);
        this.setDesc(desc);
        this.setStreet_name(street_Name);
        this.setSuburb(suburb);
        this.setPhone_no(phone_no);
        this.setAge(age);
        //System.out.println("1" +getAge());
        this.setHire_date(hire_Date);
        this.departName= deptName;
        //this.workingTime = workingTime;
        this.wstartTime= wstartTime;
        this.wendTime  = wendTime;
        //String mystring = "1000";
        doccounter++;
        String myid = Integer.toString(doccounter);
       //System.out.println(myid);

        setId(myid);

    }


    public Doctor()
    {
        this.setId(getId());
        this.setName(getName());
        this.setDesc(getDesc());
        this.setStreet_name(getStreet_name());
        this.setSuburb(getSuburb());
        this.setAge(getAge());
       // System.out.println("2" +getAge());
        this.setPhone_no(getPhone_no());
        this.setHire_date(getHire_date());
        this.departName = departName;
       // this.workingTime = workingTime;
        this.wstartTime= wstartTime;
        this.wendTime  = wendTime;
//        String mystring = "100";
//        String myid = mystring+doccounter;
//        doccounter++;
//        setId(myid);

    }
    public ArrayList getPatientList()
    {
        Patient patient = new Patient();
        for (int index =0; index<patient.mypatientlist.size(); index++)
        {
            if(patient.mypatientlist.isEmpty())
                System.out.println("No patients in the list");
            else{
                System.out.println(patient.mypatientlist);
            }
        }
        return patient.mypatientlist;
    }
    public String getWorkingHours(){

        Scanner scanner = new Scanner(System.in);
        String inputHoursMins ;
        LocalTime valStartTime =LocalTime.parse("09:00");
        LocalTime valEndTime =LocalTime.parse("17:00");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("kk:mm");

        if (wstartTime ==null || wstartTime.equals(""))
        {
        System.out.println("Enter the Start time of working hours, Time format (HH24:MM) ");
            inputHoursMins=  scanner.next();
        try{
            wstartTime = LocalTime.parse(inputHoursMins, formatter);
            //System.out.println(wstartTime +  " " + valStartTime + " " +wendTime+" "+ valEndTime);
            if (wstartTime.isBefore(valStartTime) || wstartTime.isAfter(valEndTime)){
                System.out.println("Working hours is between 09:00 and 17:30");
                wstartTime =null;
                return "Failed";

            }
        }
        catch(DateTimeParseException e){
            System.out.println("Invalid Start Time");
            wstartTime =null;
            return "Failed";
        }
            wHoursValidation =0;
        } //if start time blank

        if (wendTime ==null || wendTime.equals("")) {
            System.out.println("Enter the End time of working hours  Time format (HH24:MM) ");
            inputHoursMins = scanner.next();
            try {

                wendTime = LocalTime.parse(inputHoursMins, formatter);
                if (wendTime.isBefore(valStartTime) || wendTime.isAfter(valEndTime)) {
                    System.out.println("Working hours is between 09:00 and 17:30");
                    wendTime = null;
                    return "Failed";
                }
                else if (wendTime.isBefore(wstartTime))
                {
                    System.out.println("End time is greater than start time");
                    wendTime = null;
                    return "Failed";
                }
                //System.out.println("Valid");
            } catch (DateTimeParseException e) {
                System.out.println("Invalid End Time");
                wendTime = null;
                return "Failed";
            }
        }
        return "Success";

    }

    public ArrayList addDoctor(Doctor doctor)
    {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter from one of the following");
        boolean continueChoice =false;
        do {
            for (int j = 0; j < getDeptNames().length; j++) {
                // checking character in string
                System.out.println(j+1 + ")" + getDeptNames()[j]);
            }
            int a = scanner.nextInt();
            if (a > getDeptNames().length || a < 1) {
                System.out.println("Invalid choice. Pls choose from one of the above");
                continueChoice =true;
                //continue;

            }
            departName = getDeptNames()[a - 1];
        }while(continueChoice);
        String wHoursValidationResult;
         continueChoice =false;
          do{

              /***************************************/
               wHoursValidationResult=  getWorkingHours();
              /***************************************/

              wHoursValidation=wHoursValidation+1;

              if (wHoursValidationResult.contains("Success") || wHoursValidation>2) {
                  continueChoice=false;
              }else{
                  continueChoice=true;
              }
             // System.out.println("wHoursValidationResult " +wHoursValidationResult +  " "+wHoursValidation);
           }while(continueChoice);

          if(wHoursValidationResult.contains("Failed"))
          {
              return mydoctorlist;
          }


        String id=null;
          String name =null;
          String suburb=null;
          String street_name=null;
          String desc=null;
          String phoneno=null;
          int age ;
//        System.out.println("Id of the Doctor");
//        id = getId();
//        System.out.println(id);

        try {
            System.out.println("Please Enter the Name of the Doctor");
            name = scanner.next();
            scanner.nextLine();


            for(int i = 0; i<name.length(); i++)
            {
                if(!Character.isLetter(name.charAt(i)))
                {
                    System.out.println("Given Name does not contain only letters!");
                    return mydoctorlist;
                }
            }
        }
        catch(Exception e)
        {
            System.out.println("Invalid Name ");
            return mydoctorlist;
        }

        try {
            System.out.println("Enter the description of the Doctor(Doctor/Nurse/Psychologist)");
            desc = scanner.next();
            scanner.nextLine();
            for(int i = 0; i<desc.length(); i++)
            {
                if(!Character.isLetter(desc.charAt(i)))
                {
                    System.out.println("Given Description does not contain only letters!");
                    return mydoctorlist;
                }
            }
        }
        catch(Exception e)
        {
            System.out.println("Invalid Description ");
            return mydoctorlist;
        }

        System.out.println("Enter the Street number and Street Name of the Doctor(Input Format No,Street Name)");
        street_name = scanner.nextLine();
        //scanner.nextLine();
        try {
            System.out.println("Enter the Suburb of the Doctor");
            suburb = scanner.nextLine();
            //scanner.nextLine();
            for(int i = 0; i<suburb.length(); i++)
            {
                if(!Character.isLetter(suburb.charAt(i)))
                {
                    System.out.println("Given Suburb does not contain only letters!");
                    return mydoctorlist;
                }
            }
        }
        catch(Exception e)
        {
            System.out.println("Invalid Suburb");
            return mydoctorlist;
        }
        try {
            System.out.println("Enter the age of the Doctor");
            age = scanner.nextInt();
            //scanner.nextLine();

            if(age<=0 || age>100)
            {
                System.out.println("Invalid Age");
                return mydoctorlist;
            }
        }
        catch(Exception e)
        {
            System.out.println("Not a valid input ");
            return mydoctorlist;
        }

        /*@@****Input for Hire Date and validation****/
                    String hiringDate;
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                    LocalDate hire_date=null;
                    int counter =0;
                    do {

                        try {
                            counter++;
                            System.out.println("Enter the Hire_Date of the Doctor dd-MM-yyyy" );
                            hiringDate =scanner.next();
                            hire_date = LocalDate.parse(hiringDate, formatter);
                            break;
                            //System.out.println("Valid Format");

                        } catch (DateTimeParseException e) {
                            hire_date=null;
                            //System.out.println("Invalid Format" + e);
                        }
                    }while(counter<=2);

                    if (hire_date == null || hire_date.equals("")){
                        return mydoctorlist;
                    }
        /*!--****Input for Hire Date and validation****/
        try {
            System.out.println("Enter the phone no of the Doctor ");
            phoneno = scanner.next();
            scanner.nextLine();
            //System.out.println(phoneno);
            for(int i = 0; i<phoneno.length(); i++)
            {
                if(!Character.isDigit(phoneno.charAt(i)))
                {
                    System.out.println("Given phone no does not contain only Numbers!");
                    return mydoctorlist;
                }
            }
        }
        catch(Exception e)
        {
            System.out.println("Invalid Phone no");
            return mydoctorlist;
        }

        //System.out.println(phoneno);
        //scanner.nextLine();
       //System.out.println("Start " + wstartTime+  " endtime "+wendTime);
        /********************************************/
        Doctor doctor1 = new Doctor(
                id
                ,name
                ,desc
                ,street_name
                ,suburb
                ,phoneno
                ,age
                ,hire_date
                ,departName
                ,wstartTime
                ,wendTime
        );
        mydoctorlist.add(doctor1);
        printHeader();
        mydoctorlist = showDoctors();
        return mydoctorlist;

    }

    public ArrayList showDoctors() {
            Iterator i = mydoctorlist.iterator();
            while(i.hasNext())
            {
                System.out.println(i.next());
            }
            return mydoctorlist;

    }

    public Doctor showDoctor(String id) {

        for (int index = 0; index < mydoctorlist.size(); index++)
            if (Doctor.mydoctorlist.get(index).getId().equalsIgnoreCase(id)) {
                System.out.println("Your Doctor is at location \t" + index);
                Doctor.mydoctorlist.toString();
                break;
            } else {
                System.out.println("No Record Found");

            }
        Doctor doctor= new Doctor();
        return doctor;
    }
    public ArrayList deleteDoctor(Doctor doctor) {
        for (int index = 0; index < mydoctorlist.size(); index++) {
            System.out.println("Enter the ID of the doctor to delete");
            Scanner scanner = new Scanner(System.in);
            String id = scanner.next();
            if (Doctor.mydoctorlist.get(index).getId().equals(id)) {
                System.out.println(" Your Doctor is at location \t" + index);
                mydoctorlist.remove(index); // delete of student from list
                break;
            }
            else
            {
                System.out.println("No Record Found");
            }
        }
        printHeader();
        mydoctorlist =showDoctors();
        return mydoctorlist;
    }
    @Override
    public double computePay()
    {
        System.out.println("I am from doctor compute pay");
        return 15000;
    }

    public void setWendTime(LocalTime wendTime) {
        this.wendTime = wendTime;
    }
    public LocalTime getWstartTime() {
        return wstartTime;
    }
    public LocalTime getWendTime() {
        return wendTime;
    }

    public void setWstartTime(LocalTime wendTime) {
    this.wendTime = wendTime;
    }

    public void setDepartName(String departName) {
        this.departName = departName;
    }

    public String getDepartName() {
        return departName;
    }

    public void setDeptNames(String[] deptNames) {
        this.deptNames = deptNames;
    }

    public String[] getDeptNames() {
        return deptNames;
    }

    public void setWorkingTime(LocalTime workingTime) {
        this.workingTime = workingTime;
    }

    public LocalTime getWorkingTime() {
        return workingTime;
    }


    public static String padRight(String s, int n) {
        return String.format("%1$-" + n + "s", s);
    }

    public static String padLeft(String s, int n) {
        return String.format("%1$" + n + "s", s);
    }

    public void printHeader(){
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println(padLeft("Doctor Details",52));
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println(padRight("ID",10)
                +padRight("Name",15)
               // + padRight("Last Name",15)
                +padRight("Description",15)
                +padRight("Street Name",20)
                +padRight("Suburb",15)
                +padRight("Phone Number",15)
                +padRight("Age",4)
                +padRight("Hire Date",12)
                +padRight("Department Name",20)
                +padRight("Wrk St",12)
                +padRight("Wrk End",12)
        );
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------");
    }

    @Override
    public String toString() {
//        return  "Id \t\t" +
//                "Name \t" +
//                "Desc \t"+
//                "Address\t\t\t"+
//                "Suburb\t"+
//                "Age\t"+
//                "Hire-date\t"+
//                "Department\t\t"+
//                "Working Hours\n"+
        String departNames ="" ;

               return(padRight(getId(),10)
                +padRight(getName(),15)
                + padRight(getDesc(),15)
                +padRight(getStreet_name(),20)
                +padRight(getSuburb(),15)
                +padRight(getPhone_no(),15)
                +padRight(getAge()+"",4)
                +padRight(getHire_date()+"",12)
                +padRight(departName,20)
                +padRight(getWstartTime()+"",12)
                +padRight(getWendTime()+"",12));
    }


    @Override
    public boolean isAnAdult(int age) {
        System.out.println("Enter the age of the Person");
        Scanner scanner = new Scanner(System.in);
        age = scanner.nextInt();
        if (age > 18)
            return true;
        else
            return false;

    }

    @Override
    public void setId(String id) {
      super.setId(id);
    }
}
