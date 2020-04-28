package gfx;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ImageLoader {


    public static BufferedImage loadImage(String imageURL){
        try {
            //Return buffered image object
            return ImageIO.read(ImageLoader.class.getResource(imageURL));
        } catch (IOException e) {
            e.printStackTrace();

            System.exit(1);
        }
        return null;
    }
}
