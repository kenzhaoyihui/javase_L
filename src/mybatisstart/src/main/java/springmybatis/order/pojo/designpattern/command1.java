package springmybatis.order.pojo.designpattern;

import java.util.ArrayList;
import java.util.List;

interface Command{
    void execute();
}

class MouseCursor{
    private int x = 10;
    private int y = 10;

    public void move(){
        System.out.println("Old Position: " + x + ":" + y);
        x++;
        y++;
        System.out.println("New Position: " + x + ":" + y);
    }

    public void reset(){
        System.out.println("reset");
        x = 10;
        y = 10;
    }
}

class MoveCursor implements Command{
    private MouseCursor abcStock;

    public MoveCursor(MouseCursor abcStock){
        this.abcStock = abcStock;
    }

    public void execute() {
        abcStock.move();
    }
}


class ResetCursor implements Command{
    private MouseCursor abcStock;

    public ResetCursor(MouseCursor abcStock){
        this.abcStock = abcStock;
    }

    public void execute() {
        abcStock.reset();
    }
}



class MouseCommands{
    private List<Command> orderList = new ArrayList<Command>();

    public void takeOrder(Command order){
        orderList.add(order);
    }

    public void placeOrders(){
        for(Command order: orderList){
            order.execute();
        }

        orderList.clear();
    }
}
public class command1 {
    public static void main(String[] args){
        MouseCursor cursor = new MouseCursor();
        MoveCursor moveCursor = new MoveCursor(cursor);
        ResetCursor resetCursor = new ResetCursor(cursor);

        MouseCommands commands = new MouseCommands();
        commands.takeOrder(moveCursor);
        commands.takeOrder(resetCursor);

        commands.placeOrders();

    }
}
