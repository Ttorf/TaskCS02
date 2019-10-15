import java.io.File;

public class SearchAllLocalDisc {
    public void search() {

        for (File f : File.listRoots()) {
            List.list(f.getPath());
        }
    }
}
