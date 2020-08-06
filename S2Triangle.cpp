#include "S2Triangle.hpp"


int T(int i, int j){                        //works for any i,j as far as I know
    assert (j<=(2*i));
    if (i == 1 && j == 1) {return 1;}
    if (j == 2) {return i;}
    if (j == 3) {return (i-1)*(i+2)/2;}     //pattern from OEIS
    if (j == 4) {return (i-1)*i*(i+4)/6;}
    if (j == 2*i || j == 2*i - 1) {return T(i,2*i-2);}
    return (T(i-1,j) + T(i,j-1));
}



int Fact(int n){             //this only works for i<=12
    assert(n>=0);
    if(n==0||n==1){return 1;}
    return n*Fact(n-1);
}

int binom(int i, int j){     //this only works for i<=12
    assert(j<=i);
    return (Fact(i))/(Fact(i-j)*Fact(j));
}

int T_i_2i(int i, int j){    //need i+j-2<=12
assert (j==2*i);
return binom(3*i-2,i-1)/i;
}
