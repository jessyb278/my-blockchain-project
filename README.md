# BetaChain — Lightweight Blockchain Prototype

A simple blockchain prototype built in Java that demonstrates how blocks are mined, linked, and verified using SHA-256 encryption.  
This project illustrates fundamental blockchain mechanics like proof-of-work, block validation, and JSON-based chain output.

---

## Features

- Creates a linked chain of mined blocks  
- Uses SHA-256 hashing for block validation  
- Adjustable mining difficulty  
- JSON-formatted blockchain output using Gson  
- Demonstrates the logic behind decentralized ledger systems  

---


## How to Run

### Option 1 — IntelliJ IDEA
1. Open the project in IntelliJ IDEA  
2. Run `BetaChain.java`  
3. In the console, enter a difficulty level (1 = simple, 6+ = complex)  
4. Watch the blocks mine and verify in real time  


### Option 2 — Command Line
```bash
javac -d out src/main/java/blockchain/*.java
java -cp out blockchain.BetaChain
```
---

## Project Structure

```bash
src/
├── main/
    └── java/
        └── blockchain/
            ├── BetaChain.java     # Main class – runs the blockchain
            ├── Block.java         # Defines block structure and validation
            └── StringUtil.java    # Provides SHA-256 hashing and utilities


```
---
## Example Output

```
Select difficulty for mining operation 1 simple 6+ complex: 4
Trying to Mine block 1... 
Block Mined!!! : 000084e741583f9dec8c325a19f47448e7ec027ed01e66d91de3a72bfe0a7ce5
Trying to Mine block 2... 
Block Mined!!! : 00002560d2aabc653246ef45562b27e41d2fa60ad1d3e2d6de591e00720e9b99
Trying to Mine block 3... 
Block Mined!!! : 000075e7c9215988c8da73d0f0a501672a94ebe7d2ecca6cbeae799602e1f1ee
Trying to Mine block 4... 
Block Mined!!! : 00006ea277e5b43c04b3d825efadbd7ae2236404a4de55bb9095198339066601

Blockchain is Valid: true

The block chain: 
[
  {
    "hash": "000084e741583f9dec8c325a19f47448e7ec027ed01e66d91de3a72bfe0a7ce5",
    "previousHash": "0",
    "data": "First block",
    "timeStamp": 1760779726776,
    "nonce": 54382
  },
  {
    "hash": "00002560d2aabc653246ef45562b27e41d2fa60ad1d3e2d6de591e00720e9b99",
    "previousHash": "000084e741583f9dec8c325a19f47448e7ec027ed01e66d91de3a72bfe0a7ce5",
    "data": "Second block",
    "timeStamp": 1760779726890,
    "nonce": 87
  },
  {
    "hash": "000075e7c9215988c8da73d0f0a501672a94ebe7d2ecca6cbeae799602e1f1ee",
    "previousHash": "00002560d2aabc653246ef45562b27e41d2fa60ad1d3e2d6de591e00720e9b99",
    "data": "Third block",
    "timeStamp": 1760779726891,
    "nonce": 70950
  },
  {
    "hash": "00006ea277e5b43c04b3d825efadbd7ae2236404a4de55bb9095198339066601",
    "previousHash": "000075e7c9215988c8da73d0f0a501672a94ebe7d2ecca6cbeae799602e1f1ee",
    "data": "Fourth block",
    "timeStamp": 1760779726959,
    "nonce": 54649
  }
]
```
---

## Technologies Used
- Java 17
- Gson (Google)
- SHA-256 Hashing
