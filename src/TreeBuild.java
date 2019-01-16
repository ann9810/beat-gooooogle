
import java.util.ArrayList;
import java.util.Arrays;

public class TreeBuild {
	String keyword;
	public TreeBuild(String keyword) {
		this.keyword = keyword;
	}
	public String getTree() {
		ArrayList<Integer> countListZARA;
		ArrayList<Integer> countListBurberry;
		ArrayList<Integer> countListGenquo;
		ArrayList<Integer> countListUR;
		ArrayList<Integer> countListHM;
		ArrayList<Integer> countListNET;
		

		
		WordCount wordcountZARA = new WordCount("https://www.zara.com/tw/zt/woman-l1000.html?v1=791035");
		WordCount wordcountGenquo = new WordCount("https://www.genquo.com/");
		WordCount wordcountBurberry = new WordCount("https://tw.burberry.com/");
		WordCount wordcountUrbanResearch = new WordCount("https://www.urban-research.tw");
		WordCount wordcountHM = new WordCount("https://www2.hm.com/zh_asia3/index.html");
		WordCount wordcountNET = new WordCount("https://www.net-fashion.net/");
		
		
		WebPage rootPageZARA = new WebPage("https://www.zara.com/tw/zt/woman-l1000.html?v1=791035", "ZARA");
		WebTree treeZARA = new WebTree(rootPageZARA);
		
		WebPage rootPageGenquo = new WebPage("https://www.genquo.com/", "Genquo");
		WebTree treeGenquo = new WebTree(rootPageGenquo);
		
		WebPage rootPageBurberry = new WebPage("https://tw.burberry.com/", "Burberry");
		WebTree treeBurberry = new WebTree(rootPageBurberry);
		
		WebPage rootPageUbResearch = new WebPage("https://www.urban-research.tw" , "Urban Research");
		WebTree treeUR = new WebTree(rootPageUbResearch);
		
		WebPage rootPageHM = new WebPage("https://www2.hm.com/zh_asia3/index.html", "H&M");
		WebTree treeHM = new WebTree(rootPageHM);
		
		WebPage rootPageNET = new WebPage("https://www.net-fashion.net/", "NET");
		WebTree treeNET = new WebTree(rootPageNET);
		
		treeNET.root.addChild(new WebNode(new WebPage("https://www.net-fashion.net/category/1466", "女裝")));
		treeNET.root.children.get(0).addChild(new WebNode(new WebPage("https://www.net-fashion.net/category/24", "外套大衣")));
		
		treeHM.root.addChild(new WebNode(new WebPage("https://www2.hm.com/zh_asia3/ladies.html", "女裝")));
		treeHM.root.children.get(0).addChild(new WebNode(new WebPage("https://www2.hm.com/zh_asia3/ladies/shop-by-product/jackets-and-coats.html?product-type=ladies_jacketscoats&sort=stock&image-size=small&image=model&offset=0&page-size=504"
				, "夾克及外套")));
		
		treeBurberry.root.addChild(new WebNode(new WebPage("https://tw.burberry.com/women/", "女裝")));
		treeBurberry.root.children.get(0).addChild(new WebNode(new WebPage("https://tw.burberry.com/womens-coats-jackets/", "所有大衣及外套")));
		
		treeGenquo.root.addChild(new WebNode(new WebPage("https://www.genquo.com/WOMEN", "女裝")));
		treeGenquo.root.children.get(0).addChild(new WebNode(new WebPage("https://www.genquo.com/WOMEN/TOP/JACKET", "外套")));
		
		treeZARA.root.addChild(new WebNode(new WebPage("https://www.zara.com/tw/zt/woman-l1000.html?v1=791035", "女裝")));
		treeZARA.root.children.get(0).addChild(new WebNode(new WebPage("https://www.zara.com/tw/zt/woman-outerwear-l1184.html?v1=1179522", "大衣")));
		treeZARA.root.children.get(0).addChild(new WebNode(new WebPage("https://www.zara.com/tw/zt/woman-jackets-l1114.html?v1=1178995", "夾克外套")));
		treeZARA.root.children.get(0).addChild(new WebNode(new WebPage("https://www.zara.com/tw/zt/woman-blazers-l1055.html", "西裝外套")));
		
		treeUR.root.addChild(new WebNode(new WebPage("https://www.urban-research.tw/item_list/?select_type=27&select_item=All_item", "女裝")));
		treeUR.root.children.get(0).addChild(new WebNode(new WebPage("https://www.urban-research.tw/item_list/?select_item=All_item&select_brand=19&select_type=27&select_category=31&keyword=", "外套")));
		String name = keyword;
			try {
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
			
			System.out.print("Urban Research");
			countListUR = wordcountUrbanResearch.countKeyword(name);
			System.out.println(" "); 
			treeUR.setPostOrderScore(name);
			
			System.out.print("H&M");
			countListHM = wordcountHM.countKeyword(name);
			System.out.println();
			treeHM.setPostOrderScore(name);
			
			System.out.print("NET");
			countListNET = wordcountNET.countKeyword(name);
			System.out.println();
			treeNET.setPostOrderScore(name);
			
			
			int a = treeZARA.root.nodeScore;
			int b = treeBurberry.root.nodeScore;
			int c = treeGenquo.root.nodeScore;
			int d = treeUR.root.nodeScore;
			int e = treeHM.root.nodeScore;
			int f = treeNET.root.nodeScore;
			
			int [] score = new int[6];
			score[0] = a;
			score[1] = b;
			score[2] = c;
			score[3] = d;
			score[4] = e;
			score[5] = f;
			
			QuickSort rank = new QuickSort();
		    rank.sort(score, 0, score.length-1);
		    System.out.println("score rank: " + Arrays.toString(score));
		    
			//用score回推url
		    ArrayList<String> retVal = new ArrayList<>();
		   
		    for(int i = score.length-1; i >= 0; i--) {
			    int q = score[i];
			    if(q==a) {String temp="ZARA: " + wordcountZARA.urlStr;retVal.add(temp) ;a = 1;}
			    else if(q==b) {String temp="Burberry: " + wordcountBurberry.urlStr;retVal.add(temp) ;b = 1;}
			    else if(q==c) {String temp="Genquo: " + wordcountGenquo.urlStr;retVal.add(temp) ;c = 1;}
			    else if(q==d) {String temp="Urban Research: " + wordcountUrbanResearch.urlStr;retVal.add(temp) ;d = 1;}
			    else if(q==e) {String temp="H&M: " + wordcountHM.urlStr;retVal.add(temp) ;e = 1;}
			    else if(q==f) {String temp="NET: " + wordcountNET.urlStr;retVal.add(temp) ;f = 1;}
		    }
		    String reretVal = "";
		    for(String ele: retVal) {
		    	reretVal+= ele +"<br/>";
		    }
		    reretVal = "<html>" + reretVal + "</html>";
		    
			return reretVal;
//		    System.out.println(Arrays.toString(scoreRank));
			}catch (Exception e) {
				// TODO: handle exception
			}
			return "";
	
	}
}

