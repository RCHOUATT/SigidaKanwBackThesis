/*
package Sigida_Kanw.Memoire.Model;

import org.springframework.web.multipart.MultipartFile;
import java.io.*;

public class ByteArrayMultipartFile implements MultipartFile {

    private final byte[] fileContent;
    private final String fileName;

    public ByteArrayMultipartFile(byte[] fileContent, String fileName) {
        this.fileContent = fileContent;
        this.fileName = fileName;
    }

    @Override
    public String getName() {
        return fileName;
    }

    @Override
    public String getOriginalFilename() {
        return fileName;
    }

    @Override
    public String getContentType() {
        // Vous pouvez définir le type MIME approprié ici, comme "image/png"
        return "image/png";
    }

    @Override
    public boolean isEmpty() {
        return fileContent == null || fileContent.length == 0;
    }

    @Override
    public long getSize() {
        return fileContent.length;
    }

    @Override
    public byte[] getBytes() throws IOException {
        return fileContent;
    }

    @Override
    public InputStream getInputStream() throws IOException {
        return new ByteArrayInputStream(fileContent);
    }

    @Override
    public void transferTo(File dest) throws IOException, IllegalStateException {
        try (FileOutputStream out = new FileOutputStream(dest)) {
            out.write(fileContent);
        }
    }
}
*/
