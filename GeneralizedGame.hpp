#ifndef GeneralizedGame_hpp
#define GeneralizedGame_hpp
#include <vector>
#include <stdio.h>

/**
Returns the N'th  number in the nonconstant recurrence a(n+1) = n*a(n) + a(n-1).
@param N : the index of value to be returned. Initial conditions a(1) = 1, a(2) = 2
@return F_N
*/
int NthGen(int N);

/**
Prints all terms in the reccurence less than N
@param N : all numbers of the sequence printed are less than this parameter
*/
void AllGenUpTo(int N);

/**
Returns the greatest term less than or equal to N
@param N : Integer
@return : the largest general sequence term less than or equal to N
*/
int LastGenBefore(int N);

/**
Returns the index of the greatest term less than or equal to N
@param N : Integer
@return : the index of the largest general sequence term less than or equal to N
*/
int IndxLastGenBefore(int N);

/**
Arranges the terms of the gerneral decomposition of N as elements of a vector, for convenience.
@param N : Integer
@return : vector containing all summands in the decomposition of N (including repeated values)
*/
std::vector<int> GeneralizedDecomp(int N);

/**
 Prints the elements of the above vector.
 @param N : The integer to which we find the decomposition of
 */
void printGenDecomp(int N);

/**
 Gives the number of terms in the generalized decomposition, LZ(N).
 @param N : decomposing this
 @return : LZ(N), the number of terms in the decomposition.
 */
size_t LZ(int N);



//------------Playing the Game using Greedy Algorithm--------------

/**
 Number of moves in a greedy algorithm game when playing on the Nth term in the sequence
 @param N : the index of the value being played on
 */
int MovesToGetNthGen(int N);

/**
 Number of moves in a greedy algorithm game when playing on an arbitrary N.
 @param N : playing for the decomposition of this value.
 */
int MovesInGreedyAlgGame(int N);

#endif /* GeneralizedGame_hpp */
