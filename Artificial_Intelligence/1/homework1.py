# Zachary Tarell - zjt170000
# Homework 1: Search Algorithms - 8 puzzle
# CS 4365.501 Artificial Intelligence

import sys
from collections import deque
from heapq import heappush, heappop, heapify


class State:

    def __init__(self, state, parent, move, depth, cost, key):
        self.state = state
        self.parent = parent
        self.move = move
        self.depth = depth
        self.cost = cost
        self.key = key

        if self.state:
            self.map = ''.join(str(e) for e in self.state)

    def __eq__(self, other):
        return self.map == other.map

    def __lt__(self, other):
        return self.map < other.map


goal_state = [1, 2, 3, 4, 5, 6, 7, 8, 0]
goal_node = State
initial_state = list()
board_len = 9   # set as 9 (total spaces) a global because it's known 8-puzzle
board_side = 3  # set as 3 (sqrt of total spaces) a global because it's known 8-puzzle

nodes_expanded = 0
max_search_depth = 10
enqueued_states = 0

moves = list()
costs = set()


# Breadth-First Search
def bfs(start_state):
    global enqueued_states, goal_node, max_search_depth
    explored, queue = set(), deque([State(start_state, None, None, 0, 0, 0)])
    while queue:
        node = queue.popleft()
        explored.add(node.map)
        if node.state == goal_state:
            goal_node = node
            return queue
        neighbors = expand(node)
        for neighbor in neighbors:
            if neighbor.map not in explored:
                queue.append(neighbor)
                explored.add(neighbor.map)
                if neighbor.depth > max_search_depth:
                    print('Goal Depth was not reached before 11 moves')
                    quit(0)
        if len(queue) > enqueued_states:
            enqueued_states = len(queue)


# Iterative Deepening Search
def ids(start_state):
    global costs
    threshold = h_one(start_state)
    while 1:
        response = dls_mod(start_state, threshold)
        if type(response) is list:
            return response
            break
        threshold = response
        costs = set()


# Depth-First Search that is passed to ids
def dls_mod(start_state, threshold):
    global enqueued_states, goal_node, max_search_depth, costs
    explored, stack = set(), list([State(start_state, None, None, 0, 0, threshold)])
    while stack:
        node = stack.pop()
        explored.add(node.map)
        if node.state == goal_state:
            goal_node = node
            return stack
        if node.key > threshold:
            costs.add(node.key)
        if node.depth < threshold:
            neighbors = reversed(expand(node))
            for neighbor in neighbors:
                if neighbor.map not in explored:
                    neighbor.key = neighbor.cost + h_one(neighbor.state)
                    stack.append(neighbor)
                    explored.add(neighbor.map)
                    if neighbor.depth > max_search_depth:
                        print('Goal Depth was not reached before 11 moves')
                        quit(0)
            if len(stack) > enqueued_states:
                enqueued_states = len(stack)

    return min(costs)


