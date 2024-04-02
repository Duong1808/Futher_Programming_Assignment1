import java.util.ArrayList;
import java.util.List;

/**
 * @author <Nguyen Tuan Duong - S3965530>
 */

public class ClaimProcessManagerImplementation implements ClaimProcessManager {
    private List<Claim> claims;
    public ClaimProcessManagerImplementation(List<Claim> claims) {
        this.claims = claims;
    }

    // 1. add method
    @Override
    public void add(Claim claim) {
        claims.add(claim);
    }

    // 2. update method
    @Override
    public void update(Claim claim) {
        // this method will find a claim by its ID then update
        for (int i = 0; i < claims.size(); i++) {
            if (claims.get(i).getId().equals(claim.getId())) { // find ID of claim
                claims.set(i, claim); // update claim
                return;
            }
        }
    }

    // 3. delete method
    @Override
    public void delete(String id) {
        // this method will find a claim by its ID them remove
        claims.removeIf(claim -> claim.getId().equals(id));
    }

    // 4. get one method
    @Override
    public Claim getOne(String id) {
        // this method will find a claim by its ID then return
        for (Claim claim : claims) {
            if (claim.getId().equals(id)) { // find a claim by its ID
                return claim;
            }
        }
        return null;
    }

    // 5. get all method
    @Override
    public List<Claim> getAll() {
        // this method return all claims in the system
        return new ArrayList<>(claims);
    }
}
