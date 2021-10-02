# -*- coding: utf-8 -*-
"""
Created on Fri Oct  1 12:09:58 2021

@author: disha
"""

"""
Take input of any word from the user and write a program to find out the number
of the permutations of letters of that word. 
"""
def factorial(n):   #Function to calculate factorial of a number
    if n <= 1:
        return 1
    else:
        return n * factorial(n-1)   #Recursion

x = str(input("Enter any word: "))  #To take string input from user
x = x.upper()   #To convert all letters to uppercase

list1=[]    #To add characters of string into a list
for char in x:
    list1.append(char)  
    
my_dict = {i:list1.count(i) for i in list1} #To count occurance of each character present in the word

list2=[]    #To store the factorial of each occurance
for i in my_dict.values():
    list2.append(factorial(i))

mul=1
for i in list2:     #To multiply the factorials stored in list2
    mul *= i

print(factorial(len(x))//mul)   #Prints the number of permutations
