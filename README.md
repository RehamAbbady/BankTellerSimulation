# BankTellerSimulation

A bank has one drive-in teller (who can serve customers without leaving their
cars). The drive-in teller has a room (i.e., a queue) for one additional customer to
wait. Customers arriving when the drive-in teller queue is full will park their cars
and go inside the bank to transact business. Inside the bank, the waiting area is
sufficient to accommodate all customers, and there is one teller who is as
efficient as the drive-in teller in terms of serving the customers. The timebetween-arrivals and service-time distributions are given below

Time between arrivals(minutes) | probability |	Cumulative probability |	ranges
0                                	0.09	              0.09	              01-09
1                                	0.17	              0.26              	10-26
2                               	0.27              	0.53	              27-53
3                               	0.20	              0.73	              54-73
4                               	0.15	              0.88               	74-88
5	                                0.12	              1.00	              89-00


The problem is to estimate the system measures of performance in terms of the
following:
1- The average service time of the drive-in teller and the inside-bank teller.
2- The average waiting time in the drive-in teller queue and the inside-bank
teller queue.
3- The maximum inside-bank teller queue length.
4- The probability that a customer wait in the inside-bank teller queue.
5- The portion of idle time of the inside-bank teller.
Moreover, the policy maker requires answers for the following questions:
6- Does the theoretical average service time of the service time distribution
match with the experimental one?
7- Does the theoretical average inter-arrival time of the inter-arrival time
distribution match with the experimental one?
8- If the drive-in teller queue can accommodate for two cars instead of one
car, how does this affect the average waiting time in the drive-in teller
queue and the inside-bank teller queue?
