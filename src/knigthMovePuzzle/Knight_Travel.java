package knigthMovePuzzle;

import java.util.*;

public class Knight_Travel {
    private boolean[][] visited;

    public Knight_Travel() {
        visited = new boolean[8][8];
        refreshBoard();
    }

    private void refreshBoard() {
        for (int i = 0; i < visited.length; i++) {
            for (int j = 0; j < visited[0].length; j++) {
                visited[i][j] = false;
            }
        }
    }

    public List<pos> shortedPath(pos start, pos end) {
        if (!start.isValid() || !end.isValid()) {
            System.out.println("invalid input");
            return null;
        }
        refreshBoard();
        List<pos> steps = new ArrayList<>();
        Queue<pos> queue = new LinkedList<>();
        queue.offer(start);
        while (!queue.isEmpty()) {
            pos current = queue.poll();
            visited[current.row][current.col] = true;
            if (current.equalTo(end)) {
                while (current.parent != null) {
                    steps.add(current);
                    current = current.parent;
                }
                Collections.reverse(steps);
                for (pos step : steps) {
                    step.print();
                }
                return steps;
            } else {
                List<pos> nextMoves = current.nextMoves();
                for (pos move : nextMoves) {
                    if (!move.isVisited(visited)) {
                        move.parent = current;
                        queue.offer(move);
                    }
                }
            }
        }
        System.out.println("No solution");
        return null;
    }

    public static void main(String[] args) {
        Knight_Travel game = new Knight_Travel();
        List<pos> steps = game.shortedPath(new pos(0, 0), new pos(1, 1));
    }
}
