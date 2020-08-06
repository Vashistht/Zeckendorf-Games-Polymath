#include "GeneralizedGame.hpp"
#include <iostream>
#include <vector>
#include <set>

using namespace std;

int NthGen(int N){
    if (N == 1) {return 1;}
    if (N == 2) {return 2;}
    return ((N-1)*NthGen(N-1) + NthGen(N-2));
}

void AllGenUpTo(int N){
    for (int i = 1; NthGen(i) <= N; ++i){
        cout << NthGen(i) << ' ';
    }
    cout << endl;
}

int LastGenBefore(int N){
    vector<int> G;
    for (int i = 0; NthGen(i + 1) <= N; ++i) {
        G.push_back(NthGen(i + 1));
    }
    return G[G.size()-1];
}

int IndxLastGenBefore(int N){
    vector<int> G;
    for (int i = 0; NthGen(i + 1) <= N; ++i) {
        G.push_back(NthGen(i + 1));
    }
    return static_cast<int>(G.size());
}


vector<int> GeneralizedDecomp(int N){
    vector<int> Decomp;
    while (N >= 1) {
        int G = LastGenBefore(N);
        Decomp.push_back(G);
        N -= G;
    }
    return Decomp;
}

void printGenDecomp(int N){
    vector<int> D = GeneralizedDecomp(N);
    for (int i = 0; i < D.size(); ++i){cout << D[i] << ' ';}
    cout << endl;
}

size_t LZ(int N){
    vector<int> D = GeneralizedDecomp(N);
    return D.size();
}

int MovesToGetNthGen(int N){
    if (N==NthGen(1)){ return 0;}
    if (N==NthGen(2)){ return 1;}
    return (N-1)*MovesToGetNthGen(N-1)+MovesToGetNthGen(N-2)+1;
}

int MovesInGreedyAlgGame(int N){
    assert (N >= 0);
    int moves = 0;
    vector<int> D = GeneralizedDecomp(N);
    vector<int> I (D.size(), 0);
    for (int i = 0; i < D.size(); ++i){
        I[i] = IndxLastGenBefore(D[i]);
    }
    for (int i = 0; i < D.size(); ++i){
        moves += MovesToGetNthGen(I[i]);
    }

    return moves;
}
