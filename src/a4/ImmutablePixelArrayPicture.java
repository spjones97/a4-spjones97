package a4;

public class ImmutablePixelArrayPicture implements Picture {

    private int width;
    private int height;
    private Pixel[][] immutableArr;

    // Creates new object using values provided by pixel_array, matching in size.
    public ImmutablePixelArrayPicture(Pixel[][] pixel_array) {
        if (pixel_array == null) {
            throw new IllegalArgumentException("need to specify pixel_array");
        }
        this.width = pixel_array.length;
        this.height = pixel_array[0].length;
        this.immutableArr = pixel_array;
    }

    // Creates new object by providing geometry and initial value for all pixels.
    public ImmutablePixelArrayPicture(int width, int height, Pixel initial_value) {
        if (width <= 0) {
            throw new IllegalArgumentException("width is less than or equal to zero");
        }
        if (height <= 0) {
            throw new IllegalArgumentException("height is less than or equal to zero");
        }
        if (initial_value == null) {
            throw new IllegalArgumentException("need to specify pixel");
        }
        this.width = width;
        this.height = height;
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                this.immutableArr[i][j] = initial_value;
            }
        }
    }

    // Creates new object by providing geometry. Initial value should be medium
    // gray.
    public ImmutablePixelArrayPicture(int width, int height) {
        if (width <= 0) {
            throw new IllegalArgumentException("width is less than or equal to zero");
        }
        if (height <= 0) {
            throw new IllegalArgumentException("height is less than or equal to zero");
        }
        Pixel pixel = new GrayPixel(0.5);
        this.width = width;
        this.height = height;
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                this.immutableArr[i][j] = pixel;
            }
        }
    }

    @Override
    public int getWidth() {
        return this.width;
    }

    @Override
    public int getHeight() {
        return this.height;
    }

    @Override
    public Pixel getPixel(int x, int y) {
        if (x < 0) {
            throw new IllegalArgumentException("x is less than zero");
        }
        if (x >= this.width) {
            throw new IllegalArgumentException("x is too large");
        }
        if (y < 0) {
            throw new IllegalArgumentException("y is less than zero");
        }
        if (y >= this.height) {
            throw new IllegalArgumentException("y is too large");
        }
        return immutableArr[x][y];
    }

    @Override
    public Picture paint(int x, int y, Pixel p) {
        if (x < 0) {
            throw new IllegalArgumentException("x is less than zero");
        }
        if (x >= this.width) {
            throw new IllegalArgumentException("x is too large");
        }
        if (y < 0) {
            throw new IllegalArgumentException("y is too large");
        }
        if (y >= this.height) {
            throw new IllegalArgumentException("y is too large");
        }
        this.immutableArr[x][y] = p;
        return this;
    }

    @Override
    public Picture paint(int x, int y, Pixel p, double factor) {
        if (x >= this.width) {
            throw new IllegalArgumentException("x is too large");
        }
        if (x < 0) {
            throw new IllegalArgumentException("x is too small");
        }
        if (y >= this.height) {
            throw new IllegalArgumentException("y is too large");
        }
        if (y < 0) {
            throw new IllegalArgumentException("y is too small");
        }
        if (p == null) {
            throw new IllegalArgumentException("need to specify pixel");
        }
        if (factor < 0) {
            throw new IllegalArgumentException("factor value less than zero");
        }
        if (factor > 1) {
            throw new IllegalArgumentException("factor value greater than one");
        }
        this.immutableArr[x][y] = p.blend(p, factor);
        return this;
    }

    @Override
    public Picture paint(int ax, int ay, int bx, int by, Pixel p) {
        if (ax < 0) {
            throw new IllegalArgumentException("ax is less than zero");
        }
        if (bx >= this.width) {
            throw new IllegalArgumentException("bx is too large");
        }
        if (ay < 0) {
            throw new IllegalArgumentException("ay is less than zero");
        }
        if (by >= this.height) {
            throw new IllegalArgumentException("by is too large");
        }
        if (bx > ax || by > ay) {
            throw new IllegalArgumentException("bx is greater than ax or by is greater than bx");
        }
        if (p == null) {
            throw new IllegalArgumentException("need to specify pixel");
        }
        for (int i = ax; i <= bx; i++) {
            for (int j = ay; j <= by; j++) {
                this.immutableArr[i][j] = p;
            }
        }
        return this;
    }

    @Override
    public Picture paint(int ax, int ay, int bx, int by, Pixel p, double factor) {
        if (ax < 0) {
            throw new IllegalArgumentException("ax is less than zero");
        }
        if (bx >= this.width) {
            throw new IllegalArgumentException("bx is too large");
        }
        if (ay < 0) {
            throw new IllegalArgumentException("ay is less than zero");
        }
        if (by >= this.height) {
            throw new IllegalArgumentException("by is too large");
        }
        if (bx > ax || by > ay) {
            throw new IllegalArgumentException("bx is greater than ax or by is greater than bx");
        }
        if (p == null) {
            throw new IllegalArgumentException("need to specify pixel");
        }
        if (factor < 0) {
            throw new IllegalArgumentException("factor value less than zero");
        }
        if (factor > 1) {
            throw new IllegalArgumentException("factor value greater than one");
        }
        for (int i = ax; i <= bx; i++) {
            for (int j = ay; j <= by; j++) {
                this.immutableArr[i][j] = p.blend(p, factor);
            }
        }
        return this;
    }

    @Override
    public Picture paint(int cx, int cy, double radius, Pixel p) {
        if (cx < 0) {
            throw new IllegalArgumentException("cx is less than zero");
        }
        if (cx >= this.width) {
            throw new IllegalArgumentException("cx is too large");
        }
        if (cy < 0) {
            throw new IllegalArgumentException("cy is less than zero");
        }
        if (cy >= this.height) {
            throw new IllegalArgumentException("cy is too large");
        }
        if (radius <= 0) {
            throw new IllegalArgumentException("radius is less than or equal to zero");
        }
        if (p == null) {
            throw new IllegalArgumentException("need to specify pixel");
        }
        for (int i = 0; i < this.immutableArr.length; i++) {
            for (int j = 0; j < this.immutableArr[0].length; j++) {
                double distance = Math.sqrt((i - cx) * (i - cx) + (j - cy) * (j - cy));
                if (distance <= radius) {
                    this.immutableArr[i][j] = p;
                }
            }
        }
        return this;
    }

    @Override
    public Picture paint(int cx, int cy, double radius, Pixel p, double factor) {
        if (cx < 0) {
            throw new IllegalArgumentException("cx is less than zero");
        }
        if (cx >= this.width) {
            throw new IllegalArgumentException("cx is too large");
        }
        if (cy < 0) {
            throw new IllegalArgumentException("cy is less than zero");
        }
        if (cy >= this.height) {
            throw new IllegalArgumentException("cy is too large");
        }
        if (radius <= 0) {
            throw new IllegalArgumentException("radius is less than or equal to zero");
        }
        if (p == null) {
            throw new IllegalArgumentException("need to specify pixel");
        }
        if (factor < 0) {
            throw new IllegalArgumentException("factor value less than zero");
        }
        if (factor > 1) {
            throw new IllegalArgumentException("factor value greater than one");
        }
        for (int i = 0; i < this.immutableArr.length; i++) {
            for (int j = 0; j < this.immutableArr[0].length; j++) {
                double distance = Math.sqrt((i - cx) * (i - cx) + (j - cy) * (j - cy));
                if (distance <= radius) {
                    this.immutableArr[i][j] = p.blend(p, factor);
                }
            }
        }
        return this;
    }

}