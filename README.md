# my-blockchain-project
A lightweight blockchain prototype in Java that illustrates how blocks are mined, linked, and verified using SHA-256 encryption.
## Features
- SHA-256 hashing for secure block creation  
- Adjustable mining difficulty (proof-of-work)  
- Blockchain validation to ensure data integrity  
- JSON-formatted chain output using Gson  
## How to Run

### Option 1 – IntelliJ
1. Open the project in IntelliJ  
2. Run `BetaChain.java`  
3. Follow console prompts to select mining difficulty  

### Option 2 – Command Line
```bash
javac -d out src/main/java/blockchain/*.java
java -cp out blockchain.BetaChain
