"""
There are three pegs labelled A, B and C. Four disks are placed on peg A. The bottom most disk is
largest, and disk go on decreasing in size with topmost disk being smallest. The objective of the
game is to move the disks from peg A to peg C using peg B as an auxiliary peg.
The rules of the game are:

Only one disc may be moved at a time, and it must be the top disk on one of the pegs.
A larger disk should never be placed on the top of a smaller disk.
Write a program to print out the sequence in which the disk should be moved such that all the disks
on peg A are finally transferred to peg C.
-----------------------------------------------------------------------------------------------
 Tower of Hanoi problem
 A= from/source peg, B= aux peg, C= to/ destination peg
"""
def TOH(n,A,B,C):
    if n>0:
        TOH(n-1, A, C, B)
        print(f"Move disk from {A} to {C}.")
        TOH(n-1,B, A, C)
 
no_of_disks= 4
TOH(no_of_disks,'A','B','C')    

#---------------------------------------------------------------------------------------------
# OUTPUT:
# Move disk from A to B.
# Move disk from A to C.
# Move disk from B to C.
# Move disk from A to B.
# Move disk from C to A.
# Move disk from C to B.
# Move disk from A to B.
# Move disk from A to C.
# Move disk from B to C.
# Move disk from B to A.
# Move disk from C to A.
# Move disk from B to C.
# Move disk from A to B.
# Move disk from A to C.
# Move disk from B to C.
