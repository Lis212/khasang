package things;

/**
 * Created by Администратор on 10.01.2018.
 */
public class Clothes extends Thing{
    private int size;

    Clothes(){
    }

//    Clothes(int size){
//        this.size = size;
//    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return super.toString() + "Одежда размером: " + size;
    }
}
