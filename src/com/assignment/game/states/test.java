import java.io.File;
import java.io.FileNotFoundException;

public class test{
    public static void main(String[] args){
        if(!new File("../../../bluePlus.png").exists()){
           System.out.println("Yikes!");
        }else{
            System.out.println("Found it!");
        }

        String path = new File(".").getCanonicalPath();
    }
}