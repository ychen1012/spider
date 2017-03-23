import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Fenxi {
	public ArrayList fenxi(String filePath){
		ArrayList urls =new ArrayList();
		File input =new File(filePath);
		Document doc;
		try {
			
			doc = Jsoup.parse(input,"utf-8","");
	
		Elements contents =doc.getElementsByTag("body");
		for(Element cont:contents){
		Elements links =cont.getElementsByTag("a");
			for(Element link:links){
				String linkhref =link.attr("href");
			urls.add(linkhref);
			System.out.println(linkhref);
			Xiazai x=new Xiazai();
			String filePath1 ="d://websites/"+x.getFileName(linkhref)+".html";
			x.xiazaiPage(linkhref, filePath1);
			
		}
		
	}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return urls;
	}
	//public static void main(String[] args){
		//Fenxi fx=new Fenxi();
		//fx.fenxi("");
			
		//}
	}


