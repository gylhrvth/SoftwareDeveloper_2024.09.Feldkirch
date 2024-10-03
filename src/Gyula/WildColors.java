package Gyula;

public class WildColors {
    public static void main(String[] args) {
        for (int red = 0; red < 256; red += 8) {
            for (int green = 0; green < 256; green += 8) {
                for (int blue = 0; blue < 256; blue += 8) {
                    String color = getColor(red, green, blue);
                    System.out.printf("%s%s%s", color, "a", "\u001B[0m");
                }
            }
            System.out.println();
        }
    }

    public static String getColor(int red, int green, int blue){
        if (red >= 0 && red < 256 && green >= 0 && green < 256 && blue >= 0 && blue < 256){
            return String.format("\u001B[38;2;%d;%d;%dm", red, green, blue);
        } else {
            return "\u001B[0m";
        }
    }


    public static String getColorFromHSL(double hue, double saturation, double light){
        int[] rgb = hslToRgb(hue, saturation, light);
        // System.out.printf("%4.0f ==> %3d, %3d, %3d", hue, rgb[0], rgb[1], rgb[2]);
        return getColor(rgb[0], rgb[1], rgb[2]);
    }



    /** HSL to RGB converter
     *
     * @param hue 0-359
     * @param saturation 0-1
     * @param light 0-1
     * @return array with R-G-B values
     */
    private static int[] hslToRgb(double hue, double saturation, double light){
        double[] rgb = null;
        hue /= 360.0; // convert hue to 0-1

        if (saturation == 0.0){
            rgb = new double[]{light, light, light};
        } else {
            double q = light < 0.5 ? light * (1 + saturation) : light + saturation - light * saturation;
            double p = 2 * light - q;

            rgb = new double[]{
                hueToRGB(p, q, hue + 1/3.0),
                hueToRGB(p, q, hue),
                hueToRGB(p, q, hue -1/3.0),
            };
        }
        return new int[]{
                (int)Math.min(256 * rgb[0], 255),
                (int)Math.min(256 * rgb[1], 255),
                (int)Math.min(256 * rgb[2], 255),
        };
    }

    private static double hueToRGB(double p, double q, double t){
        if (t < 0.0) {
            t += 1.0;
        }
        if (t > 1.0){
            t -= 1.0;
        }
        if (t < 1.0/6.0){
            return p + (q - p) * 6.0 * t;
        }
        if (t < 1.0/2.0){
            return q;
        }
        if (t < 2.0/3.0){
            return p + (q - p) * (2.0/3.0 - t) * 6.0;
        }

        return p;
    }

    public static double partValue(int start, int end, int index, int steps){
        if (steps < 2) return start;
        if (index >= steps) return end;

        return start + (end - start) * index / (steps - 1.0);
    }
}
