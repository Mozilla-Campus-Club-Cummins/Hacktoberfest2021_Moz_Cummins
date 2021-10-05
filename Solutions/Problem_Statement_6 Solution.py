str1=str(input("Enter an unbalanced bracket sequence:"))
op=0   #number of open brackets
clo=0  #number of closed brackets
#for calculating open and closed brackets
for i in range(0,len(str1)):
    if (str1[i]=="("):
        op=op+1
    if (str1[i]==")"):
        clo=clo+1
if (op==clo):
    x = "(" + str1 + ")"
    stack=[]  #list to add open brackets
    #checinkg if x is balanced or not
    for i in range(0,len(x)):
       if(x[i]=="(") :
          stack.append("(")
       else:
           if(len(stack)!=0):
               stack.remove("(")  #finding open bracket for closed bracket and removing it from stack
    if (len(stack)==0): #checking if all opening brackets have closed brackets
        print("YES")
    else:
        print("NO")
else:
    print("NO")