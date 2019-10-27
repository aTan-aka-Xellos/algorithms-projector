def divison(a: int, b: int):
    bad = 0
    good = a
    for i in range(60):
        x = (bad + good) / 2
        if x * b >= a:
            good = x
        else:
            bad = x
    return good


In [16]: divison(6, 4)
Out[16]: 1.5

In [17]: divison(6, 1)
Out[17]: 6.0

In [18]: divison(1, 2)
Out[18]: 0.5

In [19]: divison(1, 3)
Out[19]: 0.3333333333333333