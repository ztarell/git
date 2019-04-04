/* this program demonstrates the use of signal to trap interrupts 
 * from the terminal.  To suspend the program type ^Z twice
 */ 
#include <signal.h> 
#include <stdio.h> 
 
 void cnt(int sig); void cnt2(int sig); void cnt3 (int sig);

main() 
{ 

      signal(SIGINT, cnt);    
      signal(SIGTSTP, cnt2);    /* SIGTSTP = cntl-Z */

      printf("Begin counting INTERRUPTs and cntl-Z \n"); 

      for(;;);  /* infinite loop */ 

} 
 


void cnt(int sig) 
{ static int count=0;   
      printf("Total of %d INTERRUPTS received\n", ++count); 
      if(count == 5) signal(SIGINT, cnt3);  
	 
} 


void cnt2(int sig) 
{ static int count=0;   
      printf("Total of %d Cntl-Z 's received\n", ++count); 
  
      if(count==1) signal(SIGTSTP, SIG_DFL); 
} 

void cnt3(int sig) 
{ 
  signal(SIGINT, SIG_DFL); 
} 
