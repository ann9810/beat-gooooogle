import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

public class WordCounter {
	private String url;
	private ArrayList<String> content;
	String conte;
	int score;
	private ArrayList<String> urls = new ArrayList<String>();
	private ArrayList<String> contearray = new ArrayList<>();
	private ArrayList<Integer> retVALarr = new ArrayList<>();
	
	String HM = "https://www2.hm.com/zh_asia3/ladies.html";
	String ZARA = "https://www.zara.com/tw/zt/woman-l1000.html?v1=791035";
	String OB = "https://www.obdesign.com.tw/";
	String Burberry = "https://tw.burberry.com/";
	
	public WordCounter() {
	urls.add(HM);
	urls.add(ZARA);
	urls.add(OB);
	urls.add(Burberry);
	}
	
	
	
	private ArrayList<String> fetchContent()throws IOException{
		ArrayList<String> content = new ArrayList<String>();
		for(int i = 0; i < urls.size(); i++) {
		this.url = urls.get(i);
		URL url = new URL(this.url);
		//connect
		URLConnection conn = url.openConnection();
		//read
		InputStream in = conn.getInputStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		
		String retVAL= "";
		String line = null;
		
		while((line=br.readLine())!=null) {
			retVAL= retVAL+line +"\n";
		}
		content.add(retVAL);
		}
		
		return content;
	}
	
	public int countKeyword(String kword)throws IOException{
		if(content==null) {
			content = fetchContent();
		}
		for(int i = 0; i < content.size(); i++) {
			String con = content.get(i);
			conte =con.toUpperCase();
			contearray.add(conte);
		}
		
		kword = kword.toUpperCase();
		
		int fromIdx =0;
		int found= -1;
		int retVAL= 0;
		for(int i = 0; i < contearray.size(); i++) {
			retVALarr.add(i, retVAL);
			retVAL=0;
		while((found=contearray.get(i).indexOf(kword,fromIdx))!=-1) {
			retVAL++;
			fromIdx= found+kword.length();
			}
		}
		return retVAL;
	}
}
