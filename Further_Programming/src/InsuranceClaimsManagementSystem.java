import java.util.ArrayList;
import java.util.List;

public class InsuranceClaimsManagementSystem {

    public static void main(String[] args) {

        FileManager fileManager = new FileManager();
        List<Customer> customers = fileManager.readCustomersFromFile("Further_Programming/src/customers.txt");
        List<InsuranceCard> insuranceCards = fileManager.readInsuranceCardsFromFile("Further_Programming/src/insurance_cards.txt");
        List<Claim> claims = fileManager.readClaimsFromFile("Further_Programming/src/claims.txt");

        System.out.println("Customers:");
        fileManager.printFileContents("Further_Programming/src/customers.txt");

        // Print insurance cards
        System.out.println("Insurance Cards:");
        fileManager.printFileContents("Further_Programming/src/insurance_cards.txt");

        // Print claims
        System.out.println("Claims:");
        fileManager.printFileContents("Further_Programming/src/claims.txt");

        ClaimProcessManager claimProcessManager = new ClaimProcessManagerImplementation(claims);

        UI ui = new UI(customers, insuranceCards, claims);
        ui.run();

        fileManager.writeCustomersToFile(customers, "C:Further_Programming/src/customers.txt");
        fileManager.writeInsuranceCardsToFile(insuranceCards, "Further_Programming/src/insurance_cards.txt");
        fileManager.writeClaimsToFile(claims, "Further_Programming/src/claims.txt");
    }
}
