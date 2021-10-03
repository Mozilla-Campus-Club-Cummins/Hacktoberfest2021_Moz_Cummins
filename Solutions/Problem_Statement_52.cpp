#include<bits/stdc++.h>

using namespace std;

int main()
{
    vector<int> v;
    int a;
    for(int i=0; i<10; i++)
    {
        cin>>a;
        if((a&1) == 0)
        {
            v.push_back(a);
        }
    }

    for(auto i=0; i<(v.size()); i++)
    {
        cout<<v[i]<<" ";
    }
}
