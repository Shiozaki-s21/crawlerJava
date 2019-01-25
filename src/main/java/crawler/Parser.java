package crawler;

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Parser {
    // unused
    private Parser() {};

    protected Document document = null;

    public Parser(String url) throws IOException {
        this.document = Jsoup.connect(url).get();
    }

    public ArrayList<String> getElementsByClass(String className) {
        ArrayList<String> list = new ArrayList<>();
        Elements elements = document.getElementsByClass(className);
        for (Element element : elements) {
            list.add(element.text());
        }
        return list;
    }
}
