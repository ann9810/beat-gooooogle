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
		
		WebPage rootPageZARA = new WebPage("https://www.zara.com/tw/zt/woman-l1000.html?v1=791035", "ZARA");
		WebTree treeZARA = new WebTree(rootPageZARA);
		
		WebPage rootPageHM = new WebPage("https://www2.hm.com/zh_asia3/index.html", "H&M");
		WebTree treeHM = new WebTree(rootPageHM);
		
		WebPage rootPageOB = new WebPage("https://www.obdesign.com.tw/", "OB");
		WebTree treeOB = new WebTree(rootPageOB);
		
		WebPage rootPageBuerberry = new WebPage("https://tw.burberry.com/", "Burberry");
		WebTree treeBurberry = new WebTree(rootPageBurberry);
		
		
		
		tree.root.addChild(new WebNode(new WebPage("http://soslab.nccu.edu.tw/Welcome.html", "Project")));
		tree.root.addChild(new WebNode(new WebPage("http://soslab.nccu.edu.tw/Publications.html", "Publication")));
		tree.root.children.get(1).addChild(new WebNode(new WebPage("https://scholar.google.com/citations?user=IpxUy-YAAAAJ&hl=en", "Google scholar")));
		tree.root.children.get(1).addChild(new WebNode(new WebPage("https://dblp.uni-trier.de/pers/hd/y/Yu:Fang.html", "DBLP")));
		tree.root.addChild(new WebNode(new WebPage("http://soslab.nccu.edu.tw/Members.html", "Member")));
		tree.root.addChild(new WebNode(new WebPage("http://soslab.nccu.edu.tw/Courses.html", "Course")));

		
		while(sc.hasNextLine()) {
			ArrayList <Keyword> keywords = new ArrayList<>();
			String name = sc.next();
				Keyword k = new Keyword(name);
				keywords.add(k);
				tree.setPostOrderScore(keywords);
			}
			sc.close();
		}
	}
