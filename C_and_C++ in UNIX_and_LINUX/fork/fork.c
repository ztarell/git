#include <stdio.h>
#include <stdlib.h>
#include <sys/types.h>  

int main()
{ 
	pid_t pid;
	int x = 1;

	pid = fork();
	if (pid == 0) {
		printf("child lol: x = %d\n", --x);
		exit(0);
	} else {
		printf("parent: x = %d\n", ++x);
		exit(0);
	}
}

