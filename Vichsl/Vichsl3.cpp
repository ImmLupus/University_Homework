#include <iostream>
#include <cmath>

using namespace std;

double const a = 0;
double const b = 1;
double N;

double func(double x){
	//return sqrt(x)-cos(0.1 * x * M_PI / 180);
	return exp(x);
}
double rect(double X[]){
	double I=0;
	for (double i=0; i<N; i++) I+=func(X[(int)i])*(X[(int)i+1]-X[(int)i]);
	return I;
}
double trap(double X[]){
	double I=0;
	for (double i=0; i<N; i++) I+=(func(X[(int)i])+func(X[(int)i+1]))/2*(X[(int)i+1]-X[(int)i]);
	return I;
}
double simps(double X[]){
	double I=0;
	I=(b-a)/6*(func(a)+4*func((a+b)/2)+func(b));
	return I;
}

main(){
	double I0,I1,I2;
	
	cout<<endl<<"Enter N ";
	cin>>N;
	double X[(int)N+1];
	
	for (double x=a,i=0; i<=N; i++,x+=abs(a-b)/N) X[(int)i]=x;
	
	I0=rect(X);	
	I1=trap(X);
	I2=simps(X);
	
	cout<<"I0 = "<<I0<<endl;
	cout<<"I1 = "<<I1<<endl;
	cout<<"I2 = "<<I2<<endl<<endl;
	
	cout<<"| I0-I1 | = "<<abs(I0-I1)<<endl;
	cout<<"| I1-I2 | = "<<abs(I1-I2)<<endl;
	cout<<"| I0-I2 | = "<<abs(I0-I2)<<endl;
	
	return 0;
}
