/*
Problem Statement: Given two arrays of integers, find a pair of values (one value from each array) that you can swap to give the two arrays the same sum.
Return null if no such set of integers exist.*/

/*Logic:
Given condition: sum_a - a + b = sum_b - b + a
Solving further: sum_a - a + b = sum_b - b + a
                 2a - 2b  = sum_a - sum_b
                 a - b  = (sum_a - sum_b) / 2
                 assume temp = (sum_a - sum_b) / 2
                 if temp%2==1 then no such set of integers exit*/



#include <bits/stdc++.h>
using namespace std;
#define endl "\n"


//function to find sum of elements of array
int sumOfArr(int arr[], int n)
{
	int sum = 0;
	for (int i = 0; i < n; i++)
		sum += arr[i];
	return sum;
}

// function to find tmep = (sum_a - sum_b) / 2
int findTemp(int a[], int b[], int n1, int n2) {

	// calculating sum_a, sum_b
	int sum1 = sumOfArr(a, n1);  // sum of elements of array a
	int sum2 = sumOfArr(b, n2);  // sum of elements of array b

	// from derived expression temp must be even or divisible by 2
	if ((sum1 - sum2) % 2 != 0)
		return 0;
	return ((sum1 - sum2) / 2);
}

// function to find values
void swapValues(int a[], int b[], int n1, int n2) {

	// find temp
	int temp = findTemp(a, b, n1, n2);

	if (temp == 0) return;


	int val_a, val_b; // pair of values

	// given condition sum_a - val_a + val_b = sum_b - val_b + val_a
	for (int i = 0; i < n1; i++) {
		for (int j = 0; j < n2; j++) {
			if (a[i] - b[j] == temp) {
				val_a = a[i];
				val_b = b[j];
			}
		}
	}

	cout << val_a << " " << val_b << endl;
}

int main()
{
	int n1, n2;
	cin >> n1 >> n2;
	int arr1[n1], arr2[n2];
	for (int i = 0; i < n1; i++) {
		cin >> arr1[i];
	}
	for (int j = 0; j < n2; j++) {
		cin >> arr2[j];
	}
	swapValues(arr1, arr2, n1, n2);
	return 0;
}