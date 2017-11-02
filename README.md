# Introduction
The application is written for Operating Systems module in year 3 of Software Development(2017) course at Galway Mayo Institute of Technology, Galway Campus.
The program is an implememtation of the following Proccess Scheduling Algorithms:
* First Come First Serve - FCFS
* Sortest Job First - SJF
* Round Robin - RR
# How to run
The application should be run in a command line/terminal.
## 1.Build jar file
To build the jar file, use this command:
```
jar -cf op.jar
```
## 2.Run the application
To run the application use this command:
```
java -cp ./op.jar ie.gmit.op.Runner 
```
# The app
## How it works
When the application opened, it promts the user to enter the number of the procesess to be scheduled. If the input is not a number or it is less than 1, the user is promted to enter the number again. Otherwise the application promts the user to enter each processes name and burst time. The burst time has input validation so it has to be a number higher than 0.
Once the application receives every details of the processes, the user is promted to enter the number of the Process Scheduling Algorithm:
* 1 - FCFS

Processes are iterated through in the order as the user provided them. Each process is taken into a process state holder and passed to the UI to be presented on the screen.
* 2 - SJF

The processes are sorted in ascending order based on their burst time. The sorted processes iterated through and taken into a process state holder and presented on the screen.
* 3 - RR

The user is promted to ask for the Quantum, which is validated so it has to be a number higher than 0. The processes kept in the same order as the user provided them. The algorithm slices up each process by the size of the quantum and rotates them around.
      After each quantum slice, or when the process is finished, the process is taken into a process state holder and presented on the screen.
* 4 - Exit

The application exits.
## Example run
 ```
 Enter Number of processes:
3
Enter name for process 1:
1
Enter burst time for process 1:
10
Enter name for process 2:
2
Enter burst time for process 2:
7
Enter name for process 3:
3
Enter burst time for process 3:
10
Press 1 Round Robin
Press 2 FCFS
Press 3 SJF
Press 4 to exit
1
Enter the quantum for Round Robin:
5
Process name      Start time      Remaining time      Wait Time

      1               0                 5                 0

      2               5                 2                 5

      3              10                 5                10

      1              15                 0                10

      2              20                 0                15

      3              22                 0                17
Avarage Wait Time is:14.0
 ``` 
## Structure basics
The application is written in Object Oriented way.
* Each process is stored in a Process object
* Proccess Scheduling Algorithms implements a Calculator interface, which provides the commonality between the algorithms.
* FCFS and SJF extends NonPreemtiveCalculator abstract class which implements most of the Calculator interface to avoid code duplication for FCFS and SJF.(They are nearly the same)
* Each algorithm implements iteration, which means, between each context change the algorithm can be stopped.
* The state of a current context is stored in CurrentStateContainer 
# Platform dependency
The application was developed and tested on Windows 7. It has not been tested on any other operating systems and platforms therefore it cannot be guaranteed to run on any other operating systems or platforms.