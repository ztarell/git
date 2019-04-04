******** NetBeans IDE 8.2 ************

By: Zachary Tarell
zjt170000
SE-3345.003
Spring 2019

Project 3 - Lazy Deletion Binary Search Tree

This project uses NetBeans IDE, an input file named "input.txt" and creates an output file named "output.txt" (samples below). It has a main class is named "LazyBST_Main" and supporting class named "LazyBinarySearchTree".

Sample run:

"input.txt"
Insert:98
Insert:67
Insert:55
Insert:45
PrintTree
Delete:84
Delete:45
Contains:45
FindMin
FindMax
PrintTree
Height
Size
Insert:84
Insert:32
Insert:132
PrintTree
Insert:980
Insert
hih

"output.txt"
True
True
True
True
98 67 55 45 
False
True
False
45
98
98 67 55 *45 
3
4
True
True
Error in insert: IllegalArgumentException raised
98 67 55 *45 84 
Error in insert: IllegalArgumentException raised
Error in Line: Insert
Error in Line: hih