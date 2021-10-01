/*
Given a string num that contains only digits and an integer target, return all possibilities to add the binary operators '+', '-', or ''
between the digits of num so that the resultant expression evaluates to the target value.
Example :
Input: num = "123", target = 6
Output: ["12*3","1+2+3"]

*/

#include<bits/stdc++.h>
using namespace std;

void dfs(string &num, int start, int target, string path, long prev, long cur, vector<string> &res) {
	if(start == num.size() && prev + cur == target) res.push_back(path);

	for(int i = 1; start + i <= num.size(); i++) {
		string s = num.substr(start, i);
		long n = stoll(s);        // stoll converts string to long long int
		if(to_string(n).size() != s.size()) return;
		if(!start) dfs(num, i, target, s, 0, n, res);
		else {
			dfs(num, start + i, target, path + "+" + s, prev + cur, n, res);
			dfs(num, start + i, target, path + "-" + s, prev + cur, -n, res);
			dfs(num, start + i, target, path + "*" + s, prev, cur * n, res);
		}
	}
}

vector<string> addOperators(string num, int target) {
	vector<string> res;
	dfs(num, 0, target, "", 0, 0, res);
	return res;
}


int main()
{
  string num;
  int target;
  cin>>num;
  cin>>target;
  addOperators(num,target);
  return 0;
}
