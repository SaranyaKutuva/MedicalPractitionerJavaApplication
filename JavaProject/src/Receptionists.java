import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Receptionists extends Employee
{
    private String status;

    public Receptionists()
    {
        this.setId(getId());
        this.setName(getName());
        this.setDesc(getDesc());
        this.setStreet_name(getStreet_name());
        this.setSuburb(getSuburb());
        this.setAge(getAge());
        this.setPhone_no(getPhone_no());
        this.setHire_date(getHire_date());
        this.status = status;
    }
    public Receptionists(String id, String name, String desc, String street_Name, String suburb, int age, String phoneno, LocalDate hire_date, String status)
    {
        this.setId(id);
        this.setName(name);
        this.setDesc(desc);
        this.setStreet_name(street_Name);
        this.setSuburb(suburb);
        this.setAge(age);
        this.setPhone_no(phoneno);
        this.setHire_date(hire_date);
        this.status = status;
    }

    public void Makechoice()

    {
        while(true) {
            System.out.println("Press one of the following for corresponding actions " +
                    "\n----------------------------------------------------" +
                    "\n1.DoManageMenu()" +
                    "\n2.DoApptMenu()" +
                    "\n3.Quit");

            Scanner scanner = new Scanner(System.in);
            String op = scanner.nextLine();

            if (op.equals("1")) {
                DoManageMenu();
                //break;
                //return;
            } else if (op.equals("2")) {
                DoApptMenu();
                // break;
                //return;
            } else if (op.equals("3")) {
                break;
            }
            else {
                System.out.println("Not a Valid Choice");
                return;
            }
        }

    }
    public void DoManageMenu()
    {
        System.out.println("Do Manage Menu");
        System.out.println("--------------");
        System.out.println("Enter one of the corresponding letters for the operation");
        System.out.println( " ‘A’: Add patient" +
                "\n ‘D’: Delete patient" +
                "\n ‘+’: Add doctor" +
                "\n ‘-‘: delete Doctor" +
                "\n 'Q': quit");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        System.out.println(input);
        if (input.equals("A") || input.equals("a"))
        {
            Patient patient = new Patient();
            String msg = patient.addpatient(patient);
            return;
        }
        else if (input.equals("D") || input.equals("d"))
        {
//            System.out.println("Enter the id of the doctor to show");
//            String id = scanner.next();
            Patient patient = new Patient();
            String id = patient.deletepatient(patient);
            System.out.println(id);
        }
        else if (input.equals("+"))
        {
            Doctor doctor= new Doctor();
            ArrayList list = (ArrayList) doctor.addDoctor(doctor);
            //System.out.println(list);
        }
        else if (input.equals("-"))
        {
            Doctor doctor= new Doctor();
            ArrayList list = (ArrayList) doctor.deleteDoctor(doctor);
           // System.out.println(list);
        }
        else if (input.equals("Q") || input.equals("q"))
        {
            return;
        }
        else
        {
            System.out.println("Invalid choice");
            //continue;
        }
        return;
    }
    public void DoApptMenu()
    {
        System.out.println("Do Main Menu");
        System.out.println("------------");
        System.out.println("Enter one of the corresponding letters for the operation");
        System.out.println( " ‘A’: Add Appointment" +
                "\n ‘D’: Delete Appointment" +
                "\n ‘M’: Modify Appointment" +
                "\n ‘L‘: List Day" +
                "\n 'Q': Quit");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        int doctorIndex =-1;
        int patientIndex =-1;
        if (input.equals("A") || input.equals("a"))
        {
            Doctor doctor = new Doctor();
            System.out.println("Enter the id of the doctor");
            String docid = scanner.next();
            for (int index = 0; index < doctor.mydoctorlist.size(); index++) {
                if (Doctor.mydoctorlist.get(index).getId().equals(docid)) {
                    //System.out.println(" Your Doctor is at location \t" + index);
                    doctorIndex = index;
                    break;
                }
                else
                {
                    doctorIndex=-1;
                    //System.out.println("Doctor could not be Found");
                   //return;
                }
            }
            if (doctorIndex==-1){  System.out.println("Doctor could not be Found"); return;}
            Patient patient = new Patient();
            System.out.println("Enter the id of the patient");
            String pid = scanner.next();
            for (int index = 0; index < patient.mypatientlist.size(); index++) {

                if (Patient.mypatientlist.get(index).getId().equals(pid)) {
                    //System.out.println(" Your Patient is at location \t" + index);
                    patientIndex = index;
                  break;
                }
                else
                {
                    patientIndex =-1;
                    //System.out.println("Patient could not be Found");
                    //return;
                }
            }
            if ( patientIndex ==-1){System.out.println("Patient could not be Found"); return;};

            System.out.println("Enter the time to book an appointment: Time format (HH24:MM)");
            String inputHoursMins =scanner.next();
            // scanner.nextLine();
            // System.out.println("Hello");
            // System.out.println(inputHoursMins);
            String[] hoursMin = inputHoursMins.split(":");

            //for(String name : hoursMin){
            //    System.out.println(name);
            // }
            int minute = Integer.valueOf(hoursMin[1]);
            int hours  = Integer.valueOf(hoursMin[0]);
            LocalTime time = LocalTime.of(hours,minute);
            LocalTime  startTime = Doctor.mydoctorlist.get(doctorIndex).getWstartTime() ;
            LocalTime  endTime = Doctor.mydoctorlist.get(doctorIndex).getWendTime() ;
            if (time.isBefore(startTime) || time.isAfter(endTime)){
               System.out.println("Doctor not available:-( ");
               return;
            }

            Appointment appointment = new Appointment();
            String msg= appointment.Addappt(Patient.mypatientlist.get(patientIndex),Doctor.mydoctorlist.get(doctorIndex),time);
           // appointment.printHeader();
          //  appointment.toString();
            System.out.println(msg);
        }
        else if (input.equals("D") || input.equals("d"))
        {
            Appointment appointment = new Appointment();
            System.out.println("Enter the appointment id of the Patient to cancel the appointment");
           //Scanner scanner = new Scanner(System.in);
            String aptid = scanner.next();
            String msg = appointment.deleteappt(aptid);
           // appointment.printHeader();
           // appointment.toString();
            System.out.println(msg);
        }
        else if (input.equals("M") || input.equals("m"))
        {
            Appointment appointment = new Appointment();
            System.out.println("Enter the appointment id of the Patient to modify the appointment");
            //Scanner scanner = new Scanner(System.in);
            String aptid = scanner.next();
            String msg = appointment.modifyapt(aptid);
           // appointment.printHeader();
           // appointment.toString();
            System.out.println(msg);

        }
        else if (input.equals("L") || input.equals("l"))
        {
            Appointment appointment = new Appointment();
            appointment.printHeader();
            appointment.showAppointment();
            //ArrayList listday = appointment.listday(LocalTime time);
            //System.out.println(listday);
        }
        else if (input.equals("Q") || input.equals("q"))
        {
            return;
        }
        else
        {
            System.out.println("Invalid choice");
        }
        return;
    }


    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public double computePay() {
        System.out.println("I am from Receptionist Double pay");
        return 6000;
    }

    @Override
    public String toString() {

        return  "Id \t\t Name \t Desc \t Address\t\t\t Suburb\t Age\tHire-date\t Status \n"+
               getId()+"\t" +getName()+ "\t" + getDesc() + "\t" + getStreet_name() +"\t"+ getSuburb() + "\t" +getAge() + "\t"+ getHire_date() + "\t" + getStatus() ;
    }

}

