plz install jdk1.8

 idlj -fall HelloModule.idl
 javac *.java HelloModule/*.java
 orbd -ORBInitialPort 1050&
java Server -ORBInitialPort 1050 -ORBInitialHost localhost&




New window
java Client -ORBInitialPort 1050 -ORBInitialHost localhost
Enter your name: 
Raje
Hello Raje
it-pr-7@itpr7-HP-EliteDesk-800-G1-SFF:~/Documents/DS Practicals/PR2$ 