# Manhattan Distance Heuristic
def h_one(state):
    return sum(abs(b % board_side - g % board_side) + abs(b // board_side - g // board_side)
               for b, g in ((state.index(i), goal_state.index(i)) for i in range(1, board_len)))


# A* Search with Manhattan Distance as heuristic 1
def astar1(start_state):
    global enqueued_states, goal_node, max_search_depth
    explored, heap, heap_entry = set(), list(), {}
    key = h_one(start_state)
    root = State(start_state, None, None, 0, 0, key)
    entry = (key, 0, root)
    heappush(heap, entry)
    heap_entry[root.map] = entry
    while heap:
        node = heappop(heap)
        explored.add(node[2].map)
        if node[2].state == goal_state:
            goal_node = node[2]
            return heap
        neighbors = expand(node[2])
        for neighbor in neighbors:
            neighbor.key = neighbor.cost + h_one(neighbor.state)
            entry = (neighbor.key, neighbor.move, neighbor)
            if neighbor.map not in explored:
                heappush(heap, entry)
                explored.add(neighbor.map)
                heap_entry[neighbor.map] = entry
                if neighbor.depth > max_search_depth:
                    print('Goal Depth was not reached before 11 moves')
                    quit(0)
            elif neighbor.map in heap_entry and neighbor.key < heap_entry[neighbor.map][2].key:
                hindex = heap.index((heap_entry[neighbor.map][2].key,
                                     heap_entry[neighbor.map][2].move,
                                     heap_entry[neighbor.map][2]))
                heap[int(hindex)] = entry
                heap_entry[neighbor.map] = entry
                heapify(heap)
        if len(heap) > enqueued_states:
            enqueued_states = len(heap)


# Misplaced Tiles Heuristic
def h_two(state):
    count = 0
    for i in range(1, board_len):
        if state[i] != goal_state[i]:
            count += 1

    return count


# A* Search with Misplaced Tiles as heuristic 2
def astar2(start_state):
    global enqueued_states, goal_node, max_search_depth
    explored, heap, heap_entry = set(), list(), {}
    key = h_two(start_state)
    root = State(start_state, None, None, 0, 0, key)
    entry = (key, 0, root)
    heappush(heap, entry)
    heap_entry[root.map] = entry
    while heap:
        node = heappop(heap)
        explored.add(node[2].map)
        if node[2].state == goal_state:
            goal_node = node[2]
            return heap
        neighbors = expand(node[2])
        for neighbor in neighbors:
            neighbor.key = neighbor.cost + h_two(neighbor.state)
            entry = (neighbor.key, neighbor.move, neighbor)
            if neighbor.map not in explored:
                heappush(heap, entry)
                explored.add(neighbor.map)
                heap_entry[neighbor.map] = entry
                if neighbor.depth > max_search_depth:
                    print('Goal Depth was not reached before 11 moves')
                    quit(0)
            elif neighbor.map in heap_entry and neighbor.key < heap_entry[neighbor.map][2].key:
                hindex = heap.index((heap_entry[neighbor.map][2].key,
                                     heap_entry[neighbor.map][2].move,
                                     heap_entry[neighbor.map][2]))
                heap[int(hindex)] = entry
                heap_entry[neighbor.map] = entry
                heapify(heap)
        if len(heap) > enqueued_states:
            enqueued_states = len(heap)


# Expanding the nodes
def expand(node):
    global nodes_expanded
    nodes_expanded += 1
    neighbors = list()
    neighbors.append(State(move(node.state, 1), node, 1, node.depth + 1, node.cost + 1, 0))
    neighbors.append(State(move(node.state, 2), node, 2, node.depth + 1, node.cost + 1, 0))
    neighbors.append(State(move(node.state, 3), node, 3, node.depth + 1, node.cost + 1, 0))
    neighbors.append(State(move(node.state, 4), node, 4, node.depth + 1, node.cost + 1, 0))
    nodes = [neighbor for neighbor in neighbors if neighbor.state]

    return nodes


# moving each index to new empty state
def move(state, position):
    new_state = state[:]
    index = new_state.index(0)
    if position == 1:  # Up
        if index not in range(0, board_side):
            temp = new_state[index - board_side]
            new_state[index - board_side] = new_state[index]
            new_state[index] = temp
            return new_state
        else:
            return None
    if position == 2:  # Down
        if index not in range(board_len - board_side, board_len):
            temp = new_state[index + board_side]
            new_state[index + board_side] = new_state[index]
            new_state[index] = temp
            return new_state
        else:
            return None
    if position == 3:  # Left
        if index not in range(0, board_len, board_side):
            temp = new_state[index - 1]
            new_state[index - 1] = new_state[index]
            new_state[index] = temp
            return new_state
        else:
            return None
    if position == 4:  # Right
        if index not in range(board_side - 1, board_len, board_side):
            temp = new_state[index + 1]
            new_state[index + 1] = new_state[index]
            new_state[index] = temp
            return new_state
        else:
            return None


# Back tracing to keep track of parent nodes
def backtrace():
    current_node = goal_node
    while initial_state != current_node.state:
        if current_node.move == 1:
            movement = 'Up'
        elif current_node.move == 2:
            movement = 'Down'
        elif current_node.move == 3:
            movement = 'Left'
        else:
            movement = 'Right'
        print("Movement:", movement)
        print(current_node.state[0], current_node.state[1], current_node.state[2])
        print(current_node.state[3], current_node.state[4], current_node.state[5])
        print(current_node.state[6], current_node.state[7], current_node.state[8], "\n")
        moves.insert(0, movement)
        current_node = current_node.parent

    return moves


# Export moves for outputting proper game states, moves, and total enqueued
def export():
    global moves

    moves = backtrace()

    for i in range(len(initial_state)):
        if initial_state[i] == 0:
            initial_state[i] = "*"

    print(initial_state[0], initial_state[1], initial_state[2], "(Initial input state)")
    print(initial_state[3], initial_state[4], initial_state[5])
    print(initial_state[6], initial_state[7], initial_state[8], "\n")

    print("Number of moves: " + str(len(moves)))
    print("Number of states enqueued: " + str(enqueued_states))


# read in inputs
def read(configuration):
    global board_len, board_side
    data = configuration.split(" ")
    for element in data:
        if element == "*":
            element = element.replace("*", "0")
        initial_state.append(int(element))


def main():
    if len(sys.argv) > 1:
        algorithm = sys.argv[1]
        board = sys.argv[2]
    read(board)
    function = function_map[algorithm]
    function(initial_state)
    export()


function_map = {
    'bfs': bfs,
    'ids': ids,
    'astar1': astar1,
    'astar2': astar2
}
if __name__ == '__main__':
    main()
