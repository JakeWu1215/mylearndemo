package com;

import com.Model.Student;
import com.alibaba.fastjson.JSONObject;
import commonUtils.DateUtil;
import commonUtils.FileUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.ui.Model;

import javax.jws.WebParam;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@SpringBootApplication
public class DemoApplication {
	static final String CONST_STR="AAA";
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
//		String aaa="123";
//		String[] bbb={aaa,"34353"};
//		System.out.println(bbb.length);
//        String currentTimeStr=getCurrentTimeStr();
//        System.out.println(currentTimeStr);
//
//        String strTest="123";
//        Boolean flag=new Boolean(strTest).booleanValue();
//        System.out.println(flag);
//
//		getCalendar();

//		Date currentDate=new Date();
//		List<String> dirList=new ArrayList<>();
//		dirList.add("D:\\贷款项目资料\\北京中关村资料\\20180019_20180420_repaylist.txt");
//		doBatchData(1,"",dirList);
//		//String aaaaa=currentDate.getTime();
//		try {
//			currentDate=dateAdd(currentDate,-1);
//			String currentDateStr=getDateStringByFormat(currentDate,"yyyyMMdd");
//			System.out.println(currentDateStr);
//		} catch (ParseException e) {
//			e.printStackTrace();
//		} finally {
//		}

//		String dateStr="20180108";
//		try {
//			dateStr=strToDateFormat(dateStr);
//			System.out.println(dateStr);
//
//			String date2=addMonth(dateStr,-1);
//			System.out.println(date2);
//		}catch (ParseException e){
//			e.printStackTrace();
//		}
//		Student stu=new Student();
//		stu.setId(1);
//		stu.setName("wdd");
//		stu.setAge(20);
//		stu.setSno("25");
//		String jsonString = JSONObject.toJSONString(stu);
//		JSONObject body1 = JSONObject.parseObject(jsonString);
//
//
//		JSONObject body = new JSONObject();
//		body.put("idType ", "ZJ01");
//		body.put("idno", "23242");
//		String aaa=body.toJSONString();

		//JSONObject body1 = JSONObject.parseObject(null);

//		int a=3;
//		System.out.println(a+1==4);
//		String aaa="wdd";
//		process(aaa);
//		aaa="wxx";
//		process(aaa);
	}
	private static void process(final String a) {
		System.out.println(a);;

	}
		public static String addMonth(String date,int monthNum) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date dt = sdf.parse(date);
		Calendar rightNow = Calendar.getInstance();
		rightNow.setTime(dt);
		rightNow.add(Calendar.MONTH, monthNum);
		Date dt1 = rightNow.getTime();
		String reStr = sdf.format(dt1);
		return reStr;
	}
	/**
	 *将字符串格式yyyyMMdd的字符串转为日期，格式"yyyy-MM-dd"
	 *
	 * @param date 日期字符串
	 * @return 返回格式化的日期
	 * @throws ParseException 分析时意外地出现了错误异常
	 */
	public static String strToDateFormat(String date) throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
		formatter.setLenient(false);
		Date newDate= formatter.parse(date);
		formatter = new SimpleDateFormat("yyyy-MM-dd");
		return formatter.format(newDate);
	}

	private static  void getCalendar(){
		Calendar c = Calendar.getInstance();
		c.set(Calendar.DAY_OF_MONTH, 1);
		String collectDateStart=DateUtil.dateToStringShort(c.getTime());
		System.out.println(collectDateStart);
		c.add(Calendar.MONTH,1);
		c.add(Calendar.DAY_OF_MONTH, -1);
		String collectDateEnd=DateUtil.dateToStringShort(c.getTime());
		System.out.println(collectDateEnd);
	}

	public static Date dateAdd(Date date, int dayNum) throws ParseException {
		Calendar cal = Calendar.getInstance();
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		cal.setTime(formatter.parse(formatter.format(date)));
		cal.add(Calendar.DATE, dayNum);
		return cal.getTime();
	}
	public static String getDateStringByFormat(Date date, String format) {
		if (date != null) {
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			return sdf.format(date);
		}
		return null;
	}
	private static  String getCurrentTimeStr(){

		// TODO Auto-generated method stub
		//获得系统的时间，单位为毫秒,转换为妙
		long totalMilliSeconds = System.currentTimeMillis();

		DateFormat dateFormatterChina = DateFormat.getDateTimeInstance(DateFormat.MEDIUM,DateFormat.MEDIUM);//格式化输出
		TimeZone timeZoneChina = TimeZone.getTimeZone("Asia/Shanghai");//获取时区 这句加上，很关键。
		dateFormatterChina.setTimeZone(timeZoneChina);//设置系统时区
		long totalSeconds = totalMilliSeconds / 1000;

		//求出现在的秒
		long currentSecond = totalSeconds % 60;

		//求出现在的分
		long totalMinutes = totalSeconds / 60;
		long currentMinute = totalMinutes % 60;

		//求出现在的小时
		long totalHour = totalMinutes / 60;
		long currentHour = totalHour % 24;

		//显示时间
		System.out.println("总毫秒为： " + totalMilliSeconds);
		System.out.println(currentHour + ":" + currentMinute + ":" + currentSecond + " GMT");


		Date nowTime = new Date(System.currentTimeMillis());
		System.out.println(System.currentTimeMillis());
		SimpleDateFormat sdFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:dd");
		String retStrFormatNowDate = sdFormatter.format(nowTime);

		//System.out.println(retStrFormatNowDate);
		return retStrFormatNowDate;
	}

	private static List<String[]> doBatchData(Integer type, String fileName, List<String> dirList) {
		List<String[]> appNoList = new ArrayList<>();
		for (int j = 0; j < dirList.size(); j++) {
			// 按照OK文件中列出的文件名分别下载和读取相应文件并做相应操作
			String downLoadFileName = dirList.get(j);
			List<String> lines = FileUtil.readTxtFile(downLoadFileName);
			//文件记录明细统计条数
			int totalNum = lines.size();
			if(1 == type){
				totalNum = totalNum -2;
//				//文件内容记录明细记录条数
//				String fileTotalNumStr = lines.get(lines.size()-1);
//				int fileTotalNum = 0;
//				if(fileTotalNumStr != null && !"".equals(fileTotalNumStr)) {
//					fileTotalNum = fileTotalNumStr != null ? Integer.parseInt(fileTotalNumStr) : 0;
//				}
//				if(totalNum != fileTotalNum) {
//
//				}
			}

			if (lines != null && totalNum > 0) {
				for (int i = 1; i <= totalNum; i++) {
					String[] line = lines.get(i).split("\\<\\|\\>");
					appNoList.add(line);
				}
			}
		}
		return appNoList;
	}
}
