#include <iostream>
#include <fstream>
using namespace std;

int main(void)
{
	ifstream fin("g.in");
	int t,n, score1, score2;
	char player1, player2;
	fin >> t;
	while (t--)
	{
		fin >> n;
		score1 = score2 = 0;
		while (n--)
		{
			fin >> player1 >> player2;
			switch(player1)
			{
				case 'R': switch(player2)
				{
					case 'P': score2++; break;
					case 'S': score1++; break;
				}; break;
				case 'P': switch(player2)
				{
					case 'S': score2++; break;
					case 'R': score1++; break;
				}; break;
				case 'S': switch(player2)
				{
					case 'R': score2++; break;
					case 'P': score1++; break;
				}; break;
			}
		}
		if (score1 > score2) cout << "Player 1" << endl;
		else if (score2 > score1) cout << "Player 2" << endl;
		else cout << "TIE" << endl;
	}
	return 0;
}
