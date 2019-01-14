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
	
	public void setNodeScore(ArrayList<Integer> countli) throws IOException {
		webPage.setScore(countli);
		this.nodeScore = webPage.score;
		
		System.out.print(webPage.name+" ");
		//System.out.println(nodeScore);
		for(WebNode child : children) {
			this.nodeScore += child.nodeScore;
		}
	}
	
	public void addChild(WebNode child) {
		this.children.add(child);
		child.parent = this;
	}
	
	public void rank() {
		
	}
	
	
}
