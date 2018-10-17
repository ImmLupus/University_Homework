#include <iostream>
#include <vector>
#include <set>
#include <iomanip>
using namespace std;
struct trio{
	string F="",S="",T="";
};
trio make_trio(string F, string S, string T){
	trio t;
	t.F=F; t.S=S; t.T=T;
	return t;
}
main(){
	freopen("input.txt","r",stdin);
	vector<trio> A;
	set<string> S;
	trio t;
	string s1,s2,s;
	while(cin>>s1){
		cin>>s2;
		t.F=s1;
		if (s2.size()==2){
			s="";
			s+=s2[0];
			S.insert(s);
			t.S=s;
			s="";
			s+=s2[1];
			t.T=s;
		}
		else{
			S.insert(s2);
			t.S=s2;
			t.T="N";
		}
		A.push_back(t);
	}
	/*for (int i=0; i<A.size(); i++){
		cout<<A[i].F<<" "<<A[i].S<<" "<<A[i].T<<endl;
	}
	cout<<endl;*/
	for (int i=0; i<A.size()-1; i++){
		for (int j=i+1; j<A.size(); j++){
			if (A[i].F==A[j].F && A[i].S==A[j].S){
				A[i].T+=", "+A[j].T;
				A.erase(A.begin()+j);
				j--;
				continue;
			}
		}
	}
	/*for (int i=0; i<A.size(); i++){
		cout<<A[i].F<<" "<<A[i].S<<" "<<A[i].T<<endl;
	}*/
	
	cout<<"--------|--------|--------|"<<endl;
	cout<<setw(8)<<""<<"|";
	for (auto c: S) cout<<setw(8)<<c<<"|";
	cout<<endl;
	cout<<"--------|--------|--------|"<<endl;
	for (int i=0; i<A.size(); i++){
		cout<<setw(8)<<A[i].F<<"|";
		for (auto c: S) if (c==A[i].S) cout<<setw(8)<<A[i].T<<"|"; else cout<<setw(8)<<(char)15<<"|";
		cout<<endl;
		cout<<"--------|--------|--------|"<<endl;
		
	}
}
