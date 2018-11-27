import java.util.*;
public class BMIAnalyzer{
	private int nrecords;
	private Record[] data;

	public BMIAnalyzer(){
		this.loadFromTables();
		this.sortById();
	}

	public Record find(String sid){
int i;
int l=0,r=nrecords;
int temp=0;



	    while (l <= r)
	    {
	        int m = l + (r-l)/2;

	        // Check if x is present at mid
	        if (data[m].getSubjectId().equals(sid))
	           temp=m;

	        // If x greater, ignore left half
	        if ((sid.compareTo(data[m].getSubjectId()))==1)
	            l = m + 1;

	        // If x is smaller, ignore right half
	        else
	            r = m - 1;
	    }




	return data[temp];
}

	public ArrayList<Record> find(double bmi1, double bmi2){
		ArrayList<Record> bm= new ArrayList<Record>();
for(int i=0;i< nrecords;i++)
{
	if(data[i].getBmiValue()>bmi1 && data[i].getBmiValue()< bmi2)
	bm.add(data[i]);
}
return bm;
	}

	public double lowestBMI(){
double min;
min=data[0].getBmiValue();
for(int i=0;i<nrecords;i++){
	if(data[i].getBmiValue()<min)
	min=data[i].getBmiValue();
}
return min;
	}
	public double highestBMI(){
		double max;
		max=data[0].getBmiValue();
		for(int i=0;i<nrecords;i++){
			if(data[i].getBmiValue()>max)
			max=data[i].getBmiValue();
		}
		return max;
			}

	public double averageBMI(){
double avg;
avg=(lowestBMI()+highestBMI())/2;
return avg;
}
	private void sortById(){
		for(int i=1;i<nrecords;i++){
			int j = i;
			Record temp=data[i];
			while(j>0 && (data[j-1].getSubjectId().compareTo(temp.getSubjectId()))==1){
				data[j] = data[j-1];
				j=j-1;
			}
			data[j]=temp;
		}

	}

		private void loadFromTables() {
		        String[] subjects={"S02","S04","S03","S01"};



		        double[] height={16.3,18.4,20.0,30.0};
		            // your values go here



		        double[] weight={16.3,18.4,20.0,30.0};


		        nrecords = subjects.length;
		        data = new Record[nrecords];
		        for (int i = 0; i < nrecords; i++ ) {
		            double v = weight[i]/(height[i]*height[i]);
		            String c = classify( v );
		            Record r = new Record(subjects[i],height[i],weight[i],v,c);
		            data[i] = r;
		} }

	private String classify(double bmi){
		if(bmi<=15)
		return "Very severely underweight";
	else	if(bmi>15 && bmi<=16)
		return "Severely underweight";
	else	if(bmi>16 && bmi<=18.5)
		return "underweight";
	else	if(bmi>18.5 && bmi<=25)
		return "Normal (healthy weight)";
	else	if(bmi<25 && bmi<=30)
		return "Overweight";
	else	if(bmi>30 && bmi<=35)
		return "Obese Class I(Moderately obese)";
	else	if(bmi<35 && bmi<=40)
		return "Obese Class II(Severely obese)";
	else	if(bmi>40)
		return "Obese Class III( Very Severely obese)";
		else
		return "0";
	}

}
