import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Arrays;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class WordCount {

	public String urlStr;
	private String content;

	public ArrayList<String> keywordli;
	
	public WordCount(String urlStr) {
		this.urlStr = urlStr;
	}
	
	private String fetchContent() throws IOException {
		URL url = new URL(this.urlStr);
		
		URLConnection conn = url.openConnection();
		InputStream in = conn.getInputStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		
		String retVal = "";
		String line = null;
		
		while((line = br.readLine()) != null) {
			retVal = retVal + line + "\n" ;
		}
		Document retValStr = Jsoup.parse(retVal);
		String retValText = retValStr.text();
		//System.out.println(retValText);
		return retValText;
	}

	private ArrayList<String> splitKeywordStr(String keywordStr) {
		String[] k = keywordStr.split("\\s+");
		this.keywordli = new ArrayList<>(Arrays.asList(keywordStr.split("\\s")));
		for(int i = 0; i < keywordli.size(); i++)
		System.out.print("[" + keywordli.get(i) + "]");
		return keywordli;
	}
	
	public ArrayList<Integer> countList = new ArrayList<>();
	
public ArrayList<Integer> countKeyword(String keyword) throws IOException {
		
		if(content == null) {
			content = fetchContent();
		}
		content = content.toUpperCase();
		keyword = keyword.toUpperCase();
		
		splitKeywordStr(keyword);
		
		for(int t = 0; t < keywordli.size(); t++) {
		int count = 0;
		String temp = content + "";
		int i = temp.indexOf(keywordli.get(t));
		while(i != -1) {
			i = temp.indexOf(keywordli.get(t));
			temp = temp.substring(i + keywordli.get(t).length(), temp.length());
			count++;
		}
		countList.add(count);
		}
		return countList;
	}
}
