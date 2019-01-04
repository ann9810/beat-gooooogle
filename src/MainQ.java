import java.io.IOException;
import java.util.Scanner;
public class MainQ {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextLine()) {
			String keyword = sc.next();
			GoogleQuery googleQuery = new GoogleQuery();
			googleQuery.query();
			}
		sc.close();

	}
	
}
