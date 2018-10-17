#include <iostream>
#include <cmath>
#include <iomanip>

using namespace std;

double N,M;

double Func(double x){
	return sqrt(x)-cos(0.1 * x * M_PI / 180);
}

double plnLgr(double a){
	
	double p,s=0;
	
	for (double x=0,i=0; i<=N; x+=2/N,i++){
		p=1;
		for (double y=0,j=0; j<=N; y+=2/N,j++) if (i!=j){
			p*=(a-y)/(x-y);
		}
		s+=Func(x)*p;
	}
	return s;
}

main(){
	double a;
	
	cout<<"enter N"<<endl;
	cin>>N;
	
	cout<<endl<<"1:"<<endl;
	for (double x=0,i=0; i<=N; x+=2/N,i++) cout<<x<<" ";
	cout<<endl<<endl;
	
	cout<<endl<<"2:"<<endl;
	for (double x=0,i=0; i<=N; x+=2/N,i++) cout<<Func(x)<<" ";
	cout<<endl<<endl;
	
	/*cout<<"3:";
	cout<<"enter x"<<endl; cin>>a; cout<<plnLgr(a);*/
	
	cout<<endl<<endl<<"4:";
	cout<<endl<<"enter M"<<endl; cin>>M;
	for (double x=0,i=0; i<=M; x+=2/M,i++) cout<<x<<" ";
	
	cout<<endl<<endl<<"5:"<<endl;
	cout.precision(6);
	for (double x=0,i=0; i<=M; x+=2/M,i++){
		cout<<setw(5)<<x<<setw(15)<<Func(x)<<setw(15)<<plnLgr(x)<<endl<<endl;
	}
	
}
