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
	
	public void printTree() {
		printTree(root);
	}
	
	private void printTree(WebNode startNode) {
		for(int i =0; i<startNode.getDepth();i++){System.out.print("  ");}

		if(startNode.children.isEmpty()){
		System.out.println("("+startNode.webPage.name+","+startNode.nodeScore+ ")") ;
		}
		else{ 
		System.out.println("("+startNode.webPage.name+","+startNode.nodeScore);
		for(WebNode child : startNode.children){
		printTree(child);
		}
		for(int i =0; i<startNode.getDepth();i++){
		System.out.print("  ");
		}System.out.println(")");
		}
	}
}
