import java.util.*;

abstract class Student {
    protected String name;
    protected static final double TRANSPORT_FEE = 12000.0;

    Student(String name) {
        this.name = name;
    }

    abstract double getTuition();

    boolean usesBus() {
        return false;
    }

    double getTotalFee() {
        double fee = getTuition();

        if (usesBus()) {
            fee += TRANSPORT_FEE;
        }

        return fee;
    }
}

class DayScholar extends Student {
    DayScholar(String name) {
        super(name);
    }

    double getTuition() {
        return 40000.0;
    }

    boolean usesBus() {
        return true;
    }
}

class Hosteller extends Student {
    Hosteller(String name) {
        super(name);
    }

    double getTuition() {
        return 40000.0 + 60000.0;
    }
}

class ScholarshipStudent extends Student {
    ScholarshipStudent(String name) {
        super(name);
    }

    double getTuition() {
        return 20000.0;
    }

    boolean usesBus() {
        return true;
    }
}

public class Problem3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double totalCollected = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();

            Student student;

            if (type.equals("DAY_SCHOLAR")) {
                student = new DayScholar(name);
            } else if (type.equals("HOSTELLER")) {
                student = new Hosteller(name);
            } else {
                student = new ScholarshipStudent(name);
            }

            double fee = student.getTotalFee();
            totalCollected += fee;

            System.out.printf("%s: %.2f%n", name, fee);
        }

        System.out.printf("Total Collected: %.2f%n", totalCollected);
    }
}