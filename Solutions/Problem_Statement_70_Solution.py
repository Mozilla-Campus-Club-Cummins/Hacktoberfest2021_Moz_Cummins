#Write a program to find the missing number from range (10,50) in a given Unsorted Array of integers. If no number is missing return null.
def missing_number(num_list):
        return sum(range(num_list[0],num_list[-1]+1)) - sum(num_list)

li=[10,12,16,13,14,15,17]
li.sort()
temp=missing_number(li)
if(temp!=0):
    print(temp,"is the number missing in the list from",li[0],"to",li[-1])
else:
    print("no number is missing")
