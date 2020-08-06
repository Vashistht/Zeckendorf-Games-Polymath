#ifndef Fib_Zeck_hpp
#define Fib_Zeck_hpp
#include <cassert>
#include <vector>
#include <iostream>
#include <stdio.h>


/**
 Returns the N'th Fibonacci number. Runs very slow if N > 45.
 @param N : the index of the Fibonacci number to be returned. Initial conditions F_1 = 1, F_2 = 2
 @return F_N
 */
int NthFib(int N);

/**
Prints all Fibonacci numbers less than N
@param N : all Fibonacci numbers printed are less than this parameter
*/
void AllFibUpTo(int N);

/**
 Returns the greatest Fibonacci number less than or equal to N
 @param N : Integer
 @return : the largest Fibonacci number less than N
 */
int LastFibBefore(int N);

/**
 Returns the Zeckendorf decomposition of an integer, N
 @param N : Integer for which the Zeckendorf decomposition will be printed
 */
void ZeckendorfDecomp(int N);

/**
 Returns Z(n) for all integers n ≤ N
 @param N : greatest integer for which Z(n) is evaluated
 */
void NumOfTerms_ZD(int N);

#endif /* Fib_Zeck_hpp */
