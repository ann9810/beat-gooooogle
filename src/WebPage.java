import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class WebPage {
	public String url;
	public String name;
	public WordCount count;
	public int score = 0;
	
	private int[] weight = {7,5,4,2,1,1};
	
	
	public WebPage(String url, String name) {
		this.url = url;
		this.name = name;
		count = new WordCount(url);
	}
	
	ArrayList<Integer> countList = new ArrayList<>();
	
	public void setScore(String keyword) throws IOException{
		
		ArrayList<Integer> countList = count.countKeyword(keyword);
		
		for(int i = 0; i < countList.size(); i++) {
			this.score += countList.get(i) * weight[i];
		}
		System.out.print(countList);
		}
}
