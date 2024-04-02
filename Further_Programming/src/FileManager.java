import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;


/**
 * @author <Nguyen Tuan Duong - S3965530>
 */

public class FileManager {
    // This class is used to handle file tasks
    private static String CUSTOMERS_FILE_PATH = "Further_Programming/src/customers.txt";
    private static String INSURANCE_CARDS_FILE_PATH = "Further_Programming/src/insurance_cards.txt";
    private static String CLAIMS_FILE_PATH = "Further_Programming/src/claims.txt";

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    // 1. Read file method

    public List<Customer> readCustomersFromFile(String filename) {
        List<Customer> customers = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("Further_Programming/src/customers.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length >= 3) {
                    Customer customer = new Customer();
                    customer.setId(data[0]);
                    customer.setFullName(data[1]);
                    InsuranceCard insuranceCard = parseInsuranceCard(data[2]);
                    customer.setInsuranceCard(insuranceCard);
                    customers.add(customer);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return customers;
    }

    private InsuranceCard parseInsuranceCard(String cardString) {
        String[] cardData = cardString.split("\\|");
        if (cardData.length >= 4) {
            InsuranceCard insuranceCard = new InsuranceCard();
            insuranceCard.setCardNumber(cardData[0]);
            insuranceCard.setCardHolder(cardData[1]);
            insuranceCard.setPolicyOwner(cardData[2]);
            try {
                insuranceCard.setExpirationDate(DATE_FORMAT.parse(cardData[3]));
            } catch (Exception e) {
                e.printStackTrace();
            }
            return insuranceCard;
        }
        return null;
    }

    public List<InsuranceCard> readInsuranceCardsFromFile(String filename) {
        List<InsuranceCard> insuranceCards = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("Further_Programming/src/insurance_cards.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    InsuranceCard insuranceCard = new InsuranceCard();
                    insuranceCard.setCardNumber(parts[0]);
                    insuranceCard.setCardHolder(parts[1]);
                    insuranceCard.setPolicyOwner(parts[2]);
                    insuranceCard.setExpirationDate(DATE_FORMAT.parse(parts[3]));
                    insuranceCards.add(insuranceCard);
                }
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return insuranceCards;
    }

    public List<Claim> readClaimsFromFile(String filename) {
        List<Claim> claims = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("Further_Programming/src/claims.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 9) {
                    Claim claim = new Claim();
                    claim.setId(parts[0]);
                    claim.setClaimDate(DATE_FORMAT.parse(parts[1]));
                    claim.setInsuredPerson(parts[2]);
                    claim.setCardNumber(parts[3]);
                    claim.setExamDate(DATE_FORMAT.parse(parts[4]));
                    claim.setDocuments(new ArrayList<>());
                    String[] documentNames = parts[5].split(";");
                    for (String docName : documentNames) {
                        claim.getDocuments().add(docName);
                    }
                    claim.setClaimAmount(Double.parseDouble(parts[6]));
                    Claim.ClaimStatus status = Claim.ClaimStatus.valueOf(parts[7]);
                    BankingInfo receiverBankingInfo = new BankingInfo();
                    receiverBankingInfo.setBank(parts[8]);
                    receiverBankingInfo.setName(parts[9]);
                    receiverBankingInfo.setNummber(parts[10]);
                    claim.setBankingInfo(receiverBankingInfo);
                    claims.add(claim);
                }
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return claims;
    }

    // 2. Write to file method
    public void writeCustomersToFile(List<Customer> customers, String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Further_Programming/src/customers.txt"))) {
            for (Customer customer : customers) {
                writer.write(customer.getId() + "," + customer.getFullName() + ","
                        + formatInsuranceCard(customer.getInsuranceCard()) + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String formatInsuranceCard(InsuranceCard insuranceCard) {
        return insuranceCard.getCardNumber() + "|" + insuranceCard.getCardHolder() + "|"
                + insuranceCard.getPolicyOwner() + "|" + DATE_FORMAT.format(insuranceCard.getExpirationDate());
    }

    public void writeInsuranceCardsToFile(List<InsuranceCard> insuranceCards, String filename) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("Further_Programming/src/insurance_cards.txt"))) {
            for (InsuranceCard card : insuranceCards) {
                String line = String.format("%s,%s,%s,%s", card.getCardNumber(), card.getCardHolder(),
                        card.getPolicyOwner(), DATE_FORMAT.format(card.getExpirationDate()));
                bw.write(line);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeClaimsToFile(List<Claim> claims, String filename) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("Further_Programming/src/claims.txt"))) {
            for (Claim claim : claims) {
                String documents = String.join(";", claim.getDocuments());
                String line = String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", claim.getId(),
                        DATE_FORMAT.format(claim.getClaimDate()), claim.getInsuredPerson(), claim.getCardNumber(),
                        DATE_FORMAT.format(claim.getExamDate()), documents, claim.getClaimAmount(), claim.getStatus(),
                        claim.getBankingInfo().getBank(), claim.getBankingInfo().getName(),
                        claim.getBankingInfo().getNumber());
                bw.write(line);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void printFileContents(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
