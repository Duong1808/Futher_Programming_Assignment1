package Further_Programming.src;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
public class UI {
    private List<Customer> customers;
    private List<InsuranceCard> insuranceCards;
    private List<Claim> claims;
    private ClaimProcessManager claimProcessManager;

    public UI(List<Customer> customers, List<InsuranceCard> insuranceCards, List<Claim> claims) {
        this.customers = customers;
        this.insuranceCards = insuranceCards;
        this.claims = claims;
        this.claimProcessManager = new ClaimProcessManagerImplementation(claims);
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("1. Add claim");
            System.out.println("2. Update claim");
            System.out.println("3. Delete claim");
            System.out.println("4. View claim details");
            System.out.println("5. View all claims");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    addClaim();
                    break;
                case 2:
                    updateClaim();
                    break;
                case 3:
                    deleteClaim();
                    break;
                case 4:
                    viewClaimDetails();
                    break;
                case 5:
                    viewAllClaims();
                    break;
                case 6:
                    System.out.println("Already existed");
                    break;
                default:
                    System.out.println("Invalid");
            }
        } while (choice != 6);
    }

    private void addClaim() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Claim ID: ");
        String id = scanner.nextLine();
        System.out.print("Claim Date (yyyy-MM-dd): ");
        String claimDateStr = scanner.nextLine();
        Date claimDate = null;
        try {
            claimDate = new SimpleDateFormat("yyyy-MM-dd").parse(claimDateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.print("Insured Person: ");
        String insuredPerson = scanner.nextLine();
        System.out.print("Insurance Card Number: ");
        String cardNumber = scanner.nextLine();
        System.out.print("Exam Date (yyyy-MM-dd): ");
        String examDateStr = scanner.nextLine();
        Date examDate = null;
        try {
            examDate = new SimpleDateFormat("yyyy-MM-dd").parse(examDateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println("Document: ");
        String document = scanner.nextLine();
        System.out.print("Claim Amount: ");
        double claimAmount = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Enter claim status (NEW, PROCESSING, DONE): ");
        String statusStr = scanner.next().toUpperCase();
        Claim.ClaimStatus status = Claim.ClaimStatus.valueOf(statusStr);
        System.out.print("Enter banking info - Bank: ");
        String bank = scanner.next();
        System.out.print("Enter banking info - Name: ");
        String name = scanner.next();
        System.out.print("Enter banking info - Number: ");
        String number = scanner.next();
        BankingInfo bankingInfo = new BankingInfo(bank, name, number);
        Claim claim = new Claim();
        claim.setId(id);
        claim.setClaimDate(claimDate);
        claim.setInsuredPerson(insuredPerson);
        claim.setCardNumber(cardNumber);
        claim.setExamDate(examDate);
        claim.setStatus(status);
        claimProcessManager.add(claim);
        System.out.println("Claim added successfully.");
    }
    private void updateClaim() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the ID of the claim to update: ");
        String id = scanner.nextLine();
        Claim existingClaim = claimProcessManager.getOne(id);
        if (existingClaim == null) {
            System.out.println("Claim not found.");
            return;
        }
        System.out.println("Enter new details for the claim (press Enter to keep existing values):");
        System.out.print("Claim Date (yyyy-MM-dd): ");
        String input = scanner.nextLine();
        if (!input.isEmpty()) {
            Date claimDate = null;
            try {
                claimDate = new SimpleDateFormat("yyyy-MM-dd").parse(input);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        System.out.print("Insured Person: ");
        input = scanner.nextLine();
        if (!input.isEmpty()) {
            existingClaim.setInsuredPerson(input);
        }
        claimProcessManager.update(existingClaim);
        System.out.println("Claim updated successfully.");
    }
    private void deleteClaim() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the ID of the claim to delete: ");
        String id = scanner.nextLine();
        claimProcessManager.delete(id);
        System.out.println("Claim deleted successfully.");
    }
    private void viewClaimDetails() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the ID of the claim to view details: ");
        String id = scanner.nextLine();
        Claim claim = claimProcessManager.getOne(id);
        if (claim != null) {
            System.out.println("Claim Details:");
            System.out.println("ID: " + claim.getId());
            System.out.println("Claim Date: " + claim.getClaimDate());
            System.out.println("Insured Person: " + claim.getInsuredPerson());
            System.out.println("Insurance Card Number: " + claim.getCardNumber());
            // Print other details as needed
        } else {
            System.out.println("Claim not found.");
        }
    }
    private void viewAllClaims() {
        List<Claim> allClaims = claimProcessManager.getAll();
        System.out.println("All Claims:");
        for (Claim claim : allClaims) {
            System.out.println("ID: " + claim.getId() + ", Insured Person: " + claim.getInsuredPerson() +
                    ", Claim Date: " + claim.getClaimDate() + ", Status: " + claim.getStatus());
        }
    }

//    private Date parseDate(String dateString) {
//        try {
//            return DATE_FORMAT.parse(dateString);
//        } catch (ParseException e) {
//            System.out.println("Invalid date format. Please use yyyy-MM-dd.");
//            return null;
//        }
//    }
}