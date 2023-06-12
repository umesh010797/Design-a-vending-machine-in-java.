# Design-a-vending-machine-in-java.
Design a vending machine in java.
I design a Vending Machine which
1. Accepts coins of 1,5,10,25 Cents i.e. penny, nickel, dime, and quarter.
2. Allow user to select products Coke(25), Pepsi(35), Soda(45)
3. Allow user to take refund by canceling the request.
4. Return selected product and remaining change if any
5. Allow reset operation for vending machine supplier.

Sample Output:
Welcome to Vending Machine
-------------------------------------
SrNo In_Stock Items Price
-------------------------------------
1 5 Coke 25
2 5 Pepsi 35
3 5 Soda 45
-------------------------------------
Select Item by SrNo:
2
Price: 35
-------------------------------------
SrNo Coin Value
-------------------------------------
1 PENNY 1
2 NICKLE 5
3 DIME 10
4 QUARTER 25
-------------------------------------
Select coins by SrNo separated by (,):
4,3
Collect your Item, Thank you!!!
Enter 'exit' or Press Enter to start again!!!
-------------------------------------
SrNo In_Stock Items Price
-------------------------------------
1 5 Coke 25
2 4 Pepsi 35
3 5 Soda 45
-------------------------------------
Select Item by SrNo:
3
Price: 45
-------------------------------------
SrNo Coin Value

-------------------------------------
1 PENNY 1
2 NICKLE 5
3 DIME 10
4 QUARTER 25
-------------------------------------
Select coins by SrNo separated by (,):
3,3,2
Price not full paid, remaining : 20
Enter 'exit' or Press Enter to try again!!!
-------------------------------------
SrNo In_Stock Items Price
-------------------------------------
1 5 Coke 25
2 4 Pepsi 35
3 5 Soda 45
-------------------------------------
Select Item by SrNo:
1
Price: 25
-------------------------------------
SrNo Coin Value
-------------------------------------
1 PENNY 1
2 NICKLE 5
3 DIME 10
4 QUARTER 25
-------------------------------------
Select coins by SrNo separated by (,):
3,3,3
Change:
NICKLE - 5
Collect your Item and Change, Thank you!!!
Enter 'exit' or Press Enter to start again!!!
exit
