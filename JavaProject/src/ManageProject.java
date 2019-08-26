import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Date;
import java.util.function.DoubleConsumer;

public class ManageProject
{
    static String userName, userPswd;
    public static void main(String[] args)
    {
        String name;
        int age;
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Please Enter your Name(Only Letters Pls): ");
            name = scanner.next();
            for (int i = 0; i < name.length(); i++)
            {
                if (!Character.isLetter(name.charAt(i)))
                {
                    System.out.println("Given Name does not contain only letters!");
                    return;
                }
            }
        }
    catch(Exception e)

    {
        System.out.println("Not a valid input(Only Letters Pls)"+ e);
        return;
    }
        //Integer.parseInt(name);
        //System.out.println(Integer.parseInt(name));
        try {
            System.out.println("Please Enter your age(18 to 110) whole numbers ONLY : ") ;
            age = scanner.nextInt();
            if(age<18 || age>110)
            {
                System.out.println("Incorrect age provided");
                return;
            }
        }
        catch(Exception e)
        {
            System.out.println("Not a valid input for age" );
            return;
        }
        System.out.println("Please Enter 'A' or 'a' for Admin and 'U' or 'u' for User");
        //String op = scanner.nextLine;
        String op = scanner.next().toUpperCase();
        //System.out.println(op);
        //char op = Character.valueOf(input);
//        Receptionists receptionists = new Receptionists();
//        receptionists.Makechoice();

        if (op.equals("A") ) {
            userName = "Iamadmin" + name;
            userPswd = "Admin!Don'tMess" + age;
            System.out.println("Your User Name is: \t" + userName);
            System.out.println("Your Password is: \t" + userPswd);
            System.out.println("Please Enter the USERNAME: ");
            String username = scanner.next();
            System.out.println("Please Enter the PASSWORD: ");
            String userpswd = scanner.next();
            if (username.equals(userName) && userpswd.equals(userPswd)) {
                System.out.println("Welcome to Western Sydney Medical Practice!");
                scanner.nextLine();
                System.out.println("If you are not a robot then input line of text");
                String str = scanner.next();
                scanner.nextLine();
                //System.out.println();
                System.out.println("Please Enter a letter to search");
                String a = scanner.next();
                char s = a.charAt(0);
                int res = 0;
                for (int j= 0; j < str.length(); j++)
                {
                    // checking character in string
                    if (str.charAt(j) == s)
                    {
                        res++;
                    }
                }

                int counter = 0;
                do {
                    System.out.println("\"Letter " + s + " is found in your line  " + res + " times” Press Yes or No");
                    String valid = scanner.next();
                    if (valid.equals("Yes") || valid.equals("yes"))
                    {
                        data();
                        Receptionists receptionists = new Receptionists();
                        //System.out.println(receptionists);
                        receptionists.Makechoice();

                        break;

                    } else if (valid.equals("No") || valid.equals("no")) {
                        continue;
                    } else
                        {
                        System.out.println("Invalid input");
                        continue;
                    }

                }
                while (counter < 3);
                if(counter == 3)
                    System.out.println("Robots are not allowed !!! Bye");

            }
            else {
                System.out.println("Invalid UserName and password");

            }

        } else if (op.equals("U")) {
            userName = name + "IamUser";
            userPswd = "Useronly" + age;
            System.out.println(" Your User Name is \t" + userName);
            System.out.println(" Your Password is \t " + userPswd);
            System.out.println(" Please Enter the USERNAME");
            String username = scanner.next();
            System.out.println(" Please Enter the PASSWORD");
            String userpswd = scanner.next();
            if (username.equals(userName) && userpswd.equals(userPswd)) {
                System.out.println(" Thanks,Still Under Work");
                return;
            }

            else {
                System.out.println("Invalid UserName and password");

            }


        } else {
            System.out.println("Invalid Choice ");
            return;
//            Receptionists receptionists = new Receptionists();
//            System.out.println(receptionists);
//            receptionists.Makechoice();
            //break;
        }

    }

        Employee employee = new Employee() {
            @Override
            public double computePay() {
                System.out.println("Iam from Receptionist Pay");
                return (4000.00);
            }
        };

    public static String padRight(String s, int n) {
        return String.format("%1$-" + n + "s", s);
    }

    public static String padLeft(String s, int n) {
        return String.format("%1$" + n + "s", s);
    }

