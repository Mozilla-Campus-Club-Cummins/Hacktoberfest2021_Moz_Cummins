"""
Author : Divya Ganesh
01 October 2021
Hacktoberfest Mozilla Campus Club 
Cummins College of Engineering for Women Pune
"""
import re
import numpy as np

#makes all the ones that are part of the same island 0	
def remove_ones(x,y):
	global r 
	global c  
	global grid

	#check that indices x and y exist in grid
	if (x<0 or x>=r or y<0 or y>=c): 
		return	
	if grid[x][y]==0:
		return
	#Marks the cell as 0
	grid[x][y] = 0

	#this function should keep calling itself till the entire island
	#has been traversed and all the ones in it made to 0

	#checking
	#horizontal and vertical
	remove_ones(x+1,y)
	remove_ones(x-1,y)
	remove_ones(x,y+1)
	remove_ones(x,y-1)
	#diagonal
	remove_ones(x+1,y+1)
	remove_ones(x+1,y-1)
	remove_ones(x-1,y+1)
	remove_ones(x-1,y-1)

def iterate():
	count=0
	#this is simple ireator that calls the remove_ones 
	#function for the first time for a particular island 
	for i in range(0,r):
		for j in range(0,c):
			if grid[i][j]==1:
				count+=1
				remove_ones(i,j)
				#print(grid)
				##uncomment above to visialize the islands being removed
	return(count)


#the grid must be entered in the following format {{0,1},{1,0},{1,1},{1,0}}
s=input("grid = ")

#no of rows
r=s.count("{") - 1

#grid is initially a 1D numpy array 
#the regex removes all the characters that are not 0 or 1 
grid=np.array(list(re.sub(r"[^0-1]","",s)), dtype= int)

#reshape the grid
c=(int) (len(grid)/r) #columns
grid = np.reshape(grid, (r,c))

#print(grid)
##uncomment above line to visualize grid

islands = iterate()
print(islands)

#print (sum(sum(grid)))
##if the above statement prints 0, the program has taken 
##all islands into account