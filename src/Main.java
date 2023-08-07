public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}

public class Point {
    private int x;
    private int y;


    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }


    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }


    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }


    public double distance() {
        return Math.sqrt(x * x + y * y);
    }

    public double distance(Point p) {
        int xDistance = this.x - p.getX();
        int yDistance = this.y - p.getY();
        return Math.sqrt(xDistance * xDistance + yDistance * yDistance);
    }

    public double distance(int a, int b) {
        int xDistance = this.x - a;
        int yDistance = this.y - b;
        return Math.sqrt(xDistance * xDistance + yDistance * yDistance);
    }

    public static void main(String[] args) {
        Point first = new Point(6, 5);
        Point second = new Point(3, 1);
        Point point = new Point(0, 0);

        System.out.println("distance(0,0)= " + point.distance());
        System.out.println("distance(second)= " + first.distance(second));
        System.out.println("distance(2,2)= " + first.distance(2, 2));
        System.out.println("distance()= " + point.distance());
    }
}



public class Player {
    private String name;
    private int healthPercentage;
    private Weapon weapon;

    // Enum for Weapon
    public enum Weapon {
        SWORD, AXE, BOW
    }


    public Player(String name, int healthPercentage, Weapon weapon) {
        this.name = name;
        this.healthPercentage = Math.min(Math.max(healthPercentage, 0), 100);
        this.weapon = weapon;
    }


    public int healthRemaining() {
        return healthPercentage;
    }


    public void loseHealth(int damage) {
        healthPercentage = Math.max(healthPercentage - damage, 0);
        if (healthPercentage == 0) {
            System.out.println(name + " player has been knocked out of the game");
        }
    }

    
    public void restoreHealth(int healthPotion) {
        healthPercentage = Math.min(healthPercentage + healthPotion, 100);
    }

    public static void main(String[] args) {
        Player player1 = new Player("John", 80, Weapon.SWORD);
        Player player2 = new Player("Jane", 120, Weapon.BOW);

        System.out.println(player1.name + "'s health: " + player1.healthRemaining());
        System.out.println(player2.name + "'s health: " + player2.healthRemaining());

        player1.loseHealth(30);
        player2.loseHealth(50);

        System.out.println(player1.name + "'s health after damage: " + player1.healthRemaining());
        System.out.println(player2.name + "'s health after damage: " + player2.healthRemaining());

        player1.restoreHealth(20);
        player2.restoreHealth(40);

        System.out.println(player1.name + "'s health after restoration: " + player1.healthRemaining());
        System.out.println(player2.name + "'s health after restoration: " + player2.healthRemaining());
    }
}
