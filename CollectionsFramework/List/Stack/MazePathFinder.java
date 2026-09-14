/*
#10 Hard Classic — backtracking with Stack
-----------------------------------------------------------------------------------------------------------------------------------
Maze path finder

Given a 5x5 grid maze where 0=open path and 1=wall, find a path from top-left (0,0) to bottom-right (4,4) using Stack-based backtracking.
Push each step onto Stack. When stuck, pop (backtrack) to previous position and try another direction. Print the path taken and all
backtrack steps.
-----------------------------------------------------------------------------------------------------------------------------------
⚠️ Legacy Stack approach: Stack<int[]> stores each position as [row, col]. Push when moving forward, pop when backtracking. This manual
stack-based DFS (Depth First Search) directly shows HOW recursion works internally — recursive calls use the call stack implicitly.
Iterative Stack makes the backtracking explicit and visible.
-----------------------------------------------------------------------------------------------------------------------------------
✅ Modern replacement — ArrayDeque + Recursion: Real maze solvers use recursive DFS (cleaner code, call stack handles backtracking implicitly)
or BFS with Queue for shortest path. ArrayDeque used as Stack for iterative DFS. For production pathfinding — A* algorithm with priority
queue. This problem is the gateway to understanding graph traversal algorithms.
-----------------------------------------------------------------------------------------------------------------------------------
Maze:
0 0 1 0 0
0 0 0 1 0
1 0 0 0 0
0 1 0 1 0
0 0 0 0 0
Path: (0,0)→(0,1)→(1,1)→(1,2)→(2,2)→..→(4,4)
Backtrack: prints when dead end hit → pops to try new direction

Skills: Stack backtracking, DFS concept, visited[][] tracking, 4-direction movement, bounds checking, path reconstruction
Hint at bottom --->
 */

package List.Stack;

import java.util.ArrayList;
import java.util.Stack;

public class MazePathFinder {
    static int[][] maze = {
            {0,0,1,0,0},
            {0,0,0,1,0},
            {1,0,0,0,0},
            {0,1,0,1,0},
            {0,0,0,0,0}
    };
    static boolean[][] visited = new boolean[5][5];

    public static void main(String[] args) {
        Stack<int[]> path = new Stack<>();

        int r = 0, c = 0;
        path.push(new int[]{r, c});
        visited[r][c] = true;

        while(!path.isEmpty()){
            int[] current = path.peek();
            r = current[0];
            c = current[1];

            if(r == 4 && c == 4){
                System.out.println("Found! Path:");
                printPath(path);
                return;
            }

            // try 4 directions: right, down, left, up
            if(isValid(r, c+1) && maze[r][c+1] != 1 && !visited[r][c+1]){
                visited[r][c+1] = true;
                path.push(new int[]{r, c+1});
            } else if(isValid(r+1, c) && maze[r+1][c] != 1 && !visited[r+1][c]){
                visited[r+1][c] = true;
                path.push(new int[]{r+1, c});
            } else if(isValid(r, c-1) && maze[r][c-1] != 1 && !visited[r][c-1]){
                visited[r][c-1] = true;
                path.push(new int[]{r, c-1});
            } else if(isValid(r-1, c) && maze[r-1][c] != 1 && !visited[r-1][c]){
                visited[r-1][c] = true;
                path.push(new int[]{r-1, c});
            } else {
                // stuck — no valid direction — backtrack
                int[] deadEnd = path.pop();
                System.out.println("Backtracking from [" + deadEnd[0] + "," + deadEnd[1] + "]");
            }
        }

        System.out.println("No path found — maze unsolvable from this start.");
    }

    static boolean isValid(int r, int c){
        return r >= 0 && r < 5 && c >= 0 && c < 5;
    }

    static void printPath(Stack<int[]> path){
        // Stack extends Vector, so indexed access goes bottom-to-top, i.e., start-to-finish order
        for(int i = 0; i < path.size(); i++){
            int[] pos = path.get(i);
            System.out.println("(" + pos[0] + "," + pos[1] + ")");
        }
    }
}


/*
Setup:
int[][] maze = {{0,0,1,0,0},{0,0,0,1,0},{1,0,0,0,0},{0,1,0,1,0},{0,0,0,0,0}}
boolean[][] visited = new boolean[5][5] — track visited cells.
Stack<int[]> path = new Stack<>() — stores [row, col] of each step.

Algorithm:
Push starting position {0,0}. Mark visited[0][0]=true.
While stack not empty:
— peek top position [r,c].
— if [r,c] == [4,4] → found! Print path by iterating stack.
— try moving in 4 directions: right[r,c+1], down[r+1,c], left[r,c-1], up[r-1,c].
— for each direction: check bounds (0-4), check maze[nr][nc]==0, check !visited[nr][nc].
— if valid direction found: push {nr,nc}, mark visited, break.
— if NO valid direction found: pop (backtrack) and print "Backtracking from [r,c]".

Print path: Convert stack to ArrayList and print in order — stack.get(i) gives bottom-to-top access since Stack extends Vector.

Bounds check helper: boolean isValid(int r, int c) { return r>=0 && r<5 && c>=0 && c<5; }

Modern ArrayDeque:
Deque<int[]> path = new ArrayDeque<>()
push()=addFirst, pop()=removeFirst, peek()=peekFirst.
To print path in order: convert to array — Object[] arr = path.toArray() — iterate from end to start since ArrayDeque's push goes to front.
 */