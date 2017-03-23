import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.Scanner;

import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class Xiazai {
	public void xiazaiPage(String url,String filePath){
		CloseableHttpClient httpClient =HttpClients.createDefault();
		HttpGet httpGet =new HttpGet(url);
		try {
			CloseableHttpResponse respons =httpClient.execute(httpGet);
			InputStream Is=null;
			if(respons.getStatusLine().getStatusCode()==HttpStatus.SC_OK){
				HttpEntity entity=respons.getEntity();
				Is=entity.getContent();
				//save?
				saveFile(filePath,Is);
				
				
			}
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	private void saveFile(String filePath,InputStream is){
		Scanner sc =new Scanner(is);
		Writer os=null;
		try {
			os =new PrintWriter(filePath);
			while(sc.hasNext()){
				try {
					os.write(sc.nextLine());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{if(sc!=null)
					sc.close();
				 if(os!=null)
					try {
						os.flush();
						os.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		}
	}
	public String getFileName(String url){
		//url =url.substring(7);
		String fileName =url.replaceAll("[\\?:*|<>\"/]", "_")+".html";
		return fileName;
		
		
	}
	public static void main(String[] args){
		Xiazai s=new Xiazai();
		String url= "http://www.bistu.edu.cn/";
		//String filePath ="d://baidu.html";
		String filePath ="d://websites/"+ s.getFileName(url);
		s.xiazaiPage(url, filePath);
	}

}
