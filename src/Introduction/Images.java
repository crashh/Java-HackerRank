package Introduction;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class Images {

    public static void main(String[] args) {
        BufferedImage jpgImage = LoadImageFromDisk("Introduction/Resources/image.jpg");
        BufferedImage pngImage = LoadImageFromDisk("Introduction/Resources/image.png");

        Image scaledJpgImage = jpgImage.getScaledInstance(557/2, 78/2, Image.SCALE_SMOOTH);
        SaveImageFromDisk(scaledJpgImage, "Introduction/Resources/image_scaled.jpg", "jpg");

        Image scaledPngImage1 = pngImage.getScaledInstance(530, 70, Image.SCALE_SMOOTH);
        SaveImageFromDisk(scaledPngImage1, "Introduction/Resources/image_scaled.png", "png");
    }

    private static BufferedImage LoadImageFromDisk(String s) {
        URL imagePath = Images.class.getClassLoader().getResource(s);

        BufferedImage img = null;
        try {
            img = ImageIO.read(new File(imagePath != null ? imagePath.getPath() : s));
        } catch (IOException e) {
            System.out.println(String.format("Failed to load image at '%s' %s", imagePath, System.lineSeparator() + e));
    }
        return img;
    }

    private static void SaveImageFromDisk(Image img, String s, String fileType) {
        URL imagePath = Images.class.getProtectionDomain().getCodeSource().getLocation();

        BufferedImage bufferedImage = new BufferedImage(img.getWidth(null), img.getHeight(null),
                BufferedImage.TYPE_INT_RGB);
        Graphics g = bufferedImage.getGraphics();
        g.drawImage(img, 0, 0, null);
        g.dispose();

        try {
            ImageIO.write(bufferedImage, fileType, new File(imagePath.getPath() + s));
        } catch (IOException e) {
            System.out.println(String.format("Failed to write image at '%s' %s", s, System.lineSeparator() + e));
        }
    }
}
