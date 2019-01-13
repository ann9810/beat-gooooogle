import java.io.IOException;
import java.util.ArrayList;
public class WebTree {
	public WebNode root;
	
	public WebTree(WebPage rootPage) {
		this.root = new WebNode(rootPage);
	}
	
	public void setPostOrderScore(ArrayList<Integer>countli) throws IOException {
		setPostOrderScore(root, countli);
	}
	private void setPostOrderScore(WebNode startNode, ArrayList<Integer>countli) throws IOException {
		startNode.setNodeScore(countli);
		for(WebNode child: startNode.children) {
			setPostOrderScore(child, countli);
		}
		System.out.println(startNode.nodeScore);
	}
	
//	public void print() {
//		printTree(root);
//	}

//	private void printTree(WebNode startNode) {
//		System.out.print( startNode.webPage.name +" "+ startNode.nodeScore);
//	}
	
	public void printTree() {
		printTree(root);
	}

	private void printTree(WebNode startNode) {
		System.out.print( "(" + startNode.webPage.name +" "+ startNode.nodeScore);
		if(startNode.children.size() == 0)
			System.out.println(")");
		else {
			System.out.println("");
		for(int i = 0; i < startNode.children.size(); i++){
			WebNode node = startNode.children.get(i);
			printTree(node);
		}
		System.out.println(")");
		}
	}
}
