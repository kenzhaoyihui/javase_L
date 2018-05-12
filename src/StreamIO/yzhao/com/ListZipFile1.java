package StreamIO.yzhao.com;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.stream.Stream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class ListZipFile1 {
//    public static void main(String[] args) throws Exception {
//        ZipFile zf = new ZipFile("ziptest.zip");
//
//        // Get the enumeration for all zip entries and loop through them
//        Enumeration<? extends ZipEntry> e = zf.entries();
//        ZipEntry entry = null;
//
//        while (e.hasMoreElements()) {
//            entry = e.nextElement();
//
//            // Get the input stream for the current zip entry
//            InputStream is = zf.getInputStream(entry);
//
//            /* Read data for the entry using the is object */
//
//            // Print the name of the entry
//            System.out.println(entry.getName());
//        }
//
//    }

    public static void main(String[] args) throws Exception {
        ZipFile zf = new ZipFile("ziptest.zip");

        Stream<? extends ZipEntry> entryStream = zf.stream();
        entryStream.forEach(entry -> {
            try {
                // Get the input stream for the current zip entry
                InputStream is = zf.getInputStream(entry);
                System.out.println(entry.getName());
            } catch (IOException e) {
                e.printStackTrace();
            }

        });
    }
}
