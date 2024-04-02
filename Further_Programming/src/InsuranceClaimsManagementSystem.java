import java.util.ArrayList;
import java.util.List;

/**
 * @author <Nguyen Tuan Duong - S3965530>
 */

public class InsuranceClaimsManagementSystem {

    public static void main(String[] args) {
        // 1. Read from file
        FileManager fileManager = new FileManager();
        List<Customer> customers = fileManager.readCustomersFromFile("Further_Programming/src/customers.txt");
        List<InsuranceCard> insuranceCards = fileManager.readInsuranceCardsFromFile("Further_Programming/src/insurance_cards.txt");
        List<Claim> claims = fileManager.readClaimsFromFile("Further_Programming/src/claims.txt");

        // 2. Print to the screen
        System.out.println("Customers:");
        fileManager.printFileContents("Further_Programming/src/customers.txt");
        System.out.println("Insurance Cards:");
        fileManager.printFileContents("Further_Programming/src/insurance_cards.txt");
        System.out.println("Claims:");
        fileManager.printFileContents("Further_Programming/src/claims.txt");

        ClaimProcessManager claimProcessManager = new ClaimProcessManagerImplementation(claims);

        // 3. run user interface after read from file
        UI ui = new UI(customers, insuranceCards, claims);
        ui.Menu();

        // 3. Save to the file
        fileManager.writeCustomersToFile(customers, "C:Further_Programming/src/customers.txt");
        fileManager.writeInsuranceCardsToFile(insuranceCards, "Further_Programming/src/insurance_cards.txt");
        fileManager.writeClaimsToFile(claims, "Further_Programming/src/claims.txt");
    }
}
