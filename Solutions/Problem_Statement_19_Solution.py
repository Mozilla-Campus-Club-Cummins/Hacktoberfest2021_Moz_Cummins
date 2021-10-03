# -*- coding: utf-8 -*-
"""
Created on Sat Oct  2 12:53:10 2021

@author: disha
"""

"""
Write a general purpose function to display any given number as its roman equivalent. (Eg. 10 = X)
"""
# A dictionary containing necessary numbers along with their Roman equivalent
dict1 = {1:"I",4:"IV",5:"V",9:"IX",10:"X",40:"XL",50:"L",90:"XC",100:"C",400:"CD",500:"D",900:"CM",1000:"M"}

list1 = []
for i in dict1:     #To store the keys of dictionary seperately
    list1.append(i)
list1.reverse()     #To reverse the list

def roman(n):       #Function for conversion
    for i in dict1:  
        if(i==n):   #If entered number is already present in dict1
            print(dict1[i])
            break
        
        else:       #If the entered number does not belong to dict1
            for i in list1: 
                if(n//i>0):     #To divide the number and get a non-zero quotient
                    for j in range(n//i):   
                        print(dict1[i],end="")  #To print the divided number's roman equivalent
                n %= i      #To generate a remainder for the next iteration

n = int(input("Enter a number "))   #To take integer input from user
roman(n)    #Function call