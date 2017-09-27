package com.wonder.Service;


import java.io.IOException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import com.wonder.Dao.sybaseDao;
import com.wonder.Entity.Data;

public class SybaseDaoService {

	public static List<Map> getData(String province, String tdate) throws ParseException {
		// TODO Auto-generated method stub
		List<Map> maplist = new ArrayList<Map>();		
		switch(province){
		case "上海市":
			String city[]={"上海市"};
			String area[]={"浦东","宝山","闵行","嘉定","杨浦","普陀","静安","松江","奉贤","青浦","徐汇","金山","长宁","虹口","黄浦","崇明","闸北","南汇"};
			getMaplist("上海市", city,area,tdate,maplist);
			break;
		case "江苏省":
			String city1[]={"南京市","无锡市","徐州市","常州市","苏州市","南通市","连云港市","淮安市","盐城市","扬州市","镇江市","泰州市","宿迁市"};
			String area1[]={"市辖区","玄武区","白下区","秦淮区","建邺区","鼓楼区","下关区","浦口区","栖霞区","雨花台区","江宁区","六合区","溧水区","高淳区","市辖区","崇安区","南长区","北塘区","锡山区","惠山区","滨湖区","江阴市","宜兴市","市辖区","鼓楼区","云龙区","贾汪区","泉山区","丰县","沛县","铜山区","睢宁县","新沂市","邳州市","市辖区","天宁区","钟楼区","戚墅堰区","新北区","武进区","溧阳市","金坛区","市辖区","沧浪区","平江区","金阊区","虎丘区","吴中区","相城区","常熟市","张家港市","昆山市","吴江区","太仓市","姑苏区","市辖区","崇川区","港闸区","海安县","如东县","启东市","如皋市","通州区","海门市","市辖区","连云区","新浦区","海州区","赣榆区","东海县","灌云县","灌南县","市辖区","清河区","淮安区","淮阴区","清浦区","涟水县","洪泽县","盱眙县","金湖县","市辖区","亭湖区","盐都区","响水县","滨海县","阜宁县","射阳县","建湖县","东台市","大丰市","市辖区","广陵区","邗江区","维扬区","宝应县","仪征市","高邮市","江都区","市辖区","京口区","润州区","丹徒区","丹阳市","扬中市","句容市","市辖区","海陵区","高港区","兴化市","靖江市","泰兴市","姜堰市","市辖区","宿城区","宿豫区","沭阳县","泗阳县","泗洪县"};
			getMaplist("江苏省",city1,area1,tdate,maplist);
			break;
		case "安徽省":
			String city2[]={"合肥市","芜湖市","蚌埠市","淮南市","马鞍山市","淮北市","铜陵市","安庆市","黄山市","滁州市","阜阳市","宿州市","巢湖市","六安市","亳州市","池州市","宣城市"};
			String area2[]={"市辖区","瑶海区","庐阳区","蜀山区","包河区","长丰县","肥东县","肥西县","庐江县","巢湖市","市辖区","镜湖区","三山区","弋江区","鸠江区","繁昌县","南陵县","芜湖县","无为县","市辖区","龙子湖区","蚌山区","禹会区","淮上区","怀远县","五河县","固镇县","市辖区","大通区","田家庵区","谢家集区","八公山区","潘集区","凤台县","市辖区","金家庄区","花山区","雨山区","当涂县","博望区","含山县","和县","市辖区","杜集区","相山区","烈山区","濉溪县","市辖区","铜官山区","狮子山区","郊区","铜陵县","市辖区","迎江区","大观区","宜秀区","怀宁县","枞阳县","潜山县","太湖县","宿松县","望江县","岳西县","桐城市","市辖区","屯溪区","黄山区","徽州区","歙县","休宁县","黟县","祁门县","市辖区","琅琊区","南谯区","来安县","全椒县","定远县","凤阳县","天长市","明光市","市辖区","颍州区","颍东区","颍泉区","临泉县","太和县","阜南县","颍上县","界首市","市辖区","埇桥区","砀山县","萧县","灵璧县","泗县","市辖区","居巢区","庐江县","无为县","含山县","和县","市辖区","金安区","裕安区","寿县","霍邱县","舒城县","金寨县","霍山县","市辖区","谯城区","涡阳县","蒙城县","利辛县","市辖区","贵池区","东至县","石台县","青阳县","市辖区","宣州区","郎溪县","广德县","泾县","绩溪县","旌德县","宁国市"};
			getMaplist("安徽省",city2,area2,tdate,maplist);
			break;
		case "浙江省":
			String city3[]={"杭州市","宁波市","温州市","嘉兴市","湖州市","绍兴市","金华市","衢州市","舟山市","台州市","丽水市"};
			String area3[]={"市辖区","上城区","下城区","江干区","拱墅区","西湖区","滨江区","萧山区","余杭区","桐庐县","淳安县","建德市","富阳区","临安市","市辖区","海曙区","江东区","江北区","北仑区","镇海区","鄞州区","象山县","宁海县","余姚市","慈溪市","奉化市","市辖区","鹿城区","龙湾区","瓯海区","洞头区","永嘉县","平阳县","苍南县","文成县","泰顺县","瑞安市","乐清市","市辖区","秀洲区","嘉善县","海盐县","海宁市","平湖市","桐乡市","南湖区","市辖区","吴兴区","南浔区","德清县","长兴县","安吉县","市辖区","越城区","绍兴县","新昌县","诸暨市","上虞区","嵊州市","柯桥区","市辖区","婺城区","金东区","武义县","浦江县","磐安县","兰溪市","义乌市","东阳市","永康市","市辖区","柯城区","衢江区","常山县","开化县","龙游县","江山市","市辖区","定海区","普陀区","岱山县","嵊泗县","市辖区","椒江区","黄岩区","路桥区","玉环县","三门县","天台县","仙居县","温岭市","临海市","市辖区","莲都区","青田县","缙云县","遂昌县","松阳县","云和县","庆元县","景宁畲族自治县","龙泉市"};
			getMaplist("浙江省",city3, area3, tdate, maplist);
			break;
		case "山东省":
			String city4[]={"济南市","青岛市","淄博市","枣庄市","东营市","烟台市","潍坊市","济宁市","泰安市","威海市","日照市","莱芜市","临沂市","德州市","聊城市","滨州市","菏泽市"};
			String area4[]={"市辖区","历下区","市中区","槐荫区","天桥区","历城区","长清区","平阴县","济阳县","商河县","章丘市","市辖区","市南区","市北区","四方区","黄岛区","崂山区","李沧区","城阳区","胶州市","即墨市","平度市","胶南市","莱西市","市辖区","淄川区","张店区","博山区","临淄区","周村区","桓台县","高青县","沂源县","市辖区","市中区","薛城区","峄城区","台儿庄区","山亭区","滕州市","市辖区","东营区","河口区","垦利县","利津县","广饶县","市辖区","东营区","河口区","垦利县","利津县","广饶县","芝罘区","福山区","牟平区","莱山区","长岛县","龙口市","莱阳市","莱州市","蓬莱市","招远市","栖霞市","海阳市","市辖区","潍城区","寒亭区","坊子区","奎文区","临朐县","昌乐县","青州市","诸城市","寿光市","安丘市","高密市","昌邑市","市辖区","市中区","任城区","微山县","鱼台县","金乡县","嘉祥县","汶上县","泗水县","梁山县","曲阜市","兖州市","邹城市","市辖区","泰山区","岱岳区","宁阳县","东平县","新泰市","肥城市","市辖区","环翠区","文登市","荣成市","乳山市","市辖区","东港区","岚山区","五莲县","莒县","市辖区","莱城区","钢城区","市辖区","兰山区","罗庄区","河东区","沂南县","郯城县","沂水县","苍山县","费县","平邑县","莒南县","蒙阴县","临沭县","市辖区","德城区","陵县","宁津县","庆云县","临邑县","齐河县","平原县","夏津县","武城县","乐陵市","禹城市","市辖区","东昌府区","阳谷县","莘县","茌平县","东阿县","冠县","高唐县","临清市","市辖区","滨城区","惠民县","阳信县","无棣县","沾化县","博兴县","邹平县","市辖区","牡丹区","曹县","单县","成武县","巨野县","郓城县","鄄城县","定陶县","东明县"};
			getMaplist("山东省",city4, area4, tdate, maplist);
			break;
		case "福建省":
			String city5[]={"福州市","厦门市","莆田市","三明市","泉州市","漳州市","南平市","龙岩市","宁德市"};
			String area5[]={"市辖区","鼓楼区","台江区","仓山区","马尾区","晋安区","闽侯县","连江县","罗源县","闽清县","永泰县","平潭县","福清市","长乐市","市辖区","思明区","海沧区","湖里区","集美区","同安区","翔安区","市辖区","城厢区","涵江区","荔城区","秀屿区","仙游县","市辖区","梅列区","三元区","明溪县","清流县","宁化县","大田县","尤溪县","沙县","将乐县","泰宁县","建宁县","永安市","市辖区","鲤城区","丰泽区","洛江区","泉港区","惠安县","安溪县","永春县","德化县","金门县","石狮市","晋江市","南安市","市辖区","芗城区","龙文区","云霄县","漳浦县","诏安县","长泰县","东山县","南靖县","平和县","华安县","龙海市","市辖区","延平区","顺昌县","浦城县","光泽县","松溪县","政和县","邵武市","武夷山市","建瓯市","建阳市","市辖区","新罗区","长汀县","永定县","上杭县","武平县","连城县","漳平市","市辖区","蕉城区","霞浦县","古田县","屏南县","寿宁县","周宁县","柘荣县","福安市","福鼎市"};
			getMaplist("福建省",city5, area5, tdate, maplist);
			break;
		case "江西省":
			String city6[]={"南昌市","景德镇市","萍乡市","九江市","新余市","鹰潭市","赣州市","吉安市","宜春市","抚州市","上饶市"};
			String area6[]={"市辖区","东湖区","西湖区","青云谱区","湾里区","青山湖区","南昌县","新建县","安义县","进贤县","市辖区","昌江区","珠山区","浮梁县","乐平市","市辖区","安源区","湘东区","莲花县","上栗县","芦溪县","市辖区","庐山区","浔阳区","九江县","武宁县","修水县","永修县","德安县","星子县","都昌县","湖口县","彭泽县","瑞昌市","共青城市","市辖区","渝水区","分宜县","市辖区","月湖区","余江县","贵溪市","市辖区","章贡区","赣县","信丰县","大余县","上犹县","崇义县","安远县","龙南县","定南县","全南县","宁都县","于都县","兴国县","会昌县","寻乌县","石城县","瑞金市","南康市","市辖区","吉州区","青原区","吉安县","吉水县","峡江县","新干县","永丰县","泰和县","遂川县","万安县","安福县","永新县","井冈山市","市辖区","袁州区","奉新县","万载县","上高县","宜丰县","靖安县","铜鼓县","丰城市","樟树市","高安市","市辖区","临川区","南城县","黎川县","南丰县","崇仁县","乐安县","宜黄县","金溪县","资溪县","东乡县","广昌县","市辖区","信州区","上饶县","广丰县","玉山县","铅山县","横峰县","弋阳县","余干县","鄱阳县","万年县","婺源县","德兴市"};
			getMaplist("江西省",city6, area6, tdate, maplist);
			break;
		}
		
		return maplist;
	}
	private static void getMaplist(String province, String city[],String area[],String tdate,List<Map> maplist) throws ParseException {
		// TODO Auto-generated method stub
			int countSum = 0;int countSum2 =0; int countSum3 = 0;int countSum4= 0;
			int mSum = 0;
			int i =0;
			if(city[i].equals("上海市")){
				i = 1;}
			for(int j = 0;j<1&& j<area.length;j++){
				Map<String,String> map = new HashMap<String,String>();
				if(area[j].equals("市辖区"))
					i++;
				Data data = null;
				try {
					data = sybaseDao.search(province,city[i-1], area[j], tdate);
				} catch (IOException e) {
					
					e.printStackTrace();
				}
				Data data2 = null;
				try {
					data2 = sybaseDao.searchYDate(province,city[i-1], area[j], YDate(tdate));
				} catch (IOException e) {
					
					e.printStackTrace();
				}
				Data data3 = null;
				try {
					data3 = sybaseDao.search(province,city[i-1], area[j], MDate(tdate));
				} catch (IOException e) {
					
					e.printStackTrace();
				}
				Data data4 = null;
				try {
					data4 = sybaseDao.search(province,city[i-1], area[j], MDate(MDate(tdate)));
				} catch (IOException e) {
					
					e.printStackTrace();
				}
				countSum += data.getCount();
				countSum2 +=data2.getCount();
				countSum3 +=data3.getCount();
				countSum4+=data4.getCount();
				mSum += data.getSum();
				map.put("市", city[i-1]);
				map.put("区县", area[j]);
				map.put("笔数", Integer.toString(data.getCount()));
				map.put("金额", Integer.toString(data.getSum()));
				map.put("去年同月", Integer.toString(data2.getCount()));
				map.put("上个月", Integer.toString(data3.getCount()));
				map.put("上上个月", Integer.toString(data4.getCount()));
				map.put("同比", function(data.getCount(),data2.getCount()));
				map.put("环比", function(data.getCount(),data3.getCount()));
				maplist.add(map);
				System.out.println(city[i-1]+area[j]+"数据查找完成！");
			}
			Map<String,String> lastmap =new HashMap<String,String>();
			lastmap.put("市", "");
			lastmap.put("区县", "总计");
			lastmap.put("笔数", Integer.toString(countSum));
			lastmap.put("金额", Integer.toString(mSum));
			lastmap.put("去年同月", Integer.toString(countSum2));
			lastmap.put("上个月", Integer.toString(countSum3));
			lastmap.put("上上个月", Integer.toString(countSum4));
			lastmap.put("同比", function(countSum,countSum2));
			lastmap.put("环比", function(countSum,countSum3));
			maplist.add(lastmap);
			System.out.println("总计已经输出！");
		}
	
	//去年同月
	public static String YDate(String tdate) throws ParseException{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM"); 
		Date ddate = sdf.parse(tdate);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(ddate);
		//        calendar.add(Calendar.WEEK_OF_YEAR, -1);
		calendar.add(Calendar.YEAR,-1);
		Date sdate =calendar.getTime();	
		String ydate = sdf.format(sdate).toString();
		 return ydate;
	}
	//同年上月
	public static String MDate(String tdate) throws ParseException{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM"); 
		Date ddate = sdf.parse(tdate);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(ddate);
		//        calendar.add(Calendar.WEEK_OF_YEAR, -1);
		calendar.add(Calendar.MONTH,-1);
		Date sdate =calendar.getTime();	
		String mdate = sdf.format(sdate).toString();
		 return mdate;
	}
	/*
	 * 计算环比，同比的数值
	 */
	public static String  function(int a,int b){
		DecimalFormat df = new DecimalFormat("#.00");
		float c1 = (float)a;
		float c2 = (float)b;
		float c = (c1-c2)/c2;
		c*=100;
		String d = String.valueOf(df.format(c))+"%";
		return d;
		
	}

	
}
