import java.util.ArrayList;
import java.util.List;

public class InsuranceClaimsManagementSystem {

    public static void main(String[] args) {
        FileManager fileManager = new FileManager();
        List<Customer> customers = fileManager.readCustomersFromFile("customers.txt");
        List<InsuranceCard> insuranceCards = fileManager.readInsuranceCardsFromFile("insurance_cards.txt");
        List<Claim> claims = fileManager.readClaimsFromFile("claims.txt");

        ClaimProcessManager claimProcessManager = new ClaimProcessManagerImplementation(claims);

        UI ui = new UI(customers, insuranceCards, claims);
        ui.run();

        fileManager.writeCustomersToFile(customers, "customers.txt");
        fileManager.writeInsuranceCardsToFile(insuranceCards, "insurance_cards.txt");
        fileManager.writeClaimsToFile(claims, "claims.txt");
    }
}
