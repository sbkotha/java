package patterns.creational.prototype;

public class TestProtoType {
    public static void main(String[] args) {
        SongLibrary sl = new SongLibrary("My Favorites");
        System.out.println(sl);
        System.out.println(System.identityHashCode(sl));
        SongLibrary sl2 = (SongLibrary) CloneFactory.getInstance().makeCopy(sl);
        sl2.setName("New Favourites");
        System.out.println(sl2);
        System.out.println(System.identityHashCode(sl2));
    }
}
