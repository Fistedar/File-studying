import java.io.*;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args){
        StringBuilder sb = new StringBuilder();
        createDir("C://Games", "src", sb);
        createDir("C://Games//src", "main", sb);
        createFiles("C://Games//src//main//Main.java", sb);
        createFiles("C://Games//src//main//Utils.java", sb);
        createDir("C://Games//src", "test", sb);
        createDir("C://Games", "res", sb);
        createDir("C://Games//res", "drawables", sb);
        createDir("C://Games//res", "vectors", sb);
        createDir("C://Games//res", "icon", sb);
        createDir("C://Games", "savegames", sb);
        createDir("C://Games", "temp", sb);
        createFiles("C://Games//temp//temp.txt", sb);
        try (FileWriter file  = new FileWriter("C://Games//temp//temp.txt")){
            file.write(String.valueOf(sb));
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    public static void createDir(String path, String name, StringBuilder sb) {
        File file = new File(path, name);
        if (file.isDirectory()) {
            sb.append(LocalDateTime.now() + "          " + "Каталог:" + name + " не может быть создан по причине,что каталог с таким именем уже существует.\n");
        } else if (file.mkdir()) {
            sb.append(LocalDateTime.now() + "          " + "Каталог:" + name + " был создан.\n");
        } else {
            sb.append("Произошла ошибка\n");
        }
    }

    public static void createFiles(String pathName, StringBuilder sb) {
        File file = new File(pathName);
        try {
            if (file.isFile()) {
                sb.append(LocalDateTime.now() + "          " + "Файл:" + file.getName() + " не может быть создан по причине,что файл с таким именем уже существует.\n");
            } else if (file.createNewFile()) {
                sb.append(LocalDateTime.now() + "          " + "Файл был создан.\n");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
            ;
        }
    }
}