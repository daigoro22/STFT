package sample;

import javafx.scene.image.ImageView;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

/**
 * Created by abedaigorou on 16/04/10.
 */
public class spectrumAnl
{
    private int length;
    private int width[];
    private int height[];
    private final int offset=2;
    private WritableImage writableImage;
    private PixelWriter pixelWriter;
    //private ImageView image=new ImageView(new Image("http://cdn-ak.f.st-hatena.com/images/fotolife/G/Grano/20151104/20151104015247.jpg"));
    private ImageView image;

    public spectrumAnl(int length,int imageWidth,int imageHeight)
    {
        this.length=length;
        width=new int[length];
        height=new int[length];
        writableImage=new WritableImage(imageWidth,imageHeight);
        pixelWriter=writableImage.getPixelWriter();
        image=new ImageView(writableImage);
    }

    public ImageView getImage(Double[] data)
    {
        for(int i=0;i<height.length;i++)
            height[i]=data[i].intValue();

        for(int x=0;x<length;x++) {
            for (int y = 0; y < height[y]; y++)
                pixelWriter.setColor(x, y, Color.RED);
        }

        return image;
    }
}
