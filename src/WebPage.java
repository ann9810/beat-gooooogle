import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class WebPage {
	public String url;
	public String name;
	public WordCount count;
	public int score = 0;
	
	private int[] weight = {3, 2, 1};
	
	
	public WebPage(String url, String name) {
		this.url = url;
		this.name = name;
		this.count = new WordCount(url);
	}
	
	ArrayList<Integer> countList = new ArrayList<>();
	
	public void setScore(ArrayList<Integer> countList) throws IOException{
		for(int i = 0; i < countList.size(); i++) {
			this.score += countList.get(i) * weight[i];
		}
		System.out.println(score);
		}
}
