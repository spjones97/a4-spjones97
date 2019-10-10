package a4;

public class VerticalStackPicture implements Picture {

    private int width;
    private int height;
    private Pixel[][] verticalArr;

    public VerticalStackPicture(Picture top, Picture bottom) {
        this.width = top.getWidth();
        this.height = top.getHeight() + bottom.getHeight();
        this.verticalArr = new Pixel[this.width][this.height];

        // Add top picture
        for (int i = 0; i < this.width; i++) {
            for (int j = 0; j < top.getHeight(); j++) {
                this.verticalArr[i][j] = top.getPixel(i, j);
            }
        }

        // Add bottom picture
        for (int i = 0; i < this.width; i++) {
            for (int j = top.getHeight(); j < (top.getHeight() + bottom.getHeight()); j++) {
                this.verticalArr[i][j] = bottom.getPixel(i, j);
            }
        }
    }

    @Override
    public int getWidth() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int getHeight() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public Pixel getPixel(int x, int y) {
        // TODO Auto-generated method stub
        return null;
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