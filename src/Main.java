import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.plaf.basic.BasicTreeUI.TreeCancelEditingAction;


public class Main {

	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		
		ArrayList<Integer> countListZARA;
		ArrayList<Integer> countListBurberry;
		ArrayList<Integer> countListGenquo;
		
		WordCount wordcountZARA = new WordCount("https://www.zara.com/tw/zt/woman-l1000.html?v1=791035");
		WordCount wordcountGenquo = new WordCount("https://www.genquo.com/");
		WordCount wordcountBurberry = new WordCount("https://tw.burberry.com/");
		
		WebPage rootPageZARA = new WebPage("https://www.zara.com/tw/zt/woman-l1000.html?v1=791035", "ZARA");
		WebTree treeZARA = new WebTree(rootPageZARA);
		
		WebPage rootPageGenquo = new WebPage("https://www.genquo.com/", "Genquo");
		WebTree treeGenquo = new WebTree(rootPageGenquo);
		
		WebPage rootPageBurberry = new WebPage("https://tw.burberry.com/", "Burberry");
		WebTree treeBurberry = new WebTree(rootPageBurberry);
		
		treeBurberry.root.addChild(new WebNode(new WebPage("https://tw.burberry.com/women/", "女")));
		treeBurberry.root.children.get(0).addChild(new WebNode(new WebPage("https://tw.burberry.com/womens-coats-jackets/", "所有大衣及外套")));
		
		treeGenquo.root.addChild(new WebNode(new WebPage("https://www.genquo.com/WOMEN", "女")));
		treeGenquo.root.children.get(0).addChild(new WebNode(new WebPage("https://www.genquo.com/WOMEN/TOP/JACKET", "外套")));
		
		treeZARA.root.addChild(new WebNode(new WebPage("https://www.zara.com/tw/zt/woman-l1000.html?v1=791035", "女")));
		treeZARA.root.children.get(0).addChild(new WebNode(new WebPage("https://www.zara.com/tw/zt/woman-outerwear-l1184.html?v1=1179522", "大衣")));
		treeZARA.root.children.get(0).addChild(new WebNode(new WebPage("https://www.zara.com/tw/zt/woman-jackets-l1114.html?v1=1178995", "夾克外套")));
		treeZARA.root.children.get(0).addChild(new WebNode(new WebPage("https://www.zara.com/tw/zt/woman-blazers-l1055.html", "西裝外套")));
		
		while(sc.hasNextLine()) {
			String name = sc.nextLine();
			
			System.out.print("zara");
			countListZARA = wordcountZARA.countKeyword(name);
			System.out.println();
			treeZARA.setPostOrderScore(name);
			
			System.out.print("burberry");
			countListBurberry = wordcountBurberry.countKeyword(name);
			System.out.println();
			treeBurberry.setPostOrderScore(name);
			
			System.out.print("genquo");
			countListGenquo = wordcountGenquo.countKeyword(name);
			System.out.println();
			treeGenquo.setPostOrderScore(name);
			}
			sc.close();
			
		//QuickSort rank = new QuickSort(scoreRank, 0, scoreRank.size());
		}
	}
