package blockchain;
import com.google.gson.*;
import java.util.ArrayList;
import java.util.Scanner;
/*
 Main driver class for the Betachain blockchain demonstration.
 Creates a chain of mined blocks, verifies their validity,
 and prints the final blockchain in JSON format.
 */
public class BetaChain {

    //Difficulty determined by user input and establishes leading zeros hash must start with
    public static int difficulty;
    //Within this program the blockchain is just an ArrayList of Block objects
    public static ArrayList<Block> blockchain = new ArrayList<Block>();


    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Select difficulty for mining operation 1 simple 6+ complex: ");
        difficulty = input.nextInt();

        //Creates and mines first block (Genesis)
        blockchain.add(new Block("First block", "0"));
        System.out.println("Trying to Mine block 1... ");
        blockchain.get(0).mineMethod(difficulty);

        //Create and mine additional blocks, each linked to the previous
        blockchain.add(new Block("Second block",blockchain.get(blockchain.size()-1).hash));
        System.out.println("Trying to Mine block 2... ");
        blockchain.get(1).mineMethod(difficulty);

        blockchain.add(new Block("Third block",blockchain.get(blockchain.size()-1).hash));
        System.out.println("Trying to Mine block 3... ");
        blockchain.get(2).mineMethod(difficulty);

        blockchain.add(new Block("Fourth block",blockchain.get(blockchain.size()-1).hash));
        System.out.println("Trying to Mine block 4... ");
        blockchain.get(3).mineMethod(difficulty);

        //Validates the chain to make sure no data has been changed
        System.out.println("\nBlockchain is Valid: " + isChainValid());

        //Converts the blockchain into a pretty JSON format
        String blockchainJson = new GsonBuilder().setPrettyPrinting().create().toJson(blockchain);
        System.out.println("\nThe block chain: ");
        System.out.println(blockchainJson);

    }


    /*
    Verifies that the blockchain is valid
    Checks each blocks hash, previous hash, and proof of work condition (number of zeros)
    returns true if everything is consistent and mined correctly
    */
    public static Boolean isChainValid() {
        Block currentBlock;
        Block previousBlock;
        String hashTarget = new String(new char[difficulty]).replace('\0', '0');

        for(int i=1; i < blockchain.size(); i++) {
            currentBlock = blockchain.get(i);
            previousBlock = blockchain.get(i-1);

            //recalculate the hash and check integrity
            if(!currentBlock.hash.equals(currentBlock.calculateHash()) ){
                System.out.println("Current Hashes not equal");
                return false;
            }
            //Check that this block's previousHash matches the real has of the previous block
            if(!previousBlock.hash.equals(currentBlock.previousHash) ) {
                System.out.println("Previous Hashes not equal");
                return false;
            }
            //Verifies proof of work
            if(!currentBlock.hash.substring( 0, difficulty).equals(hashTarget)) {
                System.out.println("This block hasn't been mined");
                return false;
            }
        }
        return true;
    }

}