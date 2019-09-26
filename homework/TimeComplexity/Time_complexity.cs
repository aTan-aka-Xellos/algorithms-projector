Find the number of times f() is called as a function of the input size n.

// O(logN)
a. for (i = n; i > 1; i /= 2) 
 		f()

// O((N^(1/2))
https://stackoverflow.com/questions/33194931/when-can-an-algorithm-have-square-rootn-time-complexity
b. for (i = 0; i * i < n; i++) 
		f()

// O(256*N)	
c. for (i = 0; i < n; i++)
	  	for (j = 0; j < 256; j++)
		  f()
		

// n=4,  i=1..6  | 1+2+3+4+5+6=21
// n=5,  i=1..15 | count=120
// n=6,  i=1..26 | count=351
// n=10, i=1..90 | 
// N = n^2-10
// N(1+N)/2 => (n^2-10)((n^2-10)+1)/2
// O((n^4-19n^2+90)/2)
d. for (i = 1; i <= n * n - 10; i++) 
		for (j = 1; j <= i; j ++)
			f()


// 2 loops: n=3  1 + 2 + 3 = n(n+1)/2
// k(k+1)/2, k=n(n+1)/2
// n(n+1)/2 * (n(n+1)/2 +1)/2 
// O((n^4+2n^3+3n^2+2n)/8)
e.  for (i = 1; i <= n; i++)
		for (j = 1; j <= i; j++)
			for (k = 1; k <= j; k++) 
				f()


https://stackoverflow.com/questions/2095395/is-logn-%ce%98n-logn
// log(a) + log(b) = log(ab)
// log(1) + log(2) + log(3) + .. log(N-1) + log(N) 
// O(log(n!))
f. for (i = 1; i <= n; i++)
		for (j = 1; j < i; j *= 2)
			f()

// https://brilliant.org/wiki/harmonic-progression/ 
// https://en.wikipedia.org/wiki/Harmonic_progression_(mathematics)
// https://www.geeksforgeeks.org/harmonic-progression-sum/
// i = 1,2,3...N
// inner: N+N/2+N/3+N/4+ ... +N/N 
// O(N*ln2N)
g. for (i = 1; i <= n; i++)
		for (j = 1; j <= n; j += i)
			f()

		

// n=2 2 + 2/2 + 2/2 = 2+2 = 4 
// n=3 3 + 3/2 + 3/2 = 3+1+1 = 5
// n=4 4 + 2/2 + 2/2 = 4+1+1 = 6
// n=5 5 + 2* n=2 = 5 + 2*4 = 13
// n=6 6 + 2*n3 = 6 + 2*5 = 16
// 17 32 33 36 37 44 45 48

// depth: logn
// n calls on each lvl (less in fact due rounding 5/2=2)
// O(nlogn) 
h. void compute(int n)
	  if (n == 0) return;
	  for (int i = 0; i < n; i++) 
	  	  f()
	  compute(n/2) 
	  compute(n/2)
	  
	  
Total:
a. O(logN)
b. O((N^(1/2))
c. O(256*N)
d. O((n^4-19n^2+90)/2)
e. O((n^4+2n^3+3n^2+2n)/8)
f. O(log(n!))
g. O(n*ln2n)
h. O(nlogn) 


	  
	  