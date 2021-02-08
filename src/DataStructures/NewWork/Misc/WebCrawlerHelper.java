package DataStructures.NewWork.Misc;

import java.util.*;
import java.util.concurrent.*;

public class WebCrawlerHelper {
    public static void main(String[] args) {
        HtmlParser parser = new Parser();
        WebCrawlerHelper helper = new WebCrawlerHelper();

        System.out.println(helper.crawl("http://news.yahoo.com/news/topics/", parser));
    }

    public List<String> crawl(String startUrl, HtmlParser htmlParser) {
        Set<String> set = new HashSet();
        Queue<String> queue = new LinkedList();
        queue.offer(startUrl);

        ExecutorService executorService = Executors.newFixedThreadPool(4);
        List<Future<List<String>>> futureList = new ArrayList();
        for(int i = 0 ; i < 4 ; i++){
            futureList.add(executorService.submit(new WebCrawler(queue, htmlParser, set)));
        }
        for(Future<List<String>> future : futureList){
            try {
                future.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        executorService.shutdown();
        return new ArrayList(set);
    }

    class WebCrawler implements Callable<List<String>> {

        private Queue<String> queue;
        private HtmlParser htmlParser;
        private Set<String> urls;

        WebCrawler(Queue<String> queue, HtmlParser htmlParser, Set<String> set){
            this.queue = queue;
            this.htmlParser = htmlParser;
            this.urls = set;
        }

        @Override
        public List<String> call(){
            while(!queue.isEmpty()){
                String seedUrl = queue.poll();
                if(!urls.contains(seedUrl)){
                    List<String> fetchedUrls = htmlParser.getUrls(seedUrl);
                    urls.add(seedUrl);
                    for(String url : fetchedUrls){
                        if(hasSameHostName(seedUrl, url) && urls.add(url)){
                            queue.offer(url);
                        }
                    }
                }
            }

            return new ArrayList<>();
        }

        private boolean hasSameHostName(String start, String newURL){
            int i = 8, j = 8;

            while(i < start.length() && j < newURL.length()){
                if(start.charAt(i) == '.' || newURL.charAt(j) == '.') {
                    i++;
                    j++;
                    break;
                }
                if(start.charAt(i) != newURL.charAt(j)) return false;
                i++;
                j++;
            }

            while(i < start.length() && j < newURL.length()){
                if(start.charAt(i) == '/' && newURL.charAt(j) == '/')  return true;
                else if(start.charAt(i) != newURL.charAt(j)) return false;
                i++;
                j++;
            }

            return i == j;
        }

    }
}

interface HtmlParser {
 public List<String> getUrls(String url);
}

class Parser implements HtmlParser{

    @Override
    public List<String> getUrls(String url) {
        return new ArrayList<>(Arrays.asList("http://news.yahoo.com",
                "http://news.yahoo.com/news",
                "http://news.yahoo.com/news/topics/",
                "http://news.google.com",
                "http://news.yahoo.com/us"));
    }
}
