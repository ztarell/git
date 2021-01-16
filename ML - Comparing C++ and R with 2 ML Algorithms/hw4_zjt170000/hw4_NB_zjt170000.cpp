//Zachary Tarell
//Homework - 4 Naive Bayes

#include <iostream>
#include <string>
#include <vector>
#include <fstream>
#include <string>
#include <armadillo>

using namespace std;
using namespace arma;

int main()
{
	ifstream inputFile("titanic_project.csv");

	string pClassString;
	string survivedString;
	string sexString;
	string ageString;

	//Setting up Train & Test
	mat train(900, 4);
	mat test(146, 4);

	if (inputFile.is_open())
	{
		for (int i = 0; i < 900; i++)
		{

				//READ LINES IN
				getline(inputFile, pClassString, ',');
				getline(inputFile, survivedString, ',');
				getline(inputFile, sexString, ',');
				getline(inputFile, ageString, '\n');

				//CONVERT STRING TO FLOATS
				float pclass_val = stof(pClassString);
				float survived_val = stof(survivedString);
				float sex_val = stof(sexString);
				float age_val = stof(ageString);


				//Insert values into TRAIN
				train(i, 0) = pclass_val;
				train(i, 1) = survived_val;
				train(i, 2) = sex_val;
				train(i, 3) = age_val;




		}

		for (int i = 0; i < 146; i++)
		{
			//READ LINES IN
			getline(inputFile, pClassString, ',');
			getline(inputFile, survivedString, ',');
			getline(inputFile, sexString, ',');
			getline(inputFile, ageString, '\n');

			//CONVERT STRING TO FLOATS
			float pclass_val = stof(pClassString);
			float survived_val = stof(survivedString);
			float sex_val = stof(sexString);
			float age_val = stof(ageString);

			//Insert values into TEST
			test(i, 0) = pclass_val;
			test(i, 1) = survived_val;
			test(i, 2) = sex_val;
			test(i, 3) = age_val;

		}


	}


	else
	{
		cout << "Error opening file." << endl;
	}


	float survived1 = 0;
	float survived0 = 0;
	for (int i = 0; i < 900; i++)
	{
		if (train(i, 1) == 1)
		{
			survived1++;
		}
		else
		{
			survived0++;
		}
	
	}

//likelihood for pclass
	mat lh_pclass(2, 3);


//likelihood for sex
	mat lh_sex(2, 2);
//likelihood for age
	mat age_mean(1, 2,fill::zeros);
	mat age_var(1, 2, fill::zeros);
	age_mean;




	//TEST PRINT DATA
	cout << "Train data:" << endl;
	train.print();
	cout << "NUMBER OF ROWS train: " << train.n_rows << endl;

	cout << "Test data:" << endl;
	test.print();
	cout << "NUMBER OF ROWS test: " << test.n_rows << endl;



	cout << "Numver of survived1 is: " << survived1 << "     Number of survived0 is: " << survived0 << endl;
	
	float apriori1 = survived1 / 900;
	float apriori0 = survived0 / 900;

	mat apriori(1, 2);
	apriori(0, 0) = apriori0;
	apriori(0, 1) = apriori1;

	apriori.print();
	age_mean.print();
}

