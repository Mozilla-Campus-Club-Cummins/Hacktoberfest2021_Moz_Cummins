'''
Given a wire of length in inches and an array of prices that includes 
prices of all pieces of size smaller than n. Determine the maximum value 
obtainable by cutting up the wire and selling the pieces. For example, 
if the length of the wire is 8 and the values of different pieces are given 
as the following, then the maximum obtainable value is 22 (by cutting in 
two pieces of lengths 2 and 6)
'''

# Solution by Dynamic Programming Method

import sys

INT_MIN = -sys.maxsize

# cuttingWire returns the best obtainable price for a wire of length n and
# price[] as prices of different pieces taken from the user
def cuttingWire(price, n):
    
    # val maintains the maximum price for every prossible length of the wire
	val = [0 for x in range(n+1)]

    # maximum price of wire of length 0 is 0 
	val[0] = 0

	# Build the list val[] in bottom up manner and return
	# the last entry from the table
	for i in range(1, n+1):
		max_val = INT_MIN
		for j in range(i):
			max_val = max(max_val, price[j] + val[i-j-1])
		val[i] = max_val
	return val[n]

# accept prices from user
prices = [int(x) for x in input("Enter Prices: ").split()]
# find size of the input array
size = len(prices)
print("Maximum Obtainable Value is " + str(cuttingWire(prices, size)))


'''
Sample Output:

Enter Prices: 3 5 8 9 10 17 17 20
Maximum Obtainable Value is 24
'''