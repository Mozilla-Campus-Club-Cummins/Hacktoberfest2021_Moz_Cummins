# A perfect number is a positive integer that is equal to the sum of its proper
# positive divisor (excluding itself) Check whether the given integer is perfect or not.

def checkPerfect(no):
    # Since there are no odd perfect numbers
    if no%2!=0:
        print(no,"is not a perfect number")
    # If the number is even
    else:
        sum=1
        fact=no
        i=2
        while i<fact:
            if no%i==0:
                # if i is a factor then no/i will also be a factor
                fact=no//i
                sum=sum+i+fact
            i=i+1
        # If number is equal to sum then it is a perfect number
        if no==sum:
            print(no,"is a perfect number")
        else:
            print(no,"is not a perfect number")

num=input("Enter any number: ")
# If user enters invalid input
try:
    no=int(num)
    checkPerfect(no)
except ValueError:
    print("Please enter a valid number")
