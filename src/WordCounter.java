import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class WordCounter {
	private String urlStr;
	private String content;
	
	public WordCounter(String urlStr) {
		this.urlStr = urlStr;
	}
	
	private String fetchContent()throws IOException{
		URL url = new URL(this.urlStr);
		URLConnection conn = url.openConnection();
		InputStream in = conn.getInputStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		
		String retVAL= "";
		String line = null;
		
		while((line=br.readLine())!=null) {
			retVAL= retVAL+line +"\n";
		}
		return retVAL;
	}
	
	public int countKeyword(String kword)throws IOException{
		if(content==null) {
			content = fetchContent();
		}
		content =content.toUpperCase();
		kword =kword.toUpperCase();
		
		int retVAL=0;
		int fromIdx =0;
		int found= -1;
		while((found=content.indexOf(kword,fromIdx))!=-1) {
			retVAL++;
			fromIdx= found+kword.length();
			
		}
		
		return retVAL;
	}
}
