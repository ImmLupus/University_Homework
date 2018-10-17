#include <iostream>
#include <cmath>
#include <iomanip>

using namespace std;

double N,M,step;
double *X,*Y;

double factorial(double i)
{
  if (i==0) return 1;
  else return i*factorial(i-1);
}

double Func(double x){
	return sqrt(x)-cos(0.1 * x * M_PI / 180);
}

double Delta(int p, int i)
        {
            if (p == 1) return Y[i]-Y[i-1];
            return Delta(p - 1, i) - Delta(p - 1, i - 1);
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

double plnNwt(double x){
	double p,s=0;
	s+=Y[0];
	for (int i=1; i<=N; i++){
		p=1;
		for (int j=0; j<i; j++){
			p*=x-X[j];
		}
		s+=(Delta(i,i)/(factorial(i)*pow(step,i)))*p;
	}
	return s;
}

main(){
	int n;
	cout<<"enter N"<<endl;
	cin>>N;
	n=N;
	X=new double[n+1]; Y=new double[n+1];
	double s;
	
	cout<<endl<<"1:"<<endl;
	for (double x=0,i=0; i<=N; x+=2/N,i++){
		cout<<x<<" ";
		n=i;
		X[n]=x;
	}
	cout<<endl<<endl;
	
	cout<<endl<<"2:"<<endl;
	for (double x=0,i=0; i<=N; x+=2/N,i++){
		cout<<Func(x)<<" ";
		n=i;
		Y[n]=Func(x);
	}
	cout<<endl<<endl;
	
	cout<<Y[0];
	
	step=X[1]-X[0];
	
	cout<<endl<<endl<<"4:";
	cout<<endl<<"enter M"<<endl; cin>>M;
	n=M;
	double Mfp[n+1],Mfl[n+1],Mpl[n+1];
	
	cout<<endl<<endl<<"5:"<<endl;
	cout.precision(6);
	cout<<"|    X    |      F(x)    |     L(x)     |     P(x)     |"<<endl;
	cout<<"|---------|--------------|--------------|--------------|"<<endl;
	for (double x=0,i=0; i<=M; x+=2/M,i++){
		n=i;
		Mfp[n]=abs(Func(x)-plnNwt(x));
		Mfl[n]=abs(Func(x)-plnLgr(x));
		Mpl[n]=abs(plnLgr(x)-plnNwt(x));
		cout<<"|"<<setw(9)<<x<<"|"<<setw(14)<<Func(x)<<"|"<<setw(14)<<plnLgr(x)<<"|"<<setw(14)<<plnNwt(x)<<"|"<<endl;
		cout<<"|---------|--------------|--------------|--------------|"<<endl;
	}
	cout<<endl;
	s=0;
	for (int i=0; i<=M; i++) s+=Mfp[i];
	cout<<"|F(x)-P(x)| = "<<s/(M+1)<<endl;
	s=0;
	for (int i=0; i<=M; i++) s+=Mfl[i];
	cout<<"|F(x)-L(x)| = "<<s/(M+1)<<endl;
	s=0;
	for (int i=0; i<=M; i++) s+=Mpl[i];
	cout<<"|P(x)-L(x)| = "<<s/(M+1)<<endl;
}
