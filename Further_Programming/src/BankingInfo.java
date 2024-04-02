
/**
 * @author <Nguyen Tuan Duong - S3965530>
 */

public class BankingInfo {
    private String bank;
    private String name;
    private String number;

    // 1. Constructor
    public BankingInfo() {}

    public BankingInfo(String bank, String name, String nummber) {
        this.bank = bank;
        this.name = name;
        this.number = nummber;
    }

    // 2. Getters & Setters

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNummber(String nummber) {
        this.number = nummber;
    }

    @Override
    public String toString() {
        return "BankingInfo{" +
                "bank='" + bank + '\'' +
                ", name='" + name + '\'' +
                ", number='" + number + '\'' +
                '}';
    }
}
