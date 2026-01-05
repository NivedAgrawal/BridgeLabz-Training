package scenerio_based;

class InvalidInvoiceFormatException extends Exception {
    public InvalidInvoiceFormatException(String message) {
        super(message);
    }
}

public class InvoiceGenerator {

    public static String[] parseInvoice(String input) throws InvalidInvoiceFormatException {
        if (!input.contains("-")) {
            throw new InvalidInvoiceFormatException("Invalid invoice format");
        }
        return input.split(",");
    }

    public static int getTotalAmount(String[] tasks) throws InvalidInvoiceFormatException {
        int total = 0;

        for (String task : tasks) {
            String[] parts = task.split("-");
            if (parts.length < 2) {
                throw new InvalidInvoiceFormatException("Invalid task format");
            }

            String amountPart = parts[1].replace("INR", "").trim();
            total += Integer.parseInt(amountPart);
        }
        return total;
    }

    public static void main(String[] args) {
        String input = "Logo Design - 3000 INR, Web Page - 4500 INR";

        try {
            String[] tasks = parseInvoice(input);
            int total = getTotalAmount(tasks);
            System.out.println("Total Invoice Amount: ₹" + total);
        } catch (InvalidInvoiceFormatException e) {
            System.out.println(e.getMessage());
        }
    }
}
