import os

def reverse(str):
    res = ""
    i = len(str) - 1
    while i >= 0:
        res = res + str[i]
        i = i - 1
    return res

# odd case : vov
# even case : maam
# long sequence of chars case : maam...

def is_palindrom_naive(str):
    return str == str[::-1]

def is_palindrom(str):
    i, j, mid = 0, len(str) - 1, len(str) / 2
    while str[i] == str[j] and i < mid:
        i = i + 1
        j = j - 1

    if i == j or j < i: # 
        return True

    return False

if __name__ == '__main__':
    while True:
        input = raw_input()
    # print reverse(input)
    # using extended slice syntax
        print input[::-1]
        print is_palindrom(input)
