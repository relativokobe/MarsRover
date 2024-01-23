package org.example;

public class Main {
    private int x;
    private int y;
    private char direction = 'N';
    private static final char[] DIRECTIONS = {'N', 'E', 'S', 'W'};

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getPosition() {
        return x + ", " + y + ", " + direction;
    }

    public char getDirection() {
        return direction;
    }

    public static void main(String[] args) {
        Main rover = new Main();
        rover.instructions("LMLMLMLMLM");
        System.out.println(rover.getX() + ", " + rover.getY() + ", " + rover.getDirection());

        runSimpleUnitTest();
    }

    private static void runSimpleUnitTest(){
        Main rover1 = new Main();
        rover1.instructions("LMLMLMLMLM");
        if ("0, 1, W".equals(rover1.getPosition())) {
            System.out.println("Test1 passed!");
        } else {
            System.out.println("Test1 failed. Expected: 0, 1, W, Actual: " + rover1.getPosition());
        }

        Main rover2 = new Main();
        rover2.instructions("RMRMRMRMRM");
        if ("1, 1, E".equals(rover2.getPosition())) {
            System.out.println("Test2 passed!");
        } else {
            System.out.println("Test2 failed. Expected: 1, 1, E, Actual: " + rover2.getPosition());
        }

        Main rover3 = new Main();
        rover3.instructions("LMRMMMMMRMLLRM");
        if ("1, 6, N".equals(rover3.getPosition())) {
            System.out.println("Test3 passed!");
        } else {
            System.out.println("Test3 failed. Expected: 1, 6, N, Actual: " + rover3.getPosition());
        }

        //TODO Can add More
    }

    public void instructions(String instructions) {
        for (char instruction : instructions.toCharArray()) {
            if (instruction == 'L') {
                left();
            } else if (instruction == 'R') {
                right();
            } else {
                move();
            }
        }
    }

    private void left() {
        int index = new String(DIRECTIONS).indexOf(direction);
        int newDirectionIndex = index - 1;
        if(newDirectionIndex < 0){
            newDirectionIndex = 3;
        }
        direction = DIRECTIONS[newDirectionIndex];
    }

    private void right() {
        int index = new String(DIRECTIONS).indexOf(direction);
        int newDirectionIndex = index + 1;
        if(newDirectionIndex > 3){
            newDirectionIndex = 0;
        }
        direction = DIRECTIONS[newDirectionIndex];
    }

    private void move() {
        switch (direction) {
            case 'N':
                y++;
                break;
            case 'E':
                x++;
                break;
            case 'S':
                y--;
                if(y < 0){
                    y++;
                }
                break;
            case 'W':
                x--;
                if(x < 0){
                    x++;
                }
                break;
        }
    }
}