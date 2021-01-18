Zachary Tarell - zjt170000
Homework 1: Search Algorithms
CS 4365.501 Artificial Intelligence
------------------------------------------
Overview and Rules of Program:

The 8-puzzle problem is played on a 3-by-3 grid with 8 square tiles labeled 1 through 8 and a blank tile. Your goal is to rearrange the blocks so that they are in order. You are permitted to slide blocks horizontally or vertically into the blank tile.

This program solves the 8-puzzle problem using each of the following algorithms:

1. Breadth- First search
2. Iterative deepening search
3. A* search using two different suitable heuristics

It implements all the algorithms and does not use any implementation provided by another library or package. It reads the initial board configuration from the standard input and prints to the standard output a sequence of board positions that solves the puzzle (only the path to goal from start), the total number of moves and the total number of search states enqueued. For each of the above algorithms, it expands the search only until depth 10, root being at depth 0. If goal state is not reached before or at depth 10, it returns a failure message.
------------------------------------------
1. How to Run:
	
	python homework1.py [algorithm_name] [space_separated_input]
	Acceptable Algorithm Names: bfs, ids, astar1, astar2
	Acceptable Input Values:  "* 1 3 4 2 5 7 8 6"
	Note: * represents empty tile

	This will run breadth-first-search algorithm with the board initial state as: [* 1 3][4 2 5][7 8 6]
------------------------------------------
2. Sample Run*** 

Input:
	python homework1.py ids "* 1 3 4 2 5 7 8 6"
Output:
	Movement: Down
	1 2 3
	4 5 6
	7 8 0 

	Movement: Right
	1 2 3
	4 5 0
	7 8 6 

	Movement: Down
	1 2 3
	4 0 5
	7 8 6 

	Movement: Right
	1 0 3
	4 2 5
	7 8 6 

	* 1 3 (Initial input state)
	4 2 5
	7 8 6 

	Number of moves: 4
	Number of states enqueued: 5

***Side Note: My backtrace() function recursively traces the parent nodes to keep track and the puzzle is printed backwards from Goal State to Initial State while displaying each movement made.
------------------------------------------
3. Short Comparative Analysis of Two Heuristics used in A*:
	
I used 2 heuristcs and titled them h_one() and h_two(). The first is known as a Manhattan Distance Heuristic and the second is known as the Misplaced Tiles Heuristic. I incorporated each outside of the A* algorithms and passed the value as a variable into each of the A* search functions.

The Manhattan distance finds the distance between two points measured along axes at right angles. The Manhattan distance between two vectors (or points) a and b is defined as ∑i|ai−bi| over the dimensions of the vectors, and all paths from the bottom left to top right of this idealized city have the same distance. It is an admissible heuristic in this case because every tile will have to be moved at least the number of spots in between itself and its correct position.

The Misplaced Tiles heuristic assumes that any tile can be moved to any position if you were to relax both adjacency and blank space conditions. So, you just need to move each tile to the final position. Therefore, h(n) will be the number of misplaced tiles. This heuristic is admissable because each misplaced tile must be moved.

The conclusion: h_two(n) <= h_one(n) <= h*(n). This means that the Manhattan Distance Heuristic dominates the Misplaced Tiles Heuristic. Some problems with the A* algorithm with an admissable heuristic is that even though provides optimality, it has the same space complexity as BFS. There can be a better way to come up with another heuristic (not done in this project) and that is to run searches on smaller sub-problems and store those results. All of those results would have a maximum cost and that would be the new, better, heuristic. And if the sub-problems are disjoint, you can add the costs. This method can be very effective when feasible, and when well constructed, this can outperform the manhattan distance heuristic for the 8 puzzle. But, even so, all the search properties used on the 8 puzzle have limitations that need to be considered for any optimality or "better way" to search; observability, known environment, determinism, and discrete states. 
------------------------------------------
Experience and Problems:

The most prominent problem I ran into was knowing what exactly was meant by 'Number of states enqueued'. I came to the conclusion of it being the total number of states visited on the way to solving the problem. I don't know if that is what was meant but it was very cumbersome. So, my total states enqued is the max search depth.

Next would be the Iterative-Deepenig Search (ids) and how it implements a Depth-First Search (dfs). Through my research, I noticed a lot of the the implementation form the dfs was recursive. It threw me off considering 'iterative' is in the name of the search. So, I ended up concluding that it was reading the dfs iteratively and that is what I ended up doing.

Lastly, would be the A* algorithm implementation with two separate heuristics. My questions were, does the A* use the same search function for both but just passes the heuristic as a value (which is what I ended up doing). Or, are they two separate algorithms altogether. Hopefully it's the former.
------------------------------------------
Resource(s):

http://www.cs.toronto.edu/~edelisle/384/f14/Lectures/384slides-sep18.pdf
	  