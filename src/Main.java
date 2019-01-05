import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.plaf.basic.BasicTreeUI.TreeCancelEditingAction;


public class Main {

	public static void main(String[] args) throws IOException{
		
		
		Scanner sc = new Scanner(System.in);
		WordCounter wordcounter = new WordCounter();
		String kword = sc.next();
		int c = wordcounter.countKeyword(kword);
		System.out.print(c);
		
		WebPage rootPage = new WebPage("http://soslab.nccu.edu.tw/Welcome.html", "Welcome");
		WebTree tree = new WebTree(rootPage);
		
		tree.root.addChild(new WebNode(new WebPage("http://soslab.nccu.edu.tw/Welcome.html", "Project")));
		tree.root.addChild(new WebNode(new WebPage("http://soslab.nccu.edu.tw/Publications.html", "Publication")));
		tree.root.children.get(1).addChild(new WebNode(new WebPage("https://scholar.google.com/citations?user=IpxUy-YAAAAJ&hl=en", "Google scholar")));
		tree.root.children.get(1).addChild(new WebNode(new WebPage("https://dblp.uni-trier.de/pers/hd/y/Yu:Fang.html", "DBLP")));
		tree.root.addChild(new WebNode(new WebPage("http://soslab.nccu.edu.tw/Members.html", "Member")));
		tree.root.addChild(new WebNode(new WebPage("http://soslab.nccu.edu.tw/Courses.html", "Course")));

		
		while(sc.hasNextLine()) {
			//把輸進來的關鍵字存進keywords
			ArrayList <Keyword> keywords = new ArrayList<>();
			String name = sc.next();
				Keyword k = new Keyword(name);
				keywords.add(k);
				tree.setPostOrderScore(keywords);
			}
			sc.close();
		}
	}
