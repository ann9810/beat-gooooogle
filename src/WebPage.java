import java.io.IOException;
import java.util.ArrayList;

public class WebPage {
	public String url;
	public String name;
	public WordCounter counter;
	public int score;
	
	private int[] weight = {12, 8, 4};
	
	
	public WebPage(String url, String name) {
		this.url = url;
		this.name = name;
		this.counter = new WordCounter();
	}
	
	//算單一Web的score，再用一個ArrayList存，ArrayList共會有個分數
	public void setScore(ArrayList<Keyword> keywords) throws IOException {
		int z = 0;
		for(int i = 0; i < keywords.size(); i++) {
			this.score = counter.countKeyword(keywords.get(i).name).get(i) * weight[i];
			System.out.println(i);
			System.out.println(score);
			}
			
		}
}
