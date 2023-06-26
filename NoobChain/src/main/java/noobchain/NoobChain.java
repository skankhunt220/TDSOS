package noobchain;

import lombok.extern.slf4j.Slf4j;
import noobchain.medical.Block;
import noobchain.medical.MedicalBlockchain;
import noobchain.medical.MedicalRecord;

import java.util.Date;
import java.util.List;

@Slf4j
public class NoobChain {

    public static void main(String[] args) {

        // Create a new blockchain with difficulty level 2
        MedicalBlockchain blockchain = new MedicalBlockchain(5);

        // Create some sample medical records
        MedicalRecord record1 = new MedicalRecord("1", "John Doe", "Fever", new Date(), "Prescribed medication");
        MedicalRecord record2 = new MedicalRecord("2", "Jane Smith", "Headache", new Date(), "Rest advised");
        MedicalRecord record3 = new MedicalRecord("3", "Jane Smith", "Headache v2.0", new Date(), "Rest advised");

        // Create blocks and add the medical records
        Block block1 = new Block(1, null, System.currentTimeMillis(), List.of(record1));
        Block block2 = new Block(2, null, System.currentTimeMillis(), List.of(record2, record3));

        // Add the blocks to the blockchain
        blockchain.addBlock(block1);
        blockchain.addBlock(block2);

        // Validate the blockchain
        boolean isChainValid = blockchain.isChainValid();
        log.info("Is blockchain valid? " + isChainValid);

        // Get the latest block
        Block latestBlock = blockchain.getLatestBlock();
        log.info("Latest block: " + latestBlock);

        // Access the medical records from the latest block
        List<MedicalRecord> medicalRecords = latestBlock.getMedicalRecords();
        for (MedicalRecord record : medicalRecords) {
            log.info("Medical Record: " + record.getRecordId() + " - " + record.getPatientName());
        }

        blockchain.getBlockchain().forEach(b -> log.info(b.toString()));

    }

}
