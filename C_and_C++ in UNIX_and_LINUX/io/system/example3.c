#include <fcntl.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

main()
{
	int fd, sz;

	fd = open("out3", O_RDWR | O_CREAT | O_APPEND, 0644);
	if (fd < 0) { perror("r1"); exit(1); }

	sz = write(fd, "cs3377\n", strlen("cs3377\n"));

	printf("called write(%d, \"cs3377\\n\", %d), which returned %d\n",fd, strlen("cs3377\n"), sz);



	close(fd);
}

