/* Problem Statement: Write a program to get the following output for the input.
INPUT : 1 2 3 4 5 OUTPUT : 5 1 2 3 4*/



#include <bits/stdc++.h>
using namespace std;


//function to rotate the array to right by 1
void rotate(int arr[], int n) {

	int temp = arr[n - 1];  //storing the value of last element

	for (int i = n - 1; i > 0; i--) {
		arr[i] = arr[i - 1];
	}

	arr[0] = temp;  //assigning the value to first element
}


int main()
{
	//array
	int arr[5] = {1, 2, 3, 4, 5};

	//rotating array
	rotate(arr, 5);
	for (int i = 0; i < 5; i++) {
		cout << arr[i] << " ";
	}

	return 0;
}