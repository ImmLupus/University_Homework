#include <iostream>
#include <vector>
#include <string>

using namespace std;

bool is_nonTerm(string s){
	if (s.size()==1 && s[0]>=65 && s[0]<=90) return true;
	else return false;
}
bool is_Term(string s){
	if (s.size()==1 && s[0]>=97 && s[0]<=122) return true;
	else return false;
}
bool is_nonTerm(char s){
	if (s>=65 && s<=90) return true;
	else return false;
}
bool is_Term(char s){
	if (s>=97 && s<=122) return true;
	else return false;
}
string toString(char c){
	string S="";
	
}

main(){
	//freopen("input.txt","r",stdin);
	vector<pair<string,string> > G;
	string s;
	pair<string,string> p;
	bool b;
	int right=0,left=0;
	
	
	cout<<"Enter one rule by a space, and then push \'Enter\'"<<endl<<"Enter 0 (zero) to finish typing."<<endl<<endl;
	
	while(cin>>s){
		if (s=="0") s="";
		p.first=s;
		cin>>s;
		if (s=="0") s="";
		p.second=s;
		G.push_back(p);
	}
	cout<<endl<<"-------------------------------"<<endl;
	
	for (int i=0; i<G.size(); i++){
		cout<<G[i].first<<"  ->  "<<G[i].second<<endl;
	}
	
	
	for (int i=0; i<G.size(); i++){		//Проверка на 3 грамматику
		b=false;
		if (is_nonTerm(G[i].first) && is_Term(G[i].second)) {b=true; right++; left++;}
		if (is_nonTerm(G[i].first) && G[i].second.size()==2 && is_Term(G[i].second[0]) && is_nonTerm(G[i].second[1])) {b=true; right++;}
		if (is_nonTerm(G[i].first) && G[i].second.size()==2 && is_nonTerm(G[i].second[0]) && is_Term(G[i].second[1])) {b=true; left++;}
		if (G[i].first.size()==1 && G[i].first=="S") if (b==false) {b=true; left++; right++;}
		if (b==false) {/*cout<<G[i].second<<" ";*/ goto loop1;}
	}
	/*cout<<right<<" "<<left<<" ";*/
	if (right==G.size()) {cout<<"3th Grammar, right-sided"<<endl; return 0;}
	if (left==G.size()) {cout<<"3th Grammar, left-sided"<<endl; return 0;}
	loop1:
	for (int i=0; i<G.size(); i++){		//Проверка на 2 грамматику
		b=false;
		if (is_nonTerm(G[i].first) && G[i].first.size()==1) {b=true;}
		if (b==false) goto loop2;
	}
	cout<<"2th Grammar"<<endl; return 0;
	loop2:
	for (int i=0; i<G.size(); i++){		//Проверка на 1 грамматику
		b=false;
		for (int j=0; j<G[i].first.size(); j++){
			if (is_nonTerm(G[i].first[j])) b=true;
		}
		if (b==false) goto loop4;
	}
	for (int i=0; i<G.size(); i++){
		b=false;
		if (!G[i].second.empty()) b=true;
		if (G[i].first=="S" && G[i].second.empty()) b=true;
		if (b==false) goto loop3;
	}
	cout<<"1th Grammar"<<endl; return 0;
	loop3:
	cout<<"0th Grammar"<<endl; return 0;
	loop4:
	cout<<"not a Grammar"<<endl;
}
