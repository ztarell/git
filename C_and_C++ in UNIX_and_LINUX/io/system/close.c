#include <fcntl.h>
#include <stdio.h>
#include <stdlib.h>
main(){
	int fd1, fd2;

	if(( fd1 = open("foo.txt", O_RDONLY)) < 0){
		perror("foo.txt");
		exit(1);
	}
	if (close(fd1) < 0) {
		perror("foo.txt");
		exit(1);
	}
	printf("closed the fd's\n");
	close(0);
}
