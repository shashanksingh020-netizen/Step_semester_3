import java.util.*;

abstract class Appliance {
    protected double hours;

    Appliance(double hours) {
        this.hours = hours;
    }

    abstract double getPower();

    double getUnits() {
        return (getPower() * hours) / 1000;
    }

    double getCost() {
        return getUnits() * 8;
    }
}

interface SaverMode {
    double getSaverUnits();
}

class Fridge extends Appliance {
    Fridge(double hours) {
        super(hours);
    }

    double getPower() {
        return 150;
    }
}

class AC extends Appliance implements SaverMode {
    AC(double hours) {
        super(hours);
    }

    double getPower() {
        return 1500;
    }

    public double getSaverUnits() {
        return getUnits() * 0.75;
    }
}

class TV extends Appliance {
    TV(double hours) {
        super(hours);
    }

    double getPower() {
        return 100;
    }
}

class Washer extends Appliance implements SaverMode {
    Washer(double hours) {
        super(hours);
    }

    double getPower() {
        return 500;
    }

    public double getSaverUnits() {
        return getUnits() * 0.75;
    }
}

public class Problem5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double totalCost = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double hours = sc.nextDouble();

            boolean saver = false;

            if (sc.hasNext()) {
                sc.useDelimiter("\\s+");
            }

            String mode = "";

            // Read SAVER only if it exists on the same input line
            // using a simple line-based approach is safer.
        }
    }
}g