public class BankingInfo {
    private String bank;
    private String name;
    private String nummber;

    // Constructor

    public BankingInfo(String bank, String name, String nummber) {
        this.bank = bank;
        this.name = name;
        this.nummber = nummber;
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

    public String getNummber() {
        return nummber;
    }

    public void setNummber(String nummber) {
        this.nummber = nummber;
    }
}
