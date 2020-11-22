package rockfall;

import java.util.Random;

public class Structure{
    public enum RockPiece {
        No, Z, S, Line, TShape, Square, L, MirroredL
    }

    private RockPiece pieceShape;
    private int[][] coordinates;

    public Structure() {
        coordinates = new int[4][2];
        setShape(RockPiece.No);
    }

    void setShape(RockPiece shape) {
        int[][][] coordsChart = new int[][][]{
                {{0, 0}, {0, 0}, {0, 0}, {0, 0}},
                {{0, -1}, {0, 0}, {-1, 0}, {-1, 1}},
                {{0, -1}, {0, 0}, {1, 0}, {1, 1}},
                {{0, -1}, {0, 0}, {0, 1}, {0, 2}},
                {{-1, 0}, {0, 0}, {1, 0}, {0, 1}},
                {{0, 0}, {1, 0}, {0, 1}, {1, 1}},
                {{-1, -1}, {0, -1}, {0, 0}, {0, 1}},
                {{1, -1}, {0, -1}, {0, 0}, {0, 1}}};

        for (int i = 0; i < 4; i++) {
            System.arraycopy(coordsChart[shape.ordinal()], 0, coordinates, 0, 4);
        }
        pieceShape = shape;
    }

    private void setX(int index, int x) {
        coordinates[index][0] = x;
    }

    private void setY(int index, int y) { coordinates[index][1] = y; }

    int x(int index) { return coordinates[index][0]; }

    int y(int index) { return coordinates[index][1]; }

    RockPiece getShape() { return pieceShape; }

    void setRandomShape() {
        var r = new Random();
        int x = Math.abs(r.nextInt()) % 7 + 1;
        RockPiece[] values = RockPiece.values();
        setShape(values[x]);
    }

    public int minX() {
        int m = coordinates[0][0];
        for (int i = 0; i < 4; i++) {
            m = Math.min(m, coordinates[i][0]);
        }
        return m;
    }


    int minY() {
        int m = coordinates[0][1];
        for (int i = 0; i < 4; i++) {
            m = Math.min(m, coordinates[i][1]);
        }
        return m;
    }

    Structure rotateLeft() {
        if (pieceShape == RockPiece.Square) {
            return this;
        }

        var result = new Structure();
        result.pieceShape = pieceShape;

        for (int i = 0; i < 4; i++) {
            result.setX(i, y(i));
            result.setY(i, -x(i));
        }
        return result;
    }

    Structure rotateRight() {
        if (pieceShape == RockPiece.Square) {
            return this;
        }

        var result = new Structure();
        result.pieceShape = pieceShape;

        for (int i = 0; i < 4; i++) {
            result.setX(i, -y(i));
            result.setY(i, x(i));
        }
        return result;
    }
}