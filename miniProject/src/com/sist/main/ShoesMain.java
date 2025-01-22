package com.sist.main;
import java.util.*;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.sist.dao.*;
public class ShoesMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try
		{
			ShoesDAO dao=ShoesDAO.newInstance();
			for(int i=1;i<=32;i++)
			{
				Document doc=Jsoup.connect("https://www.10000recipe.com/recipe/list.html?order=reco&page="+i).get();
				Elements link=doc.select("div.common_sp_caption_tit line2 a");
				System.out.println("======="+i+"page=======");
				for(int j=0;j<link.size();j++)
				{
					System.out.println(link.get(j).attr("href"));
	        		String url="https://www.shoemarker.co.kr"+link.get(j).attr("href");
					Document doc2=Jsoup.connect(url).get();
					Element name=doc2.selectFirst("li.itemprop span.name");
					String strName=name.text();
					strName=strName.substring(0,strName.indexOf("["));
					System.out.println(strName);
//					
//					Element size=doc2.selectFirst("div.areaBasic dl.restType dd.type");
//					System.out.println(type.text());
//					
//					Element brand=doc2.selectFirst("div.areaBasic dl.restType dd.type");
//					System.out.println(type.text());
					
					//name,image,brand,size,sale_price,price;
//					ShoesVO vo=new ShoesVO();
//					vo.setName(strName.trim());
//					vo.setImage(image.text());
//					vo.setBrand(brand.text());
//					vo.setSize(size.text());
//					vo.setSale_price(sale_price.text());
//					vo.setPrice(price.text());
				}
				System.out.println("=========================");
			}
			System.out.println("데이터 저장 완료!!");
		}catch (Exception ex) {
			// TODO: handle exception
		}
	}
}
