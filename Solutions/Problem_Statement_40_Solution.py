#input: a list of positive integers.
#output: largest number formed out of all permutations possible.

from itertools import permutations
def largest_num(l):
    l1 = []
    for i in permutations(l, len(l)):l1.append("".join(map(str,i)))
    return max(l1)

print(largest_num(list(map(int,input().strip().split(" ")))))
'''
For example:
input: 2 30 34 6 9
output: 9634302
'''