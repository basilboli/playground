# Problem : we have two SORTED! arrays of integers. Find intersection


def find_intersection(a, b):
    i, j = 0, 0
    res = []
    while i < len(a) and j < len(b):
        if a[i] > b[j]:
            j = j + 1
        elif a[i] < b[j]:
            i = i + 1
        else:
            res.append(a[i])
            i = i + 1
            j = j + 1
    return res

if __name__ == '__main__':

    a = [1, 2, 3]
    b = [3, 4, 5]    
    assert find_intersection(a, b) == [3]

    a = [1, 2, 3]
    b = [5, 6, 7]    
    assert find_intersection(a, b) == []

    a = [1, 3, 5, 6]
    b = [1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 3]    
    assert find_intersection(a, b) == [1, 3]

    a = []
    b = []    
    assert find_intersection(a, b) == []

    a = [1]
    b = []    
    assert find_intersection(a, b) == []

    a = []
    b = [2]    
    assert find_intersection(a, b) == []

    print "Success!"
