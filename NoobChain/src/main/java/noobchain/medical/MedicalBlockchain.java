package noobchain.medical;

import java.util.ArrayList;
import java.util.List;

public class MedicalBlockchain {

    private final List<Block> blockchain;
    private final int difficulty;

    public MedicalBlockchain(int difficulty) {
        this.blockchain = new ArrayList<>();
        this.difficulty = difficulty;
        // Create the genesis block
        Block genesisBlock = createGenesisBlock();
        blockchain.add(genesisBlock);
    }

    private Block createGenesisBlock() {
        return new Block(0, null, System.currentTimeMillis(), new ArrayList<>());
    }

    public Block getLatestBlock() {
        return blockchain.get(blockchain.size() - 1);
    }

    public void addBlock(Block newBlock) {
        newBlock.setPreviousHash(getLatestBlock().getHash());
        newBlock.mineBlock(difficulty);
        blockchain.add(newBlock);
    }

    public List<Block> getBlockchain()
    {
        return blockchain;
    }

    public boolean isChainValid() {
        for (int i = 1; i < blockchain.size(); i++) {
            Block currentBlock = blockchain.get(i);
            Block previousBlock = blockchain.get(i - 1);

            // Check if the current block's hash is valid
            if (!currentBlock.getHash().equals(currentBlock.calculateHash())) {
                return false;
            }

            // Check if the previous block's hash matches the current block's previous hash
            if (!currentBlock.getPreviousHash().equals(previousBlock.getHash())) {
                return false;
            }
        }
        return true;
    }

    public MedicalRecord findRecordById(String recordId) {
        for (Block block : blockchain) {
            List<MedicalRecord> records = block.getMedicalRecords();
            for (MedicalRecord record : records) {
                if (record.getRecordId().equals(recordId)) {
                    return record;
                }
            }
        }
        return null; // Record not found
    }


}
