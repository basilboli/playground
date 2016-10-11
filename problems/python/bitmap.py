""" 
Given an integer n. output the following sequence: n! , (n-1)! , ... , 1! 
Space complexity O(1) 
Time complexity O(n) 

Solution : 

1. save i! step result using bitmaps 
2. iterate over all the bits and print position i where bit(i) = 1

complexity : O(n) + O(m) 
where m number of bits in n!

"""

def fact(n): 
    print "Fact for n: %s" %n
    bitmap = 0 # result 
    pos = 1
    i = 1
    while (i <= n):
        # calculate n step factorial number
        pos = i * pos 
        # persist it as value bit pos
        bitmap = setbit(bitmap, pos, 1) 
        i = i + 1        
    print "result bitmap %s:" % bin(bitmap)    
    
    pos = bitlen(bitmap)    
    print "Bitmap length : %s" %pos
    while pos >= 0:
        if isset(bitmap, pos):
            print pos,
        pos-=1                

def setbit(i, offset, value): 
    """ sets the value of a bit to 0 or 1 at the specified offset for a given key """
    return i | (value << offset)

def isset(i, offset):
    return (i & (1 << offset))!=0

def bitlen(i):
    length = 0
    while i:
        i >>= 1
        # print i
        length += 1
    return length    

fact(6)