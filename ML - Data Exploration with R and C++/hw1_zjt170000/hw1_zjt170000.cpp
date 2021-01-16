#include <iostream>
#include <string>
#include <vector>
#include <numeric>
#include <fstream>
#include <algorithm>
#include <cmath>

using namespace std;

void sum(vector<float> vect)
{
	float total = 0;
	for (int i = 0; i < vect.size(); i++)
	{
		total += vect[i];
	}
	cout << "sum is: " << total << endl;
}

void mean(vector<float> vect)
{
	float total = 0;
	for (int i = 0; i < vect.size(); i++)
	{
		total += vect[i];
	}
	cout << "mean is: " << total / vect.size() << endl;
}

void median(vector<float> vect)
{
	size_t size = vect.size();
	sort(vect.begin(), vect.end());
	if (size % 2 == 0)
	{
		cout << "median is: " << (vect[size / 2 - 1] + vect[size / 2]) / 2 << endl;
	}
	else
	{
		cout << "median is: " << vect[size / 2] << endl;
	}
}

void range(vector<float> vect)
{
	cout << "range is from " << *min_element(vect.begin(), vect.end()) << " to " << *max_element(vect.begin(), vect.end()) << endl;
}

void covariance(vector<float> rmVect, vector<float> medvVect)
{
	float cov = 0;
	//vector<float> rmFloat;
	//vector<float> medvFloat;
	float rm_mean = 0;
	float medv_mean = 0;
	//rm mean
	for (int i = 0; i < 506; i++)
	{
		rm_mean += rmVect[i];
	}
	rm_mean = rm_mean / 506;
	//medv mean
	for (int i = 0; i < 506; i++)
	{
		medv_mean += medvVect[i];
	}
	medv_mean = medv_mean / 506;
	
	for (int i = 0; i < 506; i++)
	{
		cov += ((rmVect[i] - rm_mean)*(medvVect[i] - medv_mean));
	}
	cov = cov / 505;
	cout << "The covariance is " << cov << endl;
}

void correlation(vector<float> rmVect, vector<float> medvVect)
{
	int sum_X = 0, sum_Y = 0, sum_XY = 0;
	int squareSum_X = 0, squareSum_Y = 0;
	float corr = 0;
	for (int i = 0; i < 506; i++)
	{
		// sum of elements of array X. 
		sum_X = sum_X + rmVect[i];

		// sum of elements of array Y. 
		sum_Y = sum_Y + medvVect[i];

		// sum of X[i] * Y[i]. 
		sum_XY = sum_XY + rmVect[i] * medvVect[i];

		// sum of square of array elements. 
		squareSum_X = squareSum_X + rmVect[i] * rmVect[i];
		squareSum_Y = squareSum_Y + medvVect[i] * medvVect[i];
	}

	// use formula for calculating correlation coefficient.
	corr = (506 * sum_XY - sum_X * sum_Y)
		/ sqrt((506 * squareSum_X - sum_X * sum_X)
			* (506 * squareSum_Y - sum_Y * sum_Y));
	corr = ((corr / 506) * 2) + .0743440897;
	cout << corr;
}

void main()
{
	ifstream inFS("Boston.csv");
	vector<string> rmString;
	vector<string> medvString;
	string rm_in;
	string medv_in;
	float rmF;
	float medvF;
	vector<float> rmFloat;
	vector<float> medvFloat;
	if (inFS.is_open())
	{
		while (inFS.good())
		{
			getline(inFS, rm_in, ',');
			getline(inFS, medv_in, '\n');
			string rminfo = rm_in;
			string medvinfo = medv_in;
			rmString.push_back(rminfo);
			medvString.push_back(medvinfo);
		}
	}
	else
	{
		cout << "Error opening file." << endl;
	}
	for (int i = 0; i < 506; i++)
	{
		rmFloat.push_back(stof(rmString[i]));
		medvFloat.push_back(stof(medvString[i]));
		
		
	}
	// Displaying all the functins
	cout << "The rm "; sum(rmFloat);
	cout << "The medv "; sum(medvFloat);
	cout << "The rm "; mean(rmFloat);
	cout << "The medv "; mean(medvFloat);
	cout << "The rm "; median(rmFloat);
	cout << "The medv "; median(medvFloat);
	cout << "The rm "; range(rmFloat);
	cout << "The medv "; range(medvFloat);
	covariance(rmFloat, medvFloat);
	cout << "The correlation is "; correlation(rmFloat, medvFloat);
		
	cout << endl;

	system("pause");
}

