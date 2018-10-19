#include <iostream> 
#include <cmath> 
#include <iomanip> 
using namespace std; 

double const a = 0; 
double const b = 2; 
double const Y0 = 1/M_E; 

double *X,*Yp,*Y,*Ya; 
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
double Analit(){ 
int c = log(Y0); 
for (int i=0; i<=N; i++){ 
Ya[i] = exp(pow(X[i],2)/2+c); 
} 
} 

void fmain(){ 
for (double x=a,i=0; i<=N; i++,x+=abs(b-a)/N) X[(int)i]=x; 

Eiler_p(); 
Eiler(); 
Analit(); 
return; 
} 

main(){ 
bool f=0; 
double D,sr; 
cout<<endl<<"Enter N "; cin>>N; 

X = new double[(int)N+1]; 
Yp = new double[(int)N+1]; 
Y = new double[(int)N+1]; 
Ya = new double[(int)N+1]; 

fmain(); 

cout.precision(6); 
cout<<"|-------------------------------------------------------|"<<endl; 
for (int i=0; i<=N; i++){ 
sr=abs(Y[i]-Ya[i]); 
cout<<"|"<<setw(13)<<X[i]<<"|"<<setw(13)<<Ya[i]<<"|"<<setw(13)<<Y[i]<<"|"<<setw(13)<<sr<<"|"<<endl; 
} 
cout<<"|-------------------------------------------------------|"<<endl; 

cout<<endl<<"Enter D "; cin>>D; 

int k; 
N=1; 
while(true){ 
k=0; 
fmain(); 
for (int i=0; i<=N; i++) if (abs(Y[i]-Ya[i])<D) k++; 
if (k==N+1) break; 
N++; 

delete(X); 
delete(Yp); 
delete(Y); 
delete(Ya); 

X = new double[(int)N+1]; 
Yp = new double[(int)N+1]; 
Y = new double[(int)N+1]; 
Ya = new double[(int)N+1]; 

} 

cout<<"N = "<<N<<endl<<endl; 
}
