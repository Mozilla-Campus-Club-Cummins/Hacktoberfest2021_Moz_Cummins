// A bracket is considered to be any one of the following characters: (, ), {, }, [, or ].
// Two brackets are considered to be a matched pair if the opening bracket (i.e., (, [, or {) occurs to the left
// of a closing bracket (i.e., ), ], or }) of the exact same type. There are three types of matched pairs of brackets: [], {}, and ().
// A matching pair of brackets is not balanced if the set of brackets it encloses are not matched. For example,
// {[(])} is not balanced because the contents in between { and } are not balanced. The pair of square brackets
//enclose a single, unbalanced opening bracket, (, and the pair of parentheses encloses a single, unbalanced closing square bracket, ].
#include <iostream>
#include<vector>
#include<stack>
#include<unordered_map>
using namespace std;
bool isbalanced(string s){
    stack<char>st;
    unordered_map<char,char>m={
        {'[',']'},
        {'{','}'},
        {'(',')'}
    };
    for(int i=0;i<s.size();i++){
        if(s[i]=='{' ||s[i]=='('|| s[i]=='['){
            st.push(s[i]);
        }
        else{
            if(st.empty()||m[st.top()]!=s[i]){
                return false;
            }
            else{
                st.pop();
            }
        }
    }
    return st.empty();
}
int main()
{
    int n;
    cin>>n;
    vector<string>v;
    string s;
    for(int i=0;i<n;i++){
        cin>>s;
        v.push_back(s);
    }
    for(int i=0;i<n;i++){
        if(isbalanced(v[i]))
            cout<<"YES"<<endl;
        else{
            cout<<"NO"<<endl;
        }
    }
    return 0;
}