import java.io.IOException;
import java.util.ArrayList;

public class WebNode {
	public WebNode parent;
	public ArrayList<WebNode>children;
	public WebPage webPage;
	public int nodeScore;
	public int[]scoreRank;
	
	public WebNode(WebPage webPage) {
		this.webPage = webPage;
		this.children = new ArrayList<WebNode>();
	}
	
	public void setNodeScore(ArrayList<Keyword>keywords) throws IOException {
		webPage.setScore(keywords);
		this.nodeScore = webPage.score;
		
		System.out.println(webPage.name);
		System.out.println(nodeScore);
		for(WebNode child : children) {
			this.nodeScore += child.nodeScore;
		}
//		System.out.println(webPage.name);
//		System.out.println(nodeScore);
	}
	
	public void addChild(WebNode child) {
		this.children.add(child);
		child.parent = this;
	}
	
	public void rank() {
		
	}
	
	
}
