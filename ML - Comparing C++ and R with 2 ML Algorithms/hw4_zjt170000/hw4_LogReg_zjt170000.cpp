//Zachary Tarell
//Homework - 4 Logistic Regression C++

#include <iostream>
#include <string>
#include <vector>
#include <fstream>
#include <string>
#include <armadillo>

using namespace std;
using namespace arma;


float sigmoid(float z)
{
return	1 / (1 + exp(-z));

}

int main()
{
	ifstream inputFile("plasma.csv");
	string fibString;
	string ERSString;
	mat DataMatrix(32, 2);
	mat fib(32,1);
	mat esr(32, 1);
	mat labels(32, 1);

	if (inputFile.is_open())
	{
		for (int i =0; i < 32 ; i ++)
		{
			
			//READ LINES IN
			getline(inputFile, fibString, ',');
			getline(inputFile, ERSString, '\n');


			//CONVERT STRING TO FLOATS
			float fib_val = stof(fibString);
			float ESR_val = stof(ERSString);
		

			//Insert values into matrixes
			fib(i, 0) = fib_val;
			esr(i, 0) = ESR_val;

			DataMatrix(i, 0) = 1;
			DataMatrix(i, 1) = fib_val;

			labels(i, 0) = (ESR_val);

		}
	}


	else
	{
		cout << "Error opening file." << endl;
	}


	mat weights(2, 1,fill::ones);

	float learning_rate = 0.001;

	float timerStart = clock();
//LOOP copy as R
	for (int i = 0; i < 500000; i++)
	{
		mat prob_vector = DataMatrix * weights;
		for (int j =0;j<32;j++)
		{
			prob_vector(j) = sigmoid(prob_vector(j));
		}
		mat error = labels - prob_vector;
		weights = weights + learning_rate *DataMatrix.t() * error;
	}
	float timerEnd = clock();
	
	cout << "Weights after looping" << endl;
	weights.print();
	cout << "Run time of loop: " << (timerEnd - timerStart)/CLOCKS_PER_SEC << endl;
}


