import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.*;

public class SingleThreadApp {

    public static void main(String[] args) throws FileNotFoundException, InterruptedException, ExecutionException {

        File dictionary = new File("crackstation-human-only.txt");

        FileReader reader = new FileReader(dictionary);

        Scanner sc = new Scanner(reader);

        ExecutorService service = Executors.newSingleThreadExecutor();

        List<String> passwords = new ArrayList<>();

        int i = 1;

        CopyOnWriteArrayList<String> foundedPasswords = new CopyOnWriteArrayList<>();

        while (sc.hasNextLine()){

            passwords.add(sc.nextLine());

            if(i >= 100000){
                Callable<String> passwordBruteTask = new PasswordBruteTask(
                        passwords,
                        "42771e944e5f5833b08f85aed8a0561b9c6ba478ba37508b72b15cc3a08370612d4ee652974298e21c63f08cf87117f892d6e63abaad5e9630bd21b7c710d8d2",
                        foundedPasswords
                );


            }

            i++;
        }
    }

}
