package StreamIO.yzhao.com;

//import java.io.*;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.Deflater;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class CreateZipFile1 {
    public static void main(String[] args){
        String zipFilename = "ziptest8.zip";
        String[] entries = new String[2];
        entries[0] = "test1.txt";
        entries[1] = "test2.txt";

        zip(zipFilename, entries);
    }

    public static void zip(String zipFilename, String[] entries){

        //**try-with-resource
        try(ZipOutputStream zos = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(zipFilename)))){
            //FileOutputStream fileOutputStream = new FileOutputStream(zipFilename);
            //BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
            //ZipOutputStream zos = new ZipOutputStream(bufferedOutputStream);
            zos.setLevel(Deflater.BEST_COMPRESSION);

            for (int i=0; i<entries.length; i++){
                File entryfile = new File(entries[i]);
                if (!entryfile.exists()){
                    System.out.println("The entry file is not exists");
                    System.out.println("Arorted processing...");
                    return;
                }

                ZipEntry ze = new ZipEntry(entries[i]);
                zos.putNextEntry(ze);
                addEntryContent(zos, entries[i]);
                zos.closeEntry();
            }

        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void addEntryContent(ZipOutputStream zos, String entryfileName) throws IOException, FileNotFoundException{
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(entryfileName));
        byte[] buffer = new byte[1024];
        int count = -1;
        while((count = bis.read(buffer)) != -1){
            zos.write(buffer, 0, count);
        }
        bis.close();
    }
}


//import java.io.BufferedInputStream;
//import java.io.BufferedOutputStream;
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.util.zip.Deflater;
//import java.util.zip.ZipEntry;
//import java.util.zip.ZipOutputStream;
//
//public class CreateZipFile1 {
//    public static void main(String[] args) {
//        String zipFileName = "ziptest2.zip";
//        String[] entries = new String[2];
//        entries[0] = "test1.txt";
//        entries[1] = "test2.txt";
//        //entries[1] = "notes" + File.separator + "test2.txt";
//        zip(zipFileName, entries);
//    }
//
//    public static void zip(String zipFileName, String[] zipEntries) {
//
//        try (ZipOutputStream zos = new ZipOutputStream(new BufferedOutputStream(
//                new FileOutputStream(zipFileName)))) {
//
//            // Set the compression level to best compression
//            zos.setLevel(Deflater.BEST_COMPRESSION);
//
//            for (int i = 0; i < zipEntries.length; i++) {
//                File entryFile = new File(zipEntries[i]);
//                if (!entryFile.exists()) {
//                    System.out.println("The entry file  " + entryFile.getAbsolutePath()
//                            + "  does  not  exist");
//                    System.out.println("Aborted   processing.");
//                    return;
//                }
//                ZipEntry ze = new ZipEntry(zipEntries[i]);
//                zos.putNextEntry(ze);
//                addEntryContent(zos, zipEntries[i]);
//                zos.closeEntry();
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static void addEntryContent(ZipOutputStream zos, String entryFileName)
//            throws IOException, FileNotFoundException {
//        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(
//                entryFileName));
//
//        byte[] buffer = new byte[1024];
//        int count = -1;
//        while ((count = bis.read(buffer)) != -1) {
//            zos.write(buffer, 0, count);
//        }
//        bis.close();
//    }
//}