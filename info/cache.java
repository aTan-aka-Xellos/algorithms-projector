int[] a = new int[64 * 1024 * 1024];

// Loop 1
for (int i = 0; i < arr.Length; i++) { 
	a[i] *= 3; 
}

// Loop 2
for (int i = 0; i < arr.Length; i += 16) { 
	a[i] *= 3;
}

// Loop 2 does ~ 6% of the work of the first loop
// but times are roughly equal. why? cache!