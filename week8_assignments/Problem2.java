import java.util.*;

interface Vehicle {
    double calculateCharge(int hours);
}

class Bike implements Vehicle {
    public double calculateCharge(int hours) {
        return hours * 10;
    }
}

class Car implements Vehicle {
    public double calculateCharge(int hours) {
        return 30 + (hours - 1) * 20;
    }
}

class Truck implements Vehicle {
    public double calculateCharge(int hours) {
        return Math.max(100, hours * 50);
    }
}

public class Problem2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        Map<String, Vehicle> vehicles = new HashMap<>();
        vehicles.put("BIKE", new Bike());
        vehicles.put("CAR", new Car());
        vehicles.put("TRUCK", new Truck());

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            int hours = sc.nextInt();

            double charge = vehicles.get(type).calculateCharge(hours);
            total += charge;

            System.out.printf("%s: %.2f%n", type, charge);
        }

        System.out.printf("Total: %.2f%n", total);
    }
}