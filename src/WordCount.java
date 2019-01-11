import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Arrays;

public class WordCount {

	private String urlStr;
	private String content;
	

	public ArrayList<String> keywordli;
	
	public WordCount(String urlStr) {
		this.urlStr = urlStr;
	}
	
	private String fetchContent() throws IOException {
		URL url = new URL(this.urlStr);
		
		System.out.println(this.urlStr);
		
		URLConnection conn = url.openConnection();
		InputStream in = conn.getInputStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		
		String retVal = "";
		String line = null;
		
		while((line = br.readLine()) != null) {
			retVal = retVal + line + "\n" ;
		}
		return retVal;
	}
	
	
	
	public ArrayList<String> splitKeywordStr(String keywordStr) {
		String[] k = keywordStr.split("\\s+");
		this.keywordli = new ArrayList<>(Arrays.asList(keywordStr.split("\\s+")));
		System.out.println(k.length);
		//System.out.println(keywordli.size());
		return keywordli;
		
	}
	
	public ArrayList<Integer> countList = new ArrayList<>();
	
public ArrayList<Integer> countKeyword(String keyword) throws IOException {
		
		if(content == null) {
			content = fetchContent();
		}
		content = content.toUpperCase();
		keyword = keyword.toUpperCase();
		
		
		for(int t = 0; t < keywordli.size(); t++) {
		int count = 0;
		int i = content.indexOf(keywordli.get(t));
		
		while(i != -1) {
			i = content.indexOf(keywordli.get(t));
			content = content.substring(i + keywordli.get(t).length(), content.length());
			count++;
		}
		countList.add(count);
		}
		System.out.println(countList);
		return countList;
	}
}
