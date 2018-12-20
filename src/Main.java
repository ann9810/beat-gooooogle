import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.plaf.basic.BasicTreeUI.TreeCancelEditingAction;


public class Main {

	public static void main(String[] args) throws IOException{
		
		
		WebPage rootPage = new WebPage( " https://www.zara.com/tw/zt/woman-l1000.html?v1=756566", "Zara" );
		WebTree tree = new WebTree(rootPage);
		tree.root.addChild(new WebNode(new WebPage("https://www.zara.com/tw/zt/woman-outerwear-l1184.html?v1=1074615","大衣")));
		tree.root.addChild(new WebNode(new WebPage("https://www.zara.com/tw/zt/woman-l1000.html","女士")));
		
		
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
