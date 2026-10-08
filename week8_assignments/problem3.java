import java.util.*;

interface Room {
    double calculateBill(int units, int occupants);
}

class SingleRoom implements Room {
    public double calculateBill(int units, int occupants) {
        return units * 8;
    }
}

class SharedRoom implements Room {
    public double calculateBill(int units, int occupants) {
        return (units * 6.0) / occupants;
    }
}

class ACRoom implements Room {
    public double calculateBill(int units, int occupants) {
        return units * 10 + 200;
    }
}

public class Problem3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        Map<String, Room> rooms = new HashMap<>();
        rooms.put("SINGLE", new SingleRoom());
        rooms.put("SHARED", new SharedRoom());
        rooms.put("AC", new ACRoom());

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            int units = sc.nextInt();

            int occupants = 1;
            if (type.equals("SHARED")) {
                occupants = sc.nextInt();
            }

            double bill = rooms.get(type).calculateBill(units, occupants);
            total += bill;

            System.out.printf("%s: %.2f%n", type, bill);
        }

        System.out.printf("Total: %.2f%n", total);
    }
}