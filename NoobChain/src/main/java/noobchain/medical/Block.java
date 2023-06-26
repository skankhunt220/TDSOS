package noobchain.medical;

import lombok.extern.slf4j.Slf4j;
import noobchain.util.StringUtil;

import java.util.List;

@Slf4j
public class Block {

    private int index;
    private String previousHash;
    private long timestamp;
    private List<MedicalRecord> medicalRecords;
    private String hash;
    private int nonce;

    public Block(int index, String previousHash, long timestamp, List<MedicalRecord> medicalRecords) {
        this.index = index;
        this.previousHash = previousHash;
        this.timestamp = timestamp;
        this.medicalRecords = medicalRecords;
        this.nonce = 0;
        this.hash = calculateHash();
    }

    public String getHash() {
        return hash;
    }

    public String getPreviousHash() {
        return previousHash;
    }

    public void setPreviousHash(String previousHash) {
        this.previousHash = previousHash;
    }

    public List<MedicalRecord> getMedicalRecords() {
        return medicalRecords;
    }

    public String calculateHash() {
        String dataToHash = index + previousHash + timestamp + medicalRecords.toString() + nonce;
        return StringUtil.applySha256(dataToHash);
    }

    public void mineBlock(int difficulty) {
        String target = StringUtil.getDificultyString(difficulty); // Create a target string with difficulty level
        while (!hash.substring(0, difficulty).equals(target)) {
            nonce++;
            hash = calculateHash();
        }
        log.info("Block mined: " + hash);
    }

    @Override
    public String toString() {
        return "Block{" +
                "index=" + index +
                ", previousHash='" + previousHash + '\'' +
                ", timestamp=" + timestamp +
                ", medicalRecords=" + medicalRecords +
                ", hash='" + hash + '\'' +
                ", nonce=" + nonce +
                '}';
    }
}