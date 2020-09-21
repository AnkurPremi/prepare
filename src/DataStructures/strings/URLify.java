package DataStructures.strings;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

public class URLify {
    public static void main(String[] args) {
        String FILE_URL = "https://cp292878-vh.akamaihd.net/i/32/3a/323af3ef-befc-41e7-85a2-1d2f2b6c462a/FF-2014-00000681_,100,400,750,1000,1600,3000,6500,k.mp4.csmil/segment7_6_av.ts?null=0&hdntl=exp=1586577340~acl=/i/32/3a/323af3ef-befc-41e7-85a2-1d2f2b6c462a/";
        String FILE_URL1 = "*~data=hdntl~hmac=2dcd4ef120a1b06b25d80cf044f91ef34498d4737ab752046c59c05caf3e0eeb";
        String FILE_NAME = "/home/invincible/abc.ts";
        try {
            downloadFile(new URL(FILE_URL+FILE_URL1), FILE_NAME);

        }catch (Exception e){
            e.printStackTrace();
        }
        try (BufferedInputStream in = new BufferedInputStream(new URL(FILE_URL).openStream());
             FileOutputStream fileOutputStream = new FileOutputStream(FILE_NAME)) {
            byte dataBuffer[] = new byte[1024];
            int bytesRead;
            while ((bytesRead = in.read(dataBuffer, 0, 1024)) != -1) {
                fileOutputStream.write(dataBuffer, 0, bytesRead);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void downloadFile(URL url, String outputFileName) throws IOException {
        try(InputStream in = url.openStream();
            ReadableByteChannel rbc = Channels.newChannel(in);
            FileOutputStream fos = new FileOutputStream(outputFileName))
        {
            fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
        }
    }
}


