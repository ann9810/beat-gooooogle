import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.plaf.basic.BasicTreeUI.TreeCancelEditingAction;


public class Main {

	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		
		WordCount wordcountZARA = new WordCount("https://www.zara.com/tw/zt/woman-l1000.html?v1=791035");
		WordCount wordcountHM = new WordCount("https://www2.hm.com/zh_asia3/ladies.html");
		WordCount wordcountBurberry = new WordCount("https://tw.burberry.com/");
		
		WebPage rootPageZARA = new WebPage("https://www.zara.com/tw/zt/woman-l1000.html?v1=791035", "ZARA");
		WebTree treeZARA = new WebTree(rootPageZARA);
		
		WebPage rootPageHM = new WebPage("https://www2.hm.com/zh_asia3/index.html", "H&M");
		WebTree treeHM = new WebTree(rootPageHM);
		
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
	
		while(sc.hasNextLine()) {
			String name = sc.nextLine();
			
				wordcountZARA.splitKeywordStr(name);
				wordcountHM.splitKeywordStr(name);
				wordcountBurberry.splitKeywordStr(name);
				
				wordcountZARA.countKeyword(name);
				wordcountHM.countKeyword(name);
				wordcountBurberry.countKeyword(name);
				
				rootPageZARA.setScore(wordcountZARA.splitKeywordStr(name));
			}
			sc.close();
			
		}
	}
