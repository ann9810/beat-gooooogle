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
}
