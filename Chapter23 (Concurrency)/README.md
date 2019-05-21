# Concurrency
### Executor Service:
Outputs:
```java
Starting Executor
task1 going to sleep for 764 millisec.
Task started, main ends.

task3 going to sleep for 1394 millisec.
task2 going to sleep for 2359 millisec.
task1 done sleeping
task3 done sleeping
task2 done sleeping
```

---

### Shared Array:
Outputs:
```java
pool-1-thread-1 write  1 to element 0.
Next write index: 1
pool-1-thread-1 write  2 to element 1.
Next write index: 2
pool-1-thread-1 write  3 to element 2.
Next write index: 3
pool-1-thread-2 write 11 to element 3.
Next write index: 4
pool-1-thread-2 write 12 to element 4.
Next write index: 5
pool-1-thread-2 write 13 to element 5.
Next write index: 6

Contents of SimpleArray:
[1, 2, 3, 11, 12, 13]
```

---

### Shared Buffer:
Outputs:
```java
Action		Value	Sum of Produced	Sum of Consumed
------		-----	---------------	---------------

Producer writes	 1	 1
Consumer reads	 1			 1
Consumer reads	 1			 2
Producer writes	 2	 3
Consumer reads	 2			 4
Consumer reads	 2			 6
Producer writes	 3	 6
Producer writes	 4	10
Consumer reads	 4			10
Consumer reads	 4			14
Producer writes	 5	15
Producer writes	 6	21
Producer writes	 7	28
Consumer reads	 7			21
Producer writes	 8	36
Consumer reads	 8			29
Producer writes	 9	45
Consumer reads	 9			38
Producer writes	10	55
Producer done producing
Terminating Producer
Consumer reads	10			48

Consumer read values totaling 48
Terminating Consumer
```

---