package BankTellerProblem;

import java.util.ArrayList;

import java.util.Random;


/* author:
 * reham abbady
 * 145330
 * CS
 * 
 */
public class Service {
	
	
	 int serviceID;
	    int interarrivalTime;
	    int arrivalTime;
	    int serviceTime;
	    int timeServiceBegins;
	    int waitingTime;
	    int timeServiceEnds;
	    int timeSpentInSystem;
	    int idleTime;

	    public Service() {
	    }



	    
	    
	   public int getServiceID() {
			return serviceID;
		}





		public void setServiceID(int serviceID) {
			this.serviceID = serviceID;
		}





		public int getInterarrivalTime() {
			return interarrivalTime;
		}





		public void setInterarrivalTime(int interarrivalTime) {
			this.interarrivalTime = interarrivalTime;
		}





		public int getArrivalTime() {
			return arrivalTime;
		}





		public void setArrivalTime(int arrivalTime) {
			this.arrivalTime = arrivalTime;
		}





		public int getServiceTime() {
			return serviceTime;
		}





		public void setServiceTime(int serviceTime) {
			this.serviceTime = serviceTime;
		}





		public int getTimeServiceBegins() {
			return timeServiceBegins;
		}





		public void setTimeServiceBegins(int timeServiceBegins) {
			this.timeServiceBegins = timeServiceBegins;
		}





		public int getWaitingTime() {
			return waitingTime;
		}





		public void setWaitingTime(int waitingTime) {
			this.waitingTime = waitingTime;
		}





		public int getTimeServiceEnds() {
			return timeServiceEnds;
		}





		public void setTimeServiceEnds(int timeServiceEnds) {
			this.timeServiceEnds = timeServiceEnds;
		}





		public int getTimeSpentInSystem() {
			return timeSpentInSystem;
		}





		public void setTimeSpentInSystem(int timeSpentInSystem) {
			this.timeSpentInSystem = timeSpentInSystem;
		}





		public int getIdleTime() {
			return idleTime;
		}





		public void setIdleTime(int idleTime) {
			this.idleTime = idleTime;
		}





	   
	      public Service(int serviceID, int interarrivalTime, int arrivalTime, int serviceTime, int timeServiceBegins,
				int waitingTime, int timeServiceEnds, int timeSpentInSystem, int idleTime) {
			super();
			this.serviceID = serviceID;
			this.interarrivalTime = interarrivalTime;
			this.arrivalTime = arrivalTime;
			this.serviceTime = serviceTime;
			this.timeServiceBegins = timeServiceBegins;
			this.waitingTime = waitingTime;
			this.timeServiceEnds = timeServiceEnds;
			this.timeSpentInSystem = timeSpentInSystem;
			this.idleTime = idleTime;
		}




	  	public int arrivalTime(int interArrivalTime, int previousArrivalTime){
	  	   
	  	   return interArrivalTime+previousArrivalTime;
	  	   
	  	   }
	  	     public int timeServiceBegins(int previousTimeServiousEnds, int arrivalTime){
	  	   
	  	         if(previousTimeServiousEnds<arrivalTime)
	  	             
	  	            return arrivalTime;
	  	         
	  	         else
	  	             
	  	             return previousTimeServiousEnds;
	  	        
	  	   }
	  	     
	  	     

