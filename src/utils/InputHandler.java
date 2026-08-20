package utils;

import java.util.Scanner;

public class InputHandler {

    private static Scanner scanner = new Scanner(System.in);


    // =========================================================
    // Read Text
    // =========================================================

    public static String readText(String prompt) {

        while (true) {

            System.out.print(prompt);

            String value = scanner.nextLine();

            if (HelperUtils.isValidText(value)) {
                return value;
            }

            System.out.println("Invalid input. Please enter text.");
        }
    }


    // =========================================================
    // Read Whole Number
    // =========================================================

    public static int readInt(String prompt) {

        while (true) {

            System.out.print(prompt);

            String value = scanner.nextLine();

            try {

                int number = Integer.parseInt(value);

                return number;

            } catch (NumberFormatException e) {

                System.out.println(
                        "Invalid number. Please enter a whole number."
                );
            }
        }
    }


    // =========================================================
    // Read Whole Number Within Range
    // =========================================================

    public static int readInt(
            String prompt,
            int min,
            int max) {

        while (true) {

            int number = readInt(prompt);

            if (HelperUtils.isInRange(
                    number,
                    min,
                    max)) {

                return number;
            }

            System.out.println(
                    "Number must be between "
                            + min
                            + " and "
                            + max
                            + "."
            );
        }
    }


    // =========================================================
    // Read Decimal
    // =========================================================

    public static double readDouble(String prompt) {

        while (true) {

            System.out.print(prompt);

            String value = scanner.nextLine();

            try {

                double number =
                        Double.parseDouble(value);

                return number;

            } catch (NumberFormatException e) {

                System.out.println(
                        "Invalid number. Please enter a decimal number."
                );
            }
        }
    }


    // =========================================================
    // Read Yes / No Confirmation
    // =========================================================

    public static boolean readConfirmation(
            String prompt) {

        String[] allowed = {
                "yes",
                "no",
                "y",
                "n"
        };

        while (true) {

            String value =
                    readText(prompt);

            if (HelperUtils.isOneOf(
                    value,
                    allowed)) {

                return value.equalsIgnoreCase("yes")
                        || value.equalsIgnoreCase("y");
            }

            System.out.println(
                    "Please enter yes or no."
            );
        }
    }


    // =========================================================
    // Read One Of Allowed Values
    // =========================================================

    public static String readOneOf(
            String prompt,
            String[] allowedValues) {

        while (true) {

            String value =
                    readText(prompt);

            if (HelperUtils.isOneOf(
                    value,
                    allowedValues)) {

                return value;
            }

            System.out.println(
                    "Invalid option. Please choose an allowed value."
            );
        }//
    }
}