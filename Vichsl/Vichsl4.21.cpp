#include <iostream>
#include <cmath>
#include <iomanip>
using namespace std;

double const a = 0;
double const b = 2;
double const Y0 = 1/M_E;

double *X,*Yp,*Y;
double N;

double func(double x, double y){return x*y;}

double Eiler_p(){
	Yp[0]=Y0;
	for (int i=1; i<=N; i++){
		Yp[i] = Yp[i-1] + (X[i] - X[i-1]) * func(X[i-1],Yp[i-1]);
	}
}
double Eiler(){
	Y[0]=Y0;
	for (int i=1; i<=N; i++){
		Y[i] = Y[i-1] + (X[i] - X[i-1]) * (func(X[i-1],Y[i-1]) + func(X[i],Yp[i])) / 2;
	}
}

double def_main(){
	double srD=0,sr;
	
	//cout<<endl<<"Enter N "; cin>>N;
	
	X = new double[(int)N+1];
	Yp = new double[(int)N+1];
	Y = new double[(int)N+1];
	
	for (double x=a,i=0; i<=N; i++,x+=abs(b-a)/N) X[(int)i]=x;
	
	Eiler_p();
	Eiler();
	
	cout.precision(6);
	//cout<<"|-----------------------------------------------|"<<endl;
	for (int i=0; i<=N; i++){
		sr=abs(Y[i]-Yp[i]);
		srD+=sr;
		//cout<<"|"<<setw(11)<<X[i]<<"|"<<setw(11)<<Yp[i]<<"|"<<setw(11)<<Y[i]<<"|"<<setw(11)<<sr<<"|"<<endl;
	}
	//cout<<"|-----------------------------------------------|"<<endl;
	return srD/N;
}

main(){
	double D;
	cout<<endl<<"Enter D "; cin>>D;
	N=0;
	do{
		N++;
		def_main();
	}while(def_main()>D);
	cout<<N<<" "<<def_main()<<endl;
}
