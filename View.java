import java.util.*;
public class View{
	private BMIAnalyzer analyzer;

	public View(BMIAnalyzer a){
		this.analyzer = a;
	}
	public void commandLoop(){
			System.out.println("run:");
			System.out.println("The following commands are recognised");
			System.out.println("\tDisplay this message\t\t\t\t> 0");
			System.out.println("\tDisplay a specific subject record:\t\t\t\t> 1 subjectID");
			System.out.println("\tDisplay records for all records within a range > 2 bmi1 bmi2");
			System.out.println("\tDisplay statistics (minimum, maximum and average marks) > 3");
			System.out.println("\tExit the application\t\t\t\t> 9");
			int i=1;
			while(i==1){
				Scanner sc = new Scanner(System.in);
				String input = sc.nextLine();
				String[] inpArray = input.split(" ");
				//int arg1 = Integer.parseInt(inpArray[0]);
				switch(inpArray[0].charAt(0)){
					case '0':
						System.out.println("run:");
						System.out.println("The following commands are recognised");
						System.out.println("\tDisplay this message													 					> 0");
						System.out.println("\tDisplay a specific subject record:						 					> 1 subjectID");
						System.out.println("\tDisplay records for all records within a range 					> 2 bmi1 bmi2");
						System.out.println("\tDisplay statistics (minimum, maximum and average marks) > 3");
						System.out.println("\tExit the application																		> 9");
						break;
					case '1':
						Record r = analyzer.find(inpArray[1]);
						System.out.println("<"+r.getSubjectId()+","+r.getHeight()+","+r.getWidth()+","+r.getBmiValue()+","+r.getCategory()+">");
						break;
					case '2':
						ArrayList<Record> al = analyzer.find(Double.parseDouble(inpArray[1]),Double.parseDouble(inpArray[2]));
						for(Record r1:al)
						System.out.println("<"+r1.getSubjectId()+","+r1.getHeight()+","+r1.getWidth()+","+r1.getBmiValue()+","+r1.getCategory()+">");
						break;
					case '3':
						double l = analyzer.lowestBMI();
						//System.out.print("<"+l.getSubjectId()+","+l.getHeight()+","+l.getWidth()+","+l.getBmiValue()+","+l.getCategory()+">");
						System.out.println("Lowest BMI : "+l);
						double h = analyzer.highestBMI();
						//System.out.print("<"+h.getSubjectId()+","+h.getHeight()+","+h.getWidth()+","+h.getBmiValue()+","+h.getCategory()+">");
						System.out.println("Highest BMI : "+h);
						double a = analyzer.averageBMI();
						//System.out.print("<"+a.getSubjectId()+","+a.getHeight()+","+a.getWidth()+","+a.getBmiValue()+","+a.getCategory()+">");
						System.out.println("Average BMI : "+a);
						break;
					case '9':
						i=0;
						break;
					default:
						System.out.println("Invalid Input case");
						break;
				}
			}
	}
}
