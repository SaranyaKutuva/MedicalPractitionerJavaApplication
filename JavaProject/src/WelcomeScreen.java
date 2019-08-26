import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class WelcomeScreen {

//
//    static String userName, userPswd;
//
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Please Enter your Name: ");
//        String name = scanner.next();
//        System.out.println("Please Enter your age: ");
//        int age = scanner.nextInt();
//        System.out.println("Please Enter 'A' or 'a' for Admin and 'U' or 'u' for User");
//        char input = scanner.next().charAt(0);
//        char op = Character.valueOf(input);
//        if (op == 'a' || op == 'A') {
//            userName = "Iamadmin" + name;
//            userPswd = "Admin!Don'tMess" + age;
//            System.out.println(" Your User Name is: \t" + userName);
//            System.out.println(" Your Password is: \t" + userPswd);
//            // System.out.println(" Please Now Enter Your USERNAME AND PASSWORD");
//            System.out.println(" Please Enter the USERNAME: ");
//            String username = scanner.next();
//            System.out.println(" Please Enter the PASSWORD: ");
//            String userpswd = scanner.next();
//            if (username.equals(userName) && userpswd.equals(userPswd)) {
//                System.out.println(" You Can login");
//                scanner.nextLine();
//                System.out.println("If you are not a robot then input line of text");
//                String str = scanner.nextLine();
//
//                System.out.println(str);
//                System.out.println();
//                System.out.println("please Enter the word to search");
//                String a = scanner.next();
//                char s = a.charAt(0);
//
////        System.out.println(s + " come in your line for " + i + " times” Press Yes or No");
////        String valid = scanner.next();
//                int res = 0;
//
//                for (int i = 0; i < str.length(); i++) {
//                    // checking character in string
//                    if (str.charAt(i) == s) {
//                        res++;
//                    }
//                }
////              System.out.println(s + " comes in your line for " + res + " times” Press Yes or No");
//////        String valid = scanner.next();
//                int counter = 0;
//                do {
//                    System.out.println(s + " come in your line for " + res + " times” Press Yes or No");
//                    String valid = scanner.next();
//                    if (valid.equals("Yes") || valid.equals("yes")) {
//
//                        break;
//
//                    } else if (valid.equals("No") || valid.equals("no")) {
//
//                        counter++;
//                        continue;
//                    } else {
//                        System.out.println("Invalid input");
//                        counter++;
//                        continue;
//                    }
//
//                }
//                while (counter < 3);
//                if(counter == 3)
//                    System.out.println("Robots are not allowed !!! Bye");
//
//            } else {
//                System.out.println("Invalid UserName and password");
//
//            }
//
//        } else if (op == 'u' || op == 'U') {
//            userName = name + "IamUser";
//            userPswd = "Useronly" + age;
//            System.out.println(" Your User Name is \t" + userName);
//            System.out.println(" Your Password is \t " + userPswd);
//            //System.out.println(" Please Now Enter Your USERNAME AND PASSWORD");
//            System.out.println(" Please Enter the USERNAME");
//            String username = scanner.next();
//            System.out.println(" Please Enter the PASSWORD");
//            String userpswd = scanner.next();
//            if (username.equals(userName) && userpswd.equals(userPswd)) {
//                System.out.println(" Thanks,Still Under Work");
//                return;
//            } else {
//                System.out.println("Invalid UserName and password");
//
//            }
//
//
//        } else {
//            System.out.println("Invalid Choice ");
//        }
//
//    }
public static void main(String[] args) {


    LocalTime mytime = LocalTime.of(12, 45, 6);
    System.out.println(" create your local time " + mytime);
    LocalDate mydate = LocalDate.of(2012, 8, 23);
    System.out.println(mydate);
}
}


