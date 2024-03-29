import java.util.List;

public interface ClaimProcessManager {
    void add(Claim claim);
    void update(Claim claim);
    void delete(String claimID);

    Claim getOne(String claimId);

    List<Claim> getAll();
}
