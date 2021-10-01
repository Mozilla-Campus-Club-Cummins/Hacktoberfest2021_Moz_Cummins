""" Problem statement 31: Write a function that takes in a string of one or more words, and returns the
                          same string but with all five or more lettter word reversed. 
                          String passed in will consist of only letters and spaces.Spaces will be included only
                          when more than one word is present. """



string=input("Enter String:")
string=string.split()
for word in string:
    if len(word)>=5:
        word=word[::-1]
        print(word,end=" ")
    else:
        print(word,end=" ")


"""
Output cases:
          
Enter String:Hey fellow friends
Hey wollef sdneirf

Enter String:This is a dog
This is a dog

Enter String:This is another pet
This is rehtona pet 

Enter String:My name is Mahevash Patel
My name is hsavehaM letaP 

 """
