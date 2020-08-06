#ifndef S2Triangle_hpp
#define S2Triangle_hpp
#include <cassert>
#include <stdio.h>

/**
 Returns the integer value associated with T(i,j)
 @param i : the diagonal row
 @param j : the entry of row i.
 */
int T(int i, int j);                     //works for any i,j as far as I know

/**
Returns n!
@param n : integer
 */
int Fact(int n);                         //this only works for i<=12

/**
 Returns the binomial coefficient binom(i,k)
 @param i : first integer
 @param k : second integer
 */
int binom(int i, int k);                 //this only works for i<=12

/**
 Returns the proposed expression for T(i,2i)
 @param i : diagonal row
 @param j : last entry in row i, i,e. 2i.
 */
int T_i_2i (int i, int j);               //need i+j-2<=12

#endif /* S2Triangle_hpp */
