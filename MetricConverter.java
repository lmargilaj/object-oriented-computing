import java.util.Scanner;

public class MetricConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the metric converter!");
        System.out.println("Please enter your query. For example: 1 km = m");
        System.out.println("Enter 'exit' to exit the program");

        while (true) {
            System.out.print("Enter your conversions query (e.g., 1 km = m)");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("exit")) {
                System.out.println("Exiting application.");
                break;
            }
            String[] parts = input.split("=");
            if (parts.length != 2) {
                System.out.println("Invalid format. Use correct format (e.g., 1 km = m)");
                continue;
            }
            String leftPart = parts[0].trim();
            String rightPart = parts[1].trim();

            String[] valueAndUnitFrom = leftPart.split("\\s+");
            String[] unitTo = rightPart.split("\\s+");

            if (valueAndUnitFrom.length != 2 || unitTo.length != 1) {
                System.out.println("Invalid format. Use correct format (e.g., 1 km = m)");
                continue;
            }

            try {
                double value = Double.parseDouble(valueAndUnitFrom[0]);
                String unitFrom = valueAndUnitFrom[1];
                String unitsTo = unitTo[0];

                double result = convert(value, unitFrom, unitsTo);

                if (result >= 0) {
                    System.out.println(value + " " + unitFrom + " = " + result + " " + unitTo);
                } else {
                    System.out.println("Conversion not supported.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input format. Please use the format '1 km = m'.");
            }
        }

        scanner.close();
    }

    public static double convert(double value, String unitFrom, String unitTo) {
        switch (unitFrom + "_" + unitTo) {
            case "km_m":
                return value * 1000;
            case "m_km":
                return value / 1000;
            case "kg_lb":
                return value * 2.20462;
            case "lb_kg":
                return value / 2.20462;
            case "cm_in":
                return value / 2.54;
            case "in_cm":
                return value * 2.54;
            default:
                return -1; // Indicates unsupported conversion
        }

    }
}