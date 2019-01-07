import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.plaf.basic.BasicTreeUI.TreeCancelEditingAction;


public class Main {

	public static void main(String[] args) throws IOException{
		
		
		Scanner sc = new Scanner(System.in);
		WordCounter wordcounter = new WordCounter();
		String kword = sc.next();
		ArrayList<Integer> c = wordcounter.countKeyword(kword);
		System.out.print(c);
		
		WebPage rootPageZARA = new WebPage("https://www.zara.com/tw/zt/woman-l1000.html?v1=791035", "ZARA");
		WebTree treeZARA = new WebTree(rootPageZARA);
		
		WebPage rootPageHM = new WebPage("https://www2.hm.com/zh_asia3/index.html", "H&M");
		WebTree treeHM = new WebTree(rootPageHM);
		
		//WebPage rootPageOB = new WebPage("https://www.obdesign.com.tw/", "OB");
		//WebTree treeOB = new WebTree(rootPageOB);
		
		WebPage rootPageBurberry = new WebPage("https://tw.burberry.com/", "Burberry");
		WebTree treeBurberry = new WebTree(rootPageBurberry);
		
		
		
		treeBurberry.root.addChild(new WebNode(new WebPage("https://tw.burberry.com/women/", "女")));
		treeBurberry.root.children.get(0).addChild(new WebNode(new WebPage("https://tw.burberry.com/womens-coats-jackets/", "所有大衣及外套")));
		
		treeHM.root.addChild(new WebNode(new WebPage("https://www2.hm.com/zh_asia3/ladies.html", "女")));
		treeHM.root.children.get(0).addChild(new WebNode(new WebPage("https://www2.hm.com/zh_asia3/ladies/shop-by-product/jackets-and-coats.html?product-type=ladies_jacketscoats&sort=stock&image-size=small&image=model&offset=0&page-size=540", 
				"大衣")));
		treeHM.root.children.get(0).addChild(new WebNode(new WebPage("https://www2.hm.com/zh_asia3/ladies/shop-by-product/blazers-and-waistcoats/blazers.html?sort=stock&image-size=small&image=model&offset=0&page-size=144", 
				"西裝外套")));
		
		

		treeZARA.root.addChild(new WebNode(new WebPage("https://www.zara.com/tw/zt/woman-l1000.html?v1=791035", "女")));
		treeZARA.root.children.get(0).addChild(new WebNode(new WebPage("https://www.zara.com/tw/zt/woman-outerwear-l1184.html?v1=1179522", "大衣")));
		treeZARA.root.children.get(0).addChild(new WebNode(new WebPage("https://www.zara.com/tw/zt/woman-jackets-l1114.html?v1=1178995", "夾克外套")));
		treeZARA.root.children.get(0).addChild(new WebNode(new WebPage("https://www.zara.com/tw/zt/woman-blazers-l1055.html", "西裝外套")));
		
		//treeOB.root.addChild(new WebNode(new WebPage("https://www.obdesign.com.tw/inpage.aspx?no=6964", "女")));
		//treeOB.root.children.get(0).addChild(new WebNode(new WebPage("https://www.obdesign.com.tw/inpage.aspx?no=7001", 
				//"外套")));
		
		
		

		
		while(sc.hasNextLine()) {
			ArrayList <Keyword> keywords = new ArrayList<>();
			String name = sc.next();
				Keyword k = new Keyword(name);
				keywords.add(k);
				treeBurberry.setPostOrderScore(keywords);
				treeHM.setPostOrderScore(keywords);
				treeZARA.setPostOrderScore(keywords);
				//treeOB.setPostOrderScore(keywords);
			}
			sc.close();
		}
	}
