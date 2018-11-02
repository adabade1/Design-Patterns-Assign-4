# CS542: Assignment 4
## Name: Akshata Dabade

-----------------------------------------------------------------------
-----------------------------------------------------------------------

Following are the commands and the instructions to run ANT on the project.
#### Note: build.xml is present in coursesRegistration/src folder.

-----------------------------------------------------------------------
## Instruction to clean:
(When ran from src folder)
####Command: ant -buildfile build.xml clean

Description: It cleans up all the .class files that were generated during compilation.

-----------------------------------------------------------------------
## Instruction to compile:

####Command: ant -buildfile build.xml all

Description: Compiles the code and generates .class files inside the BUILD folder.

-----------------------------------------------------------------------
## Instruction to run:

####Command: 
ant -buildfile build.xml run -Darg0=/home/adabade1/DP/Akshata_Dabade_assign2/csx42-f18-assign-2-adabade1/akshata_dabade_assign_2/studentCoursesBackup/src/input_file.txt -Darg1=/home/adabade1/DP/Akshata_Dabade_assign2/csx42-f18-assign-2-adabade1/akshata_dabade_assign_2/studentCoursesBackup/src/delete_file.txt -Darg2=/home/adabade1/DP/Akshata_Dabade_assign2/csx42-f18-assign-2-adabade1/akshata_dabade_assign_2/studentCoursesBackup/src/output1_file.txt -Darg3=/home/adabade1/DP/Akshata_Dabade_assign2/csx42-f18-assign-2-adabade1/akshata_dabade_assign_2/studentCoursesBackup/src/output2_file.txt -Darg4=/home/adabade1/DP/Akshata_Dabade_assign2/csx42-f18-assign-2-adabade1/akshata_dabade_assign_2/studentCoursesBackup/src/output3_file.txt

Note: Arguments accept the absolute path of the files.


-----------------------------------------------------------------------
## Description: In this assignment Observer pattern is implemented for students with three digit Bnumber and courses that range between A and Z. A Binary Search Tree has been implemented to create a main tree and two backup trees from two input files (input_file.txt and delete_file.txt). The input is read line by line to create tree nodes and to update them as well. At the end, we get three identical output files with final updated Bnumber-Courses pair.
-----------------------------------------------------------------------
### Academic Honesty statement:
-----------------------------------------------------------------------

"I have done this assignment completely on my own. I have not copied
it, nor have I given my solution to anyone else. I understand that if I am involved in plagiarism or cheating an official form will be submitted to the Academic Honesty Committee of the Watson School to determine the action that needs to be taken."

Date: -- Oct' 07 2018 

-----------------------------------------------------------------------

Data structures used in this assignment are mainly Arraylists and Binary Search Tree.

-----------------------------------------------------------------------


