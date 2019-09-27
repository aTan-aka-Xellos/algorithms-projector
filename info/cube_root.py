# to understand see how float point numbers stored
# 60  for 64 bit numbers, but for 32-bit numbers 23 is enough

def cube_root(n: int):
    bad = 0
    good = n
    for i in range(60):
        m = (bad+good)/2
        if m*m*m >= n:
            good = m
        else:
            bad = m
    return good
	
	
# Окончание, когда границы отрезка — два соседних по представлению значения в типе данных.
# Утверждается, что два числа — соседние, если середина их отрезка совпадает или с левой, или с правой границей.
​
def cube_root(n: int):
    bad = 0
    good = n
	m = (bad+good)/2
    while bad!=m and good!=m:
        if m*m*m >= n:
            good = m
        else:
            bad = m
		m = (good+bad)/2
    return good