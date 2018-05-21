package transient1;

import java.io.Externalizable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

/**
 * @descripiton Externalizable
 *
 * @author yzhao
 * @date 2018-05-21
 *
 */
public class transient2 implements Externalizable {

    private transient String content = "是的，我将会被序列化，不管我是否被transient关键字修饰";
    private transient String content1 = "hhahaha";

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(content1);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException,
            ClassNotFoundException {
        content = (String) in.readObject();
    }

    public static void main(String[] args) throws Exception {

        transient2 et = new transient2();
        ObjectOutput out = new ObjectOutputStream(new FileOutputStream(
                new File("test")));
        out.writeObject(et);

        ObjectInput in = new ObjectInputStream(new FileInputStream(new File(
                "test")));
        et = (transient2) in.readObject();
        System.out.println(et.content);

        out.close();
        in.close();
    }
}
