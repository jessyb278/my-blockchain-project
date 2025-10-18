package blockchain;
import javax.xml.crypto.Data;
import java.util.Date;
/*
represents a single block in the blockchain.
Each block has its own stored hash, previous hash, timestamp, data, and nonce
 */
public class Block {
    public String hash;
    public String previousHash;
    private String data;
    private long timeStamp;
    private int nonce;


    //Contains all the data in our individual blocks
    public Block(String data, String previousHash){
        this.data = data;
        this.previousHash = previousHash;
        this.timeStamp = new Date().getTime(); // Current system time in milliseconds
        this.hash = calculateHash();           // Initial hash before mining
    }

    /*
    Combines all fields and returns the SHA-256 hash as a string.
    This identifies the block's contents
     */
    public String calculateHash() {
        String calculatedhash = StringUtil.applySha256(
                previousHash +
                        Long.toString(timeStamp) +
                        Integer.toString(nonce) +
                        data
                );
        return calculatedhash;
    }

    /*
    Proof of work algorithm
    Keeps changing the nonce and recalculating the hash
    until it gets the number of leading zeros equal to the difficulty
     */
    public void mineMethod(int difficulty) {
        String goal = new String(new char[difficulty]).replace('\0', '0');
        while(!hash.substring( 0, difficulty).equals(goal)) {
            nonce ++;                   // Try new hash
            hash = calculateHash();     // Recompute hash with new hash


        }
        System.out.println("Block Mined!!! : " + hash);
    }
}

