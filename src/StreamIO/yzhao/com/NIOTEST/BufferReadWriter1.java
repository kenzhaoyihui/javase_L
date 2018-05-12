package StreamIO.yzhao.com.NIOTEST;

import java.nio.ByteBuffer;

public class BufferReadWriter1 {
    public static void main(String[] args) {
        ByteBuffer bb = ByteBuffer.allocate(20);
        printBufferInfo(bb);

        // Use flip() to reset the position to zero because
        // the printBufferInfo() method uses relative get() method
        bb.flip();

        int i = 50;
        while (bb.hasRemaining()) {
            bb.put((byte) i++);
        }

        // Call flip() again to reset the position to zero,
        // because the above put() call incremented the position
        bb.flip();
        printBufferInfo(bb);
    }

    public static void printBufferInfo(ByteBuffer bb) {
        int limit = bb.limit();
        System.out.println("Position =  " + bb.position() + ", Limit   = " + limit);
        while (bb.hasRemaining()) {
            System.out.print(bb.get() + "  ");
        }
        System.out.println();
    }
}
