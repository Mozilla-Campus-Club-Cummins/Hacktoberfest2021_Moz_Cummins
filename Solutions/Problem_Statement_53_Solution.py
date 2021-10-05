'''
There's a birthday party in Magicland, and everyone can feel the excitement! There are two towns in Magicland, town A and B, with a population of N people in each. Everyone choses a partner for Salsa dance. Since couple from within the same town is forbidden, you as a match maker need to match people from town A to people from town B. Since people of Magicland are very amicable, most people have no problem dancing with anyone from the other town. However, there are M pairs of people (Ai,Bi) who are incompatible with each other. Find the maximum number of people you can pair up for dance as an event planner!

Input:
First line will contain T, number of testcases. Then the testcases follow.
The first line of each testcase contains two integers N,M.
The next M lines of each testcase contain the incompatible pairs (Ai,Bi).

Output:
For each testcase, output in a single line the maximum number of people you can match.
'''
# Solution by Brute Force

t=int(input())
while t:
    # accept n and m values from user
    n,m=tuple((int(x) for x in input().split()))
    # l contains all the pairs that are incompatible 
    l=[]
    for i in range(m):
         l.append([int(x) for x in input().split()])
         
    # ans counts the number of people that can form a pair     
    ans=0
    for i in range(n):
        for j in range(n):
            if [i+1,j+1] not in l and [j+1,i+1] in l:
                ans=ans+2
            elif [i+1,j+1] not in l and [j+1,i+1] not in l:
                ans=ans+1
    print(ans)
    t=t-1

    '''
    INPUT:
    1
    3 6
    1 1
    2 1
    2 2
    2 3
    3 2
    3 3
    
    Output:
    4
    '''