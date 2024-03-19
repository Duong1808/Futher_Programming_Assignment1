public class BankingInfo {
    private String bank;
    private String name;
    private String number;

    // Constructor

    public BankingInfo(String bank, String name, String nummber) {
        this.bank = bank;
        this.name = name;
        this.number = nummber;
    }

    // Getters & Setters

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
}
