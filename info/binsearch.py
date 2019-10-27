def binsearch(a, x):
    n = len(a)
    bad = -1  # a[bad] < x
    good = n  # a[good] >= x
    while bad + 1 < good:
        m = (bad + good) // 2
        # bad < m < good
        if a[m] >= x:
            good = m
        else:
            bad = m
    # now a[good] >= x
    return good < n and a[good] == x, good

a = [2, 3, 5, 5, 5, 6, 10]
a.sort()
print(a)
for i in range(1, 12):  # [1, 12) == [1, 11]
    print(i, binsearch(a, i))