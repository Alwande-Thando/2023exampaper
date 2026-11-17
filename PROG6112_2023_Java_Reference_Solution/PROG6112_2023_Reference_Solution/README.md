# PROG6112 Programming 1B — 2023 Reference Solution

This project set is based on the 2023 take-home examination paper about estate-agent property sales and commission.

## Projects
- `Question1_EstateAgentSales`: two-dimensional monthly sales array for Joe Bloggs and Jane Doe, total sales, 2% commission, top-performing agent, interface/class and three JUnit tests.
- `Question2_EstateAgentGUI`: Swing GUI for location, agent name, property price and commission percentage; process, clear, save report, validation, interface/class and three JUnit tests.

## Open and run
Each question is a separate Maven project. Open its folder (the one containing `pom.xml`) in NetBeans or IntelliJ. Use JDK 17+:
```bash
mvn test
mvn package
```
Run Question 2:
```bash
mvn exec:java
```
The GUI saves `report.txt` in the working directory when Save Report is selected.

## Paper-specific details
- Locations: Cape Town, Durban, Pretoria.
- Q1 monthly values and 2% commission are taken from the paper.
- Q2 commission is property price multiplied by the entered commission percentage.
- Validation rejects blank location/name and property price or commission percentage less than or equal to zero.
- The paper's interface method signatures are retained.

This is a worked reference solution. Review and understand the code, run it in your IDE, and follow your lecturer's instructions on independent work and disclosure of AI assistance.
