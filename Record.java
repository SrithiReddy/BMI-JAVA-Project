import java.util.*;
public class Record{
        private String subjectId,category;
        private double height,width,bmiValue;
        public  Record(String sid,double h,double w,double bmi,String c){
                this.subjectId = sid;
                this.height = h;
                this.width = w;
                this.bmiValue = bmi;
                this.category = c;
        }
        public String getSubjectId(){
                return subjectId;
        }
        public double getHeight(){
                return height;
        }
        public double getWidth(){
                return width;
        }
        public double getBmiValue(){
                return bmiValue;
        }
        public String getCategory(){
                return category;
        }
}
