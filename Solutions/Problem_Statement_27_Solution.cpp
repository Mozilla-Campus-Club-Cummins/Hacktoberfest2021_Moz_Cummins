/*
In a hospital, there's a waiting room with N chairs set in a single row.
Chairs are consecutively numbered from 1 to N.
The first chair is closest to the door.

For some reason people choose a chair that is:

    1. as far from other people as possible and
    2. as close to the door as possible
    All chairs must be occupied before the first person will be served.
    then Find the last patient's chair's number.

Input - N - integer greater than 2 - number of chairs.
The output should be a positive integer too - the last patient's chair's number.

Example:
Consider if N=10, the seating arrangement will be as following:
Chairs 	    1 	2 	3 	4 	5 	6 	7 	8 	9 	10
Patients 	1 	7 	5 	8 	3 	9 	4 	6 	10 	2

Thus, the last person's chair number is 9.
*/

#include<iostream>
#include<vector>
#include<algorithm>
using namespace std ;

/*
 * Structure of single chair is defined. It has members as: chair no, patient's no who is going to sit on this
 * chair, distance between nearest occupied seat at left and itself, distance between itself and nearest occupied
 * seat at right and total distance(i.e left_distance + right_distance)
 */
struct individual_seat{
	int chair_no ;
	int patient_no ;
	int left_distance ;
	int right_distance ;
	int total_distance ;
};

/*
 * This function sorts the seats first in decreasing order of total distances. If any two seats have
 * total distances as equal, then those 2 seats are sorted in increasing order of the absolute difference between
 * left and right distances. At last, if two seats have the absolute difference equal too, then those are sorted
 * in increasing order of the chair no(smaller value of chair_no is preferred as it is closer to the exit).
 */
bool compareTwoSeates(individual_seat a, individual_seat b)
{
    if (a.total_distance != b.total_distance)
        return a.total_distance > b.total_distance;

    int ab_diff1 = max(a.left_distance-a.right_distance, a.right_distance-a.left_distance);
    int ab_diff2 = max(b.left_distance-b.right_distance, b.right_distance-b.left_distance);
    if (ab_diff1 != ab_diff2)
        return ab_diff1 < ab_diff2;

    return (a.chair_no < b.chair_no);
}

int main(void)
{
	struct individual_seat *waiting_room = NULL ;	//array of individual seats is created to get the waiting room
	struct individual_seat *waiting_room1 = NULL ;
	vector<int> occupied_chairs ;  //Vector to keep track of occupied chairs
	int optimum_chair_index = 0 ;  //stores the index of optimum chair for given patient
	int N = 0 ;
	int i = 0 ;
	unsigned int j = 0 ;
	int start = 0 ;
	int end = 0 ;
	int k = 0 ;
	int l = 0 ;

	cin >> N ;

	//Assign memory to the waiting_room & waiting_room1 array
	waiting_room = new individual_seat[N];
	waiting_room1 = new individual_seat[N];

	//Assigning chair_nos to the individual_chairs in array waiting room
	for(i=0 ; i<N ; ++i)
	{
		waiting_room[i].chair_no = i ;
		waiting_room1[i].chair_no = i ;
	}

	/*
	 * 1st patient will always be at 1st chair as he is only patient & seat1 is closest to exit. left_distance,
	 * right_distance and total_distance are set to -1 to indicate that this seat is already occupied
	 */
	waiting_room[0].patient_no = 1 ;
	waiting_room[0].left_distance = -1 ;
	waiting_room[0].right_distance = -1 ;
	waiting_room[0].total_distance = -1 ;

	/*
	 * 2nd patient will occupy the last chair(i.e N-1 th chair) as last chair is farthest from occupied chair
	 * i.e 1st chair. left_distance, right_distance and total_distance are set to -1 to indicate that this seat is already occupied
	 */
	waiting_room[N-1].patient_no = 2 ;
	waiting_room[N-1].left_distance = -1 ;
	waiting_room[N-1].right_distance = -1 ;
	waiting_room[N-1].total_distance = -1 ;

	//as 1st and last chairs are occupied, those indices are added to the vector occupied_chairs
	occupied_chairs.push_back(0);
	occupied_chairs.push_back(N-1);

	//this loop assigns the seats to the patients from 3 to N
	for(i=3 ; i<=N ; ++i)
	{
		//for each patient
		for(j=0 ; j<occupied_chairs.size()-1 ; ++j)
		{
			//here, pair from vector occupied_chairs is considered. start is 1st and end is next chair in vector
			start = occupied_chairs[j];
			end = occupied_chairs[j+1] ;

			/*
			 * All chairs between start and end are empty. for each chair between start and end, left, right and
			 * total distance if patient is seated there is calculated
			 */
			for(k=start+1; k<end ; ++k)
			{
				waiting_room[k].left_distance = k - start ;
				waiting_room[k].right_distance = end - k ;
				waiting_room[k].total_distance = waiting_room[k].left_distance + waiting_room[k].right_distance ;
			}
		}

		//copying waiting_room array to waiting_room1 array for sorting
		for(l=0; l<N ; ++l)
		{
			waiting_room1[l].chair_no = waiting_room[l].chair_no ;
			waiting_room1[l].patient_no = waiting_room[l].patient_no ;
			waiting_room1[l].left_distance = waiting_room[l].left_distance ;
			waiting_room1[l].right_distance = waiting_room[l].right_distance ;
			waiting_room1[l].total_distance = waiting_room[l].total_distance ;
		}

		//sorting waiting_room1 array by using comparetwoSeates function
		sort(waiting_room1, waiting_room1+N, compareTwoSeates);

		/*
		 * After sorting, the 1st chair is the optimum chair on which if given patient is seated, then that patient
		 * will be as far as possible from rest patients and also as near as possible to the exit Therefore, chair_no
		 * of 0th seat in waiting_room1 will give the optimum index in which the patient can be seated. at this index,
		 * given patient is added & it is pushed in occupied_chairs vector as this is index is now occupied
		 */
		optimum_chair_index = waiting_room1[0].chair_no ;
		waiting_room[optimum_chair_index].patient_no = i ;
		occupied_chairs.push_back(optimum_chair_index);

		//sorting the occupied_chairs vector
		sort(occupied_chairs.begin(), occupied_chairs.end());

		/*
		 * set left_distance, right_distance & total_distance of optimum chair(now occupied) as -1 to indicate that
		 * this chair is occupied
		 */
		waiting_room[optimum_chair_index].left_distance = -1 ;
		waiting_room[optimum_chair_index].right_distance = -1 ;
		waiting_room[optimum_chair_index].total_distance = -1 ;
	}

	cout << "Final seating arrangement is : " << endl << endl ;
	cout << "Chairs :      " ;
	for(l=0 ; l<N ; ++l)
	{
		cout << waiting_room[l].chair_no+1 << "   " ;
	}
	cout << endl ;

	cout << "Patients :    " ;
	for(l=0 ; l<N ; ++l)
	{
		cout << waiting_room[l].patient_no << "   " ;
	}
	cout << endl << endl ;

	//last person's chair number is last value of optimum_chair_index+1
	cout << "Chair number of last patient is : " << optimum_chair_index+1 ;

	//deallocating the memory allocated to the arrays waiting_room & waiting_room1
	delete(waiting_room);
	waiting_room = NULL ;
	delete(waiting_room1);
	waiting_room1 = NULL ;
	return 0 ;
}
