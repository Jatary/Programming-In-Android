package org.itec.classroom;

import java.io.BufferedWriter;  
import java.io.File;  
import java.io.FileWriter;  
import org.watij.webspec.dsl.Tag;  
import org.watij.webspec.dsl.WebSpec;  

public class TestWatijIBM {

	private static String homepage = "http://jwczyk.jxnu.edu.cn/QualityCourse";

	//��ѧ¥��Ӧvalueֵ����ʮ��8������7������5����ʮ��1
	private static String[] building = {"W12", "E9", "W5", "E12"};
	private static String[] buildingValue = {"8", "7", "5", "1"};
	private static String filePath = "D:\\Classroom\\";

	public static void main(String[] args) throws Exception {
		//����ҳ
           		WebSpec spec = new WebSpec().mozilla();
		spec.open(homepage);

		for (int i = 0; i < 4; i ++) {
			System.out.println("Fetching data of building " + building[i]);
			spec.find.select().with.id("Build").set("value", buildingValue[i]);//ѡ���ѧ¥
			spec.find.input().with.name("btnRightall").click();//ѡ�����н���
			spec.find.input().with.name("Button1").click();//�����ѯ
			int page = 0;
			File file;
			Tag tag = spec.find.a().with.innerText("��ҳ");
			//��������ҳ����ҳ
			while (tag.exists()) {
				page++;
				file = new File(filePath, building[i] + "/" + page + ".html");
				BufferedWriter bw = new BufferedWriter(new FileWriter(file));
				System.out.println("Downloading page " + page + " ...");
				String htmlString = spec.source();  // get the brower's source as a html string
				bw.write(htmlString);
				bw.close();
				tag.click();
				tag = spec.find.a().with.innerText("��ҳ");
			}
			System.out.println("All the pages have been downloaded.");
		}
	}

}