		public int idle(int previousServiceEnds, int arrivalTime){
	      if (arrivalTime>previousServiceEnds)
	          return arrivalTime-previousServiceEnds;
	      else
	          return 0;
	      }
	   
	      
	       public int waitingTime(int timeServiceBegins, int arrivalTime){
	      
	          return timeServiceBegins-arrivalTime;
	      
	      }
	       
	       
	        public int timeServiceEnds(int timeServiceBegins, int serviceTime){
	      
	          return timeServiceBegins+serviceTime;
	      
	      }
	        
	        
	         public int timeSpent(int  waitingTime,int serviceTime){
	      
	          return waitingTime+serviceTime;
	      
	      }



public ArrayList<Integer> generateInterArrivalTime(int numberOfTests, int range){
	
	 ArrayList<Integer> generatedInterArrival = new ArrayList<>();

		for(int i=0;i<numberOfTests;i++) {
			
			
			Random trials = new Random();

			int  n = trials.nextInt(range) + 0;
			
			generatedInterArrival.add(n);
			
			
		}
		return generatedInterArrival;
		
	
	
}


public ArrayList<Integer> generateSeviceTime(int numberOfTests, int range){
	
	 ArrayList<Integer> generatedService = new ArrayList<>();

		for(int i=0;i<numberOfTests;i++) {
			Random trials = new Random();

			int  n = trials.nextInt(range) + 0;
			
			generatedService.add(n);
		
			
		}
		return generatedService;
		
	
	
}
public ArrayList<Double> calculateCDF( ArrayList<Double> probabilty){
	
	ArrayList<Double> CDF = new ArrayList<>();
	for(int i=0;i<probabilty.size();i++) {
		
		if(i==0)
			CDF.add(probabilty.get(i));
		else
			CDF.add(probabilty.get(i)+CDF.get(i-1));
		
	}
	
	return CDF;
	
}

public ArrayList<Integer> calculateRanges( ArrayList<Double> CDF){

	ArrayList<Integer> ranges = new ArrayList<>();
	double temp;
	for(int i=0;i<CDF.size();i++) {
		
		temp=CDF.get(i)*100;
		
		ranges.add((int) temp);
		
	}
	
	return ranges;
	
	
	
}

public ArrayList<Integer> calculateServiceTime(ArrayList<Integer> generatedTime,ArrayList<Integer> ranges) {
	
	ArrayList<Integer> time=new ArrayList<>();
	
for(int i=0;i<generatedTime.size();i++) {
		
		if(generatedTime.get(i)>=1&&generatedTime.get(i)<=ranges.get(0))
			time.add(1);
		else if(generatedTime.get(i)>=ranges.get(0) &&generatedTime.get(i)<=ranges.get(1))
			time.add(2);
		else if(generatedTime.get(i)>=ranges.get(1)+1 &&generatedTime.get(i)<=ranges.get(2))
			time.add(3);
		else if(generatedTime.get(i)==ranges.get(2)+1 ||generatedTime.get(i)==0 )
			time.add(4);		
		
	}
	
	return time;
	
}

public ArrayList<Integer> calculateInterArrivalTime(ArrayList<Integer> generatedTime,ArrayList<Integer> ranges) {
	
	ArrayList<Integer> time=new ArrayList<>();
	
for(int i=0;i<generatedTime.size();i++) {
		if(i==0)
			time.add(0);
		else {
		if(generatedTime.get(i)>=1&&generatedTime.get(i)<=ranges.get(0))
			time.add(0);
		else if(generatedTime.get(i)>=ranges.get(0) &&generatedTime.get(i)<=ranges.get(1))
			time.add(1);
		else if(generatedTime.get(i)>=ranges.get(1)+1 &&generatedTime.get(i)<=ranges.get(2))
			time.add(2);
		else if(generatedTime.get(i)>=ranges.get(2)+1 &&generatedTime.get(i)<=ranges.get(3))
			time.add(3);	
		else if(generatedTime.get(i)>=ranges.get(3)+1 &&generatedTime.get(i)<=ranges.get(4))
			time.add(4);	
		else if(generatedTime.get(i)+1==ranges.get(4)+1 ||generatedTime.get(i)==0 )
			time.add(5);	
		}
		
	}
	
	return time;
	
}

			@Override
			public String toString() {
				return "Service [serviceID=" + serviceID + ", interarrivalTime=" + interarrivalTime + ", arrivalTime="
						+ arrivalTime + ", serviceTime=" + serviceTime + ", timeServiceBegins=" + timeServiceBegins
						+ ", waitingTime=" + waitingTime + ", timeServiceEnds=" + timeServiceEnds
						+ ", timeSpentInSystem=" + timeSpentInSystem + ", idleTime=" + idleTime + "]";
			}

	  
	    

}
