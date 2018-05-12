package StreamIO.yzhao.com.NIOTEST;

import java.nio.ByteBuffer;
import java.nio.InvalidMarkException;

public class bufferio1 {
    public static void main(String[] args){
        ByteBuffer bb = ByteBuffer.allocate(10);

        System.out.println("Capacity: "+ bb.capacity());
        System.out.println("Limit: " + bb.limit());
        System.out.println("Position: " + bb.position());
        System.out.println("Mark: " + bb.mark());

        try{
            bb.reset();
            System.out.println("Mark: " + bb.position());
        }catch (InvalidMarkException e){
            System.out.println("Mark is not set");
        }
    }
}
