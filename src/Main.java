import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {

	public static void main(String[] args) throws IOException{
		
		
		WebPage rootPage = new WebPage( " https://www.zara.com/tw/zt/woman-l1000.html?v1=756566", "Zara" );
		
		WebTree tree = new WebTree(rootPage);
		
		
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextLine()) {
			int numOfKeywords = sc.nextInt();
			ArrayList<Keyword> keywords = new ArrayList<>();
			
			for(int i=0; i<numOfKeywords; i++) {
				String name =  sc.next();
				double weight = sc.nextDouble();
				int count = sc.nextInt();
				Keyword k = new Keyword(name, count, weight);
				keywords.add(k);
			}
			
			tree.setPostOrderScore(keywords);
			tree.printTree();
		}
	}

}
