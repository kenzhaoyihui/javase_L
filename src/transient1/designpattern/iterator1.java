package transient1.designpattern;

interface Iterator {
    public boolean hasNext();
    public Object next();
}
class LetterBag {
    public String names[] = {"R" , "J" ,"A" , "L"};
    public Iterator getIterator() {
        return new NameIterator();
    }
    class NameIterator implements Iterator {
        int index;
        //@Override
        public boolean hasNext() {
            if(index < names.length){
                return true;
            }
            return false;
        }
        //@Override
        public Object next() {
            if(this.hasNext()){
                return names[index++];
            }
            return null;
        }
    }
}
public class iterator1 {
    public static void main(String[] args) {
        LetterBag bag = new LetterBag();
        for(Iterator iter = bag.getIterator(); iter.hasNext();){
            String name = (String)iter.next();
            System.out.println("Name : " + name);
        }
    }
}