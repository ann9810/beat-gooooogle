import java.io.IOException;
import java.util.ArrayList;
public class WebTree {
	public WebNode root;
	
	public WebTree(WebPage rootPage) {
		this.root = new WebNode(rootPage);
	}
	
	public void setPostOrderScore(String kw) throws IOException {
		setPostOrderScore(root, kw);
	}
	private void setPostOrderScore(WebNode startNode, String kw) throws IOException {
		for(WebNode child: startNode.children) {
			setPostOrderScore(child, kw);
		}
		
		startNode.setNodeScore(kw);
		System.out.println(startNode.nodeScore+ " ");
	}
	
//	public void print() {
//		printTree(root);
//	}
//
//	private void printTree(WebNode startNode) {
//		System.out.print( startNode.webPage.name +" "+ startNode.nodeScore);
//	}
//	
//	public void printTree() {
//		printTree(root);
//	}
//
//	private void printTree(WebNode startNode) {
//		System.out.print( "(" + startNode.webPage.name +" "+ startNode.nodeScore);
//		if(startNode.children.size() == 0)
//			System.out.println(")");
//		else {
//			System.out.println("");
//		for(int i = 0; i < startNode.children.size(); i++){
//			WebNode node = startNode.children.get(i);
//			printTree(node);
//		}
//		System.out.println(")");
//		}
//	}
}
