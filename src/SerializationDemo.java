import java.io.*;
import java.util.*;
//电影类型
enum MovieType implements Serializable{
	喜剧片,科幻片;
}
//电影
class Movie implements Serializable{
	String movieName;
	MovieType movieType;
	Movie(){
		
	}
	Movie (String movieName,MovieType movieType){
		this.movieName=movieName;
		this.movieType=movieType;
	}
}
//电影放映时间段
class MovieSchedule implements Serializable{
	String screeningHall;
	String time;
	MovieSchedule(){
		
	}
	MovieSchedule(String screeningHall,String time){
		this.screeningHall=screeningHall;
		this.time=time;
	}
	
}
//座位
class Seat implements Serializable{
	String seat;
	Seat(){
		
	}
	Seat(String seat){
		this.seat=seat;
	}
}
//电影票
class Ticket implements Serializable{
	Movie movie;
	MovieSchedule movieSchedule;
	Seat seat;
	Ticket(){
		
	}
	Ticket(Movie movie,MovieSchedule movieSchedule,Seat seat){
		this.movie=movie;
		this.movieSchedule=movieSchedule;
		this.seat=seat;
	}
	public void printTicket(){
		//打印票的详细信息 
		System.out.println(movie.movieName);
		System.out.println("类型："+movie.movieType);
		System.out.println("放映厅："+movieSchedule.screeningHall);
		System.out.println("时间："+movieSchedule.time);
		System.out.println("座位："+seat.seat);
	}
}

public class SerializationDemo {

	public static void main(String[] args) {
		MovieType mt1=MovieType.喜剧片;
		MovieType mt2=MovieType.科幻片;
		try {
			File file=new File("movie1.dat");
			FileOutputStream fos=new FileOutputStream(file);
			ObjectOutputStream oos=new ObjectOutputStream(fos);
			Ticket t1=new Ticket();
			Movie m1=new Movie("疯狂的石头",mt1);
			MovieSchedule ms1=new MovieSchedule("放映厅1","2010年7月12日 20时20分");
			Seat s1=new Seat("10排12座");
			t1.movie=m1;
			t1.movieSchedule=ms1;
			t1.seat=s1;
			t1.printTicket();
			oos.writeObject(t1);
			oos.close();
			fos.close();
			System.out.println("********************");
			FileInputStream fis=new FileInputStream(file);
			ObjectInputStream ois=new ObjectInputStream(fis);
			Ticket t2=(Ticket)ois.readObject();
			t2.seat.seat="10排13座";
			t2.printTicket();
			oos.close();
			fos.close();
		}catch(ClassNotFoundException ex){
			ex.printStackTrace();
		}catch(IOException ex){
			ex.printStackTrace();
		}
		System.out.println("********************");
		try {
			File file=new File("movie2.dat");
			FileOutputStream fos=new FileOutputStream(file);
			ObjectOutputStream oos=new ObjectOutputStream(fos);
			Ticket t1=new Ticket();
			Movie m1=new Movie("2012",mt2);
			MovieSchedule ms1=new MovieSchedule("放映厅2","2010年7月14日 19时40分");
			Seat s1=new Seat("8排8座");
			t1.movie=m1;
			t1.movieSchedule=ms1;
			t1.seat=s1;
			t1.printTicket();
			oos.writeObject(t1);
			oos.close();
			fos.close();
			System.out.println("********************");
			FileInputStream fis=new FileInputStream(file);
			ObjectInputStream ois=new ObjectInputStream(fis);
			Ticket t2=(Ticket)ois.readObject();
			t2.seat.seat="8排9座";
			t2.printTicket();
			oos.close();
			fos.close();
		}catch(ClassNotFoundException ex){
			ex.printStackTrace();
		}catch(IOException ex){
			ex.printStackTrace();
		}
		System.out.println("********************");
	}

}
