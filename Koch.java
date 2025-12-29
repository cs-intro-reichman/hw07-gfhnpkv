/** Draws the Koch curve and the the Koch snowflake fractal. */
public class Koch {

    public static void main(String[] args) {
            // Tests the snowflake function:
            snowFlake(Integer.parseInt(args[0]));
        // }
    }

    /** * Draws a Koch curve of depth n from (x1,y1) to (x2,y2).
     */
    public static void curve(int n, double x1, double y1, double x2, double y2) {
        // Base Case: At depth 0, we simply draw the straight line[cite: 98, 115].
        if (n == 0) {
            StdDraw.line(x1, y1, x2, y2);
            return;
        }

        // 1. Calculate the 1/3 and 2/3 points along the line.
        // These must be relative to x1,y1, not just a fraction of x2,y2.
        double qx1 = x1 + (x2 - x1) / 3.0;
        double qy1 = y1 + (y2 - y1) / 3.0;
        double qx2 = x1 + 2.0 * (x2 - x1) / 3.0;
        double qy2 = y1 + 2.0 * (y2 - y1) / 3.0;

        // 2. Calculate the peak point (p3) of the equilateral triangle.
        double px3 = 0.5 * (x1 + x2) - (Math.sqrt(3) / 6.0) * (y2 - y1);
        double py3 = 0.5 * (y1 + y2) + (Math.sqrt(3) / 6.0) * (x2 - x1);

        // 3. Recursive calls for the four new segments:
        // Segment 1: From start to 1/3 point
        curve(n - 1, x1, y1, qx1, qy1);
        
        // Segment 2: From 1/3 point to peak
        curve(n - 1, qx1, qy1, px3, py3);
        
        // Segment 3: From peak to 2/3 point
        curve(n - 1, px3, py3, qx2, qy2);
        
        // Segment 4: From 2/3 point to end
        curve(n - 1, qx2, qy2, x2, y2);
    }

    /** Draws a Koch snowflake by joining three Koch curves. */
    public static void snowFlake(int n) {
        StdDraw.setYscale(0, 1.1);
        StdDraw.setXscale(0, 1.1);
        
        // Define three points of an equilateral triangle
        double x1 = 0.1, y1 = 0.3;
        double x2 = 0.9, y2 = 0.3;
        double x3 = 0.5, y3 = 0.3 + 0.8 * (Math.sqrt(3) / 2.0);

        // Draw the three edges of the snowflake using the curve function
        curve(n, x1, y1, x2, y2); // Bottom edge
        curve(n, x2, y2, x3, y3); // Right edge
        curve(n, x3, y3, x1, y1); // Left edge
    }
}