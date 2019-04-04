#include <fcntl.h> 
#include <stdio.h> 
#include <stdlib.h> 
main(int argc, char** argv) { 
	char *c;
	int fd, sz;

	c = (char *) malloc(100 * sizeof(char));

	fd = open("foo.txt", O_RDONLY);
	if (fd < 0) { perror("foo.txt"); exit(1); }

	sz = read(fd, c, 10);
	printf("called read(%d, c, 10), which read %d bytes.\n", fd, sz);
	printf("Those bytes are as follows: %s\n", c);

	close(fd);
}

