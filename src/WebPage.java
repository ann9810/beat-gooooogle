import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class WebPage {
	public String url;
	public String name;
	public WordCount counter;
	public int score;
	
	private int[] weight = {12, 8, 4};
	
	
	public WebPage(String url, String name) {
		this.url = url;
		this.name = name;
		this.counter = new WordCount(url);
	}
	
	
	
	
	public void setScore(ArrayList<String> keywordli) throws IOException{
		for(int i = 0; i < keywordli.size(); i++) {
			this.score += counter.countKeyword(keywordli.get(i)).get(i) * weight[i];
		}
		}
}
