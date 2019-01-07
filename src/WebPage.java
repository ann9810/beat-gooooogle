import java.io.IOException;
import java.util.ArrayList;

public class WebPage {
	public String url;
	public String name;
	public WordCounter counter;
	public ArrayList<Integer> score = new ArrayList();
	
	private int[] weight = {12, 8, 4};
	
	
	public WebPage(String url, String name) {
		this.url = url;
		this.name = name;
		this.counter = new WordCounter();
	}
	
	public void setScore(ArrayList<Keyword> keywords) throws IOException {
		int z = 0;
		for(int i = 0; i < keywords.size(); i++) {
			for(int j = 0; i == z; j++) {
				
				score.add(counter.countKeyword(keywords.get(i).name).get(i)* weight[i]);
				z++;
			}
			
		}
	}
}
