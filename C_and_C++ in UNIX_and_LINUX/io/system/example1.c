#include <fcntl.h>
#include <errno.h>
#include <stdio.h>

main(int argc, char** argv) {
	int fd;
	fd = open("foo.txt", O_RDONLY);
	printf("%d\n", fd); 
	if (fd==-1) { 
		fprintf (stderr, "Error Number %d\n", errno);
		perror("Program");
	}
}


