import java.util.Date;
import java.util.List;

/**
 * @author <Nguyen Tuan Duong - S3965530>
 */

public class Claim {
    private String id;
    private Date claimDate;
    private String insuredPerson;
    private String cardNumber;
    private Date examDate;
    private List<String> documents;
    private double claimAmount;
    private  ClaimStatus status;
    private BankingInfo bankingInfo;

    public enum ClaimStatus {
        NEW, PROCESSING, DONE
    }

    // 1. Constructor
    public Claim() {}
    public Claim(String id, Date claimDate, String insuredPerson, String cardNumber, Date examDate, List<String> documents, double claimAmount, ClaimStatus status, BankingInfo bankingInfo) {
        this.id = id;
        this.claimDate = claimDate;
        this.insuredPerson = insuredPerson;
        this.cardNumber = cardNumber;
        this.examDate = examDate;
        this.documents = documents;
        this.claimAmount = claimAmount;
        this.status = status;
        this.bankingInfo = bankingInfo;
    }

    // 2. Getter & Setter
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getClaimDate() {
        return claimDate;
    }

    public void setClaimDate(Date claimDate) {
        this.claimDate = claimDate;
    }

    public String getInsuredPerson() {
        return insuredPerson;
    }

    public void setInsuredPerson(String insuredPerson) {
        this.insuredPerson = insuredPerson;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Date getExamDate() {
        return examDate;
    }

    public void setExamDate(Date examDate) {
        this.examDate = examDate;
    }

    public List<String> getDocuments() {
        return documents;
    }

    public void setDocuments(List<String> documents) {
        this.documents = documents;
    }

    public double getClaimAmount() {
        return claimAmount;
    }

    public void setClaimAmount(double claimAmount) {
        this.claimAmount = claimAmount;
    }

    public ClaimStatus getStatus() {
        return status;
    }

    public void setStatus(ClaimStatus status) {
        this.status = status;
    }

    public BankingInfo getBankingInfo() {
        return bankingInfo;
    }

    public void setBankingInfo(BankingInfo bankingInfo) {
        this.bankingInfo = bankingInfo;
    }

    @Override
    public String toString() {
        return "Claim{" +
                "id='" + id + '\'' +
                ", claimDate=" + claimDate +
                ", insuredPerson='" + insuredPerson + '\'' +
                ", cardNumber='" + cardNumber + '\'' +
                ", examDate=" + examDate +
                ", documents=" + documents +
                ", claimAmount=" + claimAmount +
                ", status=" + status +
                ", bankingInfo=" + bankingInfo +
                '}';
    }
}
