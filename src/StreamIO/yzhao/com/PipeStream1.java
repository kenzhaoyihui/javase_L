package StreamIO.yzhao.com;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class PipeStream1 {
    public static void main(String[] args) throws IOException{
        PipedInputStream in = new PipedInputStream();
        PipedOutputStream out = new PipedOutputStream();

        out.connect(in);

        Runnable producer = () -> produceData(out);
        Runnable consumer = () -> consumeData(in);

        new Thread(producer).start();
        new Thread(consumer).start();
    }

    // "Synchronized" Confirm the thread that write first finished and read later
    public static synchronized void produceData(PipedOutputStream out){
        try{
            for(int i=0; i<10;i++){
                out.write((byte) i);
                out.flush();
                System.out.println("Writeing: " + i);
                Thread.sleep(1000);
            }
            out.close();
        }catch (IOException | InterruptedException e){
            e.printStackTrace();
        }
    }

    public static synchronized void consumeData(PipedInputStream in){
        try{
            int num = -1;
            while((num = in.read()) != -1){
                System.out.println("Reading: " + num);
                Thread.sleep(1000);
            }
            in.close();
        }catch (IOException | InterruptedException e){
            e.printStackTrace();
        }
    }
}
