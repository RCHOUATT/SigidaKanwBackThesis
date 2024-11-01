package Sigida_Kanw.Memoire.Service.Notification;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

@Service
@AllArgsConstructor
public class CovertImageToByte {

    public static byte[] convertImageToBytes(InputStream inputStream) throws IOException {
        BufferedImage image = ImageIO.read(inputStream);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(image, "png", baos);
        return baos.toByteArray();
    }
}
