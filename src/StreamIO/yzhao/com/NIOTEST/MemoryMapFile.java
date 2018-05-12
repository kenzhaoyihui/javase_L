package StreamIO.yzhao.com.NIOTEST;

import java.io.FileInputStream;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class MemoryMapFile {
    public static void main(String[] args) throws Exception{
        FileInputStream fis = new FileInputStream("test1.txt");
        FileChannel fc = fis.getChannel();  // get the file object channel

        long startRegion = 0;
        long endRegion = fc.size();

        MappedByteBuffer mbb = fc.map(FileChannel.MapMode.READ_ONLY, startRegion, endRegion); // create the memeory map file region
        while (mbb.hasRemaining()){
            System.out.print((char) mbb.get());   // get the data from the region
        }


    }
}
