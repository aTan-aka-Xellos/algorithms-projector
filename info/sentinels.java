static int sentinelLinearSearch(int[] a, int x) {
    int n = a.length;
    int last = a[n - 1];
    a[n-1] = x;
    
    int i = 0;
    while(a[i] != x) {
        ++i;
    }
    
    a[n-1] = last;
    if (i < n - 1 || a[n-1] == x) {
        return i;
    }
    return -1;
}