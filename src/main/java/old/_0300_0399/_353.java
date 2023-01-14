package old._0300_0399;

import java.util.LinkedList;

/**  
 * @ClassName: _353  
 *
 * @Description: TODO(这里用一句话描述这个类的作用)  
 *
 * @author 余定邦  
 *
 * @date 2020年4月11日  
 *  
 */
public class _353 {

    class SnakeGame {

        class Node {
            int x;
            int y;

            public Node(int x, int y) {
                super();
                this.x = x;
                this.y = y;
            }
        }

        private int[][] foodList;
        private int foodIndex;

        private int width, height;

        private boolean[][] board;

        private LinkedList<Node> snake = new LinkedList<>();

        private int point = 0;

        /** Initialize your data structure here.
            @param width - screen width
            @param height - screen height 
            @param food - A list of food positions
            E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0]. */
        public SnakeGame(int width, int height, int[][] food) {
            foodList    = food;
            foodIndex   = 0;
            this.width  = width;
            this.height = height;
            board       = new boolean[height][width];
            board[0][0] = true;
            snake.add(new Node(0, 0));
        }

        /** Moves the snake.
            @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down 
            @return The game's score after the move. Return -1 if game over. 
            Game over when snake crosses the screen boundary or bites its body. */
        public int move(String direction) {
            Node snakeHead = snake.getFirst();
            int  xn        = snakeHead.x;
            int  yn        = snakeHead.y;
            switch (direction) {
                case "U":
                    --xn;
                    break;
                case "D":
                    ++xn;
                    break;
                case "R":
                    ++yn;
                    break;
                case "L":
                    --yn;
                    break;
            }
            if (xn < 0 || yn < 0 || xn >= height || yn >= width) {
                return -1;
            }

            if (foodIndex < foodList.length && xn == foodList[foodIndex][0] && yn == foodList[foodIndex][1]) {// 吃到食物的情况
                ++foodIndex;
                ++point;
                snake.addFirst(new Node(xn, yn));
                board[xn][yn] = true;
            } else {
                snake.addFirst(new Node(xn, yn));
                Node tail = snake.removeLast();
                board[tail.x][tail.y] = false;
                if (board[xn][yn]) {
                    return -1;
                }
                board[xn][yn] = true;
            }
            return point;
        }
    }

}
