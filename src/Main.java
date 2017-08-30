import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StreamTokenizer;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.function.BiConsumer;
public class Main {


	public static void main(String[] args) throws IOException, InterruptedException{
		File file = new File("logs.csv");
		FileReader fr = new FileReader(file);
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(fr);//(isr);
		// Reader r = br;
		String Headers[] = {"AlarmId","HistoryAction",
				"AlarmKey","Node","SubMethod","AlarmGroup","SubAlarmGroup","AlarmType","Reported","Severity"};

		String line;
		// skip the first line
		line = br.readLine();

		Alarm a = null;
		long inputVal;
		Scanner inputScan = new Scanner(System.in);
		String inputTxt = null;
		String inputSub = null;
		String inputField ="AlarmId";


		ArrayList<Alarm> alarms = new ArrayList<Alarm>();
		HashMap<String,ArrayList<Alarm>> nodes = new HashMap<String,ArrayList<Alarm>>();	
		while ((line = br.readLine())!=null ){
			a = new Alarm();
			String type="";
			String val ="";
			String line1=line+",";


			for (int i=0;i<Headers.length;i++){
				try {
					int index =0;
					if (line1.charAt(0)=='"'){
						index = line1.indexOf('"',1);
						val = line1.substring(0, index+1);
						line1 = line1.substring(index+2, line1.length());

					}
					else{

						index = line1.indexOf(',');
						val = line1.substring(0, index);
						line1 = line1.substring(index+1, line1.length());
					}
					//System.out.println("type "+type);
					//System.out.println(String.format("Type: %s Value: %s", type, val));
					//	System.out.println("name "+Headers[i]);
					//		System.out.println(" line "+line1);
					switch(i){
					case 0:
						a.setAlarmId(Long.parseLong(val));
						break;
					case 1:
						a.setHistoryAction(val);
						break;
					case 2:
						a.setAlarmKey(val);
						break;
					case 3:
						a.setNode(val);
						break;
					case 4:
						a.setSubMethod(val);
						break;
					case 5:
						a.setAlarmGroup(val);
						break;
					case 6:
						a.setSubAlarmGroup(val);
						break;
					case 7:
						a.setAlarmType(Integer.parseInt(val));
						break;
					case 8:
						a.setReported(Long.parseLong(val));
						break;
					case 9:
						a.setSeverity(Integer.parseInt(val));
						break;
					}

				} catch (Exception e) {
					// TODO Auto-generated catch block
					System.out.println("*type "+type);
					System.out.println("*val "+val);
					System.out.println("*name "+Headers[i]);
					System.out.println("*line "+line1);
					e.printStackTrace();
				}

				

			}
			alarms.add(a);
			//System.out.println(" Alarm "+a);

			ArrayList<Alarm> aa = nodes.get(a.getNode());
			if (aa == null){
				// the node is not in the hashmap so add in an 
				aa = new ArrayList<Alarm>();
				nodes.put(a.getNode(),aa);
				//System.out.println(a);
			}
			aa.add(a);
		}

		Scanner scan = new Scanner(System.in);
		System.out.println("enter 1 -list all");
		System.out.println("enter 2 - output alarm for an id" );
		System.out.println("enter 3 - output all the alarms that contain linkUpDown in AlarmKey" );
		System.out.println("enter 4 - Search for Alarms by a selected field and identification" );
		System.out.println("enter 5 - output all the alarms arranged by node" );
		System.out.println("enter 6 - output all the alarms arranged by node for a choosen value of Sub Method" );
		int index=0;
		while (true){
			String choice = scan.nextLine();
			switch(choice){
			case "1":
				for(Alarm ab : alarms){
					System.out.println("\n"+ab);
				}

				break;

			case "2":

				for(Alarm ab : alarms){
					if(ab.getAlarmId() == Long.parseLong(inputTxt)){
						System.out.println(a);
					}
				}
				break;

			case "3": 
				if(a.getAlarmKey().contains("linkUpDown"))
					System.out.println(" Alarm object \n"+a);
				break;

			case "4":

				String field = null;
				if(field == null){
					System.out.println("Please enter a number to choose a field \n 1: AlarmId \n 2: HistoryAction \n 3: AlarmKey \n "
							+ "4: Node \n 5: SubMethod \n 6: AlarmGroup \n 7: SubAlarmGroup \n 8: AlarmType \n 9: Reported \n 10:Severity" );
					field  = scan.nextLine();
					if(inputTxt == null){
						System.out.println("Enter the value");
						inputTxt = inputScan.nextLine();
					}
				}

				switch(field){
				case "1":
					for(Alarm ab : alarms){
						if(ab.getAlarmId() == Long.parseLong(inputTxt)){
							System.out.println(ab);
						}

					}
					break;

				case "2": 
					for(Alarm ab: alarms){
						if(ab.getHistoryAction().equals(inputTxt))
						System.out.println(ab);
					}

					break;

				case "3": 
					for(Alarm ab: alarms){
						if(ab.AlarmKey.contains(inputTxt))
						System.out.println(ab);
					}
					break;
				case "4": 
					for(Alarm ab: alarms){
						if(ab.getNode().contains(inputTxt))
						System.out.println(ab);
					}
					break;
				case "5": 
					for(Alarm ab: alarms){
						if(ab.getSubMethod().contains(inputTxt))
						System.out.println(ab);
					}
					break;
				case "6": 
					for(Alarm ab: alarms){
						if(ab.getAlarmGroup().contains(inputTxt))
						System.out.println(ab);
					}
					break;
				case "7": 
					for(Alarm ab: alarms){
						if(ab.getSubAlarmGroup().contains(inputTxt))
						System.out.println(ab);
					}
					break;
				case "8": 
					for(Alarm ab: alarms){
						if(ab.getAlarmType() == Integer.parseInt(inputTxt))
						System.out.println(ab);
					}
					break;
				case "9": 
					for(Alarm ab: alarms){
						if(ab.getReported() == Long.parseLong(inputTxt))
						System.out.println(ab);
					}
					break;
				case "10": 
					for(Alarm ab: alarms){
						if(ab.getSeverity() == Integer.parseInt(inputTxt))
						System.out.println(ab);
					}
					break;
				}
				break;				
			case "5":

				Map<String,ArrayList<Alarm>> map = new TreeMap<String,ArrayList<Alarm>>(nodes);
				Set<Entry<String, ArrayList<Alarm>>> set = map.entrySet();
				
				for(Entry<String, ArrayList<Alarm>> mapping : set){
					System.out.println(mapping);
				
				}

				break;

			case "6":
				
				if(inputSub == null){
					System.out.println("Enter the Sub Method");
					inputSub = inputScan.nextLine();
				}
				ArrayList<Alarm> c = new ArrayList<Alarm>();
				for(Alarm ab: alarms){
					if(ab.getSubMethod().contains(inputSub)){
						c.add(ab);
						//System.out.println(ab);
					}
				}
				Comparator<Alarm> d = (n1, n2) -> (n1.getNode()).compareTo(n2.getNode());
				c.sort(d);
				System.out.println(c);
				break;


				

			}

		}
	}
}