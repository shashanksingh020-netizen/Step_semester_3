import java.util.*;
import java.time.LocalDate;

interface Plan {
    LocalDate getRenewalDate(LocalDate startDate);
}

class Basic implements Plan {
    public LocalDate getRenewalDate(LocalDate startDate) {
        return startDate.plusDays(30);
    }
}

class Standard implements Plan {
    public LocalDate getRenewalDate(LocalDate startDate) {
        return startDate.plusDays(90);
    }
}

class Premium implements Plan {
    public LocalDate getRenewalDate(LocalDate startDate) {
        return startDate.plusDays(365);
    }
}

public class Problem5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Map<String, Plan> plans = new HashMap<>();
        plans.put("BASIC", new Basic());
        plans.put("STANDARD", new Standard());
        plans.put("PREMIUM", new Premium());

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            LocalDate startDate = LocalDate.parse(sc.next());

            LocalDate renewalDate =
                    plans.get(type).getRenewalDate(startDate);

            System.out.printf("%s: %s%n", name, renewalDate);
        }
    }
}