package a4;

public class HorizontalStackPicture implements Picture {

    private int width;
    private int height;
    private Pixel[][] horizontalArr;

    public HorizontalStackPicture(Picture left, Picture right) {
        this.width = left.getWidth() + right.getWidth();
        this.height = left.getHeight();
        this.horizontalArr = new Pixel[this.width][this.height];

    }

    @Override
    public int getWidth() {
        // TODO Auto-generated method stub
        return this.width;
    }

    @Override
    public int getHeight() {
        // TODO Auto-generated method stub
        return this.height;
    }

    @Override
    public Pixel getPixel(int x, int y) {
        // TODO Auto-generated method stub
        return this.horizontalArr[x][y];
    }

    @Override
    public Picture paint(int x, int y, Pixel p) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Picture paint(int x, int y, Pixel p, double factor) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Picture paint(int ax, int ay, int bx, int by, Pixel p) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Picture paint(int ax, int ay, int bx, int by, Pixel p, double factor) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Picture paint(int cx, int cy, double radius, Pixel p) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Picture paint(int cx, int cy, double radius, Pixel p, double factor) {
        // TODO Auto-generated method stub
        return null;
    }

}