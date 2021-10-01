# Write a function howSum (targetSum, numbers) that takes in a targetSum and an array of numbers of arguments.
# The function should return an array containing any combination of elements that add up to exactly the targetSum.
# If there is no combination that adds up to the targetSum, then return null.
# If there are many combinations then return any single one. A Number in numbers can be repeated any number of times to give the targetSum.

def howSum(targetSum,numbers,htable={}):
    if targetSum in htable:
        return htable[targetSum]
    if targetSum==0:
        return []
    if targetSum<0:
        return None
    
    for num in numbers:
        rem= targetSum-num
        remres= howSum(rem,numbers,htable)
        if (remres !=None):
            newarr=remres.copy()
            newarr.append(num)
            htable[targetSum]=newarr
            return htable[targetSum]
        
    htable[targetSum]=None
    return None
