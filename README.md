# Splitwise
Splitwise is an app that allows users to split expenses with friends. If there are multiple transactions in the group and the group needs to share the cost bills, Splitwise ensures that anyone who pays is reimbursed the correct amount and with a minimal number of transactions


Algorithm :

1. Find for each person their total paid and total hadToPay amounts.
2. For each person find the total outstanding amounts
3. Create 2 heaps -
A. Min heap -> all negative balance [ debit / has to pay amounts ]
B. Max heap -> all positive balance [ credit / will get paid amounts ]
4. Get the minimum from the min heap and maximum from the max heap and do a transaction to settle the amount
5. After the transaction, whoever has the outstanding balance as 0 doesn’t add them back to the heap, add the other person’s updated balance back in their respective heap. If both become zero, don’t add either of them.
6. Keep doing this until both the heaps are empty.
7. Keep track of all the transactions being done. 
