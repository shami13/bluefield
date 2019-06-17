package ua.com.shami.bluefield.findpath.graph;

public class Vertex {
    private int x;
    private int y;
    private char label;

    public Vertex(int x, int y, char label) {
        this.x = x;
        this.y = y;
        this.label = label;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public char getLabel() {
        return label;
    }

    @Override
    public String toString() {
        return "Vertex{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