static void data()
{
    Doctor doctor = new Doctor("22001","John","Doctor","12, Barton Road","Hornsby","0432795958",44,LocalDate.of(2004,3,12),"General",LocalTime.of(9,00),LocalTime.of(17,30));
    Doctor doctor1 = new Doctor("22002","Oriana","Nurse","62, Hornsey Road","Hornsby","0432098309",24,LocalDate.of(2018,9,19),"Surgery",LocalTime.of(9,00),LocalTime.of(17,30));
    Doctor doctor2 = new Doctor("22003","Edward","M.B.B.S","16, Robert Street","Strathfield","0438400909",54,LocalDate.of(2009,5,22),"Basic Nursing",LocalTime.of(9,00),LocalTime.of(17,30));
    Doctor doctor3 = new Doctor("22004","Helen","M.B.B.S","99, Kitchener Road","North Sydney","0432098958",35,LocalDate.of(2012,8,5),"General",LocalTime.of(9,00),LocalTime.of(17,30));
    Doctor doctor4 = new Doctor("22005","Selene","Doctor","12, Barton Road","Hornsby","0432795958",44,LocalDate.of(2004,4,26),"psychologist",LocalTime.of(9,00),LocalTime.of(17,30));
    Doctor doctor5 = new Doctor("22006","Peter","Doctor","72, Reserve Road","Burwood","0432000058",55,LocalDate.of(2001,12,12),"Surgery",LocalTime.of(9,00),LocalTime.of(17,30));
    Doctor.mydoctorlist.add(doctor);
    Doctor.mydoctorlist.add(doctor1);
    Doctor.mydoctorlist.add(doctor2);
    Doctor.mydoctorlist.add(doctor3);
    Doctor.mydoctorlist.add(doctor4);
    Doctor.mydoctorlist.add(doctor5);
    Patient patient1 = new Patient("20001","James","Smith","13, Arthur Street","Hornsby","234564544",34,Doctor.mydoctorlist.get(1),"0423457873");
    Patient patient2 = new Patient("20002","Jack","Smith","13, Arthur Street","Hornsby","2356564544",14,Doctor.mydoctorlist.get(1),"0423457873");
    Patient patient3 = new Patient("20003","Johny","Whittle","56, Oscar Street","Hornsby","2345878544",64,Doctor.mydoctorlist.get(3),"0423457873");
    Patient patient4 = new Patient("20004","Annie","Maree","13, Jersey Road","Hornsby","2344344544",37,Doctor.mydoctorlist.get(2),"0423457873");
    Patient patient5 = new Patient("20005","Eliza","Hird","54, Francis Street","Hornsby","2345566544",23,Doctor.mydoctorlist.get(1),"0423457873");
    Patient.mypatientlist.add(patient1);
    Patient.mypatientlist.add(patient2);
    Patient.mypatientlist.add(patient3);
    Patient.mypatientlist.add(patient4);
    Patient.mypatientlist.add(patient5);
    patient1.printHeader();
//        System.out.println("----------------------------------------------------------------------------------------------------------------");
//        System.out.println(padLeft("Patient Details",52));
//        System.out.println("----------------------------------------------------------------------------------------------------------------");
//        System.out.println(padRight("ID",10)
//                +padRight("First Name",15)
//                + padRight("Last Name",15)
//                +padRight("Street Name",20)
//                +padRight("Suburb",15)
//                +padRight("Medicare No",15)
//                +padRight("Age",4)
//                +padRight("Phone Number",10)
//                );
//        System.out.println("----------------------------------------------------------------------------------------------------------------");
    Iterator i = Patient.mypatientlist.iterator();
    while(i.hasNext())
    {
        System.out.println(i.next());
    }
    //System.out.println(Patient.mypatientlist.toString());


    //  String[] deptNames = {"General", "Surgery", "Basic Nursing", "Psychologist"};


    doctor.printHeader();
    Iterator i1 =Doctor.mydoctorlist.iterator();
       /*System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println(padLeft("Doctor Details",52));
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------");
        *//*System.out.println(    "Id"+" \t\t" +
                "Name" +"\t" +
                "Desc" +"\t\t" +
                "Address"+"\t\t\t\t"+
                "Suburb"+"\t\t\t"+
                "Age"+"\t\t"+
                "Hire-date"+"\t\t"+
                "Department"+"\t\t\t"+
                "Working Hours");*/
       /* System.out.println(padRight("ID",10)
                +padRight("Name",15)
                + padRight("Description",15)
                +padRight("Address",20)
                +padRight("Suburb",15)
                +padRight("Phone Number",15)
                +padRight("Age",4)
                +padRight("Hire Date",12)
                +padRight("Department",15)
                +padRight("Working Hours",4)


        );*/
    //System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------");
    while(i1.hasNext())
    {
        System.out.println(i1.next());
    }
    // System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------");

    Appointment appointment = new Appointment("9001",  Doctor.mydoctorlist.get(0), Patient.mypatientlist.get(0),LocalTime.of(9,30));
    Appointment.myapptlist.add(appointment);
    appointment.printHeader();
    Iterator i2 =Appointment.myapptlist.iterator();
    //System.out.println(Appointment.myapptlist);

    while(i2.hasNext())
    {

        System.out.println(i2.next());
    }
    System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------");
    Receptionists r = new Receptionists("34001","Saran","B.Com","45, Reserve Road","Toongabbie",34,"0420987898",LocalDate.of(1967,2,21),"Part Time");
    Receptionists r1 = new Receptionists("34003","Sofia","B.Com","23, Barton Road","NewTown",56,"0420987898",LocalDate.of(1987,9,23),"Full Time");
}

}

