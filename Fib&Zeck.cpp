#include "Fib&Zeck.hpp"
using namespace std;

int NthFib           (int N){
    assert(N<=45);                          //very slow if N > 45
    if (N == 1) {return 1;}
    if (N == 2) {return 2;}
    return (NthFib(N-1) + NthFib(N-2));
}

void AllFibUpTo      (int N){
    for (int i = 1; NthFib(i) <= N; ++i){
        cout << NthFib(i) << ' ';
    }
    cout << endl;
}

int LastFibBefore    (int N){
    vector<int> V;
    for (int i = 0; NthFib(i + 1) <= N; ++i) {
        V.push_back(NthFib(i + 1));
    }
    return V[V.size()-1];
}

void ZeckendorfDecomp(int N){
    while (N >= 1) {
        int F = LastFibBefore(N);
        cout << F << ' ';
        N -= F;
    }
    cout << endl;
}

void NumOfTerms_ZD   (int N){
    for (int i = 1; i <= N; ++i){
        vector<int> Terms;
        for (int j = i; j >= 1;) {
            int F = LastFibBefore(j);
            Terms.push_back(F);
            j -= F;
        }
        cout << i << ": " << Terms.size() << "......";
        cout << "n - Z(n) is ";
        if ((i - Terms.size())%2 == 0) {cout << "E";}
        else{cout << "O";}
        cout << endl;

    }
}
