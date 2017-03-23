import java.util.ArrayList;
import java.util.Hashtable;
import java.util.LinkedList;

public class Diaodu {
	private ArrayList<String> zhongziUrls=new ArrayList();
	private LinkedList<String> daixaizaiUrls=new LinkedList();
	private Hashtable yixiazaiUrls =new Hashtable();
	private Xiazai xiazai =new Xiazai();
	private Fenxi fenxi =new Fenxi();
	public void initZhongziUrls(){
	//zhongziUrls.add("http://www.bistu.edu.cn");
	zhongziUrls.add("http://www.sohu.com");
	 
	}
	public void zhongzidaixiazai(){
		for(int i=0;i<zhongziUrls.size();i++){
		daixaizaiUrls.add(zhongziUrls.get(i));
			
		}
	}
	public void Start(){
		while(!daixaizaiUrls.isEmpty()){
		//congdaixiazaizhong get url;
		String newUrl = daixaizaiUrls.getFirst();
			//String newUrl= new Fenxi().fenxi(filePath)
		//download;
		//String filepath ="d://baidu.html";
		String filepath ="d://"+new Xiazai().getFileName(newUrl)+".html";
		//System.out.println(newUrl);
		xiazai.xiazaiPage(newUrl, filepath);
		//gengxin yixiazai;
		yixiazaiUrls.put(newUrl, 1);
		//fenxi xiazai
		
		ArrayList<String> tmpUrls =fenxi.fenxi(filepath);
		for(int i=0;i<tmpUrls.size();i++){
			if(yixiazaiUrls.containsKey(tmpUrls.get(i))){
				daixaizaiUrls.add(tmpUrls.get(i));
		
	

			}
		}
		//gengxin daixaizai0
		daixaizaiUrls.removeFirst();			
		// Xiazai x=new Xiazai();
		 //x.xiazaiPage(new Fenxi().fenxi(filePath)., filePath);
		
		
		
		}
	}
	public static void main(String[] args) {
	Diaodu d=new Diaodu();
		d.initZhongziUrls();
		d.zhongzidaixiazai();
		d.Start();
	}
}

