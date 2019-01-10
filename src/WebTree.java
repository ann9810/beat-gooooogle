import java.io.IOException;
import java.util.ArrayList;
public class WebTree {
	public WebNode root;
	
	public WebTree(WebPage rootPage) {
		this.root = new WebNode(rootPage);
	}
	
	public void setPostOrderScore(ArrayList<Keyword>keywords) throws IOException {
		setPostOrderScore(root, keywords);
	}
	private void setPostOrderScore(WebNode startNode, ArrayList<Keyword>keywords) throws IOException {
		startNode.setNodeScore(keywords);
		for(WebNode child: startNode.children) {
			setPostOrderScore(child, keywords);
		}
		
	}
	
	public void print() {
		printTree(root);
	}

	private void printTree(WebNode startNode) {
		System.out.print( startNode.webPage.name +" "+ startNode.nodeScore);
	}
}
