#prob:lem statement: Make the below pattern. Here, n =4
#4 4 4 4 4 4 4
#4 3 3 3 3 3 4
#4 3 2 2 2 3 4
#4 3 2 1 2 3 4
#4 3 2 2 2 3 4
#4 3 3 3 3 3 4
#4 4 4 4 4 4 4
n=int(input("enter any number: "))
#n is the number for the outermost lines and val is the value to be printed in row i column j
#for first left quadrant
for i in range(1,n+1):
    for j in range(1,n+1):
        if(i<j):
            val=i
        else:
            val=j
        print(n-val+1, end = "")
#for right top quadrant
    for j in range(n-1,0,-1):
        if(i<j):
            val=i
        else:
            val=j
        print(n-val+1,end="")
    print()
#for bottom left quadrant
for i in range(n-1,0,-1):
    for j in range(1,n+1):
        if(i<j):
            val=i
        else:
            val=j
        print(n-val+1,end="")
#for bottom right quadrant
    for j in range(n-1,0,-1):
        if(i<j):
            val=i
        else:
            val=j
        print(n-val+1,end="")
    print()
