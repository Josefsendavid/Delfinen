package Main;

import datasource.*;
import model.*;

public class DelfinenMain {

    public static void main(String[] args) {
        Datasource datasource = new DBMapper();
        new MySystem(datasource).runDelfinen();
    }
}
