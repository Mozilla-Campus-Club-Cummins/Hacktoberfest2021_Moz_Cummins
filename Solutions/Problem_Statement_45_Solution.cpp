/*Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated sequence
of one or more dictionary words.
Example:
{ i, like, sam, sung, samsung, mobile, ice,
cream, icecream, man, go, mango}

Input: ilike
Output: true
The string can be segmented as "i like".*/

#include <iostream>
using namespace std;
 
int dictionaryContains(string word)
{
    string dictionary[] = {"mobile","samsung","sam","sung",
                            "man","mango","icecream","and",
                             "go","i","like","ice","cream"};
    int size = sizeof(dictionary)/sizeof(dictionary[0]);
    for (int i = 0; i < size; i++)
        if (dictionary[i].compare(word) == 0)
           return true;
    return false;
}
 
// returns true if string can be segmented into space
// separated words, otherwise returns false
bool wordbreak(string str)
{
    int size = str.size();
 
    // Base case
    if (size == 0)  
      return true;
 
    // Traverse till i less than or equal to size of string
    for (int i=1; i<=size; i++)
    {
    
        if (dictionaryContains( str.substr(0, i) ) &&
            wordbreak( str.substr(i, size-i) ))
            return true;
    }
 
   
    return false;
}
 
// Driver program to test above functions
int main()
{
    wordbreak("ilikesamsung")? cout <<"Yes\n": cout << "No\n";
    wordbreak("iiiiii")? cout <<"Yes\n": cout << "No\n";
    wordbreak("")? cout <<"Yes\n": cout << "No\n";
    wordbreak("ilikelikeimangoiii")? cout <<"Yes\n": cout << "No\n";
    wordbreak("samsungandmango")? cout <<"Yes\n": cout << "No\n";
    wordbreak("samsungandmangok")? cout <<"Yes\n": cout << "No\n";
    return 0;
}
