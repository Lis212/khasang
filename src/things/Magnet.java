package things;

/**
 * Created by Администратор on 10.01.2018.
 */
public class Magnet extends Thing{
    private String origin;

    Magnet(){
    }

//    Magnet(String origin){
//        this.origin = origin;
//    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    @Override
    public String toString() {
        return super.toString() + "Магнит из " + origin;
    }
}
