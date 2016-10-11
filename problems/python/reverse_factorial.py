""" 
Problem statement : 
    Given an integer n. output the following sequence: n! , (n-1)! , ... , 1! 
    Space complexity O(1) 
    Time complexity O(n) 
Solution : 
    Find n! fist and then go back backword finding (n-1)!, ..., 1!
"""


def fact(n):
    print "Fact for n: %s" % n
    f = 1
    pos = 1
    while pos <= n:        
        f = f * pos        
        pos = pos + 1
    print f,
    pos = pos - 1
    while pos >= 1:
        f = f / pos
        pos = pos - 1
        print f,

fact(6)
