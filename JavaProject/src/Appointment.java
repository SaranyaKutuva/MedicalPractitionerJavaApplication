
import javax.swing.*;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;


public class Appointment {
    static int apptCounter = 100;
    private String aptid;
    private Doctor docid;
    private Patient pid;
    private LocalTime time;



    static public ArrayList<Appointment> myapptlist = new ArrayList<>();

    public Appointment() {
        this.aptid = aptid;
        this.docid = docid;
        this.pid = pid;
        this.time = time;
    }

    public Appointment(String aptid, Doctor docid, Patient pid, LocalTime time) {
        this.aptid = aptid;
        this.docid = docid;
        this.pid = pid;
        this.time = time;
        apptCounter++;
        String myid = Integer.toString(apptCounter);
        //System.out.println(myid);

        this.aptid = myid;
        //System.out.println("manav " + getDocid().getId() +" " +getPid().getId());
    }

    public void setAptid(String aptid) {
        this.aptid = aptid;
    }

    public String getAptid() {
        return aptid;
    }


    public void setDocid(Doctor docid) {
        this.docid = docid;
    }

    public void setPid(Patient pid) {
        this.pid = pid;
    }

    public Doctor getDocid() {
        return docid;
    }

    public Patient getPid() {
        return pid;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public LocalTime getTime() {
        return time;
    }

    public static void setMyapptlist(ArrayList<Appointment> myapptlist) {
        Appointment.myapptlist = myapptlist;
    }
    public ArrayList showAppointment() {
        Iterator i = myapptlist.iterator();
        while(i.hasNext())
        {
            System.out.println(i.next());
        }
        return myapptlist;

    }

    public String Addappt(Patient pid,Doctor docid,LocalTime time) {
        Scanner scanner = new Scanner(System.in);
//        System.out.println("Enter the appointment id ");
//        String aptid = scanner.next();
//
        Appointment appt = new Appointment(aptid,docid,pid,time);
        myapptlist.add(appt);
        appt.printHeader();
        appt.showAppointment();
        //System.out.println(myapptlist);
        return "Appointment Booked";
    }


        public String deleteappt (String aptid)
        {
            for (int index = 0; index < myapptlist.size(); index++) {

//                System.out.println("Enter the appointment id of the Patient to cancel the appointment");
//                Scanner scanner = new Scanner(System.in);
//                String id = scanner.next();
                if (Appointment.myapptlist.get(index).getAptid().equals(aptid))
                    System.out.println(" Your Patient is at location \t" + index);
                myapptlist.remove(index);
                break;
            }
            printHeader();
            showAppointment();
            return "Patient Appointment Cancelled Or Deleted";
        }
        public String modifyapt(String aptid)
        {
            for (int index = 0; index < myapptlist.size(); index++) {
                Scanner scanner = new Scanner(System.in);
                if (Appointment.myapptlist.get(index).getAptid().equals(aptid))
                    System.out.println(" Your Patient is at location \t" + index);
                System.out.println("Enter the new time to book (Time format (HH24:MM");
                //System.out.println("Enter the time to book an appointment");
                String inputHoursMins =scanner.next();
                String[] hoursMin = inputHoursMins.split(":");
                int minute = Integer.valueOf(hoursMin[1]);
                int hours  = Integer.valueOf(hoursMin[0]);
                LocalTime time = LocalTime.of(hours,minute);

                LocalTime  startTime = myapptlist.get(index).getDocid().getWstartTime() ;
                LocalTime  endTime = myapptlist.get(index).getDocid().getWendTime() ;
                if (time.isBefore(startTime) || time.isAfter(endTime)){
                    //System.out.println("Doctor not available:-( ");
                    return "Doctor not available:-(";
                }
              //  System.out.println("Kkk");
                myapptlist.get(index).setTime(time);
                printHeader();
                showAppointment();
                break;
            }
            return "Patient Appointment Updated or Modified";
        }

        public ArrayList listday (LocalTime time)
        {
            Iterator<Appointment> myiterator = myapptlist.iterator();
            while (true) {
                if (myiterator.hasNext())
                    System.out.println(myiterator.next());
            }

        }
    public static String padRight(String s, int n) {
        return String.format("%1$-" + n + "s", s);
    }

    public static String padLeft(String s, int n) {
        return String.format("%1$" + n + "s", s);
    }

    public void printHeader(){
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println(padLeft("Appointment Details",52));
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println(padRight("Appointment ID",18)
                +padRight("Patient ID",12)
                +padRight("Patient Name",30)
                +padRight("Doctor ID",14)
                +padRight("Doctor Name",20)
                +padRight("Appointment Time",20)
        );
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------");
    }


        @Override
        public String toString () {
            return(padRight(getAptid(),18)
                    +padRight(getPid().getId(),12)
                    +padRight(getPid().getFirstName() + " " +getPid().getLastName(),30)
                   +padRight(getDocid().getId(),14)
                   +padRight(getDocid().getName(),20)
                   +padRight(getTime().toString(),20)
            );
        }


    }





