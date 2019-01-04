import java.io.IOException;
import java.util.ArrayList;

public class WebPage {
	public String url;
	public String name;
	public WordCounter counter;
	public double score;
	
	public WebPage(String url, String name) {
		this.url = url;
		this.name = name;
		this.counter = new WordCounter();
	}
	
	public void setScore(ArrayList<Keyword> keywords) throws IOException {
		this.score = 0;
		
		for(Keyword k : keywords) {
			this.score += counter.countKeyword(k.name)* k.weight;
		}
	}
}
