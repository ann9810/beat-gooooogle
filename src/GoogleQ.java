
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class GoogleQ {
    public String searchKeyword;
    public String url;
    public String content;

    public GoogleQ(String searchKeyword) {
        this.searchKeyword = searchKeyword;
        this.url = "http://www.google.com/search?q=" + searchKeyword + "&oe=utf8&num=50";
    }

    private String fetchContent() throws IOException {
        String retVal = "";
        URL urlStr = new URL(this.url);
        URLConnection connection = urlStr.openConnection();
        connection.setRequestProperty("User-Agent",
                "Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10.4; en-US; rv:1.9.2.2) Gecko/20100316 Firefox/3.6.2");
        connection.connect();
        InputStream inputStream = connection.getInputStream();
        InputStreamReader inReader = new InputStreamReader(inputStream, "UTF8");
        BufferedReader bf = new BufferedReader(inReader);
        String line = null;
        while ((line = bf.readLine()) != null) {
            retVal += line;
        }
        return retVal;
    }

    public String query() throws IOException {
        if (this.content == null) {
            this.content = fetchContent();
        }

        HashMap<String, String> retVal = new HashMap<String, String>();
        Document document = Jsoup.parse(this.content);
        Elements list = document.select("div.g");

        for (Element li : list) {
            try {
                Element h3 = li.select("h3.r").get(0);
                String title = h3.text();
                Element cite = li.select("cite").get(0);
                String citeurl = cite.text();
                System.out.println(title + " " + citeurl);
                retVal.put(title, citeurl);
            } catch (IndexOutOfBoundsException e) {
                // Do nothing
            }
        }

        String reretVal = "";

        Iterator it = retVal.entrySet().iterator();
        while (it.hasNext()) {
            HashMap.Entry<String, String> pair = (HashMap.Entry<String, String>)it.next();
//            System.out.println(pair.getKey() + " = " + pair.getValue());
            reretVal += pair.getKey() + "<br/>";
            reretVal += "<a href=\'" + pair.getValue() + "\'>" + pair.getValue() + "</a> " + "<br/>";
            it.remove(); // avoids a ConcurrentModificationException
        }
        // for(String ele: retVal) {
        // reretVal+= ele +"<br/>";
        // }
         reretVal = "<html>" + reretVal + "</html>";

        return reretVal;
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String keyword = sc.next();
            GoogleQ googleQuery = new GoogleQ(keyword);
            googleQuery.query();
        }
        sc.close();

    }

}
