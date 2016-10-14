package org.itec.classroom;

import java.io.BufferedWriter;  
import java.io.File;  
import java.io.FileWriter;  
import org.watij.webspec.dsl.Tag;  
import org.watij.webspec.dsl.WebSpec;  

public class TestWatijIBM {

	private static String homepage = "http://jwczyk.jxnu.edu.cn/QualityCourse";

	//教学楼对应value值，西十二8，东九7，西五5，东十二1
	private static String[] building = {"W12", "E9", "W5", "E12"};
	private static String[] buildingValue = {"8", "7", "5", "1"};
	private static String filePath = "D:\\Classroom\\";

	public static void main(String[] args) throws Exception {
		//打开网页
           		WebSpec spec = new WebSpec().mozilla();
		spec.open(homepage);

		for (int i = 0; i < 4; i ++) {
			System.out.println("Fetching data of building " + building[i]);
			spec.find.select().with.id("Build").set("value", buildingValue[i]);//选择教学楼
			spec.find.input().with.name("btnRightall").click();//选择所有教室
			spec.find.input().with.name("Button1").click();//点击查询
			int page = 0;
			File file;
			Tag tag = spec.find.a().with.innerText("后页");
			//下载所有页的网页
			while (tag.exists()) {
				page++;
				file = new File(filePath, building[i] + "/" + page + ".html");
				BufferedWriter bw = new BufferedWriter(new FileWriter(file));
				System.out.println("Downloading page " + page + " ...");
				String htmlString = spec.source();  // get the brower's source as a html string
				bw.write(htmlString);
				bw.close();
				tag.click();
				tag = spec.find.a().with.innerText("后页");
			}
			System.out.println("All the pages have been downloaded.");
		}
	}

}
