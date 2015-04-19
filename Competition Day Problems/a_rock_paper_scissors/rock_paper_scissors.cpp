#include <iostream>
#include <fstream>
using namespace std;

int main(void)
{
	int p1Count, p2Count, tieCount;
	int testCases;
	int roundSize;
	char ch1, ch2;

	ifstream fin("a.in");

	fin >> testCases;
	for (int i = 0; i < testCases; i++)
	{
		fin >> roundSize;

		p1Count = 0;
		p2Count = 0;
		tieCount = 0;

		for (int j = 0; j < roundSize; j++)
		{
			fin >> ch1 >> ch2;
			if (ch1 == 'R')
			{
				if (ch2 == 'R')
					tieCount++;
				else if (ch2 == 'P')
					p2Count++;
				else //ch2 == 'S'
					p1Count++;

			}
			else if (ch1 == 'P')
			{
				if (ch2 == 'P')
					tieCount++;
				else if (ch2 == 'S')
					p2Count++;
				else //ch2 == 'R'
					p1Count++;

			}
			else //ch1 == 'S'
			{
				if (ch2 == 'S')
					tieCount++;
				else if (ch2 == 'R')
					p2Count++;
				else //ch2 == 'P'
					p1Count++;

			}

		}//end j loop
		//report winner
		if (p1Count > p2Count)
			cout << "Player 1" << endl;
		else if (p2Count > p1Count)
			cout << "Player 2" << endl;
		else
			cout << "TIE" << endl;

	}//end i loop



}

